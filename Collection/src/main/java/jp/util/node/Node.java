package jp.util.node;

public interface Node<E> {
    /**
     * Sets an element in the node.
     * @in element to be set in the node.
     * @return void
    **/
    public void set(E element);
    /**
     * Gets the element contained in the node.
     * @return the element in the node or null.
    **/
    public E get();
    /**
     * Gets a string representation of the node.
     * @return a string representation of the node.
    **/
    public String toString();
}
