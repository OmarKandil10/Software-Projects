/**
 * Concrete Strategy Class for Quick Cleaning
 */
public class QuickCleaningStrategy implements CleaningSurfaceMode {
    private String floorStatus;

    public QuickCleaningStrategy(String floorStatus) {
        this.floorStatus = floorStatus;
    }

    @Override
    public void execute() {
        floorStatus(floorStatus);
    }

    public void floorStatus(String status) {
        if ("clean".equalsIgnoreCase(status)) {
            System.out.println("Executing Quick Cleaning Strategy");
            // Additional logic for Quick Cleaning
        } else {
            System.out.println("Quick Cleaning is not initiated.");
        }
    }
}
