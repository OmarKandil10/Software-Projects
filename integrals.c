/*program : integrals
course : SOL1 ss2022
author : omar kandil
Date : 14/06/2022*/

#include<stdio.h>
#include<math.h>
#define PI 3.14159265359

double f(double x)
{
	return cos(PI * x / 180);
}
double area(double left_x, double right_x) // to calculate area of one rectangle
{
	double mid = (right_x + left_x) / 2; // middle point between left and right
	double length = f(mid);
	double width = right_x - left_x;
	double area = length * width; // area of each rectangle equals lenght * width
	return area;
}
double integral(double left_x, double right_x, int steps) // to obtain area under the curve
{
	double left, right, area2, sum, width;
	sum = 0;
	width = (right_x - left_x) / steps; // left_x and right_x are interval boundaries where steps is the desired number of partial intervals

	for (int i = 1; i <= steps; i++)
	{
		left = left_x + (i - 1) * width;
		right = left_x + (i * width);
		area2 = area(left, right);
		sum = sum + area2;
	}
	return sum;
}

int main()
{
	printf("area of one rectangle is %lf\n", area(-0.5, 0.5));
	printf("area is %lf", integral(-0.5, 0.5, 10));
}
