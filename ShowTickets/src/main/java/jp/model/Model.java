/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jp.model;

import java.rmi.Naming;

import javax.swing.table.DefaultTableModel;
import jp.linkedlist.singly.LinkedList;
import jp.priorityQueue.PriorityQueue;
import upb.sgttp.model.domain.RouteUtilities.Route;
import upb.sgttp.model.domain.TicketUtilites.Ticket;
import upb.sgttp.rmiTest.Server;

/**
 *
 * @author thewe
 */
public class Model {

    private DefaultTableModel tableModel = new DefaultTableModel();
    LinkedList<Ticket> ticketsList;
    PriorityQueue<Ticket> queue;

    public Model() {
        ticketsList = new LinkedList<>();
        initTableModel();
    }

    private void initTableModel() {
        // Inicializar el modelo de la tabla con las columnas necesarias
        tableModel.addColumn("Estación Salida");
        tableModel.addColumn("Estación Llegada");
        tableModel.addColumn("Fecha Salida");
        tableModel.addColumn("Fecha Llegada");
        tableModel.addColumn("ID Tren");
        tableModel.addColumn("ID Ticket");
        tableModel.addColumn("Estaciones");
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public LinkedList<Ticket> getCustomerRoute() throws Exception {
        Server server = (Server) Naming.lookup("rmi://localhost/Server");
        LinkedList<Ticket> ticket = server.getTicketList();
        return ticket;
    }

    public void setTicketList(String idTrain) throws Exception {
        LinkedList<Ticket> ticketList = getCustomerRoute();
        queue = new PriorityQueue(3);
        for (int i = 0; i < ticketList.size(); i++) {
            if (ticketList.get(i).getCustomerRoute().peek().getTrainToDoRoute().getTrainId().equals(idTrain)) {
                ticketsList.add(ticketList.get(i));
                switch (ticketsList.get(i).getCustomerCategory()) {
                    case PREMIUN:
                        queue.insert(3, ticketsList.get(i));
                        break;
                    case EXECUTIVE:
                        queue.insert(2, ticketsList.get(i));
                        break;
                    case STANDAR:
                        queue.insert(1, ticketsList.get(i));
                        break;
                }
            }
        }

    }

    public PriorityQueue<Ticket> getQueue() {
        return queue;
    }

    public void setQueue(PriorityQueue<Ticket> queue) {
        this.queue = queue;
    }

    public LinkedList<Ticket> getTicketsList() {
        return ticketsList;
    }

    public void ReloadTable() throws Exception {
        while (getTableModel().getRowCount() > 0) {
            getTableModel().removeRow(0);
        }
//        LinkedList<Ticket> ticketList = getCustomerRoute();
//        LinkedList<Ticket> ticketList = getTicketsList();
        while (!queue.isEmpty()) {
            Ticket ticket = queue.extract();
                Object u[] = new Object[8];
                u[0] = ticket.getStations().peek().getStationName();
                u[1] = ticket.getStations().peekLast().getStationName();
                u[2] = ticket.getCustomerRoute().peek().getDepartureTime();
                u[3] = ticket.getCustomerRoute().peek().getEstimatedArrivalTime();
                u[4] = ticket.getCustomerRoute().peek().getTrainToDoRoute().getTrainId();
                u[5] = ticket.getTicketId();
                String stations = "";
                for (int j = 0; j < ticket.getStations().size(); j++) {
                    stations += ticket.getStations().get(j).getStationName();
                    if (j < ticket.getStations().size() - 1) {
                        stations += ",";
                    }
                }
                u[6] = stations;
                getTableModel().addRow(u);
        }
    }
}
