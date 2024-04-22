/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jp.model;

import java.rmi.Naming;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import jp.linkedlist.singly.LinkedList;
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

    public Model() {
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

    public String findIdContact() {
        String id = "";
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Formatear la fecha y hora como una cadena
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        id = "CO" + formattedDateTime;
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

    public static Date getDate() throws ParseException {
        // Obtener la fecha y hora actuales como LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();
        
        // Crear un formato de fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        // Formatear la fecha y hora como una cadena
        String formattedDateTime = formatter.format(localDateTime);
        
        // Crear un SimpleDateFormat para el formateo
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        // Convertir la cadena formateada a un objeto Date
        Date date = sdf.parse(formattedDateTime);
        
        // Devolver el objeto Date
        return date;
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
