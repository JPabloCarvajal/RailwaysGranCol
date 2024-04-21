package jp;

import java.rmi.Naming;
import java.util.Date;

import jp.controller.Controller;
import jp.model.Model;
import jp.view.FindTicket;
import upb.sgttp.model.domain.RouteUtilities.Station;
import upb.sgttp.model.domain.TicketUtilites.CustomerCategory;
import upb.sgttp.model.domain.TicketUtilites.StatusEnum;
import upb.sgttp.model.domain.TicketUtilites.Ticket;
import upb.sgttp.model.domain.persons.Contact;
import upb.sgttp.model.domain.persons.Customer;
import upb.sgttp.rmiTest.Server;
import jp.linkedlist.singly.LinkedList;

public class Client {

    

    public static boolean dataToTicketNormalRoute(Customer customer, Contact contacto, Station A, Station B, CustomerCategory category, String ticketId,
        Date purchaseDate, Date boardingDate, Date arriveDate, StatusEnum status) {

    try {
        Server server = (Server) Naming.lookup("rmi://localhost/Server");

        return server.dataToTicketNormalRoute(customer, contacto, A, B, category, ticketId,
                purchaseDate, boardingDate, arriveDate, status);
    } 
    catch (Exception e) {
        e.printStackTrace();
        return false; 
    }
}

public static boolean dataToTicketRouteList(Customer customer, Contact contacto, LinkedList<Station> estaciones, CustomerCategory category, String ticketId,
        Date purchaseDate, Date boardingDate, Date arriveDate, StatusEnum status) {

    try {
        Server server = (Server) Naming.lookup("rmi://localhost/Server");

        return server.dataToTicketRouteList(customer, contacto, estaciones, category, ticketId,
                purchaseDate, boardingDate, arriveDate, status);
    } 
    catch (Exception e) {
        e.printStackTrace();
        return false; 
    }
}




    public static void main(String[] args) throws Exception {
        
    }   
}
