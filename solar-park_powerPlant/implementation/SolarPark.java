package implementation;

import common.IPowerPlant;

/**
 * Write a description of class SolarPark here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SolarPark extends GenericList implements IPowerPlant
{
    private int landSize;
    private int connectionYear;
    
    
    /**
     * 
     */
    public SolarPark(String name, String country, double capacity,int landSize,
                     int connectionYear)
    {
        super(name,country,capacity);
        this.landSize= landSize;
        this.connectionYear= connectionYear;
    }
    
    public void print(){
        System.out.println("name:" + name + " country:" + country + " capacity[MW]:" + capacity + " landSize" + landSize+
                             " connectionYear " + connectionYear);
    }
    
    public String printFormat()
    {
        String PF = String.format("%-20s  | %-15s   | %-77.2f | %-20s  | %-20s %n",name ,country,  capacity, landSize, connectionYear);
        return PF;
    }
    
    
    public String toString()
    {
    
    return String.format("%-20s    | %-15s   | %-42.2f| %-23s|%-50s|%-60s |%-50s| %-60s | %-70s ",name,country,capacity,"","","","",landSize,connectionYear);
    }
    
    public void printt()
    {
    System.out.println(toString());
    }
}
