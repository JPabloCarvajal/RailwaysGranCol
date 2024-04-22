/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import jp.linkedlist.singly.LinkedList;
import jp.model.Model;
import jp.view.TicketSale;
import upb.sgttp.model.domain.Luggage;
import upb.sgttp.model.domain.RouteUtilities.RoutesMap;
import upb.sgttp.model.domain.RouteUtilities.Station;
import upb.sgttp.model.domain.TicketUtilites.CustomerCategory;
import upb.sgttp.model.domain.TicketUtilites.StatusEnum;
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
                String pesoMaleta = view.getjTextField7().getText();
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
                LinkedList<Station> stations = new LinkedList<>();
                float km;
                if (!nombres.isBlank() && !apellidos.isBlank() && !numeros.isBlank() && !nombresContacto.isBlank() && !apellidosContacto.isBlank() && !numerosContacto.isBlank() && !pesoMaleta.isBlank()) {
                    String[] pesos = pesoMaleta.split(",");
                    LinkedList<Luggage> luggage = new LinkedList<>();
                    for (int i = 0; i < 2 || i < pesos.length; i++) {
                        luggage.add(new Luggage(Integer.parseInt(pesos[i]), 0));
                    }
                    Contact contact = new Contact(nombresContacto, apellidosContacto, arrayContact, model.findIdContact());
                    Customer customer = new Customer(luggage, nombres, apellidos, array, model.findId());
                    if (!rutaPersonalizada) {
                        km = mapa.calculateTotalDistance(mapa.stationsToTravel(mapa.getStation(station1), mapa.getStation(station2)));
                        switch (sType) {
                            case "PREMIUM":
                                precio += 1800 * km;
                            {
                                try {
                                    model.dataToTicketNormalRoute(customer, contact, mapa.getStation(station1), mapa.getStation(station2), CustomerCategory.PREMIUN, model.findIdTicket(), model.getDate(), model.getDate(), model.getDate(), StatusEnum.ABOARD);
                                } catch (ParseException ex) {
                                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;

                            case "EXECUTIVE":
                                precio += 1200 * km;
                            {
                                try {
                                    model.dataToTicketNormalRoute(customer, contact, mapa.getStation(station1), mapa.getStation(station2), CustomerCategory.EXECUTIVE, model.findIdTicket(), model.getDate(), model.getDate(), model.getDate(), StatusEnum.ABOARD);
                                } catch (ParseException ex) {
                                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;

                            case "STANDARD":
                                precio += 1000 * km;
                            {
                                try {
                                    model.dataToTicketNormalRoute(customer, contact, mapa.getStation(station1), mapa.getStation(station2), CustomerCategory.STANDAR, model.findIdTicket(), model.getDate(), model.getDate(), model.getDate(), StatusEnum.ABOARD);
                                } catch (ParseException ex) {
                                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;

                        }

                    } else {
                        String[] estacionesCustomer = StacionesPersonalizadas.split(",");
                        for (int i = 0; i < estacionesCustomer.length; i++) {
                            stations.add(mapa.getStation(estacionesCustomer[i]));
                        }
                        km = mapa.calculateTotalDistance(stations);
                        switch (sType) {
                            case "PREMIUM":
                                precio += 1800 * km;
                            {
                                try {
                                    model.dataToTicketRouteList(customer, contact, stations, CustomerCategory.PREMIUN, model.findIdTicket(), model.getDate(), model.getDate(), model.getDate(), StatusEnum.ABOARD);
                                } catch (ParseException ex) {
                                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;

                            case "EXECUTIVE":
                                precio += 1200 * km;
                            {
                                try {
                                    model.dataToTicketRouteList(customer, contact, stations, CustomerCategory.EXECUTIVE, model.findIdTicket(), model.getDate(), model.getDate(), model.getDate(), StatusEnum.ABOARD);
                                } catch (ParseException ex) {
                                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;

                            case "STANDARD":
                                precio += 1000 * km;
                            {
                                try {
                                    model.dataToTicketRouteList(customer, contact, stations, CustomerCategory.STANDAR, model.findIdTicket(), model.getDate(), model.getDate(), model.getDate(), StatusEnum.ABOARD);
                                } catch (ParseException ex) {
                                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;

                        }
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
        }
        );
    }
}
