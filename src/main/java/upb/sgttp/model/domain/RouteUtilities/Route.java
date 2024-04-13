package upb.sgttp.model.domain.RouteUtilities;

import java.util.Date;

import jp.linkedlist.singly.LinkedList;

import upb.sgttp.model.domain.trainUtilities.Train;

public class Route {

    private String routeId;

    private LinkedList<Station> stations;//

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
    }

    
    //Prueba de como crear una ruta
    public static void main(String[] args) {
        RoutesMap mapa = new RoutesMap();

        // Definir fechas de salida y llegada
        Date departureTime1 = new Date(); // Fecha de salida actual
        Date arrivalTime1 = new Date();
        arrivalTime1 = mapa.calculateEstimatedArrivalTime(departureTime1,mapa.stationsToTravel(mapa.getStationA(), mapa.getStationB()));  

//        Route route3 = new Route(mapa.stationsToTravel(mapa.getStationA(), mapa.getStationB()), mapa.getStationA(), mapa.getStationB(),
//                departureTime1,arrivalTime1, mapa.calculateTotalDistance(mapa.stationsToTravel(mapa.getStationA(), mapa.getStationB())), 
//                new Train("Tren 3", "", 0, 0, "marca3", null, null),"2231");

//        route3.printRouteInfo();
    }
    
}