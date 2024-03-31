package jp.graphs;

public class GraphNode<E> {
    
    public  E data;
    public AdjacencyList<E> list;
    public GraphNode<E> next;
    
    public GraphNode(E element) {
        this.data = element;
        this.list = new AdjacencyList<>();
        this.next = null;
    }
}
