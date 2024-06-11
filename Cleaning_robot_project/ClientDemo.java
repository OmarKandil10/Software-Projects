import java.util.Scanner;
import java.rmi.Naming;
import java.io.Serializable;

public class ClientDemo implements Serializable {
    public static void main(String[] args) throws java.rmi.RemoteException {
        String floorStatus = "";
        CleaningSurfaceMode wetCleaningStrategy = null;
        CleaningSurfaceMode quickCleaningStrategy = null;
        CleaningSurfaceMode dryCleaningStrategy = null;

        try {
            // Look up the remote service from the registry
            CleaningRobotService cleaningRobotService =
                    (CleaningRobotService) Naming.lookup("rmi://localhost/CleaningRobotService");

            // Look up the CleaningSurfaceModeImpl from the registry
            CleaningSurfaceMode cleaningSurfaceMode =
                    (CleaningSurfaceMode) Naming.lookup("rmi://localhost/CleaningSurfaceModeImpl");

            // Prompt the user to enter floor status
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter floor status (clean/dirty/wet): ");
            floorStatus = scanner.nextLine();
            scanner.close();

            // Creating instances of Concrete Strategy Classes
            wetCleaningStrategy = new WetCleaningStrategy(floorStatus);
            quickCleaningStrategy = new QuickCleaningStrategy(floorStatus);
            dryCleaningStrategy = new DryCleaningStrategy(floorStatus);

            // Schedule cleaning with the selected strategy
            cleaningRobotService.scheduleCleaning(cleaningSurfaceMode);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Creating instances of Concrete Decorator Classes
        BasicMap decoratedWithRegionHighlight = new RegionHighlightDecorator(wetCleaningStrategy);
        BasicMap decoratedWithCleaningHistory = new CleaningHistoryDecorator(quickCleaningStrategy);
        BasicMap decoratedWithCustomMarkers = new CustomMapMarkers(dryCleaningStrategy);

        // Demonstrating Decorator Pattern
        decoratedWithRegionHighlight.execute();    // Enhanced with region highlighting
        decoratedWithCleaningHistory.execute();    // Enhanced with cleaning history
        decoratedWithCustomMarkers.execute();      // Enhanced with custom markers

        // Demonstrating Strategy Pattern based on floor status
        if ("clean".equalsIgnoreCase(floorStatus)) {
            quickCleaningStrategy.execute();
        } else if ("dirty".equalsIgnoreCase(floorStatus)) {
            wetCleaningStrategy.execute();
        } else if ("wet".equalsIgnoreCase(floorStatus)) {
            dryCleaningStrategy.execute();
        }
        
        // Creating Observable Subject with initial battery percentage at the charging dock
        CleaningRobotData cleaningScheduleData = new CleaningRobotData();

        
        // Creating Observers
        Observer displayComponent = new DisplayComponent();
        Observer robotScheduler = new RobotScheduler();

        // Adding Observers to the Observable Subject
        cleaningScheduleData.addObserver(displayComponent);
        cleaningScheduleData.addObserver(robotScheduler);

        // // Set the initial battery percentage when the robot is at the charging dock
        // cleaningScheduleData.setInitialBatteryPercentageAtChargingDock();

        // // Simulate the decrease in battery percentage over time during cleaning
        // cleaningScheduleData.decreaseBatteryPercentage(10);
        
        cleaningScheduleData.simulateCleaning(floorStatus);

        // Setting a new schedule, which will notify and update the Observers
        //cleaningScheduleData.setSchedule("New Cleaning Schedule");
    }
}
