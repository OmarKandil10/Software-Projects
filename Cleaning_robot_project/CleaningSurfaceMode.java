import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Write a description of interface CleaningStrtegy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface CleaningSurfaceMode extends Remote {
    void execute() throws RemoteException;
}
