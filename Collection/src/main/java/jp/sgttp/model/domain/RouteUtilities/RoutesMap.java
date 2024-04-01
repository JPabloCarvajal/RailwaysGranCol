package jp.sgttp.model.domain.RouteUtilities;

import jp.array.Array;
import jp.graphs.*;
import jp.queue.array.QueueArray;

public class RoutesMap {

    Graph<Station> stationsGraph = new Graph<>();

    Station stationA = new Station("Estacion A", "Ciudad A");
    Station stationB = new Station("Estacion B", "Ciudad B");
    Station stationC = new Station("Estacion C", "Ciudad C");
    Station stationD = new Station("Estacion D", "Ciudad D");
    Station stationE = new Station("Estacion E", "Ciudad E");
    Station stationF = new Station("Estacion F", "Ciudad F");
    Station stationG = new Station("Estacion G", "Ciudad G");
    Station stationH = new Station("Estacion H", "Ciudad H");
    Station stationI = new Station("Estacion I", "Ciudad I");
    Station stationJ = new Station("Estacion J", "Ciudad J");
    Station stationK = new Station("Estacion K", "Ciudad K");

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

    public float lowestDistanceBeetweenStationsKM(Station A, Station B){
        return stationsGraph.shortestPath(stationsGraph, A, B);
    }

    public QueueArray<Station> stationsToTravel(Station A,Station B){
        Array<GraphNode<Station>> shortestPathNodes = stationsGraph.shortestPathNodes(stationsGraph, A, B);
        QueueArray<Station> stations = new QueueArray<>(shortestPathNodes.size());
        for (int i = 0; i < shortestPathNodes.size(); i++) {
            stations.insert(shortestPathNodes.get(i).data);
        }
        return stations;
    }
    
}
