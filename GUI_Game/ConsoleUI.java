
/**
 * Write a description of class ConsoleUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ConsoleUI implements UI
{
    private Parser parser;
    private Playable player;
    private boolean gameWon;
    private boolean gameLost;
    

    /**
     * Constructor for objects of class ConsoleUI
     */
    public ConsoleUI(Playable game)
    {
        parser = new Parser();
        player =game;
    }

    public void print(String output)
    {
        System.out.println(output);
    
    }
    
    public void play() 
    {            
        player.printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        while (!gameWon && !gameLost) {
            Command command = parser.getCommand();
            gameWon = processCommand(command);
        }
        if(gameLost) {
            this.print("Thanks you for playing, but you lost! :C");
            return;
        }
        this.print("Thank you for playing.  Good bye.");    //Winning and terminating
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        this.print("");
        this.print("Welcome to Subway Hunt!");
        this.print("Subway Hunt is a new, incredibly boring adventure game.");
        this.print("The player is in the middle of the subwayStationa and the Mall");
        this.print("The player have to choose the direction, where he wants to go. His task is to take the stuff from the mall and deliver it to the prpoer address");
        this.print("In the mall, there are various rooms. In order to go in the room there are vaoius commands!!");
        this.print("Type 'help' if you want to go the proper place.");
        this.print("");
        //this.print("You are " + currentRoom.getLongDescription());
        //player.print("Exits: ");
    }
    
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("walk")) {
             wantToQuit = player.goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = player.quit(command);
        // }
        // else if (commandWord.equals("allItems")) {
            // printAllItems();
        }else if (commandWord.equals("take")) {
            player.takeItem(command);
            if(gameWon)
                wantToQuit = true;
        } else if (commandWord.equals("drop")) {
            player.placeItem(command);
        // } else if (commandWord.equals("look")) {
            // System.out.println(currentRoom.getLongDescription());
        }else if (commandWord.equals("back")) {
            player.back(command);
        }
        // else command not recognised.
        return wantToQuit;
    }
     public void printHelp() 
    {
        this.print("You are lost. You are alone. You wander");
        this.print("around at the SubwayStation.");
        this.print("If you want to go inside the mall, you should type \" insideMall\" or subwayStation with the command words");
        this.print("You should type the letters of the rooms properly!!");
        this.print("You can pick and drop several items in and from the room");
        this.print(" ");
        this.print("Your command words are:");
        parser.showCommands();
    }
}

