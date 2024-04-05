package jp.linkedlist.doubly.circular;

import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;


import jp.linkedlist.node.doubly.LinkedNode;

import jp.util.collection.Collection;
import jp.util.iterator.Iterator;
import jp.util.list.AbstractList;
import jp.util.list.List;

public class LinkedList<E> extends AbstractList<E> {
    public LinkedNode<E> head;
    public LinkedNode<E> tail;
    public LinkedNode<E> inode;

    public LinkedList() {
        super();
        head = null;
        tail = null;
        inode = null;
    }

    public LinkedList(E element) {
        super();
        add(element);
    }

    //OK!
    @Override 
    public boolean add(E element){
        try{
            LinkedNode<E> node = new LinkedNode<>();
            LinkedNode<E> tail;
            node.set(element);

            if(isEmpty()){
                head = node;
                node.setNext(node);
                node.setPrev(node);
                size++;
                return true;
            }
            tail = head.getPrev();
            tail.setNext(node);
            node.setPrev(tail);
            head.setPrev(node);
            node.setNext(head);
            size++;

            return true;  
        }
        catch(Exception e){
            return false;
        }
    }
    //OK!
    @Override
    public boolean addFirst(E element) {
        try{
            LinkedNode<E> node = new LinkedNode<>();
            LinkedNode<E> tail;
            node.set(element);

            if(isEmpty()){
                head = node;
                node.setNext(node);
                node.setPrev(node);
                size++;
                return true;
            }
            tail = head.getPrev();

            tail.setNext(node);
            node.setPrev(tail);

            head.setPrev(node);
            node.setNext(head);
            size++;
            head = node;

            return true;
            
        }catch(Exception e){
            return false;
        }
    }

