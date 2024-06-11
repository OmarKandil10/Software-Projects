import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.*;
/**
 *  This class is the main class of the "subway hunt" application. 
 *  "subway hunt" is an adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author Ritika Bansal and Omar kandil
 * @version 2022.11.15
 */

public class Game implements Playable
{
    private Parser parser;
    private Room currentRoom;
    private ArrayList<Item> allItems;
    private Stack<Room> roomStack;
    private Room previousRoom;
    private int points;
    private boolean gameWon;
    private boolean gameLost;
    private UI ui;
    private Room insideMall, foodCourt, gamingZone,shoppingCentre,outsideMall;
    private Room wc, terraceView, exit1,exit2;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {        
        createRooms();
        parser = new Parser();
        allItems = new ArrayList<>();
        roomStack = new Stack<>();
        points = 0;
        ui=UI.StartUI(this);
    }
    public void start()
    {
        ui.play();
    
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        //Room outside, theater, pub, lab, office;
        insideMall = new Room("inside of the Mall");
        foodCourt = new Room("in the FoodCourt");
        foodCourt.addItem(new Item("IndianFood", "10 Euros", "500g"));
        foodCourt.addItem(new Item("ThaiFood", "10.50 Euros", "800g"));
        foodCourt.addItem(new Item("ChineseFood", "9 Euros", "800g"));
        
        gamingZone = new Room("in the Gaming zone");
        gamingZone.addItem(new Item("PlayStation", "500 Euros", "1500kg"));
        gamingZone.addItem(new Item("ChessBoard", "25 Euros", "350g"));
        gamingZone.addItem(new Item("FootBall", "30 Euros", "250g"));
        
        shoppingCentre =new Room("in the shoppingCentre");
        shoppingCentre.addItem(new Item("Shoes", "150 Euros", "300g"));
        shoppingCentre.addItem(new Item("Books", "60 Euros", "150g"));
        shoppingCentre.addItem(new Item("Bags", "100 Euros", "200g"));
        
        outsideMall= new Room("outside of the Mall");
    
        wc = new Room("in the WC");
        terraceView= new Room(" going towards Terrace ");
        exit1 = new Room(" towards exit");
        exit2 = new Room("towards exit");
        
        insideMall.setExit("straight",foodCourt);
        insideMall.setExit("back",shoppingCentre);
        insideMall.setExit("left",gamingZone);
        insideMall.setExit("right",outsideMall);
        
        foodCourt.setExit("back",insideMall);
        foodCourt.setExit("right",terraceView);
        foodCourt.setExit("left",wc);
        
        gamingZone.setExit("right",insideMall);
        gamingZone.setExit("straight",wc);
        gamingZone.setExit("back",exit1);
        
        shoppingCentre.setExit("straight",insideMall);
        shoppingCentre.setExit("left",exit1);
        shoppingCentre.setExit("right",exit2);
        
        outsideMall.setExit("left",insideMall);
        
        
        wc.setExit("right",foodCourt);
        wc.setExit("back",gamingZone);
        
        terraceView.setExit("left",foodCourt);
        
        exit2.setExit("left",shoppingCentre);
        
        exit1.setExit("straight",gamingZone);
        exit1.setExit("right",shoppingCentre);
        
        
        currentRoom = outsideMall;
    }

    // /**
     // *  Main play routine.  Loops until end of play.
     // */
    // public void play() 
    // {            
        // printWelcome();

        // // Enter the main command loop.  Here we repeatedly read commands and
        // // execute them until the game is over.
        // while (!gameWon && !gameLost) {
            // Command command = parser.getCommand();
            // gameWon = processCommand(command);
        // }
        // if(gameLost) {
            // System.out.println("Thanks you for playing, but you lost! :C");
            // return;
        // }
        // System.out.println("Thank you for playing.  Good bye.");    //Winning and terminating
    // }

