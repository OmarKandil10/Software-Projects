

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ComplexNumberTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ComplexNumberTest
{
    /**
     * Default constructor for test class ComplexNumberTest
     */
    public ComplexNumberTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    @Test
    public void testConstructor()
    {
        ComplexNumber complexN1 = new ComplexNumber(1, 1);
        ComplexNumber complexN2 = new ComplexNumber(2, 2);
        assertEquals(1, complexN1.getReal(), 1e-15);
        assertEquals(1, complexN1.getImaginary(), 1e-15);
        assertEquals(2, complexN2.getReal(), 1e-15);
        assertEquals(2, complexN2.getImaginary(), 1e-15);
    }


    @Test
    public void testAdd()
    {
        ComplexNumber complexN1 = new ComplexNumber(1, 1);
        ComplexNumber complexN2 = new ComplexNumber(2, 2);
        final ComplexNumber r = complexN1.add(complexN2);
        assertEquals(3.0, r.getReal());
        assertEquals(3.0, r.getImaginary());
        
   }
   
   @Test
    public void testtoString()
    {
        ComplexNumber complexN1 = new ComplexNumber(1,1);
        ComplexNumber complexN2 = new ComplexNumber(2,2);
        assertEquals("(1.0,1.0)", complexN1.toString());
        assertEquals("(2.0,2.0)", complexN2.toString());
    }
    
    @Test
    public void testMultiply()
    {
        ComplexNumber complexN1= new ComplexNumber(1, 1);
        ComplexNumber complexN2= new ComplexNumber(2, 2);
        final ComplexNumber r = complexN1.multiply(complexN2);
        assertEquals(0.0, r.getReal());
        assertEquals(4.0, r.getImaginary());
        
    }
    
    @Test
    public void testinverse()
    {
        ComplexNumber complexN1= new ComplexNumber(1, 1);
        final ComplexNumber r = complexN1.inverse(complexN1);
        assertEquals(0.5, r.getReal());
        assertEquals(-0.5, r.getImaginary());
    }
}

