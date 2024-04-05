package jp.graphs;

public class Edge<E> {

    public  E destination;
    public float weight;
    public Edge<E> next;

    // Arco sin peso
    public Edge(E element) {
        this.destination = element;
        this.next = null;
    }

    // Arco con peso
    public Edge(E element, float weight) {
        this.destination = element;
        this.weight = weight;
        this.next = null;
    }
}

