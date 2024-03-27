
package jp.stack.list;

import java.util.function.Function;
import jp.linkedlist.singly.LinkedList;
import jp.util.collection.Collection;
import jp.util.iterator.Iterator;
import jp.util.stack.AbstractStack;

public class StackList<E> extends AbstractStack<E> {
    
    LinkedList<E> stack;

    public StackList() {
        this.stack = new LinkedList<>();
    }
    
    @Override
    public boolean clear() {
       return stack.clear();
    }

    @Override
    public boolean contains(E element) {
      return stack.contains(element);
    }

    @Override
    public boolean contains(E[] array) {
       return stack.contains(array);
    }

    @Override
    public boolean contains(Collection<E> collection) {
        return stack.contains(collection);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public boolean reverse() {
        return stack.reverse();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public void forEach(Function<E, Void> action) {
        stack.forEach(action);
    }

    @Override
    public Iterator<E> iterator() {
        return stack.iterator();
    }

    @Override
    public E peek() {
        return stack.peek();
    }

    @Override
    public E pop() {
        return stack.poll();
    }

    @Override
    public boolean push(E element) {
        return stack.addFirst(element);
    }   
    
}
