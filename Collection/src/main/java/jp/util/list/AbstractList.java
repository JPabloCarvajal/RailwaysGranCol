package jp.util.list;
import java.util.function.Function;

import jp.util.collection.Collection;
import jp.util.iterator.Iterator;

public abstract class AbstractList<E> implements List<E>, Collection<E>, Cloneable  {
    protected int size;
    
    protected AbstractList(){
        size=0;
    }
    
    public int getSize(){
        return size;
    }
    
    //SI
    @Override
    public boolean add(E[] elements) {
        try{
            for (int i=0;i<elements.length;i++){
                add(elements[i]);
            }
            return true;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    //SI
    @Override
    public boolean add(Collection<E> collection) {
        try {
            Iterator<E> iterator = collection.iterator();
            while (iterator.hasNext()) {
                E element = iterator.next();
                if (!add(element)) {
                    return false;
                }
            }
        return true;
    } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    //SI
    @Override
    public boolean addFirst(E[] elements) {
        try {    
            for(int i=0; i<elements.length; i++){
                addFirst(elements[i]);
            }
            return true;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    //SI
    @Override
    public boolean addFirst(Collection<E> collection) {
        try {
            Iterator<E> iterator = collection.iterator();
            while (iterator.hasNext()) {
                E element = iterator.next();
                if (!addFirst(element)) {
                    return false;
                }
            }
        return true;
    } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    //SI
    @SuppressWarnings("unchecked")
    @Override
    public E[] peekArray(int n){
        try {
            if (isEmpty() || n <= 0) {
                return (E[]) new Object[0];
            }
            if (n > size) {
                n = size;
            }
            E[] Array = (E[]) new Object[n];
            Iterator<E> iterator = iterator();
            for (int i = 0; i < n && iterator.hasNext(); i++) {
                Array[i] = iterator.next();
            }
            return (E[]) Array;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    //SI
    @SuppressWarnings("unchecked")
    @Override
    public E[] peekLastArray(int n) {
       try {
            if (isEmpty() || n <= 0) {
               return (E[]) new Object[0];
            }
            if (n > size) {
                n = size;
            }
            E[] tempArray = (E[]) new Object[n];
            Iterator<E> iterator = iterator();
            int i = 0;
            while (iterator.hasNext()) {
                E element = iterator.next();
                if (i >= size - n) {
                    tempArray[i - (size - n)] = element;
                }
                i++;
            }
            return tempArray;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
                return null;
        }
    }

    //SI
    @SuppressWarnings("unchecked")
    @Override
    public E[] pollArray(int n) {
        try {
            if (isEmpty() || n <= 0) {
                return (E[]) new Object[0];
            }
            if (n > size) {
                n = size;
            }
            E[] array = (E[]) new Object[n];
            for (int i = 0; i < n; i++) {
                array[i] = poll();
            }
            return array;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    //SI
    @SuppressWarnings("unchecked")
    @Override
    public E[] pollLastArray(int n) {
        try {
            if (isEmpty() || n <= 0) {
                return (E[]) new Object[0];
            }
            if (n > size) {
                n = size;
            }
            E[] array = (E[]) new Object[n];
            for (int i = 0; i < n; i++) {
                array[i] = pollLast();
            }
            return array;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    //SI
    @Override
    public boolean remove(E[] elements) {
        try {
            if (isEmpty() || elements == null || elements.length == 0) {
                return false;
            }
            boolean removed = false;
            for (E element : elements) {
                if (contains(element)) {
                    remove(element);
                    removed = true;
                }
            }
            return removed;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    //SI
    @Override
    public boolean remove(Collection<E> collection) {
        try {
            if (isEmpty() || collection == null || collection.isEmpty()) {
                return false;
            }  
            boolean removed = false;
            Iterator<E> iterator = collection.iterator();
            while (iterator.hasNext()) {
                E element = iterator.next();
                if (remove(element)) {
                    removed = true;
                }
            }
            return removed;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    //SI
    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray() {
        try{
            E[] array = (E[]) new Object[size];
            int index = 0;
        
            Iterator<E> iterator = iterator();
            while (iterator.hasNext()) {
                array[index++] = iterator.next();
            }
            return array;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    //SI
    @Override
    public boolean contains(E element) {
        try {
            Iterator<E> iterator = iterator();
            while (iterator.hasNext()) {
                E Element = iterator.next();
                if ((Element == null && element == null) ||
                    (Element != null && Element.equals(element))) {
                    return true;
                }
            }
            return false;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    //SI
    @Override
    public boolean contains(E[] array) {
        try {
            if (array == null || array.length == 0) {
                return false;
            }
            for (E element : array) {
                if (!contains(element)) {
                return false;
            }
            }   
            return true;
            }
        catch (Exception e) {   
            System.err.println(e.getMessage());
            return false;
        }
    }

    //SI
    @Override
    public boolean contains(Collection<E> collection) {
        try {    
            Iterator<E> iterator = iterator();
            while (iterator.hasNext()) {
                E Element = iterator.next();
                if (!collection.contains(Element)) {
                    return false;
            }
            }
            return true;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }   
    }
    
    //SI
    @Override
    public void forEach(Function<E, Void> action) {
        if (action == null) {
            throw new NullPointerException("Action cannot be null");
        }
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();
            action.apply(element);
        }    
    }

}
