package upb.sgttp.rmiTest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import jp.linkedlist.singly.LinkedList;
import jp.util.iterator.Iterator;
import upb.sgttp.model.domain.RouteUtilities.CustomerRoute;
import upb.sgttp.model.domain.RouteUtilities.Route;
import upb.sgttp.model.domain.RouteUtilities.RoutesMap;
import upb.sgttp.model.domain.RouteUtilities.Station;
import upb.sgttp.model.domain.TicketUtilites.CustomerCategory;
import upb.sgttp.model.domain.TicketUtilites.StatusEnum;
import upb.sgttp.model.domain.TicketUtilites.Ticket;
import upb.sgttp.model.domain.persons.Contact;
import upb.sgttp.model.domain.persons.Customer;
import upb.sgttp.model.repository.Contacts.ContactRepository;
import upb.sgttp.model.repository.Customers.CustomerRepository;
import upb.sgttp.model.repository.Routes.RouteRepository;
import upb.sgttp.model.repository.Tickets.TicketRepository;

public class ServerImplement extends UnicastRemoteObject implements Server {
    
    private static final long serialVersionUID = 1L; // Añade este atributo

    private TicketRepository ticketRepository;
    private CustomerRepository customerRepository;
    private ContactRepository contactsRepository;
    private RouteRepository routeRepository;

    public ServerImplement() throws RemoteException {
        super();
        this.ticketRepository = new TicketRepository("src\\main\\java\\upb\\sgttp\\database\\tickets.json");
        this.customerRepository = new CustomerRepository("src\\main\\java\\upb\\sgttp\\database\\customer.json");
        this.contactsRepository = new ContactRepository("src\\main\\java\\upb\\sgttp\\database\\contacts.json");
        this.routeRepository = new RouteRepository("src\\main\\java\\upb\\sgttp\\database\\routes.json");
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

    @Override
    public boolean dataToTicketNormalRoute(Customer customer, Contact contacto, Station A,Station B, CustomerCategory category,String ticketId,
    Date purchaseDate,Date boardingDate,Date arriveDate,StatusEnum status){

        customerRepository.addCustomer(customer);
        contactsRepository.addContact(contacto);

        RoutesMap mapa = new RoutesMap();
        CustomerRoute customerRoute = new CustomerRoute();

        LinkedList<Station> stations = mapa.stationsToTravel(A, B);

        LinkedList<CustomerRoute> rutaPersonalizadaCliente = customerRoute.traerLaRutaDelCliente(stations);
        float precio = mapa.calculateTotalPrice(mapa.lowestDistanceBeetweenStationsKM(A, B), category);

        Ticket ticket = new Ticket(customer, category, ticketId, purchaseDate, boardingDate, arriveDate, precio, contacto, status, rutaPersonalizadaCliente, stations);
        
        return ticketRepository.addTicket(ticket);

        /*
         * Customer customer, CustomerCategory customerCategory, String ticketId, Date purchaseDate, 
                  Date boardingDate,Date arriveDate, float value, Contact customerContact, StatusEnum status, 
                  LinkedList<CustomerRoute> customerRoute,LinkedList<Station> stations
         */ 
    }

    @Override
    public boolean dataToTicketRouteList(Customer customer, Contact contacto,LinkedList<Station> estacionesPorPasar, CustomerCategory category,String ticketId,
    Date purchaseDate,Date boardingDate,Date arriveDate,StatusEnum status){

        customerRepository.addCustomer(customer);
        contactsRepository.addContact(contacto);

        RoutesMap mapa = new RoutesMap();
        CustomerRoute customerRoute = new CustomerRoute();

        LinkedList<Station> stations = mapa.buildCustomRoute(estacionesPorPasar);

        LinkedList<CustomerRoute> rutaPersonalizadaCliente = customerRoute.traerLaRutaDelCliente(stations);
        float precio = mapa.calculateTotalPrice(mapa.calculateTotalDistance(stations), category);
        Ticket ticket = new Ticket(customer, category, ticketId, purchaseDate, boardingDate, arriveDate, precio, contacto, status, rutaPersonalizadaCliente, stations);
        return ticketRepository.addTicket(ticket);

        /*
         * Customer customer, CustomerCategory customerCategory, String ticketId, Date purchaseDate, 
                  Date boardingDate,Date arriveDate, float value, Contact customerContact, StatusEnum status, 
                  LinkedList<CustomerRoute> customerRoute,LinkedList<Station> stations
         */ 
    }

    @Override
    public LinkedList<Route> getRouteList() throws RemoteException {
        return routeRepository.getAllRoutesAsLinkedList();
    }

    
}
