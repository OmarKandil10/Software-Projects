import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

public class CleaningRobotServer {
    public static void startRegistry() throws RemoteException
    {
        LocateRegistry.createRegistry( Registry.REGISTRY_PORT );
        RemoteServer.setLog( System.err ); 
    }
    
    public static void main(String[] args) {
        String floorStatus = "";
        try {
            // Create and export the registry on port 1099
            //LocateRegistry.createRegistry(1099);

            // Create an instance of the remote service implementation
            CleaningRobotService cleaningRobotService = new CleaningRobotServiceImplementation();

            // Bind the remote service to the registry
            Naming.rebind("rmi://localhost/CleaningRobotService", cleaningRobotService);

            // Bind the CleaningSurfaceModeImpl to the registry
            CleaningSurfaceModeImpl cleaningSurfaceModeImpl = new CleaningSurfaceModeImpl(floorStatus);
            Naming.rebind("rmi://localhost/CleaningSurfaceModeImpl", cleaningSurfaceModeImpl);

            System.out.println("CleaningRobotService and CleaningSurfaceModeImpl registered in the registry.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
