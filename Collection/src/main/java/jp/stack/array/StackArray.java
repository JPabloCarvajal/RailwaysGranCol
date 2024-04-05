
package jp.stack.array;

import java.util.function.Function;
import jp.array.Array;
import jp.util.collection.Collection;
import jp.util.iterator.Iterator;
import jp.util.stack.AbstractStack;

public class StackArray<E> extends AbstractStack<E>{

    Array<E> stack;
    int top = -1;

    public int getTop() {
        return top;
    } 

    public StackArray(int size) {
        this.stack = new Array<>(size);
    }
  
    @Override
    public boolean clear() {
        top = -1;
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
        if(isEmpty()){
            return null;
        }
        return stack.get(top);
    }

    @Override
    public E pop() {
        try{
            if(isEmpty()){
                return null;
            }
            E element = stack.get(top);
            stack.remove(top);
            top--;
            return element;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean push(E element) {
        try{
            stack.add(element);
            top ++;
            return true;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= top; i++) {
            sb.append(stack.get(i));
            if (i < top) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    }

