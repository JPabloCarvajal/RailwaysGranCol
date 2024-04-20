package upb.sgttp.rmiTest;

import java.rmi.Remote;

public interface Server extends Remote {
    
    boolean ConsultarExistenciaTicket(String ticketID, String customerName) throws java.rmi.RemoteException;
    
}
