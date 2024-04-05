package jp.util.list;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import jp.util.collection.Collection;

public interface List<E> {
    /**
     * Appends the specified element to the end of this list.
     * @in element to be appended to this list.
     * @return 'true' if the element was added successfully, otherwise 'false'.
    **/  
  boolean add(E element);
  /**
     * ...
     * @in array whose elements are to be added to the list.
     * @return 'true' if the array was added successfully, otherwise 'false'.
    **/
  boolean add(E[] elements);
  /**
     * Appends all of the elements in the specified collection to the end of this list.
     * @in collection whose elements are to be added to the list.
     * @return 'true' if the element was added successfully, otherwise 'false'.
    **/
  boolean add(Collection<E> collection);
  /**
     * Appends the specified element at the beginning of this list.
     * @in element to be appended to this list.
     * @return 'true' if the element was added successfully, otherwise 'false'.
    **/
  boolean addFirst(E element);
  /**
     * Appends all of the elements in the specified array at the beginning 
       of this list, in the order that they are returned by the specified collection's iterator.
     * @in element to be appended to this list.
     * @return 'true' if the collection was added successfully, otherwise 'false'.
    **/
  boolean addFirst(E[] elements);
  /**
     * Appends all of the elements in the specified collection at the beginning of this list,
       in the order that they are returned by the specified collection's iterator.
     * @in element to be appended to this list.
     * @return 'true' if the collection was added successfully, otherwise 'false'.
    **/
  boolean addFirst(Collection<E> collection);
  /**
     *  Retrieves, but does not remove, the first element of this list.
     * @return the element in the head of this list, or 'null' if this list is empty.
    **/
  E peek();
  /**
     * Retrieves, but does not remove, the last element of this list.
     * @return the element in the last of this list, or 'null' if this list is empty.
    **/
  E peekLast();
  /**
     * Retrieves, but does not remove, the first n elements of the list.
     * @in The number of elements to get.
     * @return Returns an array containing the first n elements of the list.
    **/
  E[] peekArray(int n);
  /**
     * Retrieves, but does not remove, the last n elements of the list.
     * @in The number of elements to get.
     * @return Returns an array containing the last n elements of the list.
  **/
  E[] peekLastArray(int n);
  /**
     * Retrieves, but does not remove, the first n elements of the list.
     * @in The number of elements to get.
     * @return Returns a collection containing the first n elements of the list.
  **/
  List<E> peekCollection(int n);
  /**
     * Retrieves, but does not remove, the last n elements of the list.
     * @in The number of elements to get.
     * @return Returns a collection containing the last n elements of the list.
  **/
  List<E> peekLastCollection(int n);
  /**
     * Retrieves and removes the head (first element) of this list
     * @return Return the element in the head of this list, or 'null' if this list is empty.
  **/
  E poll();
  /**
     * Retrieves and removes the last element of this list.
     * @return Returns the element in the last of this list, or 'null' if this list is empty.
  **/
  E pollLast();
  /**
     * Retrieves and removes the first n elements of the list.
     * @in The number of elements to get.
     * @return Returns an array containing the first n elements of the list.
  **/
  E[] pollArray(int n);
  /**
     * Retrieves and removes the last n elements of the list.
     * @in The number of elements to get.
     * @return Returns an array containing the last n elements of the list.
  **/
  E[] pollLastArray(int n);
  /**
     * Retrieves and removes the first n elements of the list.
     * @in The number of elements to get.
     * @return Returns a collection containing the first n elements of the list.
  **/
  List<E> pollCollection(int n);
  /**
     * Retrieves and removes the last n elements of the list.
     * @in The number of elements to get.
     * @return Returns an array containing the first n elements of the list.
  **/
  List<E> pollLastCollection(int n);
  /**
     *Removes the first occurrence of the specified element from this list, if it is present. 
     * @in The element to be removed from this list, if present.
     * @return Returns 'true' if the element was removed successfully, otherwise 'false'.
  **/
   boolean remove(E element);
   /**
     * Removes from this list all of its elements that are contained in the specified collection.
     * @in The array containing elements to be removed from this list.
     * @return Returns 'true' if the collection elements was removed successfully, otherwise 'false'.
  **/
  boolean remove(E[] elements);
  /**
     * Removes from this list all of its elements that are contained in the specified collection.
     * @in The collection containing elements to be removed from this list.
     * @return Returns 'true' if the collection elements was removed successfully, otherwise 'false'.
  **/
  boolean remove(Collection<E> collection);
  /**
     * Removes all of the elements of this list that satisfy the given predicate. Errors or 
     * runtime exceptions thrown during iteration or by the predicate are relayed to the caller.
     * @in A predicate which returns 'true' for elements to be removed.
     * @return 
  **/
  boolean remove(Predicate<E> filter);
  /**
     * Replaces each element of this list with the result of applying the function to that element.
     * @in The element to be replaced in this list.
     * @in The element to be added to this list.
     * @in The function to apply to each element.
     * @return Returns 'true' if the list was replaced successfully, otherwise 'false'.
  **/
  boolean replace(E element, E newElement, Predicate<E> comparator);
  /**
     * Replaces each element of this list with the result of applying the function to that element.
     * @in The array containing elements to be replaced in this list.
     * @in The array containing elements to be added to this list.
     * @in The function to apply to each array element.
     * @return Returns 'true' if the list was replaced successfully, otherwise 'false'.
  **/
  boolean replace(E[] array, E[] newArray, Predicate<E> comparator);
  /**
     * Replaces each element of this list with the result of applying the function to that element.
     * @in The collection containing elements to be replaced in this list.
     * @in The collection containing elements to be added to this list.
     * @in The function to apply to each array element.
     * @return Returns 'true' if the list was replaced successfully, otherwise 'false'.
  **/
  boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator);
  /**
     * Retains only the elements in this list that are contained in the specified collection.
     * @in The array containing elements to be retained in this list.
     * @return Returns 'true' if the list was retained successfully, otherwise 'false'.
  **/
   boolean retain(E[] elements);
   /**
     * Retains only the elements in this list that are contained in the specified collection.
     * @in The collection containing elements to be retained in this list.
     * @return Returns 'true' if the list was retained successfully, otherwise 'false'.
  **/
  boolean retain(Collection<E> collection);
  /**
     * Replaces the specified element by a new element in this list. Only the first occurrence is replaced.
     * @in The element to be replaced in this list.
     * @in The element to be added to this list.
     * @return Returns 'true' if the element was replaced successfully, otherwise 'false'.
  **/
  boolean set(E element, E newElement);
  /**
     * Sorts this list according to the order induced by the specified Comparator.
     * @in The Comparator used to compare list elements.
     * @return Returns 'true' if the list was sorted successfully, otherwise 'false'.
  **/
  boolean sort(ToIntFunction<E> comparator);
  /**
     * Returns a sub list of this list between the specified "from" and "to".
     * @in The initial element of the sub list, inclusive.
     * @in The final element of the sub list, exclusive.
     * @return Returns a sub list of this list between the specified "from", inclusive, and "to", exclusive.
  **/
  List<E> subList(E from, E to);
  /**
     * Returns an array containing all of the elements in this list.
     * @return Returns an array containing all of the elements in this list.
  **/
   E[] toArray();
}
