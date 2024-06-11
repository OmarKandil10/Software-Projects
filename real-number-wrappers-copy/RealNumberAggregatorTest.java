import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RealNumberAggregatorTest.
 *
 * @author  Wolfgang Renz
 * @version 2022-11-22
 */
public class RealNumberAggregatorTest
{
    /**
     * Default constructor for test class RealNumberAggregatorTest
     */
    public RealNumberAggregatorTest()
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
        RealNumberAggregator agg1 = new RealNumberAggregator();
        RealNumberAggregator agg2 = new RealNumberAggregator();
        assertEquals(0.0, agg1.getReal(), 1e-15);
        // testing double values for equality requires numerical rounding 
        // interval, e.g. 10^-15, i.e. pow(10, -15) for double precision
        assertNotEquals(1e-15, agg2.getReal()); // negative test
    }

    @Test
    public void testNegativ()
    {
        RealNumberAggregator realNumb1 = new RealNumberAggregator();
        RealNumberAggregator realNumb2 = new RealNumberAggregator();
        realNumb1.add(5.0);
        realNumb2.add(-50.0);
        assertEquals(-5.0, realNumb1.negativ().getReal(), 1e-15);
        assertEquals(50.0, realNumb2.negativ().getReal(), 1e-15);
    }

    @Test
    public void testAdd()
    {
        RealNumberAggregator realNumb1 = new RealNumberAggregator();
        RealNumberAggregator realNumb2 = new RealNumberAggregator();
        realNumb1.add(5.0);
        realNumb2.add(-50.0);
        assertEquals(5.0, realNumb1.getReal(), 1e-15);
        assertEquals(-50.0, realNumb2.getReal(), 1e-15);
        realNumb1.add(5.0);
        realNumb2.add(-50.0);
        assertEquals(10.0, realNumb1.getReal(), 1e-15);
        assertEquals(-100.0, realNumb2.getReal(), 1e-15);
        for(int i= 0;i<10;i++){
            realNumb1.add(-1.0);
            assertEquals(9.0-i, realNumb1.getReal(), 1e-15);
            realNumb2.add(10.0);
            assertEquals(-90.0+i*10, realNumb2.getReal(), 1e-15);
        }
    }

    @Test
    public void testRealNumber()
    {
        RealNumberAggregator agg = new RealNumberAggregator();
        for(int i= 0;i<10;i++){
            assertEquals(2.0*i, agg.getReal(), 1e-15);
            agg.add(1.0).negativ().add(-1.0).negativ();
        }       
        assertEquals(new RealNumber(20), agg.toRealNumber());
    }


    @Test
    public void testMultiply()
    {
        RealNumberAggregator realNumb1 = new RealNumberAggregator();
        realNumb1.add(5.0);
        assertEquals(5.0, realNumb1.getReal(), 1e-15);
        realNumb1.multiply(2.0);
        assertEquals(10.0, realNumb1.getReal(), 1e-15);
    }

    @Test
    public void testInverse()
    {
        RealNumberAggregator realNumb1 = new RealNumberAggregator();
        realNumb1.add(2.0);
        assertEquals(2.0, realNumb1.getReal(), 1e-15);
        realNumb1.inverse();
        assertEquals(0.5, realNumb1.getReal(), 1e-15);
    }
}

