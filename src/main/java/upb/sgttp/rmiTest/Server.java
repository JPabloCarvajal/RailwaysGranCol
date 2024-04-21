package upb.sgttp.rmiTest;

import java.rmi.Remote;
import java.util.Date;

import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.RouteUtilities.Station;
import upb.sgttp.model.domain.TicketUtilites.CustomerCategory;
import upb.sgttp.model.domain.TicketUtilites.StatusEnum;
import upb.sgttp.model.domain.TicketUtilites.Ticket;
import upb.sgttp.model.domain.persons.Contact;
import upb.sgttp.model.domain.persons.Customer;

public interface Server extends Remote {
    
    boolean ConsultarExistenciaTicket(String ticketID, String customerName) throws java.rmi.RemoteException;
    
    LinkedList<Ticket> getTicketList() throws java.rmi.RemoteException;
    
    boolean dataToTicketNormalRoute(Customer customer, Contact contacto, Station A,Station B, CustomerCategory category,String ticketId,
    Date purchaseDate,Date boardingDate,Date arriveDate,StatusEnum status) throws java.rmi.RemoteException;
    
    boolean dataToTicketRouteList(Customer customer, Contact contacto,LinkedList<Station> estacionesPorPasar, CustomerCategory category,String ticketId,
    Date purchaseDate,Date boardingDate,Date arriveDate,StatusEnum status) throws java.rmi.RemoteException;
}
