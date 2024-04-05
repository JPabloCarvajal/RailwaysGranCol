package jp.util.iterator;

public interface Iterator<E> {
    /**
     * Determinates if the operator have more elements
     * @return true if the iterator has more elements
    **/
    public boolean hasNext();
    /**
     * gets the next element in the iteration
     * @return the next element in the iteration
    **/
    public E next();
    
    public void remove();   
}
