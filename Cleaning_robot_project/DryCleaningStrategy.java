/**
 * Concrete Strategy Class for Dry Cleaning
 */
public class DryCleaningStrategy implements CleaningSurfaceMode {
    private String floorStatus;

    public DryCleaningStrategy(String floorStatus) {
        this.floorStatus = floorStatus;
    }

    @Override
    public void execute() {
        floorStatus(floorStatus);
    }

    public void floorStatus(String status) {
        if ("Wet".equalsIgnoreCase(status)) {
            System.out.println("Executing Dry Cleaning Strategy");
            // Additional logic for Quick Cleaning
        } else {
            System.out.println("Dry Cleaning is not initiated.");
        }
    }
}
