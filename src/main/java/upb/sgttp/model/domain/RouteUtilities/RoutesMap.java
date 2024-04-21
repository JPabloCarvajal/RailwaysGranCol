package upb.sgttp.model.domain.RouteUtilities;

import java.io.Serializable;
import java.util.Date;

import jp.array.Array;
import jp.graphs.Graph;

import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.TicketUtilites.CustomerCategory;

/**
 * La clase RoutesMap representa un mapa de rutas que conecta diferentes estaciones.
 * Contiene información sobre las conexiones entre estaciones, la distancia entre ellas,
 * métodos para calcular la distancia más corta entre estaciones, construir rutas personalizadas,
 * calcular el tiempo y precio de viaje, entre otros.
 */

public class RoutesMap implements Serializable{

    Graph<Station> stationsGraph = new Graph<>();

    /**
     * Estaciones del mapa.
     */
    private Station stationA = new Station("Estacion A", "Ciudad A");
    private Station stationB = new Station("Estacion B", "Ciudad B");
    private Station stationC = new Station("Estacion C", "Ciudad C");
    private Station stationD = new Station("Estacion D", "Ciudad D");
    private Station stationE = new Station("Estacion E", "Ciudad E");
    private Station stationF = new Station("Estacion F", "Ciudad F");
    private Station stationG = new Station("Estacion G", "Ciudad G");
    private Station stationH = new Station("Estacion H", "Ciudad H");
    private Station stationI = new Station("Estacion I", "Ciudad I");
    private Station stationJ = new Station("Estacion J", "Ciudad J");
    private Station stationK = new Station("Estacion K", "Ciudad K");

    /**
     * Constructor de la clase que inicializa el mapa de rutas y las estaciones.
     */
    public RoutesMap() {
        // Inicialización de las estaciones
        stationsGraph.newNode(stationA);
        stationsGraph.newNode(stationB);
        stationsGraph.newNode(stationC);
        stationsGraph.newNode(stationD);
        stationsGraph.newNode(stationE);
        stationsGraph.newNode(stationF);
        stationsGraph.newNode(stationG);
        stationsGraph.newNode(stationH);
        stationsGraph.newNode(stationI);
        stationsGraph.newNode(stationJ);
        stationsGraph.newNode(stationK);

        // Construcción del grafo de conexiones entre estaciones
        stationsGraph.newEdge(stationA, stationF, 50);
        stationsGraph.newEdge(stationA, stationD, 50);
        stationsGraph.newEdge(stationA, stationC, 40);
        stationsGraph.newEdge(stationA, stationB, 30);

        stationsGraph.newEdge(stationB, stationA, 30);

        stationsGraph.newEdge(stationC, stationA, 40);
        stationsGraph.newEdge(stationC, stationI, 80);
        stationsGraph.newEdge(stationC, stationJ, 120);
        stationsGraph.newEdge(stationC, stationK, 110);

        stationsGraph.newEdge(stationD, stationA, 50);
        stationsGraph.newEdge(stationD, stationE, 20);

        stationsGraph.newEdge(stationE, stationD, 20);
        stationsGraph.newEdge(stationE, stationF, 65);

        stationsGraph.newEdge(stationF, stationA, 50);
        stationsGraph.newEdge(stationF, stationE, 65);
        stationsGraph.newEdge(stationF, stationG, 80);

        stationsGraph.newEdge(stationG, stationF, 80);
        stationsGraph.newEdge(stationG, stationH, 30);
        stationsGraph.newEdge(stationG, stationI, 145);

        stationsGraph.newEdge(stationH, stationG, 30);

        stationsGraph.newEdge(stationI, stationG, 145);
        stationsGraph.newEdge(stationI, stationC, 80);

        stationsGraph.newEdge(stationJ, stationC, 120);

        stationsGraph.newEdge(stationK, stationC, 110);
    }

    /**
     * Obtiene la estación A.
     * @return La estación A.
     */
    public Station getStationA() {
        return stationA;
    }

