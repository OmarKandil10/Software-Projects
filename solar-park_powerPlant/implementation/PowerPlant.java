package implementation;


import common.IPowerPlant;

/**
 * Write a description of class PowerPlant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PowerPlant extends GenericList implements IPowerPlant
{
    // instance variables - replace the example below with your own
    //private String name;
   // private String country;
    //private double capacity;
    private int Start;
    private int Year;
    private String Table;
    
    /**
     * Constructor for objects of class PowerPlant
     */
    public PowerPlant( String name, String country, double capacity, int constructionStart, int  connectionYear)

    {
        // initialise instance variables
        super(name,country,capacity);
        Start = constructionStart;
        Year = connectionYear;
    }
    
    public void PowerPlantTable(String name)
    {
       Table = name;
    }
    
    public void print()
    {
        // put your code here
    System.out.println( ", name: " + name + ", capacity : " + capacity + ", constructionStart : " + Start + ", connectionYear : " + Year + ", country: " + country);
    }
    /**
    public double getcapacity()
    {
        return capacity;
    }
    */
    public void getInformation()
    {
        System.out.printf("| %-20s   | %-15 | %-42s | %-23s|%18s |%n",name ,country, capacity, Start, Year);
    }
    
    public String printFormat()
    {
        String PF = String.format("%-20s  | %-15s   | %-42s| %-23s|%-16s%n",name ,country,  capacity, Start, Year);
        return PF;
    }
    
    
    /**
    public String getcountry()
    {
        return country;
    }
    */
    public String toString()
    {

        return String.format("%-20s    | %-15s   | %-42s| %-23s|%-16s|%-14d |%-15s|%-15s ",name,country,capacity,"","",Start, Year,"","");
    }
    
    public void printt()
    {
    System.out.println(toString());
    }
    
}
    
    

