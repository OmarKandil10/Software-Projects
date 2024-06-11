
/**
 * RealNumberAggregator provides instances that keeps a double precision real
 * for aggregate processing of multiple numerical operations without the overhead
 * produced by generating new instances like the RealNumber class would do,
 * Usage see e.g. RealNumberAggregatorTest methods with loops. <br><br>
 * It acts similar as StringBuffer with respect to the String class.
 *
 * @author  Wolfgang Renz
 * @version 2022-11-22
 */
public class RealNumberAggregator
{
    private double real; 

    /* Default constructor requires no action.
     * Without an implementation it uses the Object classes default constructor
     * since that is it's super class.
     */

    double getReal()
    {
        return real;
    }

    /**
     * Method add acts like addToThis: 
     * this += z 
     *
     * @param z the real number to be added to this
     */
    public RealNumberAggregator add(double z)
    {
        real+= z;
        return this;
    }

    /**
     * Method negativ acts like changeSign:
     * this  = -this <br>
     * Such a method should be implemented in class RealNumberAggregator
     *
     */
    public RealNumberAggregator negativ()
    {
        real = -real;
        return this;
    }

    /**
     * Method toRealNumber
     *
     * @return the content wrapped into a RealNumber
     */
    RealNumber toRealNumber()
    {
        return new RealNumber(real);
    }
    /**
     * 
     */
    public RealNumberAggregator multiply(double z)
    {
        real *= z;
        return this;
    }
    
    /**
     * 
     */
    public RealNumberAggregator inverse()
    {
         if(real==0){
            System.out.println("Inverse cannt be possible");
         }
        real =(1/(real));
        return this;
    
    
    }
    // /**
    // * Method equals is required for testing
    // * when assertEquals is used for RealNumberAggregator instances.
    // * 
    // * @param obj any object to compare with
    // * @return true if object is RealNumberAggregator with same value, false otherwise
    // */
    // @Override
    // public boolean equals(Object obj)
    // {
    // if(!(obj instanceof RealNumberAggregator)){
    // return false;
    // }
    // RealNumberAggregator z = (RealNumberAggregator) obj;
    // if (this.getReal()== z.getReal()){
    // return true;
    // }
    // return false;
    // }

}
