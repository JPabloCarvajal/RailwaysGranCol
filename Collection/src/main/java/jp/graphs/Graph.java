package jp.graphs;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;

public class Graph<E> {
    
    public GraphNode<E> first;
    public GraphNode<E> last;

    //Revisar metodos
    public Graph() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean contains(E element) {
        boolean contains = false;
        if (!isEmpty()) {
            GraphNode<E> temporal = first;
            while (temporal != null && !contains) {
                if (temporal.data.toString().equals(element.toString())) {
                    contains = true;
                }
                temporal = temporal.next;
            }
        }
        return contains;
    }

    public void newEdge(E from, E to) {
        GraphNode<E> position = getNodeByData(from);
        if (position != null && contains(to)) {
            position.list.newAdjacency(to);
        } else {
            System.out.println("El nodo de origen o destino no existe en el grafo.");
        }
    }
    
    public void newEdge(E from, E to, float weight) {
        GraphNode<E> position = getNodeByData(from);
        if (position != null && contains(to)) {
            position.list.newAdjacency(to, weight);
        } else {
            System.out.println("El nodo de origen o destino no existe en el grafo.");
        }
    }

    public void newNode(E element) {
        if (!contains(element)) {
            GraphNode<E> node = new GraphNode<>(element);
            if (isEmpty()) {
                first = node; 
                last = node;
            } else {
                if (element.toString().compareTo(first.data.toString()) <= 0) {
                    node.next = first;
                    first = node;    
                } else {
                    GraphNode<E> temporal = first;
                    while (temporal.next != null && element.toString().compareTo(temporal.next.data.toString()) > 0) {
                        temporal = temporal.next;
                    }
                    node.next = temporal.next;
                    temporal.next = node;
                }
            }
        }
    }

