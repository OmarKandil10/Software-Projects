/*author: omar kandil
date: 10/05/2022
exercise 1: ascii*/
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <time.h> // for time()
#include <process.h> // for _getpid()


// just a function from the previous 2021 lecture code:
void print_binary(unsigned long long num) {
	// loop from bit position 63 down to 0:
	int bitpos;
	for (bitpos = 7; bitpos >= 0; bitpos = bitpos - 1) {
		unsigned long long mask;
		mask = 1LL << bitpos; // 00000001 << 7 = 10000000
		//int condition = (num & mask) != 0; // AND logical operation 01100100 & 10000000 = 00000000
		int condition = (num & mask); // same
		if (condition) // true:
			printf("1");
		else // false:
			printf("0");
	} // for loop block
}



int main()
{
	printf("dec\t hex\t bin\t \tchar\t\n");
	for (int i = 0; i <= 127; i++) {
		printf(" %.3d \t 0X%0x \t", i, i);
		print_binary(i);
		if (i >= 33)
			printf("\t\'%c\'\t", i);
		else if (i < 33)
			printf("\t\'\'\t");
		printf("\n");

	}
	printf("Enter text input\n");
	char string0[128];
	scanf("%[^.\n]", string0);

	printf("\"%s\"\n", string0);
	int length = strlen(string0); // 'strlen' to determine the length of the string input
	printf("lenght = %d\n", length);
	printf("Decimal output like:\t"); // we wrote here so it will not be repeated in the loop
	for (int counter = 0; counter < length; counter++) {

		printf("%.3d\t", string0[counter]);
	}
	printf("\n Hexadecimal output like: \t"); // we wrote here so it will not be repeated in the loop
	for (int counter = 0; counter < length; counter++) {

		printf("0x%0x\t", string0[counter]);
	}
	printf("\n Binary output like: \t"); // it is written here so it will not be repeated in the loop
	for (int counter = 0; counter < length; counter++) {

		print_binary(string0[counter]);
		printf("\t");
	}
	char ch=' ';
	while (ch!= '.') {

		printf("\n Please enter a character: ");
		rewind(stdin);
		ch = getchar();

		printf("\n %.3d \t 0x%0X \t", ch, ch);
		print_binary(ch);
		printf("\t'\%c\'\n", ch);

	}


}

