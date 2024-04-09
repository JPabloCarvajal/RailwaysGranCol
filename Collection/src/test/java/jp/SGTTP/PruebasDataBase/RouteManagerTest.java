package jp.SGTTP.PruebasDataBase;

import java.util.Date;

import jp.linkedlist.singly.LinkedList;
import jp.sgttp.model.domain.RouteUtilities.Route;
import jp.sgttp.model.domain.RouteUtilities.RoutesMap;
import jp.sgttp.model.domain.trainUtilities.Train;
import jp.sgttp.model.repository.Routes.RouteRepository;
import jp.util.iterator.Iterator;

public class RouteManagerTest {
    
    public static void main(String[] args) {
        RoutesMap mapa = new RoutesMap();
        RouteRepository routeManager = new RouteRepository("C:\\Users\\juanp\\OneDrive\\Escritorio\\RailwaysGranCol\\EDDJP\\Collection\\src\\main\\java\\jp\\sgttp\\database\\routes.json");

        // Definir fechas de salida y llegada
        Date departureTime1 = new Date(); // Fecha de salida actual
        Date arrivalTime1 = new Date();
        arrivalTime1 = mapa.calculateEstimatedArrivalTime(departureTime1, mapa.stationsToTravel(mapa.getStationA(), mapa.getStationB()));  

        Route route3 = new Route(mapa.stationsToTravel(mapa.getStationA(), mapa.getStationB()), mapa.getStationA(), mapa.getStationB(),
                departureTime1, arrivalTime1, mapa.calculateTotalDistance(mapa.stationsToTravel(mapa.getStationA(), mapa.getStationB())), 
                new Train("Tren 3", "", 0, 0, "marca3", null, null),"555");

        Route routeMod = new Route(mapa.stationsToTravel(mapa.getStationA(), mapa.getStationB()), mapa.getStationA(), mapa.getStationB(),
        departureTime1, arrivalTime1, mapa.calculateTotalDistance(mapa.stationsToTravel(mapa.getStationA(), mapa.getStationB())), 
        new Train("Tren 3", "", 0, 1000, "marca3", null, null),"modified id");

        route3.printRouteInfo();

        routeManager.addRoute(route3);
        routeManager.removeRoute("1231232312");
        routeManager.modifyRoute("333", routeMod);

        LinkedList<Route> rutas = routeManager.getAllRoutesAsLinkedList();
        Iterator<Route> iterador = rutas.iterator();
        while(iterador.hasNext()){
            Route temp = iterador.next();
            temp.printRouteInfo();
            temp.getStations().toString();
        }
    
    }
    
}
