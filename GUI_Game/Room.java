import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits; // stores exits of this room.
    // the number of items currently in the room
    private int numberOfItems;
    // items in the room
    private ArrayList<Item>items;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<Item>();
        numberOfItems=0;
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        String longDescription=  description + ".\n" + getExitString();
        if(items.size() > 0){
        longDescription += "\n These are items of items in this room:\n";
        for(Item item :items){
            longDescription += "\t" + item.getDescription() +
            " "+ item.getPrice() + " " + item.getWeight() + "\n";
        }
        }
        return longDescription;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        // if (direction==null){
        // throw new IllegalArgumentException("null direction in room's getexit call");
        
        // }
        
        
        return exits.get(direction);
    }
    /**
     * Cretae a method to add the items in the arraylist
     */
    public void addItem(Item newItem){
        items.add(newItem);
    }
    /**
     * Create a method to remove the items from the list
     */
    public void removeItem(Item newItem){
        items.remove(newItem);
    }
    /**
     * Create a method to get the item
     */
    public ArrayList<Item> getItems(){
            return this.items;
    }
    /**
     * 
     */
    public Room leaveRoom(String direction){
         return exits.get(direction);
    
    }
}