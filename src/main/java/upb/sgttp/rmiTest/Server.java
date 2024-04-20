package upb.sgttp.rmiTest;

import java.rmi.Remote;

import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.TicketUtilites.Ticket;

public interface Server extends Remote {
    
    boolean ConsultarExistenciaTicket(String ticketID, String customerName) throws java.rmi.RemoteException;
    LinkedList<Ticket> getTicketList() throws java.rmi.RemoteException;
    
}
