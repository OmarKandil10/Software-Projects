/*program : integrals
course : SOL1 ss2022
author : omar kandil
Date : 14/06/2022*/

#include <stdio.h>
#include <stdlib.h>
#define _USE_MATH_DEFINES
#include <math.h>
#include <string.h>
#define MU 0.0
#define SIGMA 1.0
#define COLUMNS 80
#define ROWS 30
#define X COLUMNS/2
#define Y ROWS/2
#define XMAX COLUMNS-X-1
#define XMIN -(COLUMNS-X)
#define YMAX ROWS-Y
#define YMIN -(ROWS-Y)+1
#define y_to_row 6.0
#define x_to_column 10.0

char screen[ROWS][COLUMNS];
int histogram_array[26];

double gauss(double x, double mu, double sigma);
int dice(void);
void dice_statistics(int throws, int experiments);
int plot(int x, int y);
void init_grid(void);
void show_grid(void);

int main() {
	double x, y;
	// part(a)
	printf("part (a)\n");
	//plot the value of x and guass(x) and show plotted grid
	printf("guass(x)\n");
	init_grid();
	for (x = -4.0; x <= 4.0; x += 0.1) {
		y = gauss(x, MU, SIGMA);
		plot(rintf(x * x_to_column), rintf(y * y_to_row));
	}
	show_grid();

	// part(b)
	printf("part (b)\n");
	//dice function
	srand(time(NULL));
	for (int i = 0; i < 10; i++) {
		printf("random number:%d\n", dice());
	}
	// part(c)
	printf("part (c)\n");
	int throws = 5;
	int experiments = 10;
	printf("I repeated 10 times that I threw a dice 5 times.\n");
	dice_statistics(throws, experiments);
	for (int i = 0; i < throws * 5 + 1; i++) {
		printf("I got '%d' %d time(s).\n", i + 5, histogram_array[i]);
	}
}

double gauss(double x, double mu, double sigma) {
	double result = 1.0 / sigma * sqrt(2.0 * M_PI) * exp(-1.0 / 2.0 * ((x - mu) / sigma) * ((x - mu) / sigma));
	return result;
}
//this function return a value between 1 to 6.
int dice(void) {
	return rand() % 6 + 1;
}

//this function repeats 10 times throwing a dice 5 times.
void dice_statistics(int throws, int experiments) {
	double average = 0.0;
	for (int i = 0; i < experiments; i++) {
		int sum = 0;
		for (int j = 0; j < throws; j++) {
			//sum up the result of throwing a dice 5 times
			sum += dice();
		}
		// sum up how many times I get a value 5 to 30.
		histogram_array[sum - throws]++; //histogram_array[26]: I get 5 at least whith throwing a dice 5 times.
		// sum up the result of repeating 10 times throwing a dice 5 times.
		average += sum;
	}
	printf("The average of %d experiments of throwing a dice %d times: %lf\n", experiments, throws, average / experiments);
}

// this function plots the value of x and y to grid initialized in init_grid
int plot(int x, int y) {
	if (x > XMAX || x<XMIN || y>YMAX || y < YMIN) {
		return(-1);
	}
	screen[Y - y][X + x] = '*';
	return (1);
}

//initialize a grid
void init_grid(void) {
	int x, y;
	for (y = 0; y < ROWS; y++) {
		for (x = 0; x < COLUMNS; x++) {
			screen[y][x] = ' ';
		}
	}
	for (y = 0; y < ROWS; y++) {
		screen[y][X] = '|';
	}
	for (x = 0; x < COLUMNS; x++) {
		screen[Y][x] = '-';
	}
	screen[0][X] = 'y';
	screen[Y][COLUMNS - 2] = '>';
	screen[Y][COLUMNS - 1] = 'x';
	screen[Y][X] = '+';
}

//show a grid
void show_grid(void) {
	int x, y;
	for (y = 0; y < ROWS; y++) {
		for (x = 0; x < COLUMNS; x++) {
			putchar(screen[y][x]);
		}
		putchar('\n');
	}
}