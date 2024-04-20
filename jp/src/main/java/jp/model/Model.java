/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jp.model;

import java.lang.reflect.Array;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import static jp.Client.ConsultarExistenciaTicket;
import upb.sgttp.model.domain.TicketUtilites.Ticket;
import upb.sgttp.model.domain.persons.AbstractPerson;
import upb.sgttp.model.domain.persons.Customer;

/**
 *
 * @author thewe
 */
public class Model {

    private LinkedList<Ticket> ticketList = new LinkedList<>();//obtener el linkedlist desde rmi
    private LinkedList<Ticket> findTicketList = new LinkedList<>();
    private DefaultTableModel tableModel = new DefaultTableModel();

    public Model() {
        initTableModel();
    }
    
    public boolean ConsultTicket(String id, String name) throws Exception {
        return ConsultarExistenciaTicket("id", "name");
    }
    public void ConsultTicket1(String id, String name){
        for(int i=0;i<ticketList.size();i++){
            if(ticketList.get(i).getCustomer().getNames().equals(name) && ticketList.get(i).getTicketId().equals(id)){
                findTicketList.add(ticketList.get(i));
            }
        }
    }
    private void initTableModel() {
        // Inicializar el modelo de la tabla con las columnas necesarias
        tableModel.addColumn("Nombres");
        tableModel.addColumn("Apellidos");
        tableModel.addColumn("Customer id");
        tableModel.addColumn("Ticket id");
        tableModel.addColumn("Train id");
        tableModel.addColumn("Fecha salida");
        tableModel.addColumn("Fecha llegada");
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public LinkedList<Ticket> getTicketList() {
        return ticketList;
    }

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
            Object u[] = new Object[7];
            u[0] = customer.getNames();
            u[1] = customer.getLastNames();
            u[2] = customer.getCustomerId();
            u[3] = findTicketList.get(i).getTicketId();
            u[4] = findTicketList.get(i).getCustomerRoute().get(i).getTrainToDoRoute().getTrainId();
            u[5] = findTicketList.get(i).getCustomerRoute().get(i).getDepartureTime();
            u[6] = findTicketList.get(i).getCustomerRoute().get(i).getEstimatedArrivalTime();
            getTableModel().addRow(u);
        }
    }
    
}
