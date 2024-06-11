
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RealNumberTest.
 *
 * @author  Wolfgang Renz
 * @version 2022-11-22
 */
public class RealNumberTest
{
    /**
     * Default constructor for test class RealNumberTest
     */
    public RealNumberTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testConstructor()
    {
        RealNumber realNumb1 = new RealNumber(5.0);
        RealNumber realNumb2 = new RealNumber(-50.0);
        assertEquals(5.0, realNumb1.getReal(), 1e-15);
        assertEquals(-50.0, realNumb2.getReal(), 1e-15);
    }
    

    @Test
    public void testmultiply()
    {
        RealNumber realNumb1 = new RealNumber(2);
        final ComplexNumber r = realNumb1.multiply(realNumb1);
        assertEquals(4.0, r.getReal(),1e-15);
        assertEquals(0.0, r.getImaginary(),1e-15);
    }
    
    
    @Test
    public void testinverse()
    {
        RealNumber realNumb1 = new RealNumber(2);
        final ComplexNumber r = realNumb1.inverse(realNumb1);
        assertEquals(0.5, r.getReal(),1e-15);
        assertEquals(0.0, r.getImaginary(),1e-15);
    }
    
}

