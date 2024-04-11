package jp.graphs;

public class AdjacencyList<E> {
    
    public Edge<E> first;
    public Edge<E> last;

    public AdjacencyList() {
        this.first = null;
        this.last = null;
    }
    
    public boolean emptyList() {
        return first == null;
    }

    // Sin peso
    public void newAdjacency(E destination) {
        if (!adjacency(destination)) {
            Edge<E> node = new Edge<>(destination);
            insert(node, destination);
        }
    }

    public void newAdjacency(E destination, float weight) {
        if (!adjacency(destination)) {
            Edge<E> node = new Edge<>(destination, weight);
            insert(node, destination);
        }
    }
    

    public void insert(Edge<E> node, E destination) {
        if (emptyList()) {
            first = node;
            last = node;
        } else {
            if (destination.toString().compareTo(first.destination.toString()) <= 0) {
                node.next = first;
                first = node;
            } else {
                if (destination.toString().compareTo(last.destination.toString()) >= 0) {
                    last.next = node;
                    last = node;
                } else {
                    Edge<E> position = first;
                    while (position.next != null && destination.toString().compareTo(position.next.destination.toString()) > 0) {
                        position = position.next;
                    }
                    node.next = position.next;
                    position.next = node;
                }
            }
        }
    }

    public boolean adjacency(E data) {
        Edge<E> actual = first;
        while (actual != null && !data.toString().equals(actual.destination.toString())) {
            actual = actual.next;
        }
        return actual != null;
    }
}
