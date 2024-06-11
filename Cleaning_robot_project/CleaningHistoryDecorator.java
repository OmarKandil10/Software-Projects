
/**
 * Write a description of class CleaningHistoryDecorartor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CleaningHistoryDecorator extends BasicMap {
    public CleaningHistoryDecorator(CleaningSurfaceMode cleaningStrategy) {
        super(cleaningStrategy);
    }

    @Override
    public void execute() {
        super.execute();
        displayCleaningHistory();
    }

    private void displayCleaningHistory() {
        System.out.println("Displaying Cleaning History on Map");
        // Additional logic for displaying cleaning history
    }
}
