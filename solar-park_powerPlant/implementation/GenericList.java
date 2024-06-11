package implementation;

import common.IPowerPlant;
/**
 * Write a description of class List here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class GenericList 
{
    // instance variables - replace the example below with your own
    protected String name;
    public String country;
    public double capacity;

    /**
     * 
     */
    public GenericList(String name, String country, double capacity){
        this.name = name;
        this.country=country;
        this.capacity = capacity;
    
    }

    /**
     * getting the power of windfarms
     * 
     */
    public double getCapacity(){
        return capacity;        
    }

    /**
     * method return the country name
     */
    public String getCountry(){
        return country;
    }
    
    public abstract void printt();
    public abstract String toString();
    public abstract String printFormat();
    public abstract void print();
    
}
