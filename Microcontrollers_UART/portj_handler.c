#include "portj_handler.h"
#include "inc/tm4c1294ncpdt.h"
#include <stdio.h>
#include <stdint.h>

void IntPortJHandler() {
    volatile uint32_t delay;


    // Check if SW1 (PJ0) is pressed
    if ((GPIO_PORTJ_AHB_DATA_R & 0x01) == 0) {

        // Start the output sequence
        UART0_DR_R = '#';

        // Output the numbers of the LEDs that are currently on
        if (GPIO_PORTF_AHB_DATA_R & 0x01) {
            UART0_DR_R = '1';
            for (delay = 0; delay < 50000; delay++);// delay to print the LED number

        }
        if (GPIO_PORTF_AHB_DATA_R & 0x10) {
            UART0_DR_R = '2';
            for (delay = 0; delay < 50000; delay++);// delay to print the LED number

        }
        if (GPIO_PORTN_DATA_R & 0x01) {
            UART0_DR_R = '3';
            for (delay = 0; delay < 50000; delay++);// delay to print the LED number

        }
        if (GPIO_PORTN_DATA_R & 0x02) {
            UART0_DR_R = '4';
            for (delay = 0; delay < 50000; delay++);// delay to print the LED number

        }
        // Terminate the output sequence with carriage return
        UART0_DR_R = 0x0D;
    }

    // Clear the interrupt flag
    GPIO_PORTJ_AHB_ICR_R = (1 << 0);

}
