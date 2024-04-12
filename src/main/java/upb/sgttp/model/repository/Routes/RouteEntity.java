package upb.sgttp.model.repository.Routes;

import java.util.Date;

import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.RouteUtilities.Station;
import upb.sgttp.model.domain.trainUtilities.Train;

public class RouteEntity {
    
    private String routeId;

    private LinkedList<Station> stations;//

    private float totalKmToTravel;

    private Station destinationPoint; //
    private Station startPoint; //
   
    private Date departureTime;
    private Date estimatedArrivalTime;

    private Train trainToDoRoute;

    public RouteEntity(LinkedList<Station> stations,
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
}

