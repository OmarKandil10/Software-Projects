
/**
 * Write a description of class ComplexNumber here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ComplexNumber
{
    protected double real, imaginary;
   
/**
 * Constructor for rael and imaginary numbers
 */
public ComplexNumber (double r, double i)
{
    real = r;
    imaginary = i;
}

/**
 * Prints the real and imaginary numbers in there complex form
 * for Example(2+3j)
 */
public void getComplexNumber()
{
    System.out.print(real+"+"+imaginary+ "j");

}

/**
 * Prints the complex numebr in the brackets
 * for Example(2,3)
 */
public void getComplexNumbers()
{
    System.out.print("("+real +","+imaginary +")");

}

/**
 * Return the real number
 */
public double getReal()
{
    return real;
}

/**
 * Return the imaginary number
 */
public double getImaginary()
{
    return imaginary;

}

/**
 * Adding the complex numbers
 * @parm complex number(real and imaginary part)
 */
public ComplexNumber add(ComplexNumber complexNumber)
{
    ComplexNumber result = new ComplexNumber(0,0);
    result.real = real + complexNumber.real;
    result.imaginary = imaginary +complexNumber.imaginary;
    return result;
}

/**
 * Multiply the complex numebrs 
 * @parm complex numbers (real and imaginary part)
 */
public ComplexNumber multiply(ComplexNumber complexNumber)
{
    ComplexNumber result = new ComplexNumber(0,0);
    result.real= (real*complexNumber.real)-(imaginary*complexNumber.imaginary);
    result.imaginary =(real *complexNumber.imaginary)+(imaginary *complexNumber.real);
    return result;
}

/**
 * Return the inverse of the complex number
 */
public ComplexNumber inverse(ComplexNumber n1)
{
    ComplexNumber result = new ComplexNumber(0,0);
    result.real= n1.real/( (n1.real*n1.real) + (n1.imaginary*n1.imaginary));
    result.imaginary =-n1.imaginary/ ((n1.real*n1.real) + (n1.imaginary*n1.imaginary));
    return result;
}
/**
 * 
 */

@Override
public String toString(){
    return String.format("(%1.1f,%1.1f)",real,imaginary);
}
}
