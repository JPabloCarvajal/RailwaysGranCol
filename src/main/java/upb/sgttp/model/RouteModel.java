/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.RouteUtilities.Route;
import upb.sgttp.model.domain.RouteUtilities.Station;
import upb.sgttp.model.domain.trainUtilities.Train;
import upb.sgttp.model.repository.Routes.RouteRepository;
import upb.sgttp.model.repository.Trains.TrainRepository;

/**
 *
 * @author thewe
 */
public class RouteModel {

    DefaultTableModel tableModel = new DefaultTableModel();
    RouteRepository routes = new RouteRepository("src\\main\\java\\upb\\sgttp\\database\\routes.json");
    TrainRepository trains = new TrainRepository("src\\main\\java\\upb\\sgttp\\database\\train.json");

    public RouteModel() {
        initTableModel();
    }

    private void initTableModel() {
        tableModel.addColumn("Estacion inicio");
        tableModel.addColumn("Estacion destino");
        tableModel.addColumn("Fecha de salida");
        tableModel.addColumn("Fecha de llegada ");
        tableModel.addColumn("KM");
        tableModel.addColumn("Id tren");
        tableModel.addColumn("Id ruta");
        tableModel.addColumn("Estaciones");
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public LinkedList<Route> getRouteList() {
        return routes.getAllRoutesAsLinkedList();
    }

    public void addRoute(Route route) {
        String traceability = "agrego un ruta Id:";
        TraceabilityModel.writeTraceability(traceability + route.getRouteId());
        routes.addRoute(route);
        ReloadTable();
    }

    public void removeRoute(Route route) {
        String traceability = "elimino un ruta Id:";
        TraceabilityModel.writeTraceability(traceability + route.getRouteId());
        routes.removeRoute(route.getRouteId());
        ReloadTable();

    }

    public void updateRoute(Route route, String id) {
        String traceability = "modifico un ruta Id:";
        TraceabilityModel.writeTraceability(traceability + route.getRouteId());
        routes.modifyRoute(id, route);
        ReloadTable();
    }

    public void ReloadTable() {
        while (getTableModel().getRowCount() > 0) {
            getTableModel().removeRow(0);
        }
        LinkedList<Route> routeList = routes.getAllRoutesAsLinkedList();
        LinkedList<Station> stations;

        for (int i = 0; i < routeList.size(); i++) {
            stations = routeList.get(i).getStations();
            String station = "";
            for (int j = 0; j < stations.size(); j++) {
                station+=stations.get(j).getStationName();
                if (j < stations.size() - 1) {
                    station += ",";
                }
            }
            Object u[] = new Object[8];
            u[0] = routeList.get(i).getStartPoint().getStationName();
            u[1] = routeList.get(i).getDestinationPoint().getStationName();
            u[2] = routeList.get(i).getDepartureTime();
            u[3] = routeList.get(i).getArrivalTime();
            u[4] = routeList.get(i).getTotalKmToTravel();
            u[5] = routeList.get(i).getTrainToDoRoute().getTrainId();
            u[6] = routeList.get(i).getRouteId();
            u[7] = station;
            getTableModel().addRow(u);
        }
    }

    public void setAvailable(Train train) {
        trains.modifyTrain(train.getTrainId(), train);
    }

    public Train getTrain(String id) {
        return trains.getTrain(id);
    }

    public String createIdRoute(Station station1, Station station2) {
        String generatedId = "";
        generatedId = station1.getStationName() + "-" + station2.getStationName();
        return generatedId;
    }

    public Date DateConverter(String dateString) {//2024-04-19 15:30:00
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = dateFormat.parse(dateString); // Convertir String a Date
            System.out.println("Fecha convertida: " + date);
            return date;
        } catch (ParseException e) {

            System.out.println("Error al convertir la fecha: " + e.getMessage());
        }
        return null;
    }
}