    //OK!
    @Override
    public E peek() {
        try {
            if (head == null || tail == null) {
                return null;
            } 
            else {
                return head.get();
            }
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    //OK!
    @Override
    public E peekLast() {
        try {
            if (head == null || tail == null) {
                return null;
            } 
            else {
                return tail.get();
            }
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }    
    }
    //OK!
    @Override
    public List<E> peekCollection(int n) {
        try {
                if (isEmpty() || n <= 0) {
                    return new LinkedList<>();
                }    
                if (n > size) {
                    n = size;
                }
                List<E> collection = new LinkedList<>();
                Iterator<E> iterator = iterator();
                int sise = 0;
                while (iterator.hasNext() && sise < n) {
                    E element = iterator.next();
                    collection.add(element);
                    sise++;
                }
                return collection;       
            } 
            catch (Exception e) {
                System.err.println(e.getMessage());
                return null;
            }     
    }
    //OK!
    @Override
    public List<E> peekLastCollection(int n) {
        try{
            if (isEmpty() || n <= 0) {
                return new LinkedList<>();
            }    
            if (n > size) {
                n = size;
            }
            List<E> List = new LinkedList<>();
            Iterator<E> iterator = iterator();
            int sise = 0;
            while (iterator.hasNext()) {
                if ( sise >= size - n) {
                    E element = iterator.next();
                    List.add(element);
                } 
                else{
                    iterator.next();
                }
                sise++;
            }
            return List;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }    
    }
    //OK!
    @Override
    public E poll() {
        try {
            if (isEmpty()) {
                return null;
            }
            E element = head.get();
            if (size() == 1) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
                head.setPrev(tail);
                tail.setNext(head);
            }
            size--;
            return element;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    //OK!
    @Override
    public E pollLast() {
        try {
            if (isEmpty()) {
                return null;
            }
            if (size() == 1) {
                E element = tail.get();
                head = null;
                tail = null;
                size--;
                return element;
            }
            if (size() > 1) {
                E element = tail.get();
                tail = tail.getPrev();
                tail.setNext(head);
                head.setPrev(tail);
                size--;
                return element;
            }
            return null;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    //OK!
    @Override
    public List<E> pollCollection(int n) {
        try {
            if (isEmpty() || n <= 0) {
                return new LinkedList<>();
            }
            if (n > size) {
                n = size;
            }
            List<E> collection = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                collection.add(this.poll());
            }   
            return collection;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    //OK!
    @Override
    public List<E> pollLastCollection(int n) {
        List<E> collection = new LinkedList<>();
        try {
            if (isEmpty() || n <= 0) {
            return new LinkedList<>();
        }
        if (n > size) {
            n = size;
        }
        for(int i = 0; i < n; i++){
            collection.add(this.pollLast());
        }
        return collection;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    //OK! Todos los remove
    @Override
    public boolean remove(E element) {
        try {
            if (isEmpty() || element == null) {
                return false;
            } 
            LinkedNode<E> inode = head;
            do {
                LinkedNode<E> next = inode.getNext();
                LinkedNode<E> previous = inode.getPrev();

                if (element.equals(inode.get())) {
                    if (inode.equals(head)) {
                        head = next;
                        if (next == null) {
                            tail = null;
                        } 
                        else {
                            next.setPrev(tail);
                            tail.setNext(next);
                        }
                    } 
                    else if (inode.equals(tail)) {
                        tail = previous;
                        previous.setNext(head);
                        head.setPrev(tail);
                    } 
                    else {
                        previous.setNext(next);
                        next.setPrev(previous);
                    }
                    size--;
                    return true;
                }
                inode = next;
            } 
            while (inode != null && inode != head);

            return false;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    //OK!
    @Override
    public boolean remove(Predicate<E> filter) {
        try {
            if (isEmpty() || filter == null) {
                return false;
            }
            LinkedNode<E> inode = head;
            LinkedNode<E> previus = null;
            boolean removed = false;
            do {
                LinkedNode<E> next = inode.getNext();

                if (filter.test(inode.get())) {
                    if (previus == null) {
                        head = next;
                        if (head == null) {
                            tail = null;
                        } 
                        else {
                            head.setPrev(tail);
                            tail.setNext(head);
                        }
                    } 
                    else {
                        previus.setNext(next);
                        if (next == null) {
                            tail = previus;
                            head.setPrev(tail);
                        } 
                        else {
                            next.setPrev(previus);
                        }
                    }
                    size--;
                    removed = true;
                } 
                else {
                    previus = inode;
                }

                inode = next;
            } 
            while (inode != null && inode != head);

            return removed;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    //OK!
    @Override
    public boolean replace(E element, E newElement, Predicate<E> comparator) {
        try {
            if (isEmpty() || element == null || newElement == null || comparator == null) {
                return false;
            }
            inode = head;
            boolean replaced = false;
            do {
                if (comparator.test(inode.get()) && inode.get().equals(element)) {
                    inode.set(newElement);
                    replaced = true;
                }
                inode = inode.getNext();
            } 
            while (inode != null && inode != head);

            return replaced;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    //revisar
    @Override
    public boolean replace(E[] array, E[] newArray, Predicate<E> comparator) {
        try {
            if (array == null || newArray == null || comparator == null || array.length != newArray.length) {
                return false;
            }
            boolean replaced = false;
            for (int i = 0; i < array.length; i++) {
                E currentElement = array[i];
                E newElement = newArray[i];
                if (comparator.test(currentElement)) {
                    replaced |= replace(currentElement, newElement, e -> comparator.test(e));
                }
            }
            return replaced;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    //revisar
    @Override
    public boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator) {
        try {
            if (collection == null || newCollection == null || comparator == null) {
                return false;
            }
            Iterator<E> iterator = collection.iterator();
            Iterator<E> newIterator = newCollection.iterator();
            boolean replaced = false;

            while (iterator.hasNext() && newIterator.hasNext()) {
                E currentElement = iterator.next();
                E newElement = newIterator.next();

                if (comparator.test(currentElement)) {
                    replaced |= replace(currentElement, newElement, e -> comparator.test(e));
                }
            }
            return replaced;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    //OK!
    @Override
    public boolean retain(E[] elements) {
        try {
            if (isEmpty() || elements == null || elements.length == 0) {
                return false;
            }
            LinkedNode<E> inode = head;
            LinkedList<E> retainedList = new LinkedList<>();
            do {
                for (int i = 0; i < elements.length; i++) {
                    if (inode.get().equals(elements[i])) {
                        retainedList.add(inode.get());
                    }
                }
                inode = inode.getNext();
            } 
            while (inode != null && inode != head);

            head = retainedList.head;
            tail = retainedList.tail;
            size = retainedList.size;
            return true;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    //revisar
    @Override
    public boolean retain(Collection<E> collection) {
        try {
            if (isEmpty() || collection == null || collection.isEmpty()) {
                clear();
                return true;
            }
            LinkedList<E> rList = new LinkedList<>();
            Iterator<E> iterator = iterator();
            while (iterator.hasNext()) {
                E currentElement = iterator.next();
                if (collection.contains(currentElement)) {
                    rList.add(currentElement);
                }
            }
            head = rList.head;
            tail = rList.tail;
            size = rList.size;
            return true;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    //OK!
    @Override
    public boolean set(E element, E newElement) {
        try {
            if (isEmpty() || element == null) {
                return false;
            }
            LinkedNode<E> inode = head;
            do {
                if ((inode.get() == null && element == null) || (inode.get() != null && inode.get().equals(element))) {
                    inode.set(newElement);
                    return true;
                }
                inode = inode.getNext();
            } 
            while (inode != null && inode != head);

            return false;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    //OK!
    @Override
    public boolean sort(ToIntFunction<E> comparator) {
        if (size <= 1) {
            return true;
        }
        boolean swapped;
        do {
            swapped = false;
            LinkedNode<E> inode = head;
            LinkedNode<E> next = head.getNext();
            do {
                if (comparator.applyAsInt(inode.get()) > comparator.applyAsInt(next.get())) {
                    E temp = inode.get();
                    inode.set(next.get());
                    next.set(temp);
    
                    swapped = true;
                }
                inode = next;
                next = next.getNext();
            } while (next != head);
    
        } while (swapped);

        tail = head;
        while (tail.getNext() != head) {
            tail = tail.getNext();
        }
    
        return true;
    }


    //OK!
    @Override
    public List<E> subList(E from, E to) {
        try {
            List<E> subList = new LinkedList<>();
            Iterator<E> iterator = iterator();
            boolean inRange = false;
            LinkedNode<E> next = head.getNext();

            do {
                E element = iterator.next();
                if ((element == null && from == null) || (element != null && element.equals(from))) {
                    inRange = true;
                }

                if (inRange) {
                    subList.add(element);
                }

                if ((element == null && to == null) || (element != null && element.equals(to))) {
                    inRange = false;
                    break;
                }

                inode = next;
                next = next.getNext();
            } 
            while (next != head);

            return subList;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    //OK!
    @Override
    public boolean clear() {
        try{
            head = null;
            tail = null;
            inode = null;
            size = 0;
            return true;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }    
    }

    //OK!
    @Override
    public boolean isEmpty() {
        return head == null && size() == 0;    
    }

    //OK!
    @Override
    public boolean reverse() {
        try {
            if (isEmpty() || size == 1) {
                return true;
            }

            LinkedNode<E> prev = tail;
            LinkedNode<E> inode = head;
            LinkedNode<E> next = null;

            do {
                next = inode.getNext();
                inode.setNext(inode.getPrev());
                inode.setPrev(next);
                prev = inode;
                inode = next;
            } 
            while (inode != head);

            head = tail;
            tail = prev;

            return true;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    //OK!
    @Override
    public int size() {
        return getSize();
    }

    //OK!
    @Override
    public Iterator<E> iterator() {
        if(size()==1){
    
            return new Iterator<E>() {
                LinkedNode<E> inode = head;
                boolean hasNext = true;
               
            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in the list");
                }
                E element = inode.get();
                inode = inode.getNext();
                hasNext = false;
                return element;
            }
    
            @Override
            public void remove() {
                throw new UnsupportedOperationException("Unimplemented method 'remove'");
            }
        };
        
        }
            return new Iterator<E>() {
            LinkedNode<E> inode = head;

            @Override
            public boolean hasNext() {
                return inode != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in the list");
                }
                E element = inode.get();
                inode = inode.getNext();
                if (inode == head) {// si llega a la cabeza para por circular
                    inode = null;
                }
                return element;
            }
    
            @Override
            public void remove() {
                throw new UnsupportedOperationException("no necesario en la implementacion de esta lista");
            }
        };
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<E> iterator = iterator();
        if (iterator.hasNext()) {
            E element = iterator.next();
            sb.append(element.toString());
        }
        while (iterator.hasNext()) {
            E element = iterator.next();
            sb.append(", ");
            sb.append(element.toString());
        }
        sb.append("]");
        return sb.toString();
    }
    
}