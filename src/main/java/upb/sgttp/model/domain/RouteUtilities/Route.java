package upb.sgttp.model.domain.RouteUtilities;

import java.io.Serializable;
import java.util.Date;

import jp.linkedlist.singly.LinkedList;

import upb.sgttp.model.domain.trainUtilities.Train;

public class Route implements Serializable{

    private String routeId;

    private LinkedList<Station> stations;//
    private LinkedList<SubRoute> subRoutes;

    private float totalKmToTravel;

    private Station destinationPoint; //
    private Station startPoint; //
   
    private Date departureTime;
    private Date estimatedArrivalTime;

    private Train trainToDoRoute;

    public Route(LinkedList<Station> stations,
                 Station startPoint,Station destinationPoint,
                 Date departureTime, Date estimatedArrivalTime,float totalKmToTravel,
                 Train trainToDoRoute,String id) {
        this.routeId = id;
        this.stations = stations;
        this.destinationPoint = destinationPoint;
        this.startPoint = startPoint;
        this.departureTime = departureTime;
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.totalKmToTravel = totalKmToTravel;
        this.subRoutes = createSubRoutes(stations);
        this.trainToDoRoute = trainToDoRoute;
    }
    public Route(){
        
    }


    private LinkedList<SubRoute> createSubRoutes(LinkedList<Station> stations) {
        LinkedList<SubRoute> subRoutes = new LinkedList<>();
        for (int i = 0; i < stations.getSize() - 1; i++) {
            SubRoute subRoute = new SubRoute(stations.get(i), stations.get(i + 1), departureTime, estimatedArrivalTime, trainToDoRoute, routeId);
            subRoutes.add(subRoute);
        }
        return subRoutes;
    }

    public LinkedList<SubRoute> getSubRoutes() {
        return subRoutes;
    }

    public void setSubRoutes(LinkedList<SubRoute> rubRoutes) {
        this.subRoutes = rubRoutes;
    }

    public Train getTrainToDoRoute() {
        return trainToDoRoute;
    }

    public void setTrainToDoRoute(Train trainToDoRoute) {
        this.trainToDoRoute = trainToDoRoute;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public LinkedList<Station> getStations() {
        return stations;
    }

    public void setStations(LinkedList<Station> stations) {
        this.stations = stations;
    }

    public Date getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(Date estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }
    
    public Station getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(Station destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public Station getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Station startPoint) {
        this.startPoint = startPoint;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return estimatedArrivalTime;
    }

    public void ArrivalTime(Date arrivalTime) {
        this.estimatedArrivalTime = arrivalTime;
    }

    public float getTotalKmToTravel() {
        return totalKmToTravel;
    }

    public void setTotalKmToTravel(float kmToTravel) {
        this.totalKmToTravel = kmToTravel;
    }

    public void printRouteInfo() {
        System.out.println("Información de la Ruta:");
        System.out.println("ID de Ruta: " + routeId);
        System.out.println("Estación de Partida: " + startPoint.getStationName());
        System.out.println("Estación de Destino: " + destinationPoint.getStationName());
        System.out.println("Hora de Salida: " + departureTime);
        System.out.println("Hora Estimada de Llegada: " + estimatedArrivalTime);
        System.out.println("Kilómetros totales a recorrer: " + totalKmToTravel);

        System.out.println("Subrutas:");
        for (int i = 0; i < subRoutes.getSize(); i++) {
            SubRoute subRoute = subRoutes.get(i);
            System.out.println("Subruta " + (i + 1) + ":");
            System.out.println("  Estación de Partida: " + subRoute.getStartPoint().getStationName());
            System.out.println("  Estación de Destino: " + subRoute.getDestinationPoint().getStationName());
            System.out.println("  Hora de Salida: " + subRoute.getDepartureTime());
            System.out.println("  Hora Estimada de Llegada: " + subRoute.getEstimatedArrivalTime());
        }
    }

    /*
    //Prueba de como crear una ruta
    public static void main(String[] args) {
     
        RoutesMap mapa = new RoutesMap();

        // Definir fechas de salida y llegada
        Date departureTime1 = new Date(); // Fecha de salida actual
        Date arrivalTime1 = new Date();
        arrivalTime1 = mapa.calculateEstimatedArrivalTime(departureTime1,mapa.stationsToTravel(mapa.getStationA(), mapa.getStationH()));  

        Route route3 = new Route(mapa.stationsToTravel(mapa.getStationA(), mapa.getStationH()), mapa.getStationA(), mapa.getStationH(),
                departureTime1,arrivalTime1, mapa.calculateTotalDistance(mapa.stationsToTravel(mapa.getStationA(), mapa.getStationH())), 
                new Train("Tren 3", "", 0f, , "marca3", true),"2231");

        route3.printRouteInfo();
    }
    */
}