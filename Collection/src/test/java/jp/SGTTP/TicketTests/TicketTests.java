package jp.SGTTP.TicketTests;

import java.time.LocalTime;
import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import jp.queue.array.QueueArray;
import jp.sgttp.model.domain.Luggage;
import jp.sgttp.model.domain.RouteUtilities.RoutesMap;
import jp.sgttp.model.domain.RouteUtilities.Station;
import jp.sgttp.model.domain.TicketUtilites.CustomerCategory;
import jp.sgttp.model.domain.TicketUtilites.StatusEnum;
import jp.sgttp.model.domain.TicketUtilites.Ticket;
import jp.sgttp.model.domain.persons.Contact;
import jp.sgttp.model.domain.persons.Customer;
import jp.sgttp.model.domain.trainUtilities.Train;
import jp.sgttp.model.repository.Trains.TrainRepository;
import jp.util.iterator.Iterator;

public class TicketTests {

    public static void main(String[] args) {
        RoutesMap mapa = new RoutesMap();
        LinkedList<Luggage> maletas = new LinkedList<>();
        maletas.add(new Luggage(10, 0));
        maletas.add(new Luggage(20, 0));
        maletas.add(new Luggage(30, 0));
        Customer customer = new Customer(maletas, "Don Enrique", "Perez", new Array<>(new String[]{"123456789"}), "001");

        QueueArray<Station> stations = new QueueArray<>(10);
        QueueArray<Station> stations2 = new QueueArray<>(10);
        LinkedList<Station> stationslist = new LinkedList<>();
        QueueArray<Train> colaDeTrenes = new QueueArray<>(3);

        Train train1 = new Train("Expreso del Sur", "12345", 5000, 150.0f, "Renfe", new Array<>(2), new Array<>(2), mapa.getStationA());
        Train train2 = new Train("Rápido del Norte", "54321", 7000, 180.0f, "Renfe", new Array<>(2), new Array<>(2), mapa.getStationB());
        Train train3 = new Train("Interurbano Central", "67890", 6000, 170.0f, "Renfe", new Array<>(2), new Array<>(2), mapa.getStationC());
        
        colaDeTrenes.insert(train1);
        colaDeTrenes.insert(train2);
        colaDeTrenes.insert(train3);

        stations = mapa.stationsToTravel(mapa.getStationA(),mapa.getStationI());

        while(!stations.isEmpty()){
            stationslist.add(stations2.extract());
        }
        System.out.println(stationslist.toString());

        Contact contact = new Contact("contacto","ApellidoContacto",new Array<>(new String[]{"641267121"}),"Cont0002");

        Ticket ticket = new Ticket(customer, 1234, LocalTime.now(), LocalTime.now(), colaDeTrenes, stations, 0f, LocalTime.now(), LocalTime.now(), LocalTime.now(), CustomerCategory.EXECUTIVE, contact, StatusEnum.WAITING);
        ticket.setValue(ticket.totalTravelValue(mapa.calculateTotalDistance(stationslist)));

        System.out.println("Número de ticket: " + ticket.getTicketId());
        System.out.println("Categoría del cliente: " + ticket.getCustomerCategory());
        System.out.println();
        System.out.println("Valor del viaje: " + ticket.totalTravelValue(mapa.calculateTotalDistance(stationslist)));

        System.out.println("Detalles del ticket:");
        System.out.println("Número de ticket: " + ticket.getTicketId());
        System.out.println("Categoría del cliente: " + ticket.getCustomerCategory());
        System.out.println("Hora de compra: " + ticket.getPurchaseDate());
        System.out.println("Fecha de embarque: " + ticket.getBoardingDate());
        System.out.println("Trenes: " + ticket.getTrains());
        System.out.println("Valor del viaje: " + ticket.getValue());
        System.out.println("Fecha de llegada: " + ticket.getArriveDate());
        System.out.println("Hora de embarque: " + ticket.getBoardingHour());
        System.out.println("Hora de llegada: " + ticket.getArriveHour());
        System.out.println("Contacto del cliente: " + ticket.getCustomerContact());
        System.out.println("Estado del ticket: " + ticket.getStatus());
    }
}
