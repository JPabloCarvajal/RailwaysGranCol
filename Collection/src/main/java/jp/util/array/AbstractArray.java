package jp.util.array;
import java.util.function.Function;
import java.util.function.Predicate;

import jp.util.collection.Collection;
import jp.util.iterator.Iterator;

public abstract class AbstractArray<E> implements Array<E>, Cloneable, Collection<E>{
    //Sirve en cualquier metodo

    @Override
    public abstract boolean add(E element);

    @Override
    public abstract boolean add(int index, E[] array);

    @Override
    public abstract boolean add(int index, Collection<E> collection);

    @Override
    public abstract void defragment();

    @Override
    public abstract boolean dimension(int newDimension);

    @Override
    public abstract E get(int index);

    @Override
    public abstract int indexOf(E element);

    @Override
    public abstract int lastIndexOf(E element);

    @Override
    public abstract boolean remove(int index);

    @Override
    public abstract boolean remove(Predicate<E> filter);

    @Override
    public abstract boolean remove(int from, int to);

    @Override
    public abstract boolean set(int index, E element);

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
    public void forEach(Function<E, Void> action) {
        try {           
            Iterator<E> iterator = iterator();    
            while (iterator.hasNext()) {
                action.apply(iterator.next());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
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
}
