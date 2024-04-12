package upb.sgttp.model.domain.RouteUtilities;

import java.util.Date;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.trainUtilities.Train;
import upb.sgttp.model.repository.Routes.RouteRepository;
import jp.stack.list.StackList;
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


public static LinkedList<Route> assignRoutesForCustomer(LinkedList<Station> stationsToRun) {

    RouteRepository routeManager = new RouteRepository("C:\\Users\\juanp\\OneDrive\\Escritorio\\RailwaysGranCol\\EDDJP\\Collection\\src\\main\\java\\jp\\sgttp\\database\\routes.json");
    
    LinkedList<Route> availableRoutes = routeManager.getAllRoutesAsLinkedList();

    LinkedList<Route> assignedCustomerRoutes = new LinkedList<>();

    LinkedList<Station> stationToRunCopy = stationsToRun;

    StackList<Station> stationStack = new StackList<>();

    while (!stationToRunCopy.isEmpty()) {

        for (int i = 0; i < availableRoutes.getSize(); i++) {

            if (availableRoutes.get(i).getStations().containsAll(stationToRunCopy)) {
                if (stationToRunCopy.peekLast() != stationsToRun.peekLast()) {
                    stationStack.push(stationToRunCopy.pollLast());
                }
                assignedCustomerRoutes.add(availableRoutes.get(i));
                stationToRunCopy.clear();
                stationToRunCopy.add(stationStack);
                stationStack.clear();
            }
        }
        stationStack.push(stationToRunCopy.pollLast());
    }

    return assignedCustomerRoutes;
}

public static LinkedList<Route> buscarRutasCompatibles(LinkedList<Station> stationsToRun) {
    // Obtener todas las rutas disponibles
    RouteRepository routeManager = new RouteRepository("C:\\Users\\juanp\\OneDrive\\Escritorio\\RailwaysGranCol\\EDDJP\\Collection\\src\\main\\java\\jp\\sgttp\\database\\routes.json");
    LinkedList<Route> availableRoutes = routeManager.getAllRoutesAsLinkedList();

    // Lista para almacenar las rutas compatibles con las estaciones proporcionadas por el cliente
    LinkedList<Route> rutasCompatibles = new LinkedList<>();

    // Recorrer todas las rutas disponibles
    for (int i = 0; i < availableRoutes.getSize(); i++) {
        // Obtener la ruta actual
        Route route = availableRoutes.get(i);
        
        // Obtener la lista de estaciones de la ruta actual
        LinkedList<Station> stations = route.getStations();
        
        // Verificar si las estaciones proporcionadas por el cliente coinciden con alguna parte de la ruta
        boolean stationsMatch = true;
        int index = 0;
        while (index < stationsToRun.getSize()) {
            Station station = stationsToRun.get(index);
            if (index < stations.getSize() && stations.get(index).equals(station)) {
                index++;
            } else {
                stationsMatch = false;
                break;
            }
        }
        
        // Si todas las estaciones coinciden, agregar la ruta a la lista de rutas compatibles
        if (stationsMatch) {
            rutasCompatibles.add(route);
        }
    }

    // Devolver la lista de rutas compatibles
    return rutasCompatibles;
}


    
    

    public static void traerRutas(){

        RouteRepository routeManager = new RouteRepository("C:\\Users\\juanp\\OneDrive\\Escritorio\\RailwaysGranCol\\EDDJP\\Collection\\src\\main\\java\\jp\\sgttp\\database\\routes.json");
        LinkedList<Route> availableRoutes = routeManager.getAllRoutesAsLinkedList();

        Iterator<Route> iterator = availableRoutes.iterator();
        while (iterator.hasNext()) {
            Iterator<Station> stationsite = iterator.next().getStations().iterator();
            while(stationsite.hasNext()){
                System.out.println(stationsite.next().getStationName()); 
            }
            System.out.println("--------------");
        }
    }

        

    public static void main(String[] args) {
        RoutesMap map = new RoutesMap();
        // Crear una lista de estaciones por las que el cliente desea viajar
        traerRutas();

        LinkedList<Station> stationsToTravel = map.stationsToTravel(map.getStationB(),map.getStationF());
        
        // Definir la fecha de salida del cliente
        LinkedList<Route> assignedRoutes = CustomerRoute.buscarRutasCompatibles(stationsToTravel);

        // Imprimir información sobre las rutas asignadas al cliente
        System.out.println("Rutas asignadas al cliente:");
        System.out.println(assignedRoutes.toString());
        Iterator<Route> iterator = assignedRoutes.iterator();
        while (iterator.hasNext()) {
            Route route = iterator.next();
            System.out.println("Inicio ruta: " + route.getStartPoint().getStationName());
            System.out.println("Final ruta"+ route.getDestinationPoint().getStationName() );
        }
        
    }

}
