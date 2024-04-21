/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import jp.linkedlist.singly.LinkedList;
import jp.model.Model;
import jp.util.array.Array;
import jp.view.TicketSale;
import upb.sgttp.model.domain.Luggage;
import upb.sgttp.model.domain.RouteUtilities.CustomerRoute;
import upb.sgttp.model.domain.RouteUtilities.Route;
import upb.sgttp.model.domain.RouteUtilities.RoutesMap;
import upb.sgttp.model.domain.RouteUtilities.Station;
import upb.sgttp.model.domain.TicketUtilites.CustomerCategory;
import upb.sgttp.model.domain.TicketUtilites.StatusEnum;
import upb.sgttp.model.domain.TicketUtilites.Ticket;
import upb.sgttp.model.domain.persons.Contact;
import upb.sgttp.model.domain.persons.Customer;

/**
 *
 * @author thewe
 */
public class Controller {

    private final TicketSale view;
    private final Model model;

    public Controller(TicketSale view, Model model) {
        this.view = view;
        this.model = model;
        initController();
    }

    private void initController() {
        // Configurar los listeners de la vista para interactuar con el modelo
        JButton buyTicket = view.getjButton1();

        buyTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sType = (String) view.getjComboBox1().getSelectedItem();
                String nombres = view.getjTextField1().getText();
                String apellidos = view.getjTextField2().getText();
                String numeros = view.getjTextField3().getText();
                String[] numbers = numeros.split(",");
                String station1 = view.getjTextField4().getText();
                String station2 = view.getjTextField5().getText();
                String StacionesPersonalizadas = view.getjTextField6().getText();
                String[] estacionesCustomer = StacionesPersonalizadas.split(",");
                String pesoMaleta = view.getjTextField7().getText();
                String[] pesos = pesoMaleta.split(",");
                LinkedList<Luggage> luggage = new LinkedList<>();
                luggage.add(new Luggage(Integer.parseInt(pesos[0]), 0));
                luggage.add(new Luggage(Integer.parseInt(pesos[1]), 0));
                RoutesMap mapa = new RoutesMap();
                int precio = 0;
                boolean rutaPersonalizada = view.getjCheckBox1().isSelected();
                jp.array.Array array = new jp.array.Array(numbers);
                //persona Contacto
                String nombresContacto = view.getjTextField8().getText();
                String apellidosContacto = view.getjTextField9().getText();
                String numerosContacto = view.getjTextField10().getText();
                String[] numbersContacto = numerosContacto.split(",");
                jp.array.Array<String> arrayContact = new jp.array.Array<>(numbersContacto);
                Contact contact = new Contact(nombresContacto, apellidosContacto, arrayContact, station2);
                Customer customer = new Customer(luggage, nombres, apellidos, array, model.findId());
                Ticket ticket;
                LinkedList<Route> routes = model.getRouteList();
                //crear ruta personalizada
//                int index = 0;
//                Route route = null;
                LinkedList<Station> stations = new LinkedList<>();
//                Date date = new Date();
//                Date dateArrival = new Date();
                CustomerRoute customerRoute;
                LinkedList<CustomerRoute> customerRouteList = new LinkedList<>();
                float km = 0f;
                if (!nombres.isBlank()&&!apellidos.isBlank()&&!numeros.isBlank()&&!nombresContacto.isBlank()&&!apellidosContacto.isBlank()&&!numerosContacto.isBlank()&&!pesoMaleta.isBlank()) {
                    if (rutaPersonalizada) {
                        for (int i = 0; i < estacionesCustomer.length; i++) {
                            stations.add(mapa.getStation(estacionesCustomer[i]));
                        }
                        CustomerRoute aux = new CustomerRoute();
                        customerRouteList = aux.traerLaRutaDelCliente(stations);
//                    customerRoute = new CustomerRoute(stations.peek(), stations.peekLast(), model.getDate(),mapa.calculateEstimatedArrivalTime(model.getDate(),stations) , trainToDoRoute);
                    } else {
                        for (int i = 0; i < routes.size(); i++) {
                            if (routes.get(i).getStartPoint().getStationName().equals(station1) && routes.get(i).getDestinationPoint().getStationName().equals(station2)) {
//                            route = routes.get(i);
                                stations = routes.get(i).getStations();
//                            date = routes.get(i).getDepartureTime();
//                            dateArrival = routes.get(i).getArrivalTime();
                                customerRoute = new CustomerRoute(routes.get(i).getStartPoint(), routes.get(i).getDestinationPoint(), routes.get(i).getDepartureTime(), routes.get(i).getArrivalTime(), routes.get(i).getTrainToDoRoute());
                                km = routes.get(i).getTotalKmToTravel();
                                customerRouteList.add(customerRoute);
                                break;
                            }
                        }
                    }
                    switch (sType) {
                        case "PREMIUM":
                            precio += 1800 * km;
                            ticket = new Ticket(customer, CustomerCategory.PREMIUN, model.findIdTicket(), model.getDate(), customerRouteList.get(0).getDepartureTime(), customerRouteList.get(0).getEstimatedArrivalTime(), precio, contact, StatusEnum.ABOARD, customerRouteList, stations);
                            break;
                        case "EXECUTIVE":
                            precio += 1200 * km;
                            ticket = new Ticket(customer, CustomerCategory.EXECUTIVE, model.findIdTicket(), model.getDate(), customerRouteList.get(0).getDepartureTime(), customerRouteList.get(0).getEstimatedArrivalTime(), precio, contact, StatusEnum.ABOARD, customerRouteList, stations);
                            break;
                        case "STANDARD":
                            precio += 1000 * km;
                            ticket = new Ticket(customer, CustomerCategory.STANDAR, model.findIdTicket(), model.getDate(), customerRouteList.get(0).getDepartureTime(), customerRouteList.get(0).getEstimatedArrivalTime(), precio, contact, StatusEnum.ABOARD, customerRouteList, stations);
                            break;
                    }
                    view.setjLabel18(precio);
                    view.getjTextField1().setText("");
                    view.getjTextField2().setText("");
                    view.getjTextField3().setText("");
                    view.getjTextField4().setText("");
                    view.getjTextField5().setText("");
                    view.getjTextField6().setText("");
                    view.getjTextField7().setText("");
                    view.getjTextField8().setText("");
                    view.getjTextField9().setText("");
                    view.getjTextField10().setText("");
                    view.getjTextField11().setText("");
                }
            }
        });
    }
}
