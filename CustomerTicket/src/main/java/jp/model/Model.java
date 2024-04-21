/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jp.model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import jp.linkedlist.singly.LinkedList;
<<<<<<< HEAD
import javax.swing.table.DefaultTableModel;
import upb.sgttp.model.domain.TicketUtilites.Ticket;
import upb.sgttp.model.domain.persons.AbstractPerson;
import upb.sgttp.model.domain.persons.Customer;
=======
import upb.sgttp.model.domain.RouteUtilities.Route;
>>>>>>> b33523f5ab1084388b7747745fdc98b685180ff8

/**
 *
 * @author thewe
 */
public class Model {

    LinkedList<Route> routeList;

    public Model() {
        routeList = new LinkedList<>();//obtener el linkedlist de el rmi de rutas
    }

<<<<<<< HEAD
   // public boolean ConsultTicket(String id, String name) throws Exception {
        //return ConsultarExistenciaTicket("id", "name");
   // }
=======
    public LinkedList<Route> getRouteList() {
        return routeList;
    }
>>>>>>> b33523f5ab1084388b7747745fdc98b685180ff8

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
<<<<<<< HEAD

    public LinkedList<Ticket> getFindTicketList() {
        return findTicketList;
    }

    public void setFindTicketList(LinkedList<Ticket> findTicketList) {
        this.findTicketList = findTicketList;
    }

    public void ReloadTable() {
        while (getTableModel().getRowCount() > 0) {
            getTableModel().removeRow(0);
        }
        for (int i = 0; i < findTicketList.size(); i++) {
            Customer customer = findTicketList.get(i).getCustomer();
            Object u[] = new Object[8];
            u[0] = customer.getNames();
            u[1] = customer.getLastNames();
            u[2] = customer.getCustomerId();
            u[3] = findTicketList.get(i).getTicketId();
            //u[4] = findTicketList.get(i).getCustomerRoute().get(i).getTrainToDoRoute().getTrainId();
            u[5] = findTicketList.get(i).getCustomerRoute().get(i).getDepartureTime();
            u[6] = findTicketList.get(i).getCustomerRoute().get(i).getEstimatedArrivalTime();
            getTableModel().addRow(u);
        }
    }

=======
    //metodos rmi para pasarle los datos a los jsons
>>>>>>> b33523f5ab1084388b7747745fdc98b685180ff8
}