    public int getSize() {
        int size = 0;
        GraphNode<E> current = first;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
    
    public int getNodeIndex(E nodeData) {
        int index = 0;
        GraphNode<E> current = first;
        while (current != null) {
            if (current.data.equals(nodeData)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public int getNodeIndex(GraphNode<E> node) {
        int index = 0;
        GraphNode<E> current = first;
        while (current != null) {
            if (current == node) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }
    
    // Método para obtener un nodo por su índice
    public GraphNode<E> getNodeByIndex(int index) {
        GraphNode<E> current = first;
        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == index) {
                return current;
            }
            current = current.next;
            currentIndex++;
        }
        return null;
    }

    public GraphNode<E> getNodeByData(E data) {
        GraphNode<E> current = first;
        while (current != null) {
            if (current.data.equals(data)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


    public float shortestPathKm(Graph<E> graph, E startNode, E endNode) {
        // Obtener el nodo de inicio
        GraphNode<E> start = getNodeByData(startNode);
        if (start == null) {
            System.out.println("El nodo de inicio no existe en el grafo.");
            return -1;
        }
    
        // Obtener el nodo de destino
        GraphNode<E> end = getNodeByData(endNode);
        if (end == null) {
            System.out.println("El nodo de destino no existe en el grafo.");
            return -1;
        }
    
        // Inicializar las distancias desde el nodo de inicio a todos los demás nodos como infinito
        Array<Float> distances = new Array<>(graph.getSize());
        for (int i = 0; i < graph.getSize(); i++) {
            distances.add(Float.POSITIVE_INFINITY);
        }
    
        // La distancia desde el nodo de inicio a sí mismo es 0
        distances.set(graph.getNodeIndex(startNode), 0f);
    
        // Array para marcar los nodos visitados
        Array<Boolean> visited = new Array<>(graph.getSize());
        for (int i = 0; i < graph.getSize(); i++) {
            visited.add(false);
        }
        
        
        // Iterar sobre todos los nodos
        for (int i = 0; i < graph.getSize(); i++) {
            // Encontrar el nodo no visitado más cercano
            int minIndex = minDistance(distances, visited);
            visited.set(minIndex, true);
    
            // Actualizar las distancias a los nodos adyacentes
            GraphNode<E> currentNode = getNodeByIndex(minIndex);
            for (Edge<E> edge = currentNode.list.first; edge != null; edge = edge.next) {
                int adjIndex = graph.getNodeIndex(edge.destination);
                float newDistance = distances.get(minIndex) + edge.weight;
                if (!visited.get(adjIndex) && newDistance < distances.get(adjIndex)) {
                    distances.set(adjIndex, newDistance);
                }
            }
        }
    
        // La distancia más corta desde el nodo de inicio al nodo de destino
        return distances.get(graph.getNodeIndex(endNode));
    }
    
    
    private int minDistance(Array<Float> distances, Array<Boolean> visited) {
        float min = Float.POSITIVE_INFINITY;
        int minIndex = -1;
    
        // Asegurarse de que los arrays distances y visited tengan el mismo tamaño
        if (distances.size() != visited.size()) {
            throw new IllegalArgumentException("Los arrays distances y visited deben tener el mismo tamaño.");
        }
    
        for (int v = 0; v < distances.size(); v++) {
            // Verificar si el nodo no ha sido visitado y si su distancia es menor que el mínimo actual
            if (!visited.get(v) && distances.get(v) <= min) {
                min = distances.get(v);
                minIndex = v;
            }
        }
        return minIndex;
    }

    public Array<E> shortestPathNodes(Graph<E> graph, E startNode, E endNode) {
        // Obtener el nodo de inicio
        GraphNode<E> start = getNodeByData(startNode);
        if (start == null) {
            System.out.println("El nodo de inicio no existe en el grafo.");
            return null;
        }

        // Obtener el nodo de destino
        GraphNode<E> end = getNodeByData(endNode);
        if (end == null) {
            System.out.println("El nodo de destino no existe en el grafo.");
            return null;
        }

        // Inicializar las distancias desde el nodo de inicio a todos los demás nodos como infinito
        Array<Float> distances = new Array<>(graph.getSize());

        for (int i = 0; i < graph.getSize(); i++) {
            distances.add(Float.POSITIVE_INFINITY);
        }

        // La distancia desde el nodo de inicio a sí mismo es 0
        distances.set(graph.getNodeIndex(startNode), 0f);

        // Array para marcar los nodos visitados
        Array<Boolean> visited = new Array<>(graph.getSize());
        for (int i = 0; i < graph.getSize(); i++) {
            visited.add(false);
        }

        // Array para almacenar los nodos previos en el camino más corto
        Array<GraphNode<E>> previous = new Array<>(graph.getSize());
        for (int i = 0; i < graph.getSize(); i++) {
            previous.add(null);
        }

        // Iterar sobre todos los nodos
        //0,1
        for (int i = 0; i < graph.getSize(); i++) {

            // Encontrar el nodo no visitado más cercano
            int minIndex = minDistance(distances, visited);
            // 7
            visited.set(minIndex, true);

            // Actualizar las distancias a los nodos adyacentes
            GraphNode<E> currentNode = getNodeByIndex(minIndex);
            //B

            for (Edge<E> edge = currentNode.list.first; edge != null; edge = edge.next) {

                //TRAE INDICE DE A
                int adjIndex = graph.getNodeIndex(edge.destination);

                float newDistance = distances.get(minIndex) + edge.weight;
                //REVISA QUE EL NODO EN EL QUE ESTA NO HAYA SIDO VISITADO Y 
                if (!visited.get(adjIndex) && newDistance < distances.get(adjIndex)) {

                    distances.set(adjIndex, newDistance);
                    previous.set(adjIndex, currentNode);

                }
            }
        }

        // Reconstruir el camino más corto a partir de los nodos previos
        LinkedList<E> path = new LinkedList<>();
        GraphNode<E> current = end;
        while (current != null) {
            path.add(current.data);
            current = previous.get(graph.getNodeIndex(current.data));
        }
        path.reverse(); // Invertir la lista para que esté en el orden correcto
        Array<E> pathArray = new Array<>(path.toArray());
        return pathArray;
    }

    public static void printGraph(Graph<String> graph) {
        GraphNode<String> node = graph.first;
        while (node != null) {
            System.out.print("Nodo " + node.data + " tiene los siguientes vértices: ");
            Edge<String> edge = node.list.first;
            while (edge != null) {
                System.out.print("(" + edge.destination + ", peso: " + edge.weight + ") ");
                edge = edge.next;
            }
            System.out.println();
            node = node.next;
        }
    }
    public static void main(String[] args) {
        // Crear el grafo
        Graph<String> graph = new Graph<>();

        // Agregar nodos
        graph.newNode("A");
        graph.newNode("B");
        graph.newNode("C");
        graph.newNode("D");
        graph.newNode("E");
        graph.newNode("F");
        graph.newNode("G");
        graph.newNode("H");
        graph.newNode("I");
        graph.newNode("J");
        graph.newNode("K");

        // Agregar vértices
        graph.newEdge("A", "F", 50);
        graph.newEdge("A", "D", 50);
        graph.newEdge("A", "C", 40);
        graph.newEdge("A", "B", 30);
        
        graph.newEdge("B", "A", 30);

        graph.newEdge("C", "A", 40);
        graph.newEdge("C", "I", 80);
        graph.newEdge("C", "J", 120);
        graph.newEdge("C", "K", 110);

        graph.newEdge("D", "A", 50);
        graph.newEdge("D", "E", 20);

        graph.newEdge("E", "D", 20);
        graph.newEdge("E", "F", 65);

        graph.newEdge("F", "A", 50);
        graph.newEdge("F", "E", 65);
        graph.newEdge("F", "G", 80);

        graph.newEdge("G", "F", 80);
        graph.newEdge("G", "H", 30);
        graph.newEdge("G", "I", 145);

        graph.newEdge("H", "G", 30);
         
        graph.newEdge("I", "G", 145);
        graph.newEdge("I", "C", 80);

        graph.newEdge("J", "C", 120);

        graph.newEdge("K", "C", 110);

        // Verificar la estructura del grafo
        //printGraph(graph);

        // Calcular el camino más corto entre dos estaciones
        String startNode = "B";
        String endNode = "K";

         // Encontrar el camino más corto
         //float shortestDistance = graph.shortestPath(graph, startNode, endNode);
        // System.out.println("La distancia más corta entre " + startNode + " y " + endNode + " es: " + shortestDistance);

        // Obtener nodos de inicio y fin del grafo
        GraphNode<String> start = graph.getNodeByData(startNode);
        GraphNode<String> end = graph.getNodeByData(endNode);

        // Calcular el camino más corto
        Array<String> shortestPathNodes = graph.shortestPathNodes(graph, start.data, end.data);

        // Imprimir los nodos en el camino más corto
        System.out.println("Nodos en el camino más corto:");
        for (int i = 0; i < shortestPathNodes.size(); i++) {
            System.out.println(shortestPathNodes.get(i));
        }
    }
}
