/**
 * class RealNumber is a sketch of a wrapper class 
 * that allows elementary calculation
 * on real numbers via method calls. <br>
 * RealNumber objects are final constant and cannot be changed by any method,
 * i.e. a new instance is generated when processing each operation,
 * see e.g. the testMultipleOps method in RealNumberTest class. 
 * 
 * @author  Wolfgang Renz
 * @version 2022-11-22
 */
public class RealNumber extends ComplexNumber
{
    //private final double real; 
    //final means: cannot be changed any more after instantiation

    /**
     * Constructor for objects of class RealNumber
     */
    public RealNumber(double r)
    {
        super(r,0.0);
    }
    
    public RealNumber add(ComplexNumber z)
    {
        return new RealNumber(real + z.getReal());
    }

    
   

    /**
     * Method negativ acts as
     * result = - this
     *
     * @return a new instance with the negative value
     */
    /**public RealNumber negativ()
    {
        return new RealNumber(super(real,0.0));
    }
    */
    /**
     * Method add acts as
     * result = this + z
     *
     * @param z the real number to be added to this
     * @return a new instance with the sum calulated
     
    public RealNumber add(RealNumber z)
    {
        return new RealNumber(super(r,0.0)+ z.getReal());
    }
    
    
    

    /**
     * 
     
    public RealNumber inverse(RealNumber z)
    {
        if(z.getReal()==0){
            System.out.println("Inverse cannt be possible");
        }
        return new RealNumber(1 /super(r));
    }
    */
    
    /**
     * Method toString prints the real number into a String
     *
     * @return the String
     
    @Override
    public String toString()
    {
        return ""+ real;
    }
    */
    /**
     * Method equals is required for testing because
     * assertEquals will use it, check RealNumberTest test methods!
     *
     * @param obj any object
     * @return true if object is RealNumber with same value, false otherwise
     */
    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof RealNumber)){
            return false;
        }
        RealNumber z = (RealNumber) obj;
        if (this.getReal()== z.getReal()){
            return true;
        }
        return false;
    }
}

