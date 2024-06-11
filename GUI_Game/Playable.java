
/**
 * Write a description of interface Playable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Playable
{
  void printWelcome();
  //boolean processCommand(Command command);
  boolean goRoom(Command command);
  void printAllItems();
  void placeItem(Command c);
  void takeItem (Command c);
  boolean quit(Command command);
  void back(Command command);
}
