package jp.graphs;

import jp.array.Array;

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

    // Método para encontrar el camino más corto entre dos nodos utilizando el algoritmo de Dijkstra
        public float shortestPath(Graph<E> graph, E startNode, E endNode) {
            // Obtener el nodo de inicio
            GraphNode<E> start = getNode(graph, startNode);
            if (start == null) {
                System.out.println("El nodo de inicio no existe en el grafo.");
                return -1;
            }

            // Obtener el nodo de destino
            GraphNode<E> end = getNode(graph, endNode);
            if (end == null) {
                System.out.println("El nodo de destino no existe en el grafo.");
                return -1;
            }

            // Inicializar las distancias desde el nodo de inicio a todos los demás nodos como infinito
            float[] distances = new float[graph.getSize()];
            for (int i = 0; i < distances.length; i++) {
                distances[i] = Float.POSITIVE_INFINITY;
            }

            // La distancia desde el nodo de inicio a sí mismo es 0
            distances[graph.getNodeIndex(startNode)] = 0;

            // Array para marcar los nodos visitados
            boolean[] visited = new boolean[graph.getSize()];

            // Iterar sobre todos los nodos
            for (int i = 0; i < graph.getSize(); i++) {
                // Encontrar el nodo no visitado más cercano
                int minIndex = minDistance(distances, visited);
                visited[minIndex] = true;

                // Actualizar las distancias a los nodos adyacentes
                for (Edge<E> edge = getNode(graph, graph.getNodeByIndex(minIndex).data).list.first; edge != null; edge = edge.next) {
                    int adjIndex = graph.getNodeIndex(edge.destination);
                    float newDistance = distances[minIndex] + edge.weight;
                    if (newDistance < distances[adjIndex]) {
                        distances[adjIndex] = newDistance;
                    }
                }
            }

            // La distancia más corta desde el nodo de inicio al nodo de destino
            return distances[graph.getNodeIndex(endNode)];
        }

        // Método auxiliar para encontrar el nodo con la distancia mínima no visitada
        protected int minDistance(float[] distances, boolean[] visited) {
            float min = Float.POSITIVE_INFINITY;
            int minIndex = -1;
            for (int i = 0; i < distances.length; i++) {
                if (!visited[i] && distances[i] <= min) {
                    min = distances[i];
                    minIndex = i;
                }
            }
            return minIndex;
        }

        // Método auxiliar para obtener un nodo por su nombre
        public GraphNode<E> getNode(Graph<E> graph, E nodeName) {
            GraphNode<E> current = graph.first;
            while (current != null) {
                if (current.data.equals(nodeName)) {
                    return current;
                }
                current = current.next;
            }
            return null;
        }

        public float getEdgeWeight(E from, E to) {
            GraphNode<E> fromNode = getNodeByData(from);
            if (fromNode != null) {
                Edge<E> currentEdge = fromNode.list.first;
                while (currentEdge != null) {
                    if (currentEdge.destination.equals(to)) {
                        return currentEdge.weight;
                    }
                    currentEdge = currentEdge.next;
                }
            }
           
            return Float.POSITIVE_INFINITY;
        }
        

        // Método para obtener un nodo por su dato
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

        public Array<GraphNode<E>> shortestPathNodes(Graph<E> graph, E startNode, E endNode) {
            // Obtener el nodo de inicio
            GraphNode<E> start = getNode(graph, startNode);
            if (start == null) {
                System.out.println("El nodo de inicio no existe en el grafo.");
                return null;
            }
    
            // Obtener el nodo de destino
            GraphNode<E> end = getNode(graph, endNode);
            if (end == null) {
                System.out.println("El nodo de destino no existe en el grafo.");
                return null;
            }
    
            // Inicializar las distancias desde el nodo de inicio a todos los demás nodos como infinito
            float[] distances = new float[graph.getSize()];
            for (int i = 0; i < distances.length; i++) {
                distances[i] = Float.POSITIVE_INFINITY;
            }
    
            // La distancia desde el nodo de inicio a sí mismo es 0
            distances[graph.getNodeIndex(startNode)] = 0;
    
            // Array para marcar los nodos visitados
            boolean[] visited = new boolean[graph.getSize()];
    
            // Iterar sobre todos los nodos
            for (int i = 0; i < graph.getSize(); i++) {
                // Encontrar el nodo no visitado más cercano
                int minIndex = minDistance(distances, visited);
                visited[minIndex] = true;
    
                // Actualizar las distancias a los nodos adyacentes
                for (Edge<E> edge = getNode(graph, graph.getNodeByIndex(minIndex).data).list.first; edge != null; edge = edge.next) {
                    int adjIndex = graph.getNodeIndex(edge.destination);
                    float newDistance = distances[minIndex] + edge.weight;
                    if (newDistance < distances[adjIndex]) {
                        distances[adjIndex] = newDistance;
                    }
                }
            }
    
            // Crear un array para almacenar los nodos en el camino más corto
            Array<GraphNode<E>> pathNodes = new Array<>(graph.getSize());
            
            // Obtener el índice del nodo final
            int endIndex = graph.getNodeIndex(endNode);
    
            // Recorrer hacia atrás desde el nodo final hasta el nodo de inicio
            int currentIndex = endIndex;
            while (currentIndex != -1 && distances[currentIndex] != Float.POSITIVE_INFINITY) {
                pathNodes.add(graph.getNodeByIndex(currentIndex));
                // Encontrar el siguiente nodo hacia atrás con la distancia mínima
                currentIndex = findPreviousNode(distances, currentIndex, graph);
            }
    
            // Invertir el array para obtener el orden correcto de los nodos
            return pathNodes;
        }
    
        // Método auxiliar para encontrar el nodo anterior en el camino más corto
        protected int findPreviousNode(float[] distances, int currentIndex, Graph<E> graph) {
            float minDistance = Float.POSITIVE_INFINITY;
            int previousIndex = -1;
            for (Edge<E> edge = getNode(graph, graph.getNodeByIndex(currentIndex).data).list.first; edge != null; edge = edge.next) {
                int adjIndex = graph.getNodeIndex(edge.destination);
                if (distances[adjIndex] + edge.weight == distances[currentIndex]) {
                    if (distances[adjIndex] < minDistance) {
                        minDistance = distances[adjIndex];
                        previousIndex = adjIndex;
                    }
                }
            }
            return previousIndex;
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
    
}
