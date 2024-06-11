import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.Serializable;

/**
 * Concrete Observable Subject (Cleaning Robot Schedule Data)
 */
class CleaningRobotData implements Serializable  {
    private int robotBatteryPercent;
    private List<String> cleaningAreas;
    private List<Observer> observers = new ArrayList<>();

    public CleaningRobotData() {
        this.robotBatteryPercent = 100; // Set initial battery percentage to 100
        this.cleaningAreas = new ArrayList<>();
        //simulateCleaning(); // Simulate cleaning to update battery percentage and cleaning areas
    }
    
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public int getRobotBatteryPercent() {
        return robotBatteryPercent;
    }

    public List<String> getCleaningAreas() {
        return Collections.unmodifiableList(cleaningAreas);
    }

    public void addCleaningArea(String cleaningArea) {
        cleaningAreas.add(cleaningArea);
        //notifyObservers(); // Notify observers when cleaning areas are updated
    }

  public void simulateCleaning(String floorStatus) {
    System.out.println("Initial Battery Percentage: " + robotBatteryPercent);

    // Adjust battery decrease based on the user input
    int batteryDecrease;
    if ("clean".equalsIgnoreCase(floorStatus)) {
        batteryDecrease = 20 + (int) (Math.random() * 10); // Random between 20-30%
    } else if ("wet".equalsIgnoreCase(floorStatus)) {
        batteryDecrease = 40 + (int) (Math.random() * 10); // Random between 40-50%
    } else if ("dirty".equalsIgnoreCase(floorStatus)) {
        batteryDecrease = 60 + (int) (Math.random() * 10); // Random between 60-70%
    } else {
        batteryDecrease = 5; // Default battery decrease if no specific floor status
    }

    // Simulate the decrease in battery percentage
    robotBatteryPercent -= batteryDecrease;
    System.out.println("Battery Percentage after Cleaning: " + robotBatteryPercent);

    // Simulate time passing during cleaning
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}



}


