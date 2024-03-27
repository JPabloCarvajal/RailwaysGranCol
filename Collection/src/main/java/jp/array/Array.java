package jp.array;

import java.util.function.Function;
import java.util.function.Predicate;

import jp.util.array.AbstractArray;
import jp.util.collection.Collection;
import jp.util.iterator.Iterator;

public class Array<E> extends AbstractArray<E> {
    private E[] E;
    private int size ;
    
    @SuppressWarnings("unchecked")
    public Array(int size) {
        this.E = (E[]) new Object[size];
        this.size = size;
    }

    public Array(E[] elements) {
        this.E = elements;
        this.size = E.length;
    }

    @Override
    public boolean add(E element) {
        
        try{
            int index = emptyIndex();

            if(index == -1){
                return false;
            }

            E[index] = element;
            this.size++;
            return true;
        }catch(Exception e){
            return false;
        }
        
    }

    @Override
    public boolean add(int index, E[] array) {
       try {
            int sizes = 0;
            if (index < E.length) {
                for(int i = index; i < E.length; i++){
                    E[i] = array[sizes++];
                }   
                return true;
            }
        return false;
       } 
       catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
       }
    }
    

    @Override
    public boolean add(int index, Collection<E> collection) {
        try {
            Iterator<E> iterator = collection.iterator();
                if (index < E.length) {
                        while(iterator.hasNext()){
                            E[index++] = iterator.next();
                        }
                        return true;
                    }
                    return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void defragment() {
        try {
            int Index = 0;
            while (Index < size && E[Index] != null) {
                Index++;
            }
            if (Index < size) {
                int nextNonNullIndex = Index + 1;
                while (nextNonNullIndex < size && E[nextNonNullIndex] == null) {
                    nextNonNullIndex++;
                }
                while (nextNonNullIndex < size) {
                    E[Index++] = E[nextNonNullIndex++];
                }
                while (Index < size) {
                    E[Index++] = null;
                }
            }
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }   

    @Override
    public E get(int index){
        return E[index];
    }

    @Override
    public int indexOf(E element){
        try{
            for(int i=0;i<size;i++){
                if(E[i].equals(element)){
                    return i;
                }
            }
        return -1;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return -1;
        } 
    }

    @Override
    public int lastIndexOf(E element) {
        try {
            for (int i = size - 1; i >= 0; i--) {
                if (E[i] != null && E[i].equals(element)) {
                    return i;
                }
            }
            return -1;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return -1; 
        }
    }

    @Override
    public boolean remove(int index) {
        try {
            if (E[index] != null) {
                E[index] = null;
                return true;
            } else {
                return false;
            }
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean remove(Predicate<E> filter) {
        try {
            boolean removed = false;
            for (int i = 0; i < size; i++) {
                if (filter.test((E) E[i])) {
                    E[i] = null;
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

    @Override
    public boolean remove(int from,int to){
        try {
            if (from < 0 || to > E.length || from >= to) {
                return false;
            }
            for (int i = from; i < to; i++) {
                E[i] = null;
            }
            for (int i = from; i < to; i++) {
                if (E[i] != null) {
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

    @SuppressWarnings("unchecked")
    @Override
    public boolean dimension(int newDimension) {
        try {
            if (newDimension < 0) {
                return false;
            }
            if (newDimension < size) {
                for (int i = newDimension; i < size; i++) {
                    E[i] = null;
                }
                size = newDimension;
            } else if (newDimension > E.length) {
                E[] newArray = (E[]) new Object[newDimension];
                for (int i = 0; i < size; i++) {
                    newArray[i] = E[i];
                }
                E = newArray;
                size = newDimension;
            }
    
            return true;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean set(int index,E element){
        try{
        E[index] = element;
        return true;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    @SuppressWarnings("unchecked")
    public boolean set(int index,E[] array){
        try{
        E[index] = (E) array;
        return true;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    ////////////////////////////////////////////////////until here, these were array methods implementation////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public boolean clear() {
        try {
            for (int i = 0; i < E.length; i++) {
                E[i] = null;
            }
            return true;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean contains(E element) {
        try {
            Iterator<E> iterator = this.iterator();
            while (iterator.hasNext()) {
                E Element = iterator.next();
                if ((Element == null && element == null) || (Element != null && Element.equals(element))) {
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

    @Override
    public boolean contains(E[] array) {
        try {
            for(int i = 0; i < array.length; i++){
                if (this.contains(array[i]) == false) {
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

    @Override
    public boolean contains(Collection<E> collection) {
        try {
            Iterator<E> iterator = (Iterator<E>) collection.iterator();
            while (iterator.hasNext()) {
                if (this.contains(iterator.next()) == false) {
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

    @Override
    public boolean isEmpty() {
        try {
            Iterator<E> iterator = this.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() != null) {
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
    

    @Override
    public boolean reverse() {
        try {
            if (size() <= 1) {
                return true;
            }
            for (int i = 0; i < E.length / 2; i++) {
                int oppositeI = E.length - 1 - i;
                E temp = E[i];
                E[i] = E[oppositeI];
                E[oppositeI] = temp;
            }
            return true;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public int size() {
        int sizes = 0;
        for (int i = 0; i < E.length; i++) {
            if (E[i] != null) {
                sizes++;
            }
        }
        return sizes;
    }

    public int lenght(){
        return E.length;
    }

    ////////////////////////////////////////////////////until here, these were Collection methods implementation////////////////////////////////////////////////////////////////////////////

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < E.length;
            }
            
            @Override
            public E next() {
                return E[i++];
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not used here yet.");
            }
        };
    }
    
    @Override
    public void forEach(Function<E, Void> action) {
        try {           
            Iterator<E> iterator = iterator();    
            while (iterator.hasNext()) {
                action.apply(iterator.next());
            }
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public String toStringg() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(E[i]);
        }
        sb.append("]");
        return sb.toString();
    }
    
    private int emptyIndex(){
        try{
            for(int i = 0; i < E.length; i++){
                if(E[i] == null){
                    return i;
                }
            }
        }
        catch(Exception e){
            return -1;
        }
        return -1;
    }


    
}