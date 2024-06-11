/*program : integrals
course : SOL1 ss2022
author : omar kandil
Date : 14/06/2022*/

#include <stdio.h>
#include <stdlib.h>
#define _USE_MATH_DEFINES
#include <math.h>
#include <string.h>

#define COLUMNS 80
#define ROWS 30
#define X COLUMNS/2
#define Y ROWS/2
#define XMAX COLUMNS-X-1
#define XMIN -(COLUMNS-X)
#define YMAX ROWS-Y
#define YMIN -(ROWS-Y)+1
#define y_to_row 8
#define x_to_column 10

char screen[ROWS][COLUMNS];

int plot(int x, int y);
void init_grid(void);
void show_grid(void);

int main() {
	double x, y;

	//plot the value of x and sin(x) and show plotted gridh
	printf("sin(x)\n");
	init_grid();
	for (x = -M_PI; x <= M_PI; x += 0.1) {
		y = sin(x);
		plot(rintf(x * x_to_column), rintf(y * y_to_row));
	}
	show_grid();

	//plot the value of x and cos(x) and show plotted grid
	printf("cos(x)\n");
	init_grid();
	for (x = -M_PI; x <= M_PI; x += 0.1) {
		y = cos(x);
		plot(rintf(x * x_to_column), rintf(y * y_to_row));
	}
	show_grid();

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