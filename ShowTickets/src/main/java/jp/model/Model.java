/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jp.model;

import java.rmi.Naming;

import javax.swing.table.DefaultTableModel;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.RouteUtilities.Route;
import upb.sgttp.rmiTest.Server;

/**
 *
 * @author thewe
 */
public class Model {

    LinkedList<Route> routeList;
    private DefaultTableModel tableModel = new DefaultTableModel();

    public Model() {
        routeList = new LinkedList<>();//obtener el linkedlist de el rmi de rutas
        initTableModel();
    }

    private void initTableModel() {
        // Inicializar el modelo de la tabla con las columnas necesarias
        tableModel.addColumn("Estación Salida");
        tableModel.addColumn("Estación Llegada");
        tableModel.addColumn("Fecha Salida");
        tableModel.addColumn("Fecha Llegada");
        tableModel.addColumn("ID Ruta");
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

    public void ReloadTable() {
        while (getTableModel().getRowCount() > 0) {
            getTableModel().removeRow(0);
        }
//        for (int i = 0; i < userList.size(); i++) {
//            AbstractPerson person = userList.get(i).getPerson();
//            String numbers = "";
//            for (int j = 0; j < userList.get(i).getPerson().getPhoneNumbers().size(); j++) {
//                numbers += userList.get(i).getPerson().getPhoneNumbers().get(j);
//                if (j < userList.get(i).getPerson().getPhoneNumbers().size() - 1) {
//                    numbers += ",";
//                }
//            }
//            Object u[] = new Object[7];
//            u[0] = person.getNames();
//            u[1] = person.getLastNames();
//            u[2] = numbers;
//            u[3] = userList.get(i).getUsername();
//            u[4] = userList.get(i).getPassword();
//            u[5] = userList.get(i).getType();
//            int tipo = userList.get(i).getType();
//            switch (tipo) {
//                case 0 -> {
//                    //empleado
//                    Employee empleado = (Employee) userList.get(i).getPerson();
//                    u[6] = empleado.getId();
//                }
//                case 1 -> {
//                    //cliente
//                    Customer customer = (Customer) userList.get(i).getPerson();
//                    u[6] = customer.getCustomerId();
//                }
//                case 2 -> {
//                    //contact
//                    Contact contact = (Contact) userList.get(i).getPerson();
//                    u[6] = contact.getContactId();
//                }
//                case 3 -> {
//                    //admin
//                    Admin admin = (Admin) userList.get(i).getPerson();
//                    u[6] = admin.getId();
//                }
//            }
//            getTableModel().addRow(u);
//        }
    }
}
