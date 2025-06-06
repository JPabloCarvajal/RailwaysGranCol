/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jp.model;

import java.rmi.Naming;
import jp.linkedlist.singly.LinkedList;
import javax.swing.table.DefaultTableModel;
import upb.sgttp.model.domain.TicketUtilites.Ticket;
import upb.sgttp.model.domain.persons.Customer;
import upb.sgttp.rmiTest.Server;

/**
 *
 * @author thewe
 */
public class Model {

    private LinkedList<Ticket> ticketList;
    private LinkedList<Ticket> findTicketList = new LinkedList<>();
    private DefaultTableModel tableModel = new DefaultTableModel();

    public Model() throws Exception {
        ticketList = obtenerListaTickets();
        initTableModel();
    }

    public void ConsultTicket(String id, String name) {
        for (int i = 0; i < ticketList.size(); i++) {
            if (ticketList.get(i).getCustomer().getNames().equals(name) && ticketList.get(i).getTicketId().equals(id)) {
                findTicketList.add(ticketList.get(i));
            }
        }
        ReloadTable();
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
        tableModel.addColumn("Estaciones");
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
            Object u[] = new Object[8];
            u[0] = customer.getNames();
            u[1] = customer.getLastNames();
            u[2] = customer.getCustomerId();
            u[3] = findTicketList.get(i).getTicketId();
            u[4] = findTicketList.get(i).getCustomerRoute().get(0).getTrainToDoRoute().getTrainId();
            u[5] = findTicketList.get(i).getCustomerRoute().get(0).getDepartureTime();
            u[6] = findTicketList.get(i).getCustomerRoute().get(0).getEstimatedArrivalTime();
            String stations = "";
            for (int j = 0; j < findTicketList.get(i).getStations().size(); j++) {
                stations += findTicketList.get(i).getStations().get(j).getStationName();
                if (j < findTicketList.get(i).getStations().size() - 1) {
                    stations += ",";
                }
            }
            u[7] = stations;
            getTableModel().addRow(u);
        }
    }

    public boolean ConsultarExistenciaTicket(String ticketID, String customerName) throws Exception {
        // Obtén la referencia al objeto remoto
        Server server = (Server) Naming.lookup("rmi://localhost/Server");
        // Llama al método remoto en el servidor
        boolean existeTicket = server.ConsultarExistenciaTicket(ticketID, customerName);
        return existeTicket;
    }

    public LinkedList<Ticket> obtenerListaTickets() throws Exception {
        // Obtén la referencia al objeto remoto
        Server server = (Server) Naming.lookup("rmi://localhost/Server");
        // Llama al método remoto en el servidor para obtener la lista de tickets
        LinkedList<Ticket> ticketList = server.getTicketList();
        return ticketList;
    }
}
