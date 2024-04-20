package upb.sgttp.rmiTest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import jp.linkedlist.singly.LinkedList;
import jp.util.iterator.Iterator;
import upb.sgttp.model.domain.TicketUtilites.Ticket;
import upb.sgttp.model.repository.Tickets.TicketRepository;

public class ServerImplement extends UnicastRemoteObject implements Server {
    
    private static final long serialVersionUID = 1L; // Añade este atributo

    private TicketRepository ticketRepository;

    public ServerImplement() throws RemoteException {
        super();
        this.ticketRepository = new TicketRepository("RailwaysGranCol\\src\\main\\java\\upb\\sgttp\\database\\tickets.json");
    }

    @Override
    public boolean ConsultarExistenciaTicket(String ticketID,String customerName){
        LinkedList<Ticket> ticketList = ticketRepository.getAllTicketsAsLinkedList();
        Iterator<Ticket> iterator = ticketList.iterator();
        while(iterator.hasNext()){
            Ticket ticket = iterator.next();
            if(ticket.getTicketId().equals(ticketID) && ticket.getCustomer().getNames().equals(customerName)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws RemoteException {
        ServerImplement server = new ServerImplement();
        System.out.println(server.ConsultarExistenciaTicket("prueba123","popeye"));
    }

    @Override
    public LinkedList<Ticket> getTicketList() throws RemoteException {

        return ticketRepository.getAllTicketsAsLinkedList();
    }
}
