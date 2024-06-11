
/**
 * Write a description of class CustomMapMarkers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CustomMapMarkers extends BasicMap {
    public CustomMapMarkers(CleaningSurfaceMode cleaningStrategy) {
        super(cleaningStrategy);
    }

    @Override
    public void execute() {
        super.execute();
        addCustomMarkers();
    }

    private void addCustomMarkers() {
        System.out.println("Adding Custom Markers to Map");
        // Additional logic for adding custom markers
    }
}
