package upb.sgttp.rmiTest;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ProcessServer {

    public ProcessServer() {
    }

    public void initializeServer() {
        try {
            // Crea una instancia del objeto remoto
            ServerImplement server = new ServerImplement();

            // Registra el objeto remoto en el registro RMI
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Server", server);

            System.out.println("Server is running...");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // Crea una instancia del objeto remoto
            ServerImplement server = new ServerImplement();

            // Registra el objeto remoto en el registro RMI
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Server", server);

            System.out.println("Server is running...");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
