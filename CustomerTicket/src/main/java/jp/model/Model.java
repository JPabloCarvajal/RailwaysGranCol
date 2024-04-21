/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jp.model;

import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import jp.linkedlist.singly.LinkedList;
import javax.swing.table.DefaultTableModel;
import upb.sgttp.model.domain.TicketUtilites.Ticket;
import upb.sgttp.model.domain.persons.AbstractPerson;
import upb.sgttp.model.domain.persons.Customer;
import upb.sgttp.model.domain.RouteUtilities.Route;
import upb.sgttp.model.domain.RouteUtilities.Station;
import upb.sgttp.model.domain.TicketUtilites.CustomerCategory;
import upb.sgttp.model.domain.TicketUtilites.StatusEnum;
import upb.sgttp.model.domain.persons.Contact;
import upb.sgttp.rmiTest.Server;

/**
 *
 * @author thewe
 */
public class Model {

    LinkedList<Route> routeList;

    public Model() {
        routeList = new LinkedList<>();//obtener el linkedlist de el rmi de rutas
    }

    // public boolean ConsultTicket(String id, String name) throws Exception {
    //return ConsultarExistenciaTicket("id", "name");
    // }
    public LinkedList<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(LinkedList<Route> routeList) {
        this.routeList = routeList;
    }

    public String findId() {
        String id = "";
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Formatear la fecha y hora como una cadena
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        id = "C" + formattedDateTime;
        return id;
    }

    public String findIdTicket() {
        String id = "";
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Formatear la fecha y hora como una cadena
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        id = "T" + formattedDateTime;
        return id;
    }

    public Date getDate() {
        String id = "";
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Formatear la fecha y hora como una cadena
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public boolean dataToTicketNormalRoute(Customer customer, Contact contacto, Station A, Station B, CustomerCategory category, String ticketId,
            Date purchaseDate, Date boardingDate, Date arriveDate, StatusEnum status) {

        try {
            Server server = (Server) Naming.lookup("rmi://localhost/Server");

            return server.dataToTicketNormalRoute(customer, contacto, A, B, category, ticketId,
                    purchaseDate, boardingDate, arriveDate, status);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean dataToTicketRouteList(Customer customer, Contact contacto, LinkedList<Station> estaciones, CustomerCategory category, String ticketId,
            Date purchaseDate, Date boardingDate, Date arriveDate, StatusEnum status) {

        try {
            Server server = (Server) Naming.lookup("rmi://localhost/Server");

            return server.dataToTicketRouteList(customer, contacto, estaciones, category, ticketId,
                    purchaseDate, boardingDate, arriveDate, status);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
