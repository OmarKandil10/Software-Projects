import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public interface CleaningRobotService extends Remote {
    void scheduleCleaning(CleaningSurfaceMode cleaningStrategy) throws RemoteException;
}