import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 * Write a description of class CleaningRobot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
// CleaningRobot class (placeholder)
public class CleaningRobot extends UnicastRemoteObject implements CleaningRobotService {
     public CleaningRobot() throws RemoteException
     {}
     
     @Override
    public void scheduleCleaning(CleaningSurfaceMode cleaningStrategy) throws RemoteException {
        // Implementation logic for scheduling cleaning based on the strategy
        System.out.println("Cleaning Robot scheduled for cleaning.");
        cleaningStrategy.execute();
    }
}

