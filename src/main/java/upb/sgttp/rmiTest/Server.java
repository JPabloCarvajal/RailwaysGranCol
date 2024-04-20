package upb.sgttp.rmiTest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements HelloWithName {
    private String name;

    protected Server() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() throws RemoteException {
        return "¡Hola, " + name + "!";
    }

    @Override
    public void setName(String name) throws RemoteException {
        this.name = name;
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry();
            registry.rebind("Hello", server);
            System.out.println("Servidor listo");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.toString());
            e.printStackTrace();
        }
    }
    
}
