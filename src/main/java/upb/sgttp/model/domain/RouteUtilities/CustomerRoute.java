package upb.sgttp.model.domain.RouteUtilities;

import java.io.Serializable;
import java.util.Date;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.trainUtilities.Train;
import upb.sgttp.model.repository.Routes.RouteRepository;
import jp.util.iterator.Iterator;

/**
 * La clase CustomerRoute representa una ruta específica solicitada por un cliente.
 * Contiene información sobre la estación de inicio, la estación de destino, la hora de salida,
 * la hora de llegada estimada y el tren asignado para realizar la ruta, que se toma de las rutas
 * agregadas por los administradores.
 */

public class CustomerRoute implements Serializable {

    private Station startPoint;
    private Station destinationPoint;
    private Date departureTime;
    private Date estimatedArrivalTime;
    private Train trainToDoRoute;

    /**
     * Constructor de CustomerRoute.
     * @param startPoint La estación de inicio de la ruta.
     * @param destinationPoint La estación de destino de la ruta.
     * @param departureTime La hora de salida de la ruta.
     * @param estimatedArrivalTime La hora de llegada estimada de la ruta.
     * @param trainToDoRoute El tren asignado para realizar la ruta.
     */

    public CustomerRoute(Station startPoint, Station destinationPoint, Date departureTime, Date estimatedArrivalTime,
            Train trainToDoRoute) {
        this.startPoint = startPoint;
        this.destinationPoint = destinationPoint;
        this.departureTime = departureTime;
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.trainToDoRoute = trainToDoRoute;
    }

    /**
     * Constructor vacío de CustomerRoute.
     */

    public CustomerRoute(){
        this.startPoint = null;
        this.destinationPoint = null;
        this.departureTime = null;
        this.estimatedArrivalTime = null;
        this.trainToDoRoute = null;
    }

    /**
     * Obtiene la estación de inicio de la ruta.
     * @return La estación de inicio de la ruta.
     */

    public Station getStartPoint() {
        return startPoint;
    }

    /**
     * Establece la estación de inicio de la ruta.
     * @param startPoint La estación de inicio de la ruta.
     */

    public void setStartPoint(Station startPoint) {
        this.startPoint = startPoint;
    }

    /**
     * Obtiene la estación de destino de la ruta.
     * @return La estación de destino de la ruta.
     */

    public Station getDestinationPoint() {
        return destinationPoint;
    }

    /**
     * Establece la estación de destino de la ruta.
     * @param destinationPoint La estación de destino de la ruta.
     */

