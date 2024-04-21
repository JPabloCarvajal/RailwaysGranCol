/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JButton;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.gui.AdminView;
import upb.sgttp.gui.RouteView;
import upb.sgttp.model.RouteModel;
import upb.sgttp.model.domain.RouteUtilities.Route;
import upb.sgttp.model.domain.RouteUtilities.RoutesMap;
import upb.sgttp.model.domain.RouteUtilities.Station;
import upb.sgttp.model.domain.trainUtilities.Train;

/**
 *
 * @author thewe
 */
public class RouteController {

    private RouteModel model;
    private RouteView view;

    public RouteController(RouteModel model, RouteView view) {
        this.model = model;
        this.view = view;
        initView();
        initController();
    }

    private void initView() {
        model.ReloadTable();
        reloadTable();
    }

    private void initController() {
        JButton addButton = view.getjButton3();
        JButton deleteButton = view.getjButton7();
        JButton updateButton = view.getjButton5();
        JButton backButton = view.getjButton4();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //agregar ruta
                RoutesMap mapa = new RoutesMap();
                String station1 = view.getjTextField1().getText();
                String station2 = view.getjTextField2().getText();
                String fecha = view.getjTextField3().getText();
                String idtren = view.getjTextField4().getText();
                Train train = model.getTrain(idtren);
                if (train.isAvailable()) {
                    LinkedList<Station> stations = mapa.stationsToTravel(mapa.getStation(station1), mapa.getStation(station2));
                    Route route = new Route(stations, mapa.getStation(station1), mapa.getStation(station2), model.DateConverter(fecha), mapa.calculateEstimatedArrivalTime(model.DateConverter(fecha), stations), mapa.calculateTotalDistance(stations), train, model.createIdRoute(mapa.getStation(station1), mapa.getStation(station2)));
                    train.setAvailable(false);
                    model.setAvailable(train);
                    model.addRoute(route);
                    reloadTable();
                    view.getjTextField1().setText("");
                    view.getjTextField2().setText("");
                    view.getjTextField3().setText("");
                    view.getjTextField4().setText("");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //eliminar ruta
                int selectedRow = view.getjTable().getSelectedRow();
                LinkedList<Route> list = model.getRouteList();
                @SuppressWarnings("unused")
                Train train = list.get(selectedRow).getTrainToDoRoute();
                @SuppressWarnings("unused")
                String id = list.get(selectedRow).getRouteId();
                // Verificar si se ha seleccionado una fila
                if (selectedRow != -1) {
                    // Eliminar la fila del modelo de la tabla
                    if (list.size() > 1) {
                        model.removeRoute(list.get(selectedRow));
                        list.get(selectedRow).getTrainToDoRoute().setAvailable(true);
                        model.setAvailable(list.get(selectedRow).getTrainToDoRoute());
                        reloadTable();
                    }
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //actualizar ruta
                int selectedRow = view.getjTable().getSelectedRow();
                // Verificar si se ha seleccionado una fila
                if (selectedRow != -1) {
                    // modificar la fila del modelo de la tabla
                    RoutesMap mapa = new RoutesMap();
                    LinkedList<Route> list = model.getRouteList();
                    String station1 = view.getjTextField1().getText();
                    String station2 = view.getjTextField2().getText();
                    String fecha = view.getjTextField3().getText();
                    String idtren = view.getjTextField4().getText();
//                    Train train = Main.getTrain(idtren);
                    Train train = model.getTrain(idtren);
                    // Obtener la fecha y hora actual
                    LocalDateTime currentDateTime = LocalDateTime.now();
                    // Formatear la fecha y hora según tus necesidades
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    @SuppressWarnings("unused")
                    String formattedDateTime = currentDateTime.format(formatter);
                    // Convertir la fecha de partida de la lista a LocalDateTime
                    Date departureDate = list.get(selectedRow).getDepartureTime();
                    Instant instant = departureDate.toInstant();
                    ZoneId zoneId = ZoneId.systemDefault();
                    @SuppressWarnings("unused")
                    LocalDateTime departureDateTime = instant.atZone(zoneId).toLocalDateTime();
//            if (departureDateTime.isAfter(currentDateTime) && (list.get(selectedRow).getTrainToDoRoute().isAvailable() || idtren.equals(upb.sgttp.model.domain.Main.getTrain(idtren).getTrainId()))) {

                    LinkedList<Station> stations = mapa.stationsToTravel(mapa.getStation(station1), mapa.getStation(station2));
                    Route route = new Route(stations, mapa.getStation(station1), mapa.getStation(station2), model.DateConverter(fecha), mapa.calculateEstimatedArrivalTime(model.DateConverter(fecha), stations), mapa.calculateTotalDistance(stations), train, model.createIdRoute(mapa.getStation(station1), mapa.getStation(station2)));
                    String id = list.get(selectedRow).getRouteId();
                    String idt = list.get(selectedRow).getTrainToDoRoute().getTrainId();
                    Train AuxTrain = list.get(selectedRow).getTrainToDoRoute();
                    list.get(selectedRow).setStations(stations);
                    list.get(selectedRow).setStartPoint(mapa.getStation(station1));
                    list.get(selectedRow).setDestinationPoint(mapa.getStation(station2));
                    list.get(selectedRow).setDepartureTime(model.DateConverter(fecha));
                    list.get(selectedRow).setEstimatedArrivalTime(mapa.calculateEstimatedArrivalTime(model.DateConverter(fecha), stations));
                    list.get(selectedRow).setTotalKmToTravel(mapa.calculateTotalDistance(stations));
                    list.get(selectedRow).setTrainToDoRoute(train);
                    list.get(selectedRow).setRouteId(model.createIdRoute(mapa.getStation(station1), mapa.getStation(station2)));
                    if (!idtren.equals(idt)) {
                        train.setAvailable(false);
                        model.setAvailable(train);
                        AuxTrain.setAvailable(true);
                        model.setAvailable(AuxTrain);
                    }
                    model.updateRoute(route,id);
                    reloadTable();
                    view.getjTextField1().setText("");
                    view.getjTextField2().setText("");
                    view.getjTextField3().setText("");
                    view.getjTextField4().setText("");
//            }
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //retroceder (botón de atrás)
                view.dispose();
                AdminView view = new AdminView();
                @SuppressWarnings("unused")
                AdminPageController controller = new AdminPageController(view);
                view.setVisible(true);
                view.setLocationRelativeTo(null);
            }
        });
    }

    private void reloadTable() {
        view.getjTable().setModel(model.getTableModel());
    }
}