    /**
     * Establece la estación A.
     * @param stationA La estación A.
     */
    public void setStationA(Station stationA) {
        this.stationA = stationA;
    }

    /**
     * Obtiene la estación B.
     * @return La estación B.
     */
    public Station getStationB() {
        return stationB;
    }

    /**
     * Establece la estación B.
     * @param stationB La estación B.
     */
    public void setStationB(Station stationB) {
        this.stationB = stationB;
    }

    /**
     * Obtiene la estación C.
     * @return La estación C.
     */
    public Station getStationC() {
        return stationC;
    }

    /**
     * Establece la estación C.
     * @param stationC La estación C.
     */   
    public void setStationC(Station stationC) {
        this.stationC = stationC;
    }

    /**
     * Obtiene la estación D.
     * @return La estación D.
     */
    public Station getStationD() {
        return stationD;
    }

    /**
     * Establece la estación D.
     * @param stationD La estación D a establecer.
     */
    public void setStationD(Station stationD) {
        this.stationD = stationD;
    }

    /**
     * Obtiene la estación E.
     * @return La estación E.
     */
    public Station getStationE() {
        return stationE;
    }

    /**
     * Establece la estación E.
     * @param stationE La estación E a establecer.
     */
    public void setStationE(Station stationE) {
        this.stationE = stationE;
    }

    /**
     * Obtiene la estación F.
     * @return La estación F.
     */
    public Station getStationF() {
        return stationF;
    }

    /**
     * Establece la estación F.
     * @param stationF La estación F a establecer.
     */
    public void setStationF(Station stationF) {
        this.stationF = stationF;
    }

    /**
     * Obtiene la estación G.
     * @return La estación G.
     */
    public Station getStationG() {
        return stationG;
    }

    /**
     * Establece la estación G.
     * @param stationG La estación G a establecer.
     */
    public void setStationG(Station stationG) {
        this.stationG = stationG;
    }

    /**
     * Obtiene la estación H.
     * @return La estación H.
     */
    public Station getStationH() {
        return stationH;
    }

    /**
     * Establece la estación H.
     * @param stationH La estación H a establecer.
     */
    public void setStationH(Station stationH) {
        this.stationH = stationH;
    }

    /**
     * Obtiene la estación I.
     * @return La estación I.
     */
    public Station getStationI() {
        return stationI;
    }

    /**
     * Establece la estación I.
     * @param stationI La estación I a establecer.
     */
    public void setStationI(Station stationI) {
        this.stationI = stationI;
    }

    /**
     * Obtiene la estación J.
     * @return La estación J.
     */
    public Station getStationJ() {
        return stationJ;
    }

    /**
     * Establece la estación J.
     * @param stationJ La estación J a establecer.
     */
    public void setStationJ(Station stationJ) {
        this.stationJ = stationJ;
    }

    /**
     * Obtiene la estación K.
     * @return La estación K.
     */
    public Station getStationK() {
        return stationK;
    }

    /**
     * Establece la estación K.
     * @param stationK La estación K a establecer.
     */
    public void setStationK(Station stationK) {
        this.stationK = stationK;
    }

    /**
     * Calcula la distancia más corta en kilómetros entre dos estaciones mediante la implementacion
     * de la estructura de grafos y el algoritmo de Diksjtra.
     * @param A La estación de inicio.
     * @param B La estación de destino.
     * @return La distancia más corta en kilómetros entre las dos estaciones.
     */
    public float lowestDistanceBeetweenStationsKM(Station A, Station B) {
        return stationsGraph.shortestPathKm(stationsGraph, A, B);
    }


    /**
     * Muestra los índices y nombres de las estaciones en el grafo de estaciones.
     */
    public void showsStationsIndex() {
        for (int i = 0; i < 11; i++) {
            System.out.println("Indice " + i + " :" + stationsGraph.getNodeByIndex(i).data.getStationName());
        }
    }

