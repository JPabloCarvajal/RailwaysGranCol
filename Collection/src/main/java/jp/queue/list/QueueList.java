
package jp.queue.list;

import java.util.function.Function;
import jp.linkedlist.singly.LinkedList;
import jp.util.collection.Collection;
import jp.util.iterator.Iterator;
import jp.util.queue.AbstractQueue;

public class QueueList<E> extends AbstractQueue<E> {
    
    LinkedList<E> queue;

    public QueueList() {
        this.queue = new LinkedList<>();
    }

    @Override
    public boolean clear() {
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
        return queue.peek();
    }

    public E peekLast() {
        return queue.peekLast();
    }

    @Override
    public E extract() {
        return queue.poll();
    }

    @Override
    public boolean insert(E element) {
        return queue.add(element);
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
}