    /**
     * Print out the opening message for the player.
     */
    public void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Subway Hunt!");
        System.out.println("Subway Hunt is a new, incredibly boring adventure game.");
        System.out.println("The player is in the middle of the subwayStationa and the Mall");
        System.out.println("The player have to choose the direction, where he wants to go. His task is to take the stuff from the mall and deliver it to the prpoer address");
        System.out.println("In the mall, there are various rooms. In order to go in the room there are vaoius commands!!");
        System.out.println("Type 'help' if you want to go the proper place.");
        System.out.println();
        System.out.println("You are " + currentRoom.getLongDescription());
        //System.out.print("Exits: ");
    }

    // /**
     // * Given a command, process (that is: execute) the command.
     // * @param command The command to be processed.
     // * @return true If the command ends the game, false otherwise.
     // */
    // public boolean processCommand(Command command) 
    // {
        // boolean wantToQuit = false;

        // if(command.isUnknown()) {
            // System.out.println("I don't know what you mean...");
            // return false;
        // }

        // String commandWord = command.getCommandWord();
        // if (commandWord.equals("help")) {
            // printHelp();
        // }
        // else if (commandWord.equals("walk")) {
             // wantToQuit = goRoom(command);
        // }
        // else if (commandWord.equals("quit")) {
            // wantToQuit = quit(command);
        // }
        // else if (commandWord.equals("allItems")) {
            // printAllItems();
        // }else if (commandWord.equals("take")) {
            // takeItem(command);
            // if(gameWon)
                // wantToQuit = true;
        // } else if (commandWord.equals("drop")) {
            // placeItem(command);
        // } else if (commandWord.equals("look")) {
            // System.out.println(currentRoom.getLongDescription());
        // }else if (commandWord.equals("back")) {
            // back(command);
        // }
        // // else command not recognised.
        // return wantToQuit;
    // }

    // implementations of user commands:
    /**
     * print all the items 
     */
    public void printAllItems(){
        if(allItems.size() == 0){
           System.out.println("There is nothing");
        }
        else{
        System.out.println("List of items, rooms are carying");
        for(Item item: allItems){
            if(item != null)
                System.out.println(item.getLongString());
            }
        }
    }
    
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the SubwayStation.");
        System.out.println("If you want to go inside the mall, you should type \" insideMall\" or subwayStation with the command words");
        System.out.println("You should type the letters of the rooms properly!!");
        System.out.println("You can pick and drop several items in and from the room");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    public boolean goRoom(Command command) 
    {
        
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return false;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            roomStack.add(currentRoom);
            currentRoom = nextRoom;
            
            if(currentRoom.equals(exit1) || currentRoom.equals(exit2)){
                gameLost = true;
                return true;
            }
            System.out.println("You are " + currentRoom.getLongDescription());
        }
        return false;
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    public boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    /**
     * Search the item by its name 
     * find the item by its matching name, or else return nul
     */
    private Item searchByName(String s, ArrayList<Item> L){
        int n=0;
        while (n < L.size()) {
            Item i = L.get(n);
            if (s.equals(i.getDescription())) 
                return i;
            n++;
        }
        return null; 
    }
    
    /**
     * doDrop: 
     *   1. checks if user specified a thing to be dropped
     *   2. checks that it's there in inventory
     *   3. deletes that item from inventory, and adds to currentRoom
     *   4. prints a message about it.
     * 
     */
    public void placeItem(Command c) {
        if (! c.hasSecondWord()) {  // "DROP",but no object named
            System.out.println("Drop what?");
            return;
        }
        String s = c.getSecondWord();
        Item i = searchByName(s, allItems);
        if (i == null) {
            System.out.println("You don't have a " + s);
            return;
        }
        allItems.remove(i);
        points -= 10;
        System.out.println("Current Points: " + points);
        currentRoom.addItem(i);
        System.out.println("You have dropped the " + s);
    }
    
    /**
     * doTake: doesn't do anything yet
     */
    public void takeItem (Command c) {
        if (! c.hasSecondWord()) {  // "Take",but no object named
            System.out.println("Take what?");
            return;
        }
        String s = c.getSecondWord();
        Item i = searchByName(s, currentRoom.getItems());
        if (i == null) {
            System.out.println("You don't have a " + s);
            return;
        }
        if(allItems.contains(i)) {
            System.out.println("You already took it.");
            return;
        }
        
        currentRoom.removeItem(i);
        allItems.add(i);
        points += 10;
        System.out.println("Current Points: " + points);
        if(points >= 30) {
            gameWon = true;
        }
        System.out.println("You have taken the " + s);
    }
    
    /**
     * 
     */
    public void back(Command command)
    {
        if(command.hasSecondWord())
        {
            System.out.println("Back What?");
            return;
        }if(roomStack.empty()){
            System.out.println("You cannt go back, there is no room");
            }
        else{
            currentRoom= roomStack.peek();
            System.out.println("You have gone back to the previous room.");
            System.out.println(currentRoom.getLongDescription());
            roomStack.pop();
            
        }
        
    }
    
}
