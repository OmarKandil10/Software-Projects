import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Write a description of class CleaningSurfaceModeDecorator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
// Abstract Map class implementing CleaningSurfaceMode
public abstract class BasicMap implements CleaningSurfaceMode {
    private CleaningSurfaceMode cleaningStrategy;

    public BasicMap(CleaningSurfaceMode cleaningStrategy) {
        this.cleaningStrategy = cleaningStrategy;
    }

    @Override
    public void execute() {
        try
        {
            cleaningStrategy.execute();
        }
        catch (RemoteException re)
        {
            re.printStackTrace();
        }
    }
}
