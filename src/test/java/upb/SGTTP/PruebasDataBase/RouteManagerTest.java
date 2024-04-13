package upb.SGTTP.PruebasDataBase;

import java.util.Date;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.RouteUtilities.Route;
import upb.sgttp.model.domain.RouteUtilities.RoutesMap;
import upb.sgttp.model.domain.RouteUtilities.Station;
import upb.sgttp.model.domain.trainUtilities.CustomersWagon;
import upb.sgttp.model.domain.trainUtilities.LuggageWagon;
import upb.sgttp.model.domain.trainUtilities.Train;
import upb.sgttp.model.repository.Routes.RouteRepository;
import jp.util.iterator.Iterator;

public class RouteManagerTest {
    
    public static void main(String[] args) {
        RoutesMap mapa = new RoutesMap();
        RouteRepository routeManager = new RouteRepository("RailwaysGranCol\\src\\main\\java\\upb\\sgttp\\database\\routes.json");

        // Definir estaciones de inicio y fin para la primera ruta
        Station startStation1 = mapa.getStationI();
        Station endStation1 = mapa.getStationA();
 
        // Crear la primera ruta
        Route route1 = createRoute(mapa, startStation1, endStation1);

        // Definir estaciones de inicio y fin para la segunda ruta
        Station startStation2 = mapa.getStationC();
        Station endStation2 = mapa.getStationD();

        // Crear la segunda ruta
        Route route2 = createRoute(mapa, startStation2, endStation2);

        // Definir estaciones de inicio y fin para la tercera ruta
        Station startStation3 = mapa.getStationE();
        Station endStation3 = mapa.getStationF();

        // Crear la tercera ruta
        Route route3 = createRoute(mapa, startStation3, endStation3);

        // Imprimir información de las rutas
        System.out.println("Información de la primera ruta:");
        route1.printRouteInfo();
        System.out.println();

        System.out.println("Información de la segunda ruta:");
        route2.printRouteInfo();
        System.out.println();

        System.out.println("Información de la tercera ruta:");
        route3.printRouteInfo();
        System.out.println();

        // Agregar las rutas al repositorio de rutas
        routeManager.addRoute(route1);

        // Imprimir información de todas las rutas en el repositorio
        LinkedList<Route> rutas = routeManager.getAllRoutesAsLinkedList();
        Iterator<Route> iterador = rutas.iterator();
        while(iterador.hasNext()){
            Route temp = iterador.next();
            temp.printRouteInfo();
            temp.getStations().toString();
        }
    }

    // Método para crear una ruta con un inicio y fin dados
    private static Route createRoute(RoutesMap mapa, Station startStation, Station endStation) {
        LinkedList<Station> stations = mapa.stationsToTravel(startStation, endStation);
        Date departureTime = new Date(); // Hora de salida actual
        Date arrivalTime = mapa.calculateEstimatedArrivalTime(departureTime, stations);
    
        // Crear Array con la capacidad de carga para los vagones de pasajeros
        Array<Integer> passengerWagonCapacity = new Array<>(3);
        passengerWagonCapacity.add(50); // Capacidad del primer vagón de pasajeros
        passengerWagonCapacity.add(50); // Capacidad del segundo vagón de pasajeros
        passengerWagonCapacity.add(50); // Capacidad del tercer vagón de pasajeros
    
        // Crear los vagones de pasajeros y de equipaje
        Array<CustomersWagon> passengerWagons = new Array<>(3);
        Array<LuggageWagon> luggageWagons = new Array<>(3);
        for (int i = 0; i < 3; i++) {
            passengerWagons.add(null);
            luggageWagons.add(null); // Capacidad de equipaje de 100
        }
    
        // Crear el objeto Train con los vagones creados
        Train train = new Train("Tren", "idTrenPopo", 0f, passengerWagonCapacity, "marca", passengerWagons, luggageWagons, true);
    
        // Crear la ruta
        return new Route(stations, startStation, endStation, departureTime, arrivalTime,
                mapa.calculateTotalDistance(stations), train, startStation.getStationName() + "-" + endStation.getStationName());
    }
}
