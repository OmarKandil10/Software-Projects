package implementation;

//import java.util.*;
import common.IPowerPlant;
/**
 * Write a description of class WindFarm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WindFarm extends GenericList implements IPowerPlant
{
    // instance variables - replace the example below with your own
   // private String name;
    //private String country;
    //private double capacity;
    private int numberTurbines;
    private int year;

    /**
     * Constructor for objects of class WindFarm
     */
    public WindFarm(String name, String country, double capacity,int numberTurbines,
                     int year)
    {
        // initialise instance variables
        super(name,country,capacity);
        this.numberTurbines = numberTurbines;
        this.year = year;
        //this.totalPower = 0;
    }

    /**
     * this method print the details of the  WindFarms, given by the user
     *
     */
    public void print(){
        System.out.println("name:" + name + " country:" + country + " capacity[MW]:" + capacity + " numberOfTurbines:" + numberTurbines +
                             " Year:" + year);
    }
    
    /**
     * getting the power of windfarms
     * 
    public double getCapacity(){
        return capacity;        
    }
    */
    
       /**
     * forming the string to print the farm details
     * 
     */
    public String printFormat(){                         
        String p = String.format("%-18s    %s %-16s  %s %-12.1f %s %-16d %s %d \n",name,"|", country,
                              "|", capacity,"|", numberTurbines, " |",year);
        return p;
    }
    
    /**
     * method return the country name
    public String getCountry(){
        return country;
    }
    */
   /**
    * 
    */
   public String toString(){
    
    return String.format("%-18s    %s %-16s  %s %-12.1f %s %-16d %s %d \n",name,"|", country,
                              "|", capacity,"|", numberTurbines, " |",year);
    }
   
   public void printt()
    {
    System.out.println(toString());
    }
   
   
}