    /**
     * Calcula la lista de estaciones para viajar desde una estación de inicio hasta una estación de destino, por ende
     * se usa el algoritmo de Diksjtra para calcular la mejor ruta que use la menor cantidad de kilometros posible.
     * @param A La estación de inicio.
     * @param B La estación de destino.
     * @return La lista de estaciones para viajar desde la estación de inicio hasta la estación de destino.
     */
    public LinkedList<Station> stationsToTravel(Station A, Station B) {
        Array<Station> shortestPathNodes = stationsGraph.shortestPathNodes(stationsGraph, A, B);
        LinkedList<Station> stations = new LinkedList<>();
        for (int i = 0; i < shortestPathNodes.size(); i++) {
            stations.add(shortestPathNodes.get(i));
        }
        return stations;
    }

    /**
     * Construye una ruta personalizada basada en una lista de estaciones proporcionada.
     * @param stations La lista de estaciones para construir la ruta personalizada.
     * @return La lista de estaciones que conforman la ruta personalizada.
     */
    public LinkedList<Station> buildCustomRoute(LinkedList<Station> stations) {
        if (stations == null || stations.size() < 2) {
            System.out.println("La lista de estaciones proporcionada no es válida.");
            return null;
        }
        LinkedList<Station> stationsCopy = new LinkedList<>();
        stationsCopy.add(stations);

        LinkedList<Station> customRouteStations = new LinkedList<>();

        Station lastStation = stationsCopy.peekLast();

        Station currentStation = stationsCopy.poll();
        while (!stationsCopy.isEmpty()) {
            Station nextStation = stationsCopy.peek();

            LinkedList<Station> shortestPath = stationsToTravel(currentStation, nextStation);

            while (!shortestPath.isEmpty()) {
                Station stationToAdd = shortestPath.poll();

                if (!nextStation.equals(stationToAdd)) {
                    customRouteStations.add(stationToAdd);
                }
            }

            currentStation = stationsCopy.poll();
        }
        customRouteStations.add(lastStation);
        return customRouteStations;
    }

    /**
     * Calcula la distancia total recorrida en una lista de estaciones.
     * @param stations La lista de estaciones.
     * @return La distancia total recorrida en la lista de estaciones, en kilómetros.
     */
    public float calculateTotalDistance(LinkedList<Station> stations) {
        float totalDistance = 0;

        LinkedList<Station> stationsCopy = new LinkedList<>();
        stationsCopy.add(stations);

        Station currentStation = stationsCopy.poll();
        while (!stationsCopy.isEmpty()) {
            Station nextStation = stationsCopy.peek();

            float distance = lowestDistanceBeetweenStationsKM(currentStation, nextStation);

            totalDistance += distance;

            currentStation = stationsCopy.poll();
        }

        return totalDistance;
    }
    /**
     * Calcula el tiempo total de viaje en una lista de estaciones, incluyendo tiempos de parada.
     * @param stations La lista de estaciones.
     * @return El tiempo total de viaje en horas.
     */
    public float calculateTotalTime(LinkedList<Station> stations) {

        float totalDistance = calculateTotalDistance(stations);

        float travelTime = totalDistance / 250; // 250 km/h

        int numStations = stations.size();
        float stopTimePerStation = 20.0f / 60; // Convertir 20 minutos a horas
        float totalStopTime = stopTimePerStation * numStations;
        float totalTime = travelTime + totalStopTime;

        return totalTime;

    }


    /**
     * Calcula el precio total del viaje dado el número de kilómetros y la categoría del cliente.
     * @param kms El número de kilómetros del viaje.
     * @param category La categoría del cliente.
     * @return El precio total del viaje.
     */
    public float calculateTotalPrice(float kms, CustomerCategory category) {
        float pricePerKm;
        switch (category) {
            case PREMIUN:
                pricePerKm = 1800.0f; // Tarifa para clientes premium: 1800 USD por km
                break;
            case EXECUTIVE:
                pricePerKm = 1200.0f; // Tarifa para clientes ejecutivos: 1200 USD por km
                break;
            case STANDAR:
            default:
                pricePerKm = 100.0f; // Tarifa por defecto para clientes estándar: 100 USD por km
                break;
        }
        return kms * pricePerKm;
    }
    /**
     * Calcula la hora estimada de llegada basada en la hora de salida y la lista de estaciones.
     * @param departureTime La hora de salida.
     * @param stations La lista de estaciones.
     * @return La hora estimada de llegada.
     */
    public Date calculateEstimatedArrivalTime(Date departureTime, LinkedList<Station> stations) {
        float totalTime = calculateTotalTime(stations);
        long totalMillis = (long) (totalTime * 3600000); // Convertir horas a milisegundos
        return new Date(departureTime.getTime() + totalMillis);
    }

