
package jp.queue.array;

import java.util.function.Function;
import jp.array.Array;
import jp.util.collection.Collection;
import jp.util.iterator.Iterator;
import jp.util.queue.AbstractQueue;

public class QueueArray<E> extends AbstractQueue<E>{
    
    Array<E> queue;
    int head = 0;
    int tail = -1;
    
    public QueueArray(int size) {
        this.queue = new Array<>(size);
    }
    
    @Override
    public boolean clear() {
        head= 0;
        tail= -1;
        return queue.clear();
    }

    @Override
    public boolean contains(E element) {
        return queue.contains(element);
    }

    @Override
    public boolean contains(E[] array) {
        return queue.contains(array);
    }

    @Override
    public boolean contains(Collection<E> collection) {
        return queue.contains(collection); 
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean reverse() {
        return queue.reverse();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void forEach(Function<E, Void> action) {
        queue.forEach(action);
    }

    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }

    @Override
    public E peek() {
        return queue.get(head);
    }

    @Override
    public E extract() {
        try{
            E element = queue.get(head);
            queue.remove(head);
            head++;
            if(isEmpty()){
                head=0;
                tail=-1;
            }
            return element;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean insert(E element) {
        tail++;
        return queue.add(element);    
    }

}
