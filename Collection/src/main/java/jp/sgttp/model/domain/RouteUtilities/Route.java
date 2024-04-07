package jp.sgttp.model.domain.RouteUtilities;

import jp.linkedlist.singly.LinkedList;
import jp.queue.list.QueueList;
import jp.sgttp.model.domain.trainUtilities.Train;
import java.time.LocalTime;

public class Route {

    private static int routeId = 0;

    private LinkedList<Station> stations;//

    private QueueList<Station> actualRoute;//
    private QueueList<Train> actualTrain;

    private float totalKmToTravel;

    private Station destinationPoint; //
    private Station startPoint; //
   
    private String departureTime; //
    private String estimateArrivalTime; //

    public Route(LinkedList<Station> stations, QueueList<Station> actualRoute,
                 Station destinationPoint, Station startPoint,
                 QueueList<Train> actualTrain, String departureTime, String estimateArrivalTime,float totalKmToTravel) {
        this.routeId++;
        this.stations = stations;
        this.actualRoute = actualRoute;
        this.destinationPoint = destinationPoint;
        this.startPoint = startPoint;
        this.actualTrain = actualTrain;
        this.departureTime = departureTime;
        this.estimateArrivalTime = estimateArrivalTime;
        this.totalKmToTravel = totalKmToTravel;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public LinkedList<Station> getStations() {
        return stations;
    }

    public void setStations(LinkedList<Station> stations) {
        this.stations = stations;
    }

    public QueueList<Station> getActualRoute() {
        return actualRoute;
    }

    public void setActualRoute(QueueList<Station> actualRoute) {
        this.actualRoute = actualRoute;
    }

    public QueueList<Train> getActualTrain() {
        return actualTrain;
    }

    public void setActualTrain(QueueList<Train> actualTrain) {
        this.actualTrain = actualTrain;
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

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return estimateArrivalTime;
    }

    public void ArrivalTime(String arrivalTime) {
        this.estimateArrivalTime = arrivalTime;
    }

    public float getTotalKmToTravel() {
        return totalKmToTravel;
    }

    public void setTotalKmToTravel(float kmToTravel) {
        this.totalKmToTravel = kmToTravel;
    }
}
