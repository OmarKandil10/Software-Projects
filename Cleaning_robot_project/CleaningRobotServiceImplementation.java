import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CleaningRobotServiceImplementation extends UnicastRemoteObject implements CleaningRobotService {
    public CleaningRobotServiceImplementation() throws RemoteException {
    // Additional constructor logic
    System.out.println("CleaningRobotServiceImplementation instance created.");
}


    @Override
    public void scheduleCleaning(CleaningSurfaceMode cleaningStrategy) throws RemoteException {
        // Implementation logic for scheduling cleaning based on the strategy
        System.out.println("Cleaning Robot scheduled for cleaning.");
        cleaningStrategy.execute();
    }
}