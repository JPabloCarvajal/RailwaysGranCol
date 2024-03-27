package jp.sgttp.model.domain.RouteUtilities;

import jp.linkedlist.singly.LinkedList;
import jp.queue.list.QueueList;

public class Route {

    private int routeId;
    private LinkedList<Station> stations;
    private QueueList<Station> actualRoute;
    private Station destinationPoint;
    private Station startPoint;
    private float kmTraveled;
    private float kmToEachStation;

    public Route(int routeId, LinkedList<Station> stations, QueueList<Station> actualRoute,
                 Station destinationPoint, Station startPoint, float kmTraveled, float kmToEachStation) {
        this.routeId = routeId;
        this.stations = stations;
        this.actualRoute = actualRoute;
        this.destinationPoint = destinationPoint;
        this.startPoint = startPoint;
        this.kmTraveled = kmTraveled;
        this.kmToEachStation = kmToEachStation;
    }

    public int getRouteId() {
        return routeId;
    }

    public LinkedList<Station> getStations() {
        return stations;
    }

    public QueueList<Station> getActualRoute() {
        return actualRoute;
    }

    public Station getDestinationPoint() {
        return destinationPoint;
    }

    public Station getStartPoint() {
        return startPoint;
    }

    public float getKmTraveled() {
        return kmTraveled;
    }

    public float getKmToEachStation() {
        return kmToEachStation;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setStations(LinkedList<Station> stations) {
        this.stations = stations;
    }

    public void setActualRoute(QueueList<Station> actualRoute) {
        this.actualRoute = actualRoute;
    }

    public void setDestinationPoint(Station destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public void setStartPoint(Station startPoint) {
        this.startPoint = startPoint;
    }

    public void setKmTraveled(float kmTraveled) {
        this.kmTraveled = kmTraveled;
    }

    public void setKmToEachStation(float kmToEachStation) {
        this.kmToEachStation = kmToEachStation;
    }
}
