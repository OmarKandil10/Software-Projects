package common;


/**
 * Write a description of interface IPowerPlant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IPowerPlant
{
    public static String getHeader()
    {
        return  String.format( "%-20s %-30s      | %-25s  | %-35s |%-30s|%n"+ "%n" +
                               "%-20s  | %-15s   | %-7s | %-17s |  %-5s | %-18s | %-14s |%-15s|%-15s|%n","","Common Variables","Spec.Variable WindFarm","Spec.Variable PowerPlant","Spec.Variables SolarPark", "Name","Country","Capacity(MW)","No of turbines","Year","constructionStart", "ConnectionYear","LandSize","ConnectionYear") +
                               "..............................................................................................................";

    }
    
    
    /**
     * getting the power of windfarms
     * 
     */
    public double getCapacity();
    
    /**
     * method return the country name
     */
    public String getCountry();
    
    /**
     * 
     */
    public String printFormat();
}
