import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 * Write a description of interface Observer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
// Observer Interface
public interface Observer extends Remote {
    void update(String schedule) throws RemoteException;
}
