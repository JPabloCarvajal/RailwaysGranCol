package upb.sgttp.model.domain.RouteUtilities;

import java.util.Date;

import upb.sgttp.model.domain.trainUtilities.Train;


public class SubRoute {

    private String asociatedIdRoute;

    public String getAsociatedIdRoute() {
        return asociatedIdRoute;
    }

    public void setAsociatedIdRoute(String asociatedIdRoute) {
        this.asociatedIdRoute = asociatedIdRoute;
    }

    private Station startPoint;
    private Station destinationPoint;

    private Date departureTime;
    private Date estimatedArrivalTime;

    private Train trainToDoRoute;

    public SubRoute(Station startPoint, Station destinationPoint, Date departureTime, Date estimatedArrivalTime,
            Train trainToDoRoute, String asociatedIdRoute) {
        this.startPoint = startPoint;
        this.destinationPoint = destinationPoint;
        this.departureTime = departureTime;
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.trainToDoRoute = trainToDoRoute;
        this.asociatedIdRoute = asociatedIdRoute;
    }

    public Station getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Station startPoint) {
        this.startPoint = startPoint;
    }

    public Station getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(Station destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(Date estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    public Train getTrainToDoRoute() {
        return trainToDoRoute;
    }

    public void setTrainToDoRoute(Train trainToDoRoute) {
        this.trainToDoRoute = trainToDoRoute;
    }   

    public static void main(String[] args) {
        /*
        RoutesMap map = new RoutesMap();
        // Crear una lista de estaciones por las que el cliente desea viajar
        traerRutas();

        LinkedList<Station> stationsToTravel = map.stationsToTravel(map.getStationB(),map.getStationF());

        for(int i = 0 ; i < stationsToTravel.getSize(); i++ ){
            System.out.println("Estas son las rutas a recorrer" + stationsToTravel.get(i).getStationName());
        }

        // Definir la fecha de salida del cliente
        LinkedList<Route> assignedRoutes = CustomerRoute.rutasAclopadas(stationsToTravel);

        // Imprimir información sobre las rutas asignadas al cliente
        System.out.println("Rutas asignadas al cliente:");
        System.out.println(assignedRoutes.toString());
        Iterator<Route> iterator = assignedRoutes.iterator();
        while (iterator.hasNext()) {
            Route route = iterator.next();
            System.out.println("Inicio ruta: " + route.getStartPoint().getStationName());
            System.out.println("Final ruta"+ route.getDestinationPoint().getStationName() );
        }
         */
    }

}
