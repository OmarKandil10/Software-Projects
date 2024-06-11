import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 * Write a description of class DisplayComponent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
// Concrete Observer (Display Component)
class DisplayComponent extends UnicastRemoteObject implements Observer {
    public DisplayComponent() throws RemoteException {
        // Constructor logic
    }
    
    @Override
    public void update(String schedule) throws RemoteException {
        System.out.println("Display Component updated with new schedule: " + schedule);
        // Additional logic for updating the display
    }
}
