package jp.sgttp.model.domain.RouteUtilities;

import jp.array.Array;
import jp.graphs.*;
import jp.linkedlist.singly.LinkedList;
import jp.queue.array.QueueArray;
import jp.queue.list.QueueList;

public class RoutesMap {

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

    public float lowestDistanceBeetweenStationsKM(Station A, Station B){
        return stationsGraph.shortestPathKm(stationsGraph, A, B);
    }

    public QueueArray<Station> stationsToTravel(Station A,Station B){
        Array<GraphNode<Station>> shortestPathNodes = stationsGraph.shortestPathNodes(stationsGraph, A, B);
        QueueArray<Station> stations = new QueueArray<>(shortestPathNodes.size());
        for (int i = 0; i < shortestPathNodes.size(); i++) {
            stations.insert(shortestPathNodes.get(i).data);
        }
        stations.reverse();
        return stations;
    }

    public QueueList<Station> buildCustomRoute(LinkedList<Station> stations) {
        if (stations == null || stations.size() < 2) {
            // Verificar si la lista de estaciones es válida
            System.out.println("La lista de estaciones proporcionada no es válida.");
            return null;
        }
    
        LinkedList<Station> stationsCopy = new LinkedList<>();
        stationsCopy.add(stations);
    
        QueueList<Station> customRouteStations = new QueueList<>();
    
        // Guardar la estacion final para agregar al final
        Station lastStation = stationsCopy.peekLast();
    
        // Iterar sobre las estaciones proporcionadas por el cliente en la copia de la lista
        Station currentStation = stationsCopy.poll();
        while (!stationsCopy.isEmpty()) {
            Station nextStation = stationsCopy.peek(); // Miramos la siguiente estación sin quitarla de la lista
    
            // Obtener la ruta más corta desde la estación actual hasta la próxima estación
            QueueArray<Station> shortestPath = stationsToTravel(currentStation, nextStation);
    
            // Agregar las estaciones de la ruta más corta a la ruta personalizada
            while (!shortestPath.isEmpty()) {
                Station stationToAdd = shortestPath.extract();
                // Agregar la estación solo si la siguiente estación no es la misma que la actual
                if (!nextStation.equals(stationToAdd)) {
                    customRouteStations.insert(stationToAdd);
                }
            }
    
            // Actualizar la estación actual
            currentStation = stationsCopy.poll();
        }
        customRouteStations.insert(lastStation);
        return customRouteStations;
    }
    
    public float calculateTotalDistance(LinkedList<Station> stations) {
        float totalDistance = 0;

        LinkedList<Station> stationsCopy = new LinkedList<>();
        stationsCopy.add(stations);
    
        // Iterar sobre las estaciones proporcionadas por el cliente en la copia de la lista
        Station currentStation = stationsCopy.poll();
        while (!stationsCopy.isEmpty()) {
            Station nextStation = stationsCopy.peek(); // Miramos la siguiente estación sin quitarla de la lista
    
            // Obtener la distancia entre la estación actual y la próxima estación
            float distance = lowestDistanceBeetweenStationsKM(currentStation, nextStation);
    
            // Sumar la distancia al total
            totalDistance += distance;
    
            // Actualizar la estación actual
            currentStation = stationsCopy.poll();
        }
    
        return totalDistance;
    }
    
    
    
    // Prueba con este main xd
    public static void main(String[] args) {

        RoutesMap routesMap = new RoutesMap();

        Station origin = routesMap.getStationC();
        Station destination = routesMap.getStationG();

        // Calcular la distancia más corta entre dos estaciones
        float shortestDistance = routesMap.lowestDistanceBeetweenStationsKM(origin, destination);
        System.out.println("La distancia más corta entre " + origin.getStationName() + " y " +
                destination.getStationName() + " es: " + shortestDistance + " km");
        
        // Obtener la cola de estaciones en el camino más corto
        QueueArray<Station> shortestPathStations = routesMap.stationsToTravel(origin, destination);
        
        // Imprimir las estaciones en el camino más corto
        int i = 1;
        while (!shortestPathStations.isEmpty()) {
            System.out.println("Estacion "+ i);
            System.out.println(shortestPathStations.extract().getStationName()+"\n");
            i++;
        }
        
        // Prueba de la ruta personalizada
        Station intermediateStationI = routesMap.getStationI();
        Station intermediateStationJ = routesMap.getStationJ();
        Station intermediateStationA = routesMap.getStationA();
        Station intermediateStationG = routesMap.getStationG();
        Station intermediateStationH = routesMap.getStationH();

        // Crear una lista de estaciones proporcionadas por el cliente
        LinkedList<Station> customStationsList = new LinkedList<>();
        customStationsList.add(intermediateStationI);
        customStationsList.add(intermediateStationJ);
        customStationsList.add(intermediateStationA);
        customStationsList.add(intermediateStationG);
        customStationsList.add(intermediateStationH);

        // Construir la ruta personalizada
        QueueList<Station> customRouteStations = routesMap.buildCustomRoute(customStationsList);

        // Imprimir las estaciones en la ruta personalizada
        System.out.println("Ruta Personalizada:");
        int j = 1;
        while (!customRouteStations.isEmpty()) {
            System.out.println("Estación " + j + ": " + customRouteStations.extract().getStationName());
            j++;
        }

        // Calcular los kilómetros totales recorridos
        float totalDistance = routesMap.calculateTotalDistance(customStationsList);
        System.out.println("Kilómetros totales recorridos en la ruta personalizada: " + totalDistance + " km");
        
    }
}


