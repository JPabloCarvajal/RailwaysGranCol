package upb.sgttp.model.domain.RouteUtilities;

import java.io.Serializable;
import java.util.Date;

import jp.linkedlist.singly.LinkedList;

import upb.sgttp.model.domain.trainUtilities.Train;

/**
 * La clase Route representa una ruta que conecta una serie de estaciones.
 * Contiene información sobre el identificador de la ruta, las estaciones que la componen,
 * las subrutas asociadas, la hora de salida y llegada estimada, la distancia total a recorrer
 * y el tren asignado para realizar la ruta.
 */

public class Route implements Serializable{

    private String routeId; // Identificador único de la ruta

    private LinkedList<Station> stations; // Lista de estaciones que componen la ruta
    private LinkedList<SubRoute> subRoutes; // Lista de subrutas que componen la ruta

    private float totalKmToTravel; // Kilómetros totales a recorrer en la ruta

    private Station destinationPoint; // Estación de destino de la ruta
    private Station startPoint; // Estación de partida de la ruta
   
    private Date departureTime; // Hora de salida de la ruta
    private Date estimatedArrivalTime; // Hora estimada de llegada de la ruta

    private Train trainToDoRoute; // Tren asignado para realizar la ruta

    /**
     * Constructor de la clase Route.
     * @param stations Lista de estaciones que componen la ruta.
     * @param startPoint Estación de partida de la ruta.
     * @param destinationPoint Estación de destino de la ruta.
     * @param departureTime Hora de salida de la ruta.
     * @param estimatedArrivalTime Hora estimada de llegada de la ruta.
     * @param totalKmToTravel Kilómetros totales a recorrer en la ruta.
     * @param trainToDoRoute Tren asignado para realizar la ruta.
     * @param id Identificador único de la ruta.
     */
    public Route(LinkedList<Station> stations, Station startPoint, Station destinationPoint,
                 Date departureTime, Date estimatedArrivalTime, float totalKmToTravel,
                 Train trainToDoRoute, String id) {
        this.routeId = id;
        this.stations = stations;
        this.destinationPoint = destinationPoint;
        this.startPoint = startPoint;
        this.departureTime = departureTime;
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.totalKmToTravel = totalKmToTravel;
        this.trainToDoRoute = trainToDoRoute;
        this.subRoutes = createSubRoutes(stations);
    }
    
    /**
     * Constructor vacío de la clase Route.
     */
    public Route(){
        
    }

    /**
     * Crea las subrutas que componen la ruta basándose en la lista de estaciones.
     * @param stations Lista de estaciones que componen la ruta.
     * @return Una lista enlazada de objetos SubRoute que representan las subrutas de la ruta.
     */

     private LinkedList<SubRoute> createSubRoutes(LinkedList<Station> stations) {
        LinkedList<SubRoute> subRoutes = new LinkedList<>();
        for (int i = 0; i < stations.getSize() - 1; i++) {
            SubRoute subRoute = new SubRoute(stations.get(i), stations.get(i + 1), departureTime, estimatedArrivalTime, trainToDoRoute, routeId);
            subRoutes.add(subRoute);
        }
        return subRoutes;
    }
    /**
     * Obtiene la lista de subrutas de la ruta.
     * @return La lista de subrutas de la ruta.
     */
    public LinkedList<SubRoute> getSubRoutes() {
        return subRoutes;
    }

    /**
     * Establece la lista de subrutas de la ruta.
     * @param subRoutes La lista de subrutas de la ruta.
     */
    public void setSubRoutes(LinkedList<SubRoute> subRoutes) {
        this.subRoutes = subRoutes;
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
     * Obtiene el identificador único de la ruta.
     * @return El identificador único de la ruta.
     */
    public String getRouteId() {
        return routeId;
    }

    /**
     * Establece el identificador único de la ruta.
     * @param routeId El identificador único de la ruta.
     */
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    /**
     * Obtiene la lista de estaciones que componen la ruta.
     * @return La lista de estaciones que componen la ruta.
     */
    public LinkedList<Station> getStations() {
        return stations;
    }

    /**
     * Establece la lista de estaciones que componen la ruta.
     * @param stations La lista de estaciones que componen la ruta.
     */
    public void setStations(LinkedList<Station> stations) {
        this.stations = stations;
    }

    /**
     * Obtiene la hora estimada de llegada de la ruta.
     * @return La hora estimada de llegada de la ruta.
     */
    public Date getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    /**
     * Establece la hora estimada de llegada de la ruta.
     * @param estimatedArrivalTime La hora estimada de llegada de la ruta.
     */
    public void setEstimatedArrivalTime(Date estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
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
     * Obtiene la estación de partida de la ruta.
     * @return La estación de partida de la ruta.
     */
    public Station getStartPoint() {
        return startPoint;
    }

    /**
     * Establece la estación de partida de la ruta.
     * @param startPoint La estación de partida de la ruta.
     */
    public void setStartPoint(Station startPoint) {
        this.startPoint = startPoint;
    }

    /**
     * Obtiene la hora de salida de la ruta.
     * @return La hora de salida de la ruta.
     */
    public Date getDepartureTime() {
        return departureTime;
    }

    /**
     * Establece la hora de salida de la ruta.
     * @param departureTime La hora de salida de la ruta.
     */
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Obtiene la hora de llegada de la ruta.
     * @return La hora de llegada de la ruta.
     */
    public Date getArrivalTime() {
        return estimatedArrivalTime;
    }

    /**
     * Establece la hora de llegada de la ruta.
     * @param arrivalTime La hora de llegada de la ruta.
     */
    public void ArrivalTime(Date arrivalTime) {
        this.estimatedArrivalTime = arrivalTime;
    }

    /**
     * Obtiene la distancia total a recorrer en la ruta.
     * @return La distancia total a recorrer en la ruta.
     */
    public float getTotalKmToTravel() {
        return totalKmToTravel;
    }

    /**
     * Establece la distancia total a recorrer en la ruta.
     * @param kmToTravel La distancia total a recorrer en la ruta.
     */
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

        System.out.println("Subrutas:");
        for (int i = 0; i < subRoutes.getSize(); i++) {
            SubRoute subRoute = subRoutes.get(i);
            System.out.println("Subruta " + (i + 1) + ":");
            System.out.println("  Estación de Partida: " + subRoute.getStartPoint().getStationName());
            System.out.println("  Estación de Destino: " + subRoute.getDestinationPoint().getStationName());
            System.out.println("  Hora de Salida: " + subRoute.getDepartureTime());
            System.out.println("  Hora Estimada de Llegada: " + subRoute.getEstimatedArrivalTime());
        }
    }
}