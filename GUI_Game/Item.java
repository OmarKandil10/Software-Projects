import java.util.ArrayList;
import java.util.HashMap;
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String description;
    private String price;
    private String weight;
    //private ArrayList<String>items;
    
    /**
     * Constructor for objects of class Item
     */
    public Item(String description, String price, String weight)
    {
        this.description = description;
        this.price = price;
        this.weight = weight;
    }
    
  
    /**
     * Method tp get the description 
     */
    public String getDescription(){
        return description;
    }
    /**
     * 
     */
    public String getPrice(){
        return price;
    }
    /**
     * 
     */
    public String getWeight(){
        return weight;
    }
    
    public String getLongString() {
        return description + " " + price + " " +  weight;
    }
}
