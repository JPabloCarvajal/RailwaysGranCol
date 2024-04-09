package jp.sgttp.model.domain.RouteUtilities;

import java.util.Date;

import jp.linkedlist.singly.LinkedList;
import jp.queue.list.QueueList;
import jp.sgttp.model.domain.trainUtilities.Train;

public class Route {

    private static int routeId = 0;

    private LinkedList<Station> stations;//

    private float totalKmToTravel;

    private Station destinationPoint; //
    private Station startPoint; //
   
    private Date departureTime;
    private Date estimatedArrivalTime;

    private Train trainToDoRoute;

    private QueueList<Train> actualTrain;



    public Route(LinkedList<Station> stations,
                 Station startPoint,Station destinationPoint,
                 QueueList<Train> actualTrain, Date departureTime, Date estimatedArrivalTime,float totalKmToTravel,
                 Train trainToDoRoute) {
        this.routeId++;
        this.stations = stations;
        this.destinationPoint = destinationPoint;
        this.startPoint = startPoint;
        this.actualTrain = actualTrain;
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


    public static void main(String[] args) {
        // Crear estaciones
        Station startPointA = new Station("Estación A", "Ciudad A");
        Station endPointB = new Station("Estación B", "Ciudad B");

        Station startPointC = new Station("Estación C", "Ciudad C");
        Station endPointD = new Station("Estación D", "Ciudad D");

        Station startPointE = new Station("Estación E", "Ciudad E");
        Station endPointF = new Station("Estación F", "Ciudad F");

        // Crear lista de estaciones para cada ruta
        LinkedList<Station> routeStations1 = new LinkedList<>();
        routeStations1.add(startPointA);
        routeStations1.add(endPointB);

        LinkedList<Station> routeStations2 = new LinkedList<>();
        routeStations2.add(startPointC);
        routeStations2.add(endPointD);

        LinkedList<Station> routeStations3 = new LinkedList<>();
        routeStations3.add(startPointE);
        routeStations3.add(endPointF);

        // Crear cola de trenes para cada ruta
        QueueList<Train> trainQueue1 = new QueueList<>();
        QueueList<Train> trainQueue2 = new QueueList<>();
        QueueList<Train> trainQueue3 = new QueueList<>();

        // Definir fechas de salida y llegada
        Date departureTime1 = new Date(); // Fecha de salida actual
        Date estimatedArrivalTime1 = new Date(departureTime1.getTime() + 3600000); // +1 hora

        Date departureTime2 = new Date(); // Fecha de salida actual
        Date estimatedArrivalTime2 = new Date(departureTime2.getTime() + 7200000); // +2 horas

        Date departureTime3 = new Date(); // Fecha de salida actual
        Date estimatedArrivalTime3 = new Date(departureTime3.getTime() + 10800000); // +3 horas

        // Crear rutas
        Route route1 = new Route(routeStations1, startPointA, endPointB, trainQueue1, departureTime1,
                estimatedArrivalTime1, 100.0f, new Train("Tren 1"));
        Route route2 = new Route(routeStations2, startPointC, endPointD, trainQueue2, departureTime2,
                estimatedArrivalTime2, 150.0f, new Train("Tren 2"));
        Route route3 = new Route(routeStations3, startPointE, endPointF, trainQueue3, departureTime3,
                estimatedArrivalTime3, 200.0f, new Train("Tren 3"));

        // Puedes seguir usando las rutas creadas para realizar más operaciones, como mostrar información, calcular rutas personalizadas, etc.
    }
    
}
