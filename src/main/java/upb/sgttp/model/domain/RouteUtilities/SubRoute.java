package upb.sgttp.model.domain.RouteUtilities;

import java.io.Serializable;
import java.util.Date;

import upb.sgttp.model.domain.trainUtilities.Train;

/**
 * Representa una subruta dentro de una ruta principal en el sistema de gestión de rutas.
 */

public class SubRoute implements Serializable{

    private String asociatedIdRoute; // El ID de la ruta asociada

    private Station startPoint; // El punto de inicio de la subruta
    private Station destinationPoint; // El punto de destino de la subruta

    private Date departureTime; // La hora de salida de la subruta
    private Date estimatedArrivalTime; // La hora estimada de llegada de la subruta

    private Train trainToDoRoute; // El tren asignado para realizar la subruta

    /**
     * Constructor de la clase SubRoute.
     * @param startPoint El punto de inicio de la subruta.
     * @param destinationPoint El punto de destino de la subruta.
     * @param departureTime La hora de salida de la subruta.
     * @param estimatedArrivalTime La hora estimada de llegada de la subruta.
     * @param trainToDoRoute El tren asignado para realizar la subruta.
     * @param asociatedIdRoute El ID de la ruta asociada.
     */
    public SubRoute(Station startPoint, Station destinationPoint, Date departureTime, Date estimatedArrivalTime,
            Train trainToDoRoute, String asociatedIdRoute) {
        this.startPoint = startPoint;
        this.destinationPoint = destinationPoint;
        this.departureTime = departureTime;
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.trainToDoRoute = trainToDoRoute;
        this.asociatedIdRoute = asociatedIdRoute;
    }


    public String getAsociatedIdRoute() {
        return asociatedIdRoute;
    }

    public void setAsociatedIdRoute(String asociatedIdRoute) {
        this.asociatedIdRoute = asociatedIdRoute;
    }

     /**
     * Obtiene el punto de inicio de la subruta.
     * @return El punto de inicio de la subruta.
     */
    public Station getStartPoint() {
        return startPoint;
    }
    /**
     * Establece el punto de inicio de la subruta.
     * @param startPoint El punto de inicio de la subruta.
     */
    public void setStartPoint(Station startPoint) {
        this.startPoint = startPoint;
    }
    /**
     * Obtiene el punto de destino de la subruta.
     * @return El punto de destino de la subruta.
     */
    public Station getDestinationPoint() {
        return destinationPoint;
    }

    /**
     * Establece el punto de destino de la subruta.
     * @param destinationPoint El punto de destino de la subruta.
     */
    public void setDestinationPoint(Station destinationPoint) {
        this.destinationPoint = destinationPoint;
    }
    
    /**
     * Obtiene la hora de salida de la subruta.
     * @return La hora de salida de la subruta.
     */
    public Date getDepartureTime() {
        return departureTime;
    }

    /**
     * Establece la hora de salida de la subruta.
     * @param departureTime La hora de salida de la subruta.
     */
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Obtiene la hora estimada de llegada de la subruta.
     * @return La hora estimada de llegada de la subruta.
     */
    public Date getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    /**
     * Establece la hora estimada de llegada de la subruta.
     * @param estimatedArrivalTime La hora estimada de llegada de la subruta.
     */
    public void setEstimatedArrivalTime(Date estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    /**
     * Obtiene el tren asignado para realizar la subruta.
     * @return El tren asignado para realizar la subruta.
     */
    public Train getTrainToDoRoute() {
        return trainToDoRoute;
    }

    /**
     * Establece el tren asignado para realizar la subruta.
     * @param trainToDoRoute El tren asignado para realizar la subruta.
     */
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