    public void setDestinationPoint(Station destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    /**
     * Obtiene la hora de salida de la ruta.
     * @return La hora de salida de la ruta.
     */

    public Date getDepartureTime() {
        return departureTime;
    }

    /**
     * Obtiene la hora de salida de la ruta.
     * @return La hora de salida de la ruta.
     */

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Obtiene la hora de llegada estimada de la ruta.
     * @return La hora de llegada estimada de la ruta.
     */

    public Date getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    /**
     * Establece la hora de llegada estimada de la ruta.
     * @param estimatedArrivalTime La hora de llegada estimada de la ruta.
     */

    public void setEstimatedArrivalTime(Date estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    /**
     * Obtiene el tren asignado para realizar la ruta.
     * @return El tren asignado para realizar la ruta.
     */

    public Train getTrainToDoRoute() {
        return trainToDoRoute;
    }

     /**
     * Establece el tren asignado para realizar la ruta.
     * @param trainToDoRoute El tren asignado para realizar la ruta.
     */

    public void setTrainToDoRoute(Train trainToDoRoute) {
        this.trainToDoRoute = trainToDoRoute;
    }

    /**
     * Metodo auxiliar que Asigna subrutas para las estaciones del cliente y las agrupa en una lista.
     * @param stationsToRun Las estaciones del cliente por las que tiene pasar para completar su recorrido.
     * @return Una lista de subrutas asignadas.
     */

    private LinkedList<SubRoute> assignSubRoutesForCustomerStationsToRun(LinkedList<Station> stationsToRun) {
        LinkedList<SubRoute> assignedSubRoutes = new LinkedList<>();
        RouteRepository routeManager = new RouteRepository("RailwaysGranCol\\src\\main\\java\\upb\\sgttp\\database\\routes.json");

        // Iterar sobre todas las rutas disponibles
        LinkedList<Route> availableRoutes = routeManager.getAllRoutesAsLinkedList();
        for (int i = 0; i < availableRoutes.getSize(); i++) {
            Route route = availableRoutes.get(i);

            // Iterar sobre las subrutas de la ruta
            LinkedList<SubRoute> subRoutes = route.getSubRoutes();
            for (int j = 0; j < subRoutes.getSize(); j++) {
                SubRoute subRoute = subRoutes.get(j);

                // Verificar si la subruta conecta las estaciones de inicio y destino proporcionadas por el cliente
                if (stationsToRun.contains(subRoute.getStartPoint()) && stationsToRun.contains(subRoute.getDestinationPoint())) {

                    // Verificar si la subruta respeta el orden de las estaciones proporcionadas por el cliente
                    if (checkSubRouteOrder(subRoute, stationsToRun)) {
                        // Verificar si la subruta ya está asignada
                        if (!assignedSubRoutes.contains(subRoute)) {
                            assignedSubRoutes.add(subRoute);
                        }
                    }
                }
            }
        }

        return assignedSubRoutes;
    }

    /**
     * Metodo auxiliar que Verifica el orden de una subruta con respecto a las estaciones por las que tiene que pasar
     * proporcionadas por el cliente.
     * @param subRoute La subruta a verificar.
     * @param stationsToRun Las estaciones proporcionadas por el cliente.
     * @return true si el orden de la subruta es correcto, false de lo contrario.
     */
    private boolean checkSubRouteOrder(SubRoute subRoute, LinkedList<Station> stationsToRun) {
        int startIndex = stationsToRun.indexOf(subRoute.getStartPoint());
        int destIndex = stationsToRun.indexOf(subRoute.getDestinationPoint());
        return startIndex < destIndex;
    }
    
    /**
     * Metodo auxiliar que Obtiene las rutas ordenadas a partir de las subrutas asignadas,ordenadas significa que las
     * agrupa segun las que necesite el cliente especificamente y en el orden especifico.
     * @param assignedSubRoutes Las subrutas asignadas.
     * @return Una lista de rutas ordenadas.
     */

    private LinkedList<Route> getOrderedRoutes(LinkedList<SubRoute> assignedSubRoutes) {
        // Crear una lista de rutas ordenadas
        LinkedList<Route> orderedRoutes = new LinkedList<>();
    
        // Crear una lista para almacenar las rutas agrupadas
        LinkedList<LinkedList<SubRoute>> groupedRoutesList = new LinkedList<>();
    
        // Agrupar las subrutas por estación de inicio y final
        for (int i = 0; i < assignedSubRoutes.getSize(); i++) {
            SubRoute subRoute = assignedSubRoutes.get(i);
            boolean foundGroup = false;
    
            // Buscar un grupo existente para agregar la subruta
            for (int j = 0; j < groupedRoutesList.getSize(); j++) {
                LinkedList<SubRoute> group = groupedRoutesList.get(j);
                if (group.peek().getStartPoint().equals(subRoute.getStartPoint()) &&
                    group.peekLast().getDestinationPoint().equals(subRoute.getDestinationPoint())) {
                    group.add(subRoute);
                    foundGroup = true;
                    break;
                }
            }
    
            // Si no se encuentra un grupo existente, crear uno nuevo
            if (!foundGroup) {
                LinkedList<SubRoute> newGroup = new LinkedList<>();
                newGroup.add(subRoute);
                groupedRoutesList.add(newGroup);
            }
        }
    
        // Crear rutas ordenadas a partir de las subrutas agrupadas
        for (int i = 0; i < groupedRoutesList.getSize(); i++) {
            LinkedList<SubRoute> group = groupedRoutesList.get(i);
            LinkedList<LinkedList<SubRoute>> groupedRoutes = getGroupedRoutes(group);
            
            // Agregar las rutas agrupadas a la lista de rutas ordenadas
            for (int j = 0; j < groupedRoutes.getSize(); j++) {
                LinkedList<SubRoute> groupedRoute = groupedRoutes.get(j);
                Route route = createRouteFromSubRoutes(groupedRoute);
                if (!isRouteCompleted(route, orderedRoutes)) {
                    orderedRoutes.add(route);
                }
            }
        }
    
        return orderedRoutes;
    }


    /**
     *  Metodo auxiliar que verifica si una ruta ya ha sido completada.
     * @param route La ruta a verificar.
     * @param completedRoutes Las rutas completadas.
     * @return true si la ruta ya ha sido completada, false de lo contrario.
     */
    private boolean isRouteCompleted(Route route, LinkedList<Route> completedRoutes) {
        for (int i = 0; i < completedRoutes.getSize(); i++) {
            Route completedRoute = completedRoutes.get(i);
            // Verificar si las estaciones de inicio y final son las mismas
            if (route.getStartPoint().equals(completedRoute.getStartPoint()) &&
                route.getDestinationPoint().equals(completedRoute.getDestinationPoint())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo auxiliar que agrupa las subrutas en rutas ordenadas.
     * @param assignedSubRoutes Las subrutas asignadas.
     * @return Una lista de rutas ordenadas.
     */
    
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

    /**
     * Metodo auxiliar que crea una ruta a partir de un grupo de subrutas que son las que necesita el cliente
     * para cumplir su trayecto .
     * @param groupedRoute El grupo de subrutas.
     * @return La ruta creada.
     */

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

    /**
     * Metodo auxiliar que crea las rutas del cliente osea las que necesita para completar su recorrido 
     * a partir de las rutas ordenadas.
     * @param routes Las rutas ordenadas.
     * @return Una lista de rutas del cliente.
     */

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

    /**
     * Método estático para traer las rutas de la base de datos y mostrarlas por consola.
     */

    public static void traerRutasCliente() {
        RouteRepository routeManager = new RouteRepository("RailwaysGranCol\\src\\main\\java\\upb\\sgttp\\database\\routes.json");
        LinkedList<Route> availableRoutes = routeManager.getAllRoutesAsLinkedList();
    
        // Iterador para recorrer la lista de rutas
        Iterator<Route> routeIterator = availableRoutes.iterator();
    
        // Iterar sobre cada ruta disponible
        while (routeIterator.hasNext()) {
            Route route = routeIterator.next();
            LinkedList<Station> stations = route.getStations();
            
            System.out.println("Ruta: " + route.getRouteId());

            Iterator<Station> intermediateStationsIterator = stations.iterator();
            Station intermediateStation;
            while (intermediateStationsIterator.hasNext()) {
                intermediateStation = intermediateStationsIterator.next();
                
                System.out.println("Estación: " + intermediateStation.getStationName());
            }
    
            // Separador entre rutas
            System.out.println("--------------");
        }
    }

    /**
     * Trae la ruta del cliente en función de las estaciones proporcionadas.
     * @param stationsToRun Lista de estaciones proporcionadas por el cliente.
     * @return Una lista enlazada de objetos CustomerRoute que representan las rutas disponibles para el cliente.
     */
    public LinkedList<CustomerRoute> traerLaRutaDelCliente(LinkedList<Station> stationsToRun){

        // Asigna las subrutas para las estaciones del cliente
        LinkedList<SubRoute> assignedSubRoutes = assignSubRoutesForCustomerStationsToRun(stationsToRun);

        // Obtiene las rutas ordenadas
        LinkedList<Route> orderedRoutes = getOrderedRoutes(assignedSubRoutes);

        // Crea las rutas del cliente a partir de las rutas ordenadas
        LinkedList<CustomerRoute> customerRoutes = createCustomerRoutes(orderedRoutes);

        return customerRoutes;

    }

    
    /**
     * Método principal para probar la funcionalidad de la clase.
     * Muestra las rutas a recorrer, las rutas del cliente y la información sobre las subrutas asignadas.
     */
    public static void main(String[] args) {

        RoutesMap map = new RoutesMap();
    
        LinkedList<Station> stationsToTravel = map.stationsToTravel(map.getStationA(), map.getStationB());


    
        // Mostrar las rutas a recorrer
        System.out.println("Estas son las rutas a recorrer:");
        for (int i = 0; i < stationsToTravel.getSize(); i++) {
            System.out.println("  " + stationsToTravel.get(i).getStationName());
        }
    
        // Traer las rutas del cliente
        traerRutasCliente();
    
        // Asignar subrutas para las estaciones del cliente
        CustomerRoute customerRoute = new CustomerRoute(null, null, null, null, null);

        LinkedList<CustomerRoute> customerRoutezzz = customerRoute.traerLaRutaDelCliente(stationsToTravel);
        
        // Mostrar las rutas del cliente
        System.out.println("Rutas del cliente:");
        for (int i = 0; i < customerRoutezzz.getSize(); i++) {
            CustomerRoute route = customerRoutezzz.get(i);
            System.out.println("Ruta " + (i + 1) + ":");
            System.out.println("  StartPoint: " + route.getStartPoint().getStationName());
            System.out.println("  DestinationPoint: " + route.getDestinationPoint().getStationName());
            System.out.println("  DepartureTime: " + route.getDepartureTime());
            System.out.println("  EstimatedArrivalTime: " + route.getEstimatedArrivalTime());
            System.out.println("  TrainToDoRoute: " + route.getTrainToDoRoute());
        }

        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

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