package upb.sgttp.model.domain.RouteUtilities;

import java.io.Serializable;
import java.util.Date;

import jp.array.Array;
import jp.graphs.Graph;

import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.TicketUtilites.CustomerCategory;

public class RoutesMap implements Serializable{

    Graph<Station> stationsGraph = new Graph<>();

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

    public RoutesMap() {
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

        // Conexiones 
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

    public Station getStationA() {
        return stationA;
    }

    public void setStationA(Station stationA) {
        this.stationA = stationA;
    }

    public Station getStationB() {
        return stationB;
    }

    public void setStationB(Station stationB) {
        this.stationB = stationB;
    }

    public Station getStationC() {
        return stationC;
    }

    public void setStationC(Station stationC) {
        this.stationC = stationC;
    }

    public Station getStationD() {
        return stationD;
    }

    public void setStationD(Station stationD) {
        this.stationD = stationD;
    }

    public Station getStationE() {
        return stationE;
    }

    public void setStationE(Station stationE) {
        this.stationE = stationE;
    }

    public Station getStationF() {
        return stationF;
    }

    public void setStationF(Station stationF) {
        this.stationF = stationF;
    }

    public Station getStationG() {
        return stationG;
    }

    public void setStationG(Station stationG) {
        this.stationG = stationG;
    }

    public Station getStationH() {
        return stationH;
    }

    public void setStationH(Station stationH) {
        this.stationH = stationH;
    }

    public Station getStationI() {
        return stationI;
    }

    public void setStationI(Station stationI) {
        this.stationI = stationI;
    }

    public Station getStationJ() {
        return stationJ;
    }

    public void setStationJ(Station stationJ) {
        this.stationJ = stationJ;
    }

    public Station getStationK() {
        return stationK;
    }

    public void setStationK(Station stationK) {
        this.stationK = stationK;
    }

    public float lowestDistanceBeetweenStationsKM(Station A, Station B) {
        return stationsGraph.shortestPathKm(stationsGraph, A, B);
    }

    public void showsStationsIndex() {
        for (int i = 0; i < 11; i++) {
            System.out.println("Indice " + i + " :" + stationsGraph.getNodeByIndex(i).data.getStationName());
        }
    }

    public LinkedList<Station> stationsToTravel(Station A, Station B) {
        Array<Station> shortestPathNodes = stationsGraph.shortestPathNodes(stationsGraph, A, B);
        LinkedList<Station> stations = new LinkedList<>();
        for (int i = 0; i < shortestPathNodes.size(); i++) {
            stations.add(shortestPathNodes.get(i));
        }
        return stations;
    }

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

    public float calculateTotalTime(LinkedList<Station> stations) {

        float totalDistance = calculateTotalDistance(stations);

        float travelTime = totalDistance / 250; // 250 km/h

        int numStations = stations.size();
        float stopTimePerStation = 20.0f / 60; // Convertir 20 minutos a horas
        float totalStopTime = stopTimePerStation * numStations;
        float totalTime = travelTime + totalStopTime;

        return totalTime;

    }

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

    public Date calculateEstimatedArrivalTime(Date departureTime, LinkedList<Station> stations) {
        float totalTime = calculateTotalTime(stations);
        long totalMillis = (long) (totalTime * 3600000); // Convertir horas a milisegundos
        return new Date(departureTime.getTime() + totalMillis);
    }

    // Prueba con este main xd
    public static void main(String[] args) {


        RoutesMap routesMap = new RoutesMap();

        Station origin = routesMap.getStationI();
        Station destination = routesMap.getStationH();

        float shortestDistance = routesMap.lowestDistanceBeetweenStationsKM(origin, destination);
        System.out.println("La distancia más corta entre " + origin.getStationName() + " y "
                + destination.getStationName() + " es: " + shortestDistance + " km");

        LinkedList<Station> shortestPathStations = routesMap.stationsToTravel(origin, destination);

        int i = 1;
        while (!shortestPathStations.isEmpty()) {
            System.out.println("Estacion " + i);
            System.out.println(shortestPathStations.poll().getStationName() + "\n");
            i++;
        }

        // Prueba de la ruta personalizada
        Station intermediateStationI = routesMap.getStationB();
        Station intermediateStationJ = routesMap.getStationD();
        Station intermediateStationA = routesMap.getStationF();
        Station intermediateStationG = routesMap.getStationG();
        Station intermediateStationH = routesMap.getStationH();

        // Crear una lista de estaciones proporcionadas por el cliente
        LinkedList<Station> customStationsList = new LinkedList<>();
        customStationsList.add(intermediateStationI);
        customStationsList.add(intermediateStationJ);
        customStationsList.add(intermediateStationA);
        // customStationsList.add(intermediateStationG);
        // customStationsList.add(intermediateStationH);

        // Construir la ruta personalizada
        LinkedList<Station> customRouteStations = routesMap.buildCustomRoute(customStationsList);

        System.out.println("Tiempo que se demoraria la ruta: " + routesMap.calculateTotalTime(customRouteStations));

        // Imprimir las estaciones en la ruta personalizada
        System.out.println("Ruta Personalizada:");
        int j = 1;
        while (!customRouteStations.isEmpty()) {
            System.out.println("Estación " + j + ": " + customRouteStations.poll().getStationName());
            j++;
        }

        // Calcular los kilómetros totales recorridos
        float totalDistance = routesMap.calculateTotalDistance(customStationsList);
        System.out.println("Kilómetros totales recorridos en la ruta personalizada: " + totalDistance + " km");

        routesMap.showsStationsIndex();
    }

    public Station getStation(String nombre) {
        LinkedList<Station> station = getStationList();
        for (int i = 0; i < station.size(); i++) {
            if (nombre.equals(station.get(i).getStationName())) {
                return station.get(i);
            }
        }
        return null;
    }

    public LinkedList<Station> getStationList() {
        LinkedList<Station> station = new LinkedList<>();
        station.add(stationA);
        station.add(stationB);
        station.add(stationC);
        station.add(stationD);
        station.add(stationE);
        station.add(stationF);
        station.add(stationG);
        station.add(stationH);
        station.add(stationK);
        station.add(stationI);
        station.add(stationJ);
        return station;
    }
}
