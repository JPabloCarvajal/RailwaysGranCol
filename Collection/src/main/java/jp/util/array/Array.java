package jp.util.array;
import java.util.function.Predicate;
import jp.util.collection.Collection;

public interface Array<E> {
    /**
     * Inserts the specified element at the clear position in this collection.
     * @in element to be inserted.
     * @return 'true' if the element was added successfully, otherwise 'false'.
    **/
    
    boolean add(E element);
    /**
     * Inserts all of the elements in the specified array into this collection, starting at the specified position.
     * @param element to be inserted.
     * @param array containing elements to be added to this collection.
     * @return Returns 'true' if the collection was added successfully, otherwise 'false'.
    **/
    
    boolean add(int index,E[] Array);
    
    /**
     * Inserts all of the elements in the specified collection into this collection, starting at the specified position.
     * @param index at which the specified element is to be inserted.
     * @param collection containing elements to be added to this collection.
     * @return 'true' if the collection was added successfully, otherwise 'false'.
    **/
    
    boolean add(int index,Collection<E> collection);
    
    /**
     * Moves all the elements to the left.
    **/    
    
    void defragment();
    
    /**
     * Returns the element at the specified position in this collection.
     * @param index of the element to return.
     * @return Returns the element at the specified position in this collection.
    **/
    
    E get(int index);
    
    /**
     * Returns the index of the first occurrence of the specified element in this collection.
     * @param element to search for.
     * @return return the index of the first occurrence of the specified element in this collection, or -1 if this list does not contain the element.
    **/
    
    int indexOf(E element);
    
    /**
     * Returns the index of the last occurrence of the specified element in this collection.
     * @param element to search for.
     * @return return the index of the last occurrence of the specified element in this collection,
     * or -1 if this list does not contain the element.
    **/
    
    int lastIndexOf(E element);
    
    /**
     * Removes the element at the specified position in this collection.
     * @param index of the element to be removed.
     * @return 'true' if the element was removed successfully, otherwise 'false'.
    **/
    
    boolean remove(int index);
    
    /**
     * Removes the first occurrence of the specified element from this collection, if it is present.
     * @param filter to apply to each element to determine if it should be removed.
     * @return 'true' if the element was removed successfully, otherwise 'false'.
    **/
    
    boolean remove(Predicate<E> filter);
    
    /**
     * Removes from this collection all of the elements whose index is between "from" and "to".
     * @param initial index of the range to be removed, inclusive.
     * @param final index of the range to be removed, inclusive.
     * @return Returns 'true' if the element was removed successfully between the 
     * specified "from", inclusive, and "to", exclusive, otherwise 'false'.
    **/
    
    boolean remove(int from, int to);
    
    /**
     * Resizes the array to the specified dimension. 
     * If the specified dimension is less than the current dimension, the array is truncated.
     * @param new dimension of the array
     * @return 'true' if the array was re dimensioned successfully, otherwise false.
    **/
 
    boolean dimension(int newDimension);
    
    /**
     * Replaces the element at the specified position in this collection with the specified element.
     * @param index of the element to replace.
     * @param element to be stored at the specified position.
     * @return Returns 'true' if the element was replaced successfully, otherwise 'false'.
    **/
    
    boolean set(int index,E element);
    
}
