package upb.sgttp.model.domain.RouteUtilities;

import java.util.Date;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.trainUtilities.Train;
import upb.sgttp.model.repository.Routes.RouteRepository;
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
    public CustomerRoute(){
        this.startPoint = null;
        this.destinationPoint = null;
        this.departureTime = null;
        this.estimatedArrivalTime = null;
        this.trainToDoRoute = null;
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

    private LinkedList<SubRoute> assignSubRoutesForCustomerStationsToRun(LinkedList<Station> stationsToRun) {

        LinkedList<SubRoute> subRoutesOfStationsToRun = createSubStations(stationsToRun);
    
        RouteRepository routeManager = new RouteRepository("C:\\Users\\juanp\\OneDrive\\Escritorio\\clone repositorio\\RailwaysGranCol\\src\\main\\java\\upb\\sgttp\\database\\routes.json");
        LinkedList<Route> availableRoutes = routeManager.getAllRoutesAsLinkedList();
    
        LinkedList<SubRoute> assignedSubRoutes = new LinkedList<>();
    
        for (int i = 0; i < availableRoutes.getSize(); i++) {
            LinkedList<SubRoute> subRoutes = availableRoutes.get(i).getSubRoutes();
            for (int j = 0; j < subRoutes.getSize(); j++) {
                SubRoute subRoute = subRoutes.get(j);
                if (stationsToRun.contains(subRoute.getStartPoint()) && stationsToRun.contains(subRoute.getDestinationPoint())) {
                    // Verificar si la subruta conecta las mismas estaciones y el orden es correcto
                    if (stationsToRun.indexOf(subRoute.getStartPoint()) < stationsToRun.indexOf(subRoute.getDestinationPoint())) {
                        // Verificar si ya existe una subruta que conecta las mismas estaciones
                        boolean routeExists = false;
                        for (int k = 0; k < assignedSubRoutes.getSize(); k++) {
                            SubRoute assignedRoute = assignedSubRoutes.get(k);
                            if (assignedRoute.getStartPoint().equals(subRoute.getStartPoint())
                                    && assignedRoute.getDestinationPoint().equals(subRoute.getDestinationPoint())) {
                                routeExists = true;
                                break;
                            }
                        }
                        // Si no existe una subruta que conecta las mismas estaciones, agregar la nueva subruta
                        if (!routeExists) {
                            assignedSubRoutes.add(subRoute);
                        }
                    }
                }
            }
        }
    
        return assignedSubRoutes;
    }

    private LinkedList<Route> getOrderedRoutes(LinkedList<SubRoute> assignedSubRoutes) {
        // Agrupar las subrutas por ruta asociada
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
                    break;
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

    private LinkedList<CustomerRoute> createCustomerRoutes(LinkedList<Route> routes) {
        LinkedList<CustomerRoute> customerRoutes = new LinkedList<>();
        int size = routes.size();
        for (int i = 0; i < size; i++) {
            Route route = routes.get(i);
            customerRoutes.add(new CustomerRoute(route.getStations().peek(), route.getStations().peekLast(),
                    route.getDepartureTime(), route.getArrivalTime(), route.getTrainToDoRoute()));
        }
        customerRoutes.reverse();
        return customerRoutes;
    }

    public static void traerRutasCliente() {
        RouteRepository routeManager = new RouteRepository("C:\\Users\\juanp\\OneDrive\\Escritorio\\clone repositorio\\RailwaysGranCol\\src\\main\\java\\upb\\sgttp\\database\\routes.json");
        LinkedList<Route> availableRoutes = routeManager.getAllRoutesAsLinkedList();

        Iterator<Route> routeIterator = availableRoutes.iterator();

        while (routeIterator.hasNext()) {
            Route route = routeIterator.next();
            LinkedList<Station> stations = route.getStations();

            System.out.println("Estación inicial: " + stations.peek().getStationName());

            Iterator<Station> intermediateStationsIterator = stations.iterator();

            intermediateStationsIterator.next(); // Saltar la primera estación (ya mostrada como estación inicial)
            Station intermediateStation;
            while (intermediateStationsIterator.hasNext()) {
                intermediateStation = intermediateStationsIterator.next();
                System.out.println("Estación mid: " + intermediateStation.getStationName());
            }

            System.out.println("Estación final: " + stations.peekLast().getStationName());
            System.out.println("--------------");
        }
    }

    
    public LinkedList<CustomerRoute> traerLaRutaDelCliente(LinkedList<Station> stationsToRun){
        LinkedList<SubRoute> assignedSubRoutes = assignSubRoutesForCustomerStationsToRun(stationsToRun);
        LinkedList<Route> orderedRoutes = getOrderedRoutes(assignedSubRoutes);
        LinkedList<CustomerRoute> customerRoutes = createCustomerRoutes(orderedRoutes);
        return customerRoutes;
    }

    public static void main(String[] args) {

        RoutesMap map = new RoutesMap();
    
        LinkedList<Station> stationsToTravel = map.stationsToTravel(map.getStationI(), map.getStationF());
    

        System.out.println("Estas son las rutas a recorrer:");
        for (int i = 0; i < stationsToTravel.getSize(); i++) {
            System.out.println("  " + stationsToTravel.get(i).getStationName());
        }
    
        // Traer las rutas del cliente
        traerRutasCliente();
    
        // Asignar subrutas para las estaciones del cliente
        CustomerRoute customerRoute = new CustomerRoute(null, null, null, null, null);
        LinkedList<SubRoute> assignedSubRoutes = customerRoute.assignSubRoutesForCustomerStationsToRun(stationsToTravel);
    
        // Mostrar información sobre las subrutas asignadas al cliente
        System.out.println("SubRutas asignadas al cliente:");
        for (int i = 0; i < assignedSubRoutes.getSize(); i++) {
            SubRoute route = assignedSubRoutes.get(i);
            System.out.println("Inicio ruta: " + route.getStartPoint().getStationName());
            System.out.println("Final ruta: " + route.getDestinationPoint().getStationName());
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
    
        // Crear las rutas del cliente
        LinkedList<CustomerRoute> customerRoutes = customerRoute.createCustomerRoutes(orderedRoutes);
    
        // Mostrar las rutas del cliente
        System.out.println("Rutas del cliente:");
        for (int i = 0; i < customerRoutes.getSize(); i++) {
            CustomerRoute route = customerRoutes.get(i);
            System.out.println("Ruta " + (i + 1) + ":");
            System.out.println("  StartPoint: " + route.getStartPoint().getStationName());
            System.out.println("  DestinationPoint: " + route.getDestinationPoint().getStationName());
            System.out.println("  DepartureTime: " + route.getDepartureTime());
            System.out.println("  EstimatedArrivalTime: " + route.getEstimatedArrivalTime());
            System.out.println("  TrainToDoRoute: " + route.getTrainToDoRoute());
        }
    }

}