    /**
     * Obtiene una estación por su nombre.
     * @param nombre El nombre de la estación a buscar.
     * @return La estación correspondiente al nombre especificado, o null si no se encuentra ninguna estación con ese nombre.
     */
    public Station getStation(String nombre) {
        LinkedList<Station> stationList = getStationList();
        for (int i = 0; i < stationList.size(); i++) {
            if (nombre.equals(stationList.get(i).getStationName())) {
                return stationList.get(i);
            }
        }
        return null;
    }

    /**
     * Obtiene una lista de todas las estaciones disponibles en el mapa de rutas.
     * @return Una lista de estaciones.
     */
    public LinkedList<Station> getStationList() {
        LinkedList<Station> stationList = new LinkedList<>();
        stationList.add(stationA);
        stationList.add(stationB);
        stationList.add(stationC);
        stationList.add(stationD);
        stationList.add(stationE);
        stationList.add(stationF);
        stationList.add(stationG);
        stationList.add(stationH);
        stationList.add(stationK);
        stationList.add(stationI);
        stationList.add(stationJ);
        return stationList;
    }

    // public static void main(String[] args) {


    //     RoutesMap routesMap = new RoutesMap();

    //     Station origin = routesMap.getStationI();
    //     Station destination = routesMap.getStationH();

    //     float shortestDistance = routesMap.lowestDistanceBeetweenStationsKM(origin, destination);
    //     System.out.println("La distancia más corta entre " + origin.getStationName() + " y "
    //             + destination.getStationName() + " es: " + shortestDistance + " km");

    //     LinkedList<Station> shortestPathStations = routesMap.stationsToTravel(origin, destination);

    //     int i = 1;
    //     while (!shortestPathStations.isEmpty()) {
    //         System.out.println("Estacion " + i);
    //         System.out.println(shortestPathStations.poll().getStationName() + "\n");
    //         i++;
    //     }

    //     // Prueba de la ruta personalizada
    //     Station intermediateStationI = routesMap.getStationB();
    //     Station intermediateStationJ = routesMap.getStationD();
    //     Station intermediateStationA = routesMap.getStationF();
    //     Station intermediateStationG = routesMap.getStationG();
    //     Station intermediateStationH = routesMap.getStationH();

    //     // Crear una lista de estaciones proporcionadas por el cliente
    //     LinkedList<Station> customStationsList = new LinkedList<>();
    //     customStationsList.add(intermediateStationI);
    //     customStationsList.add(intermediateStationJ);
    //     customStationsList.add(intermediateStationA);
    //     // customStationsList.add(intermediateStationG);
    //     // customStationsList.add(intermediateStationH);

    //     // Construir la ruta personalizada
    //     LinkedList<Station> customRouteStations = routesMap.buildCustomRoute(customStationsList);

    //     System.out.println("Tiempo que se demoraria la ruta: " + routesMap.calculateTotalTime(customRouteStations));

    //     // Imprimir las estaciones en la ruta personalizada
    //     System.out.println("Ruta Personalizada:");
    //     int j = 1;
    //     while (!customRouteStations.isEmpty()) {
    //         System.out.println("Estación " + j + ": " + customRouteStations.poll().getStationName());
    //         j++;
    //     }

    //     // Calcular los kilómetros totales recorridos
    //     float totalDistance = routesMap.calculateTotalDistance(customStationsList);
    //     System.out.println("Kilómetros totales recorridos en la ruta personalizada: " + totalDistance + " km");

    //     routesMap.showsStationsIndex();
    // }

    
}
