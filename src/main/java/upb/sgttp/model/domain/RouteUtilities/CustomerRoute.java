package upb.sgttp.model.domain.RouteUtilities;

import java.util.Date;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import jp.queue.list.QueueList;
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

    private LinkedList<SubRoute> createSubStations(LinkedList<Station> stations) {
        LinkedList<SubRoute> subRoutes = new LinkedList<>();
        for (int i = 0; i < stations.getSize() - 1; i++) {
            SubRoute subRoute = new SubRoute(stations.get(i), stations.get(i + 1), departureTime, estimatedArrivalTime, trainToDoRoute, "");
            subRoutes.add(subRoute);
        }
        return subRoutes;
    }

    public LinkedList<SubRoute> assignSubRoutesForCustomerStationsToRun(LinkedList<Station> stationsToRun) {

        LinkedList<SubRoute> subRoutesOfStationsToRun = createSubStations(stationsToRun);

        RouteRepository routeManager = new RouteRepository("C:\\Users\\juanp\\OneDrive\\Escritorio\\clone repositorio\\RailwaysGranCol\\src\\main\\java\\upb\\sgttp\\database\\routes.json");
        LinkedList<Route> availableRoutes = routeManager.getAllRoutesAsLinkedList();

        LinkedList<SubRoute> allAvailableSubRoutes = new LinkedList<>();

        for (int i = 0; i < availableRoutes.size(); i++) {
            LinkedList<SubRoute> subRoutes = availableRoutes.get(i).getSubRoutes();
            allAvailableSubRoutes.add(subRoutes);
        }

        LinkedList<SubRoute> assignedSubRoutes = new LinkedList<>();

        for (int i = 0; i < allAvailableSubRoutes.getSize(); i++) {
            SubRoute subRoute = allAvailableSubRoutes.get(i);
            if (stationsToRun.contains(subRoute.getStartPoint()) && stationsToRun.contains(subRoute.getDestinationPoint())) {
                assignedSubRoutes.add(subRoute);
                break;//
            }
        }



        return assignedSubRoutes;
    }   

    public LinkedList<Route> getOrderedRoutes(LinkedList<SubRoute> assignedSubRoutes) {
        // Arreglo para almacenar los grupos temporales de subrutas
        Array<LinkedList<SubRoute>> tempRouteGroups = new Array<>(assignedSubRoutes.getSize());
        int groupCount = 0;
        
        // Agrupar temporalmente las subrutas en arreglos
        for (int i = 0; i < assignedSubRoutes.getSize(); i++) {
            SubRoute subRoute = assignedSubRoutes.get(i);
            boolean foundGroup = false;
            
            // Buscar un arreglo existente donde pueda agregarse la subruta
            for (int j = 0; j < groupCount; j++) {
                LinkedList<SubRoute> group = tempRouteGroups.get(j);
                if (group.peek().getAsociatedIdRoute().equals(subRoute.getAsociatedIdRoute())) {
                    group.add(subRoute);
                    foundGroup = true;
                    //break;
                    //ver algo aqui para que no siga buscando mas rutas del mismo y por ende no se agreguen 2 veces
                }
            }
            
            // Si no se encuentra un grupo existente, crear uno nuevo
            if (!foundGroup) {
                LinkedList<SubRoute> newGroup = new LinkedList<>();
                newGroup.add(subRoute);
                tempRouteGroups.set(groupCount++, newGroup);
            }
        }
        
        // Crear una lista de rutas ordenadas
        LinkedList<Route> orderedRoutes = new LinkedList<>();
        
        // Iterar sobre los grupos temporales de subrutas y crear rutas ordenadas
        for (int i = 0; i < groupCount; i++) {
            LinkedList<SubRoute> group = tempRouteGroups.get(i);
            LinkedList<LinkedList<SubRoute>> groupedRoutes = getGroupedRoutes(group);
            
            // Agregar las rutas agrupadas a la lista de rutas ordenadas
            for (int j = 0; j < groupedRoutes.getSize(); j++) {
                LinkedList<SubRoute> groupedRoute = groupedRoutes.get(j);
                Route route = createRouteFromSubRoutes(groupedRoute);
                orderedRoutes.add(route);
            }
        }
        
        return orderedRoutes;
    }
    
    private LinkedList<LinkedList<SubRoute>> getGroupedRoutes(LinkedList<SubRoute> assignedSubRoutes) {
        LinkedList<LinkedList<SubRoute>> groupedRoutes = new LinkedList<>();
        
        if (assignedSubRoutes.isEmpty()) {
            return groupedRoutes;
        }
        
        LinkedList<SubRoute> currentGroup = new LinkedList<>();
        currentGroup.add(assignedSubRoutes.get(0));
        
        for (int i = 1; i < assignedSubRoutes.getSize(); i++) {
            SubRoute currentRoute = assignedSubRoutes.get(i);
            SubRoute previousRoute = currentGroup.peekLast();
            
            if (currentRoute.getStartPoint().equals(previousRoute.getDestinationPoint())) {
                currentGroup.add(currentRoute);
            } else {
                groupedRoutes.add(currentGroup);
                currentGroup = new LinkedList<>();
                currentGroup.add(currentRoute);
            }
        }
        
        // Agregar el último grupo
        groupedRoutes.add(currentGroup);
        
        return groupedRoutes;
    }

    private Route createRouteFromSubRoutes(LinkedList<SubRoute> groupedRoute) {
        // Obtener la información necesaria de la primera subruta en el grupo
        SubRoute firstSubRoute = groupedRoute.get(0);
        LinkedList<Station> stations = new LinkedList<>();
        stations.add(firstSubRoute.getStartPoint());
        
        // Iterar sobre el grupo de subrutas para agregar las estaciones y calcular la fecha de llegada estimada
        for (int i = 0; i < groupedRoute.getSize(); i++) {
            SubRoute subRoute = groupedRoute.get(i);
            stations.add(subRoute.getDestinationPoint());
        }
        
        // Crear la ruta con la información obtenida
        Route route = new Route(stations, firstSubRoute.getStartPoint(), firstSubRoute.getDestinationPoint(),
                firstSubRoute.getDepartureTime(), firstSubRoute.getEstimatedArrivalTime(),
                0, firstSubRoute.getTrainToDoRoute(), firstSubRoute.getAsociatedIdRoute());
        
        return route;
    }

    public static void traerRutasCliente(){

        RouteRepository routeManager = new RouteRepository("C:\\Users\\juanp\\OneDrive\\Escritorio\\clone repositorio\\RailwaysGranCol\\src\\main\\java\\upb\\sgttp\\database\\routes.json");
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

        LinkedList<Station> stationsToTravel = map.stationsToTravel(map.getStationB(), map.getStationH());
    
        traerRutasCliente();
        for (int i = 0; i < stationsToTravel.getSize(); i++) {
            System.out.println("Estas son las rutas a recorrer" + stationsToTravel.get(i).getStationName());
        }
    
        // Instanciar un objeto CustomerRoute
        CustomerRoute customerRoute = new CustomerRoute(null, null, null, null, null);
    
        LinkedList<SubRoute> assignedSubRoutes = customerRoute.assignSubRoutesForCustomerStationsToRun(stationsToTravel);
    
        // Imprimir información sobre las rutas asignadas al cliente
        System.out.println("SubRutas asignadas al cliente:");
        System.out.println(assignedSubRoutes.toString());
        Iterator<SubRoute> iterator = assignedSubRoutes.iterator();
        while (iterator.hasNext()) {
            SubRoute route = iterator.next();
            System.out.println("Inicio ruta: " + route.getStartPoint().getStationName());
            System.out.println("Final ruta" + route.getDestinationPoint().getStationName());
        }
        System.out.println("------------------------------------------------------");
    
        // Obtener rutas ordenadas
        LinkedList<Route> orderedRoutes = customerRoute.getOrderedRoutes(assignedSubRoutes);
        System.out.println("Rutas ya compiladas y organizadas a usar:");
        for (int i = 0; i < orderedRoutes.getSize(); i++) {
            System.out.println("Ruta " + (i + 1) + ":");
            Route route = orderedRoutes.get(i);
            System.out.println(route.getRouteId());    
        }

    }

}
