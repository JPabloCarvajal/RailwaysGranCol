package jp.sgttp.model.domain.RouteUtilities;

import java.util.Date;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import jp.sgttp.model.domain.trainUtilities.Train;
import jp.sgttp.model.repository.Routes.RouteRepository;
import jp.util.iterator.Iterator;

public class CustomerRoute {

    private Station startPoint;
    private Station destinationPoint;

    private Date departureTime;
    private Date estimatedArrivalTime;

    private Train trainToDoRoute;

    public CustomerRoute(Station startPoint, Station destinationPoint, Date departureTime, Date estimatedArrivalTime,
            Train trainToDoRoute) {
        this.startPoint = startPoint;
        this.destinationPoint = destinationPoint;
        this.departureTime = departureTime;
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.trainToDoRoute = trainToDoRoute;
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

    public static LinkedList<CustomerRoute> assignRoutesForCustomer(LinkedList<Station> stationsToRun, Date departureTime) {

        RouteRepository routeManager = new RouteRepository("C:\\Users\\juanp\\OneDrive\\Escritorio\\RailwaysGranCol\\EDDJP\\Collection\\src\\main\\java\\jp\\sgttp\\database\\routes.json");
    
        LinkedList<Route> availableRoutes = routeManager.getAllRoutesAsLinkedList();
    
        LinkedList<CustomerRoute> assignedCustomerRoutes = new LinkedList<>();
    
        Iterator<Route> iterator = availableRoutes.iterator();
        while (iterator.hasNext()) {
            Route route = iterator.next();
    
            // Verificamos si la ruta conecta las estaciones proporcionadas por el cliente
            if (routeConnectsStations(route, stationsToRun)) {

                // Creamos una ruta de cliente y la agregamos a la lista de rutas asignadas al cliente
                //CustomerRoute customerRoute = new CustomerRoute(route.getStartPoint(), route.getDestinationPoint(),
                //        departureTime, estimatedArrivalTime, route.getTrainToDoRoute());
                // assignedCustomerRoutes.add(customerRoute);
            }
        }
    
        return assignedCustomerRoutes;
    }

    private static boolean routeConnectsStations(Route route, LinkedList<Station> stationsToRun) {
        
        return stationsToRun.contains(route.getStations());
    }
}
