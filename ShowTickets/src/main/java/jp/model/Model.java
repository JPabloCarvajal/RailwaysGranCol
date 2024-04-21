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
import upb.sgttp.model.domain.RouteUtilities.Route;

/**
 *
 * @author thewe
 */
public class Model {

    LinkedList<Route> routeList;

    public Model() {
        routeList = new LinkedList<>();//obtener el linkedlist de el rmi de rutas
    }

    public LinkedList<Route> getRouteList() {
        return routeList;
    }

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
    //metodos rmi para pasarle los datos a los jsons
}
