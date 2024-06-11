/*author: omar kandil
date: 10/05/2022
exercise 3: numbers*/

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

void print_int_array(int* array, int num) //num=length of array=10
{
	for (int p = 0; p < num; p++) {
		printf("%d  ", array[p]);
	}
}

int main() {
	int numbers[10]; // Definition of an array of int with 10 elements
	for (int i = 0; i < 10; i++) {
		printf("Insert numbers [%d]:", i + 1);
		scanf("%d", &numbers[i]);
	}
	print_int_array(&numbers[0], 10);
	int size = sizeof(numbers); // determine memory size occupied by array
	printf("Size:%d\n", size);
	int temp = numbers[0]; // 'temp' is to save the element that is going to be deleted by the loop
	//numbers[r - 1] = temp;
	printf("Shift towards the front:\n");
	for (int r = 0; r < 10; r++) {
		numbers[r] = numbers[r + 1]; // the element is going to be replaced by the element after it in the array
	}
	numbers[9] = temp; // returning the value of the deleted element back in the array
	print_int_array(&numbers[0], 10);
	int temp1 = numbers[9]; // 'temp1' is to save the element that is going to be deleted by the loop
	printf("\nShift towards the back:\n");
	for (int h = 9; h > 0; h--) 
	{
		numbers[h] = numbers[h - 1]; // the element is going to be replaced by the element before it in the array
	}
	numbers[0] = temp1; // 'temp1' is to save the element that is going to be deleted by the loop
	print_int_array(&numbers[0], 10);



}
