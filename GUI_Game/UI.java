
/**
 * Write a description of interface UI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface UI
{   
    static UI StartUI(Playable game)
    {
        return new ConsoleUI(game);
    }
    void play();
    void print(String s);
}
