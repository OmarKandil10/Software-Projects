#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define DEBUG 0


typedef struct complex_struct 
{
	double real;
	double imag;
}complex;



complex add(complex c1, complex c2)
{
    complex result;
    result.real = c1.real + c2.real;
    result.imag = c1.imag + c2.imag;
    return result;

}


complex substract(complex c1, complex c2)
{
    complex result;
    result.real = c1.real - c2.real;
	result.imag = c1.imag - c2.imag;
	return result;
}


complex multiply(complex c1, complex c2)
{
    complex result;
    result.real = c1.real * c2.real + (-1) * c1.imag * c2.imag;
	result.imag = c1.real * c2.imag + c1.imag * c2.real;
	return result; 
    
}


complex divide(complex c1, complex c2)
{
    complex result;
	result.real = (c1.real * c2.real + c1.imag * c2.imag) / (c2.real*c2.real + c2.imag*c2.imag);
	result.imag = (c2.real * c1.imag - c2.imag * c1.real) / (c2.real*c2.real + c2.imag*c2.imag);
	return result;
}

complex power(complex c1, double powerr) 
{
	complex result = multiply(c1, c1);
	complex one = { 1, 0 };
	if (powerr < 0) 
	{ 
		
	}
	else if(powerr = 0)
	{

	}
	else
	{
		for (int i = 2; i < powerr; i++)
		result = multiply(result, c1);
	}
	
	return result;
}

void print_complex(complex c) 
{
	if (c.imag >= 0.0) { // positive imag
		printf("%.3lf+%.3lfj", c.real, c.imag);
	} else { // sign already there
		printf("%.3lf%.3lfj", c.real, c.imag);
	}
} 


void plot_complex_number(complex c, char z) {
	// map -1..+1 to ROWS..0
	int row = (int)((1.0 - c.imag) * ROWS / 2.0);
	// map -1..+1 to 0..COLS
	int col = (int)((1.0 + c.real) * COLS / 2.0);
	if (row > 0 && row < ROWS && col>0 && col < COLS) {
		screenbuffer[row][col] = z;
	}
}

void plot_complex_numbers() {
	polar p1 = { 0.99, M_PI/20.0 };
	complex c1 = polar_to_complex(p1);
	for (double exponent = 0; exponent < 120; exponent += 1) {
		complex c = pow_complex_numbers_double(c1,exponent);
		plot_complex_number(c, '*');
	}
}

void plot_random_complex_numbers(long howmany) {
	complex c;
	for (int i = 0; i < howmany; i++) {
		c = get_random_complex();
		plot_complex_number(c, '*');
	}
}

complex get_random_complex_all_quadrants() {
	complex result; // = ZERO;
	result.real = get_random_float()*2.0 - 1.0;
	result.imag = get_random_float()*2.0 - 1.0;
	return result;
}




void plot_random_complex_numbers_all_quadrants(long howmany) {
	complex c;
	for (int i = 0; i < howmany; i++) {
		c = get_random_complex_all_quadrants();
		plot_complex_number(c, '*');
	}
}


typedef struct struct_polar {
	double radius;
	double angle;
} polar;

void print_polar(polar p) {
	printf("%.3lf*e^%.3lfj", p.radius, p.angle);
}

int polar_numbers_equal(polar p1, polar p2) {
	// returns 1 for equality and 0 otherwise the meaning of ? 1 : 0
	return (fabs(p1.radius - p2.radius) < DELTA && fabs(p1.angle - p2.angle) < DELTA) ? 1 : 0;
}

polar complex_to_polar(complex c) {
	polar result;
	result.radius = complex_absolute(c);
	result.angle  = complex_argument(c);
	return result;
}

complex polar_to_complex(polar p) {
	complex result;
	result.real = p.radius*cos(p.angle);
	result.imag = p.radius*sin(p.angle);
	return result;
}

complex pow_complex_numbers_double(complex c1, double exponent) 
{
	complex result;
	polar p1 = complex_to_polar(c1);
	double radius = pow(p1.radius, exponent);
	double angle  = p1.angle*exponent;
	result.real   = radius*cos(angle);
	result.imag   = radius*sin(angle);
	return result;
}

complex pow_complex_numbers(complex c1, complex c2) 
{
	complex result;
	polar p1 = complex_to_polar(c1);
	double radius = pow(p1.radius, c2.real) * exp(c2.imag*p1.angle);
	double angle  = c2.imag*log(p1.radius) + c2.real*p1.angle;
	result.real   = radius * cos(angle);
	result.imag   = radius * sin(angle);
	return result;
	return result;
}

complex get_random_complex() {
	complex result;
	result.real = get_random_float();
	result.imag = get_random_float();
	return result;
}


