package upb.SGTTP.PruebasDataBase;

import java.util.Calendar;
import java.util.Date;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.Luggage;
import upb.sgttp.model.domain.RouteUtilities.CustomerRoute;
import upb.sgttp.model.domain.RouteUtilities.RoutesMap;
import upb.sgttp.model.domain.TicketUtilites.Ticket;
import upb.sgttp.model.domain.persons.Customer;
import upb.sgttp.model.repository.Tickets.TicketRepository;
import upb.sgttp.model.domain.TicketUtilites.CustomerCategory;
import upb.sgttp.model.domain.TicketUtilites.StatusEnum;
import upb.sgttp.model.domain.persons.Contact;

public class TicketManagerTest {
     public static void main(String[] args) {

         RoutesMap mapa = new RoutesMap();

         CustomerRoute customerRoute = new CustomerRoute();

         TicketRepository ticketRepository = new TicketRepository("RailwaysGranCol\\src\\main\\java\\upb\\sgttp\\database\\tickets.json");

         Luggage luggage = new Luggage(0f,0);
         LinkedList<Luggage> maletas = new LinkedList<>();
         maletas.add(luggage);
         maletas.add(luggage);
         Customer customer = new Customer(maletas,"kike" , "Doe", new Array<>(new String[]{"123456789"}),"123");
         Contact customerContact = new Contact("nombre del contacto", "apellido del contacto" ,new Array<>(new String[]{"123456789"}),"123");
        // Get today's date
         Date today = new Date();

         // Get tomorrow's date
         Calendar calendar = Calendar.getInstance();
         calendar.add(Calendar.DAY_OF_YEAR, 1);
         Date tomorrow = calendar.getTime();

         // Crear una nueva LinkedList para las CustomerRoute del Ticket
         LinkedList<CustomerRoute> customerRoutes = customerRoute.traerLaRutaDelCliente(mapa.stationsToTravel(mapa.getStationA(),mapa.getStationB()));

         for(int i = 0; i<customerRoutes.size(); i++){
             System.out.println(customerRoutes.get(i).getStartPoint().getStationName());
             System.out.println(customerRoutes.get(i).getDestinationPoint().getStationName());
         }

         Ticket newTicket = new Ticket(
             customer,
             CustomerCategory.EXECUTIVE,
             "kike123",
             today,  //PurchaseDate is set to today
             tomorrow, // BoardingDate is set to tomorrow
             tomorrow,  //ArriveDate is set to tomorrow
             mapa.calculateTotalPrice(mapa.lowestDistanceBeetweenStationsKM(mapa.getStationI(),mapa.getStationA()),CustomerCategory.EXECUTIVE),
             customerContact,
             StatusEnum.ABOARD,
             customerRoutes,
             mapa.stationsToTravel(mapa.getStationI(),mapa.getStationA())
         );

         boolean isAdded = ticketRepository.addTicket(newTicket);
         System.out.println("Ticket added: " + isAdded);

         LinkedList<Ticket> allTickets = ticketRepository.getAllTicketsAsLinkedList();
         System.out.println("All tickets: " + allTickets);

         Ticket retrievedTicket = ticketRepository.getTicket(newTicket.getTicketId());
         System.out.println("Retrieved ticket: " + retrievedTicket);
     }
}
