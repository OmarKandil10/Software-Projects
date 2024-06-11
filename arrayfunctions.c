/*author: omar kandil
date: 10/05/2022
exercise 2: array functions*/

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>
// sum up array elements
double sum_up(double* array, int num_elements) {
	double sum = 0.0;
	for (int i = 0; i < num_elements; i = i + 1) // all from 0 to num_elements-1
		sum = sum + array[i]; // sum up
	return sum;
}
double average(double* array, int num_elements) {

	double sum = sum_up(array, num_elements);
	double average = sum / num_elements;
	return average;

}
double scalar_product(double* vector1, double* vector2, int dim) {
	vector1[dim];
	vector2[dim];
	double sum = 0, product;
	for (int i = 0; i < dim; i++) {
		product = vector1[i] * vector2[i];
		sum += product;
	}
	return sum;

}
double distance(double* vector1, double* vector2, int dim) {
	vector1[dim];
	vector2[dim];
	double term, under_root = 0, distance, termsq;
	for (int o = 0; o < dim; o++) {
		term = vector1[o] - vector2[o];
		termsq = term * term;
		under_root += termsq;
		distance = sqrt(under_root); // 'sqrt' is used to calculate the square root of double variables
	} return distance;
}
int main(void) {
	double numbers[4] = { 1.0, 4.0, 7.7, 10.9 }; // example numbers
	double sum =
		sum_up(&numbers[0], 4); // Address of start of array
		//and the length of array
	printf("The sum is %4.2lf\n", sum);
	double av;
	av = average(&numbers[0], 2);  // when the num of elements is greater than 4, the memory doesn't allocate; where less tha num of elemetns the program calculates the average of the number of the elements.
	printf("The average is:%4.2lf\n", av);
	double vector_1[3]; // 3-Dimensional vector
	double vector_2[3];
	printf("Enter Vector1[1]: ");
	scanf("%lf", &vector_1[0]);
	printf("Enter Vector1[2]: ");
	scanf("%lf", &vector_1[1]);
	printf("Enter Vector1[3]: ");
	scanf("%lf", &vector_1[2]);
	printf("Enter Vector2[1]: ");
	scanf("%lf", &vector_2[0]);
	printf("Enter Vector2[2]: ");
	scanf("%lf", &vector_2[1]);
	printf("Enter Vector2[3]: ");
	scanf("%lf", &vector_2[2]);
	double sp = scalar_product(&vector_1[0], &vector_2[0], 3); // calling the function scalar_product
	printf("\nThe scalar product of the two vectors is : %lf\n", sp);
	double eudistance = distance(&vector_1[0], &vector_2[0], 3); // calling the function distance
	printf("The Euclidean Distance is : %lf", eudistance);
}