
/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
// Concrete Decorator Classes
public class RegionHighlightDecorator extends BasicMap {
    public RegionHighlightDecorator(CleaningSurfaceMode cleaningStrategy) {
        super(cleaningStrategy);
    }

    @Override
    public void execute() {
        super.execute();
        highlightRegion();
    }

    private void highlightRegion() {
        System.out.println("Highlighting Cleaning Region on Map");
        // Additional logic for region highlighting
    }
}

