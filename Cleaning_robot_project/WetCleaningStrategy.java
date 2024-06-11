/**
 * Concrete Strategy Class for Wet Cleaning
 */
public class WetCleaningStrategy implements CleaningSurfaceMode {
    private String floorStatus;

    public WetCleaningStrategy(String floorStatus) {
        this.floorStatus = floorStatus;
    }

    @Override
    public void execute() {
        floorStatus(floorStatus);
    }

    public void floorStatus(String status) {
        if ("Dirty".equalsIgnoreCase(status)) {
            System.out.println("Executing Wet Cleaning Strategy");
            
        } else {
            System.out.println("Wet Cleaning is not initiated.");
        }
    }
}
