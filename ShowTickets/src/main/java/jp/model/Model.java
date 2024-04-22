/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jp.model;

import java.rmi.Naming;

import javax.swing.table.DefaultTableModel;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.RouteUtilities.Route;
import upb.sgttp.model.domain.TicketUtilites.Ticket;
import upb.sgttp.rmiTest.Server;

/**
 *
 * @author thewe
 */
public class Model {

    LinkedList<Route> routeList;
    private DefaultTableModel tableModel = new DefaultTableModel();
    LinkedList<Ticket> ticketsList;

    public Model() {
        routeList = new LinkedList<>();//obtener el linkedlist de el rmi de rutas
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

    public LinkedList<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(LinkedList<Route> routeList) {
        this.routeList = routeList;
    }

    //lista de rutas
    public LinkedList<Route> obtenerListaRutas() throws Exception {
        // Obtén la referencia al objeto remoto
        Server server = (Server) Naming.lookup("rmi://localhost/Server");
        // Llama al método remoto en el servidor para obtener la lista de tickets
        LinkedList<Route> routeList = server.getRouteList();
        return routeList;
    }

    public LinkedList<Ticket> getCustomerRoute() throws Exception {
        Server server = (Server) Naming.lookup("rmi://localhost/Server");
        LinkedList<Ticket> ticket = server.getTicketList();
        return ticket;
    }

    public void setTicketList(String idTrain) throws Exception {
        LinkedList<Ticket> ticketList = getCustomerRoute();
        for (int i = 0; i < ticketList.size(); i++) {
            if (ticketList.get(i).getCustomerRoute().peek().getTrainToDoRoute().getTrainId().equals(idTrain)) {
                ticketsList.add(ticketList.get(i));
            }
        }
    }

    public LinkedList<Ticket> getTicketsList() {
        return ticketsList;
    }

    public void ReloadTable() throws Exception {
        while (getTableModel().getRowCount() > 0) {
            getTableModel().removeRow(0);
        }
//        LinkedList<Ticket> ticketList = getCustomerRoute();
        LinkedList<Ticket> ticketList = getTicketsList();
        for (int i = 0; i < ticketList.size(); i++) {
            Object u[] = new Object[8];
            u[0] = ticketList.get(i).getStations().peek().getStationName();
            u[1] = ticketList.get(i).getStations().peekLast().getStationName();
            u[2] = ticketList.get(i).getCustomerRoute().peek().getDepartureTime();
            u[3] = ticketList.get(i).getCustomerRoute().peek().getEstimatedArrivalTime();
            u[4] = ticketList.get(i).getCustomerRoute().peek().getTrainToDoRoute().getTrainId();
            u[5] = ticketList.get(i).getTicketId();
            String stations = "";
            for (int j = 0; j < ticketList.get(i).getStations().size(); j++) {
                stations += ticketList.get(i).getStations().get(j).getStationName();
                if (j < ticketList.get(i).getStations().size() - 1) {
                    stations += ",";
                }
            }
            u[6] = stations;
            getTableModel().addRow(u);
        }
    }
}