int main(int argc, char **argv)
{
    if(argc<3)
	{
		//fprintf(stderr, "Error: few number of arguments\n");
		arg_list_start_index = 0; // 0th index is used here
		debuglevel = 2;
		if (DEBUG) printf("Complex Calculator: Automatic test cases:\n");
		int ok = 1; // 1=OK, 0=NOT_OK. Changed during tests:
		char testcases[][TESTCASE_ARGS][TESTCASE_ARG_STRINGSBUFFERSIZE] = {
			//        ^^ this dimension is automatically determined.
			{"(2,0)","+","(3,0)" }, // infix notation
			{"(1,2)","(2,3)","+"}, // RPM notation
			{"(1,2)","(2,3)","-"},
			{"(0,1)","(0,1)","*"},
			{"(1,0)","(8,9)","/"},
			{"(0,2)","4","^"},
			{"(2,0)","(3,0)","(4,0)","+","*" },
		};
		// expected results for the test cases above:
		char testcase_expectations[][TESTCASE_ARG_STRINGSBUFFERSIZE] = {
			//               ^^ this dimension is automatically determined.
			{"(5,0)" },
			{"(3,5)"},
			{"(-1,-1)"},
			{"(-1,0)"},
			{"(0.055,-0.062)"},
			{"(16.0)"},
			{"(14,0)" },
		};
		// How many test cases? Determine automatically from sizeof():
		//if (DEBUG) printf("sizeof(testcases)=%d\n", sizeof(testcases));
		int num_testcases = sizeof(testcases) / TESTCASE_ARGS / TESTCASE_ARG_STRINGSBUFFERSIZE;
		int num_testcases2 = sizeof(testcase_expectations) / TESTCASE_ARG_STRINGSBUFFERSIZE;
		if (DEBUG) printf("%d Testcases: ", num_testcases);
		ok &= print_ok_or_not(num_testcases== num_testcases2); // must match
		for (int i = 0; i < num_testcases; i++) {
			char *argv_emulated[6] = { 0 };
			printf("\nTest case #%d:\n", i);
			int c;
			for (c = 0; c < 6; c++) {
				argv_emulated[c] = testcases[i][c];
				if (strlen(testcases[i][c]) > 0) { // non-empty
					printf("%s ", testcases[i][c]);
				} else { // empty
					break;
				}
			}
			int argc_emulated = c;
			printf("\n");
			complex result = complex_calc(argc_emulated, argv_emulated);
			printf("result = "); print_complex(result); printf("\n");
			complex expectation = string_to_complex(testcase_expectations[i]);
			ok &= print_ok_or_not(complex_numbers_equal(result, expectation));
		}
		return unit_test_report_stdout("unit_tests_main() {all unit tests together}", ok);
	}
	else
	{
		complex c1;
		complex c2;
		char op;
		int poww;
    	complex result;

		int len_of_op = strlen("%c");
		int len_brkt = strlen("(%lf,%lf)");
		int len_arg2 = strlen(argv[2]);

	int is_rpn = 1; // true by default
	int arg_count = 0;
	char op = ' '; // operator
	complex_stack cstack = { { 0 }, 0 }; // empty stack
	for (int argnum = arg_list_start_index; argnum < argc; argnum++) 
	{
		
		if (argv[argnum][0] == 0) break; // empty string means end of test
		complex c;
		// now try out different patterns for arguments/operators
		int rv = sscanf(argv[argnum], "(%lf,%lf)", &c.real, &c.imag);
		if (rv > 0) { // parsing worked -> complex number
			
			cstack.item[cstack.stack_index++] = c;
			if (++arg_count == 1) { c1 = c; }
			else { c2 = c; }
		} else if (sscanf(argv[argnum], "%lf", &c.real) > 0) { // just a number
			c.imag = 0.0;
			if (DEBUG) { printf("c[%d]=", cstack.stack_index); print_complex(c); printf("\n"); }
			cstack.item[cstack.stack_index++] = c;
			if (++arg_count == 1) { c1 = c; }
			else { c2 = c; }
		} else if (strlen(argv[argnum]) == 1) { // operator
		 //op = sscanf(argv[argnum], "%c", &op); // works
			op = argv[argnum][0]; // "*" -> '*' // easier
			
			if (arg_count == 1 && (argc - arg_list_start_index) == 3) {
				is_rpn = 0;
				if (DEBUG) printf("Assuming infix notation\n", op);
				// do calculation later after we got all two arguments
			} else { // Must be RPN...
				is_rpn = 1;
				
				if (cstack.stack_index >= 2) {
					c2 = cstack.item[--cstack.stack_index]; // order: c2 is last, c1 was before
					c1 = cstack.item[--cstack.stack_index];
					complex result = { 0.0, 0.0 };
					switch (op) { // which operation?
					case '+': result = add_complex_numbers(c1, c2); break;
					case '-': result = sub_complex_numbers(c1, c2); break;
					case '*': result = mul_complex_numbers(c1, c2); break;
					case '/': result = div_complex_numbers(c1, c2); break;
					case '^': result = pow_complex_numbers(c1, c2); break;
					default: fprintf(stderr, "Error: Unknown operator '%c'\n", op);
					}
					cstack.item[cstack.stack_index++] = result;
				} else {
					fprintf(stderr, "RPN stack error (%d): not enough arguments\n", cstack.stack_index);
				}
			}
		} else { // error
			fprintf(stderr, "Error: cannot parse argv[%d]=\"%s\"\n", argnum, argv[argnum]);
		}
	}
	if (!is_rpn) { // normal notation (1,1) * (2,1)
		switch (op) {
		case '+': result = add_complex_numbers(c1, c2); break;
		case '-': result = sub_complex_numbers(c1, c2); break;
		case '*': result = mul_complex_numbers(c1, c2); break;
		case '/': result = div_complex_numbers(c1, c2); break;
		case '^': result = pow_complex_numbers(c1, c2); break;
		default: fprintf(stderr, "Error: Unknown or missing operator '%c'\n", op);
		}
	} else { // RPN notation (1,1) (2,1) * (0,1) +
	 //if (DEBUG) printf("RPN notation\n", op);
		result = cstack.item[--cstack.stack_index];
		if (cstack.stack_index != 0) {
			printf("RPN stack error (%d): too many remaining arguments\n", cstack.stack_index);
		}
	}
	}
	
}