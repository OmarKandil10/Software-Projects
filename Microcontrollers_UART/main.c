//===========================================================
// Test program UART0 TX 8/N/1 @ 9600 bit/s
// LTL 17.5.2020
//==========================================================
#include "inc/tm4c1294ncpdt.h"
#include <stdint.h>
#include <stdio.h>
#include "portj_handler.h"
unsigned char cmdLineUart[16];
unsigned char promptText = 0x03E;
volatile uint8_t leds;



void configPortA(void);
void configUart0(void);
void cmdToLed(void);
void configPortJ(void);


int main(void) {

     int i = 0;


    // config Port A
    configPortA();
    // config UART0 Rx+Tx
    configUart0();

    configPortJ();


    // Initialize LEDs
         SYSCTL_RCGCGPIO_R |= 0x00001020; // Enable and clock GPIO Ports N, F
         // Set Pins PN0, PN1, PF0, and PF4 as digital outputs for LEDs
         GPIO_PORTN_DEN_R |= 0x03;
         GPIO_PORTN_DIR_R |= 0x03;
         GPIO_PORTF_AHB_DEN_R |= 0x11;
         GPIO_PORTF_AHB_DIR_R |= 0x11;


    UART0_DR_R = promptText; // send '>' in the beginning

    while (1) {
        // Check for received characters
        while ((UART0_FR_R & (1 << 4)) == 0) { // Check if the receive FIFO is not empty and wait for it to empty

            char receivedChar = UART0_DR_R; // assign the data to the register, which the user writes in the terminal

            // Here, if the user enters 16 char or presses enter (new line), it will print the cmdLineUart[i] and reset i to 0
            // 0x0D represents "CR" carriage return
            if (receivedChar == 0x0D || i == 15) { // Check for carriage return or max length
                cmdLineUart[i] = '\0'; // Terminate the string after getting 16 bit characters
                printf("Entered command: %s\n", cmdLineUart); // when it terminates the string by default or user, it sends the string to the console

                // Reset for the next command
                i = 0;
                UART0_DR_R = promptText; // send '>' each time the string terminates



            } else {
                cmdLineUart[i] = receivedChar;
                i++;
                if (receivedChar != '+' && receivedChar != '-' && receivedChar != '~' &&
                       receivedChar != '1' && receivedChar != '2' && receivedChar != '3' && receivedChar != '4') {

                    printf("LED command syntax violated\n");

                }

            }
            cmdLineUart[i] = 0x0;
        }

        cmdToLed();

    }
}

void configPortA(void) {
    // initialize Port A
    SYSCTL_RCGCGPIO_R |= (1 << 0); // switch on clock for Port A
    while ((SYSCTL_PRGPIO_R & (1 << 0)) == 0); // wait for stable clock
    GPIO_PORTA_AHB_DEN_R |= 0x03; // digital I/O enable for pin PA(1:0)
    GPIO_PORTA_AHB_AFSEL_R |= 0x03; // PA(1:0) set to alternate func
    GPIO_PORTA_AHB_PCTL_R |= 0x00000011; // alternate func is U0Rx+Tx
}

void configUart0(void) {
    // initialize UART0
    SYSCTL_RCGCUART_R |= (1 << 0); // switch on clock for UART0
    while ((SYSCTL_PRUART_R & (1 << 0)) == 0); // wait for stable clock
    UART0_CTL_R &= ~(1 << 0); // disable UART0 for config
    // initialize bitrate of 9600 bit per second
    UART0_IBRD_R = 104; // set DIVINT of BRD floor(16MHz/16/9600Hz)
    UART0_FBRD_R = 11; // set DIVFRAC of BRD
    // UART0_LCRH_R = 0x00000040; // serial format 7N1
    UART0_LCRH_R = 0x060; //(0x3 << 5) ; // 8-N-1 format
    UART0_CTL_R |= 0x0301; // re-enable UART0 RXE and TXE enable
}

void cmdToLed(void) {
    leds = 0;
    //GPIO_PORTN_DATA_R &= 0x0;
    //GPIO_PORTF_AHB_DATA_R &= 0x0;

    // Process each character in the command
    int i;
    for ( i = 0; i < 16; i++) {
        if (cmdLineUart[i] == '\0') {
            break; // End of the command string
        }
        //when it detects the the following case it will set the led and then
        switch (cmdLineUart[i]) {
            case '+':
                leds |= (1 << (cmdLineUart[i + 1] - '1'));
                break;
            case '-':
                leds &= ~(1 << (cmdLineUart[i + 1] - '1'));
                break;
            case '~':
                leds ^= (1 << (cmdLineUart[i + 1] - '1'));
                break;

            default:

                break;
        }

        // Skip the next character as it represents the LED number
        i++;
    }

    GPIO_PORTN_DATA_R = ((leds >> 2) & 0x03); // Display the rightmost 2 bits on port N and left bits get shifted by 2
    GPIO_PORTF_AHB_DATA_R = (((leds & 0x02) << 3) | ((leds & 0x03))); // Display the second last bit on port F on p4 by shifting 3 bits and the last bit as it is by masking

}

void configPortJ(void) {
    // Configure Port J(0) for the switch
    SYSCTL_RCGCGPIO_R |= (1 << 8); // Enable clock for Port J
    while ((SYSCTL_PRGPIO_R & (1 << 8)) == 0); // Wait for stable clock
    GPIO_PORTJ_AHB_DEN_R |= (1 << 0); // Digital enable for PJ0
    GPIO_PORTJ_AHB_DIR_R &= 0x00;
    GPIO_PORTJ_AHB_PUR_R |= (1 << 0); // Enable internal pull-up resistor for PJ0
    //GPIO_PORTJ_AHB_RIS_R |= (1<<8);
    GPIO_PORTJ_AHB_IS_R &= ~(1 << 0); // Set PJ0 as edge-sensitive
    GPIO_PORTJ_AHB_IBE_R |= (1 << 0); // Interrupts are controlled by IEV// trigger set to "single edge"
    GPIO_PORTJ_AHB_IEV_R |= (1 << 0); // Set to detect rising edges
    GPIO_PORTJ_AHB_ICR_R |= 0x01; // clear interrupt PORTJ(0)
    GPIO_PORTJ_AHB_IM_R |= (1 << 0); // Unmask interrupt for PJ0
    NVIC_EN1_R |= 1<<(51-32); // PortJ (Int#51 = bit 19 in EN1)
    //NVIC_PRI12_R = (NVIC_PRI12_R & 0xFFFF00FF) | 0x00004000; // Set interrupt priority

}
