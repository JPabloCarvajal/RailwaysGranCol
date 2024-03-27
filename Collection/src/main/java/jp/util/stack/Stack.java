
package jp.util.stack;

public interface Stack<E> {
    
   E peek();
   
   E pop();
   
   boolean push(E element);
   
   String toString();
}
