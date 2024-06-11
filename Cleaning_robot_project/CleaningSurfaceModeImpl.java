import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CleaningSurfaceModeImpl extends UnicastRemoteObject implements CleaningSurfaceMode {
    private String floorStatus;

    public CleaningSurfaceModeImpl(String floorStatus) throws RemoteException {
        this.floorStatus = floorStatus;
    }

    @Override
    public void execute() throws RemoteException {
        // Implementation logic based on floor status
        System.out.println("Cleaning strategy executed based on floor status");
    }
}