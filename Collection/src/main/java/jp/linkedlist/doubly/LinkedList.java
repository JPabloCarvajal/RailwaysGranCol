package jp.linkedlist.doubly;

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
            node.set(element);

            if(isEmpty()){
                tail = node;
                head = node;
                
            }else{
                tail.setNext(node);
                node.setPrev(tail);
                tail = node;
            }
            size++;
            return true;

        }
        catch(Exception e){
            return false;
        }
    }

    //OK! AbstractList
    //@Override
    //public boolean add(E[] elements) 

    //OK! AbstractList
    //@Override
    //public boolean add(Collection<E> collection) {

    //OK!  
    @Override
    public boolean addFirst(E element){
        try{
            LinkedNode<E> node = new LinkedNode<>();
            node.set(element);
            if(isEmpty()){
                tail = node;
                head = node;
            }
            else{
                head.setPrev(node);
                node.setNext(head);
                head = node;
            }
            size++;
            return true;

        }
        catch(Exception e){
            return false;
        }
    }

    //OK! AbstractList
    //@Override
    //public boolean addFirst(E[] elements) 
    

    //OK! AbstractList
    //@Override
    //public boolean addFirst(Collection<E> collection) 
    
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

    //OK! AbstractList
    //@SuppressWarnings("unchecked")
    //@Override
    //public E[] peekArray(int n)
    
    //OK! AbstractList
    //@SuppressWarnings("unchecked")
    //@Override
    //public E[] peekLastArray(int n) 

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
    public E poll() {
        try {
            if (isEmpty()) {
                return null;
            }
            E element = head.get();
            if (size() == 1) {
                head = null;
                tail = null;
            } 
            else {
                head = head.getNext();
                head.setPrev(null);
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
        try{
            if(isEmpty()){
                return null;
            }
            if(size() == 1){
                E element = head.get();
                head = null;
                tail = null;
                size--;
                return element;
            }
            if(size()>1){
                E element = tail.get();
                inode = head;
                while (!inode.getNext().equals(tail)) {
                    inode = inode.getNext();
                }
                tail = inode;
                tail.setNext(null);
                size--;
                return element;
            }
            return null;   
        }
        catch(Exception e){ 
            System.err.println(e.getMessage());
            return null;
        }
    }

    //OK! AbstractList
    //@SuppressWarnings("unchecked")
    //@Override
    //public E[] pollArray(int n) 

    //OK! AbstractList
    //@SuppressWarnings("unchecked")
    //@Override
    //public E[] pollLastArray(int n) 

    //revisar
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

    //revisar
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

    //OK!
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
                        } else {
                            next.setPrev(null);
                        }
                    } else if (inode.equals(tail)) {
                        tail = previous;
                        previous.setNext(null);
                    } else {
                        previous.setNext(next);
                        next.setPrev(previous);
                    }

                    size--;
                    return true;
                }

                inode = next;
            } 
            while (inode != null);

            return false;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    //OK! AbstractList
    //@Override
    //public boolean remove(E[] elements) {
    
    //OK! AbstractList
    //@Override
    //public boolean remove(Collection<E> collection) {
    
    //OK!!
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
                if (filter.test(inode.get())) {
                    if (previus == null) {
                        head = inode.getNext();
                        if (head == null) {
                            tail = null;
                        } 
                        else {
                            head.setPrev(null);
                        }
                    } 
                    else {
                        previus.setNext(inode.getNext());
                        if (inode.getNext() == null) {
                            tail = previus;
                        } 
                        else {
                            inode.getNext().setPrev(previus);
                        }
                    }
                    size--;
                    removed = true;
                } else {
                    previus = inode;
                }
                inode = inode.getNext();
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
            inode= head;
            boolean replaced = false;
            while (inode != null) {
                if (comparator.test(inode.get()) && inode.get().equals(element)) {
                    inode.set(newElement);
                    replaced = true;
                }
                inode = inode.getNext();
            }
            return replaced;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    //Revisar
    @Override
    public boolean replace(E[] elements, E[] newElements, Predicate<E> comparator){
        try {
            boolean rt = true;
            int limit = elements.length;
            if (elements.length > newElements.length) {
                limit = newElements.length;
                rt = false;
            }
            for (int ii = 0; ii < limit; ii++) {
                if (!replace(elements[ii], newElements[ii], comparator)) {
                    rt = false;// si no puede que retorne de una
                } 
            }
            return rt;
        } catch (Exception e) {
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
            LinkedList<E> rList = new LinkedList<>();
            do {
                for (int i = 0; i < elements.length; i++) {
                    if (inode.get().equals(elements[i])) {
                        rList.add(inode.get());
                        break; // Solo añadir una vez por elemento encontrado
                    }
                }
                inode = inode.getNext();
            } 
            while (inode != null);

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

    //revisar
    @Override
    public boolean retain(Collection<E> collection) {
        try {
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
            LinkedNode<E> inode = head;
            while (inode != null) {
                if ((inode.get() == null && element == null) ||
                    (inode.get() != null && inode.get().equals(element))) {
                    inode.set(newElement);
                    return true;
                }
                inode = inode.getNext();
            }
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
            LinkedNode<E> prev = null;
            LinkedNode<E> inode = head;
            LinkedNode<E> next = head.getNext();
            while (next != null) {
                if (comparator.applyAsInt(inode.get()) > comparator.applyAsInt(next.get())) {
                    if (prev != null) {
                        prev.setNext(next);
                    } else {
                        head = next;
                    }
                    inode.setNext(next.getNext());
                    next.setPrev(prev);

                    next.setNext(inode);
                    inode.setPrev(next);

                    prev = next;
                    next = inode.getNext();

                    swapped = true;
                } else {
                    prev = inode;
                    inode = next;
                    next = next.getNext();
                }
            }
        } 
        while (swapped);
        tail = head;
        //no estoy seguro de esta linea
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        return true;
    }

    //OK!
    @Override
    public List<E> subList(E from, E to) {
        try {
            LinkedNode<E> inode = head;

            // Encontrar el nodo de inicio
            while (inode != null && !((inode.get() == null && from == null) || (inode.get() != null && inode.get().equals(from)))) {
                inode = inode.getNext();
            }

            LinkedList<E> subList = new LinkedList<>();

            while (inode != null && !((inode.get() == null && to == null) || (inode.get() != null && inode.get().equals(to)))) {
                subList.add(inode.get());
                inode = inode.getNext();
            }

            if (inode != null) {
                subList.add(inode.get());
            }

            return subList;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    //OK! AbstractList
    //@Override
    //public E[] toArray() {
    

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

    //OK! AbstractList
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

    //OK! AbstractList 
    //@Override
    //public boolean contains(E[] array) 

    //OK! AbstractList
    //@Override
    //public boolean contains(Collection<E> collection) {
    

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

            LinkedNode<E> inode = head;
            LinkedNode<E> next = null;
            LinkedNode<E> temp = null;

            while (inode != null) {
                next = inode.getNext();
                inode.setNext(inode.getPrev());
                inode.setPrev(next);
                temp = inode;
                inode = next;
            }

            head = tail;
            tail = temp;
            return true;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    //OK
    @Override
    public int size() {
        return size;
    }

    //OK! AbstractList
    //@Override
    //public void forEach(Function<E, Void> action) 

     @Override
    public Iterator<E> iterator() {
         return new Iterator<E>() {
            LinkedNode<E> inode = head; 

            @Override
            public boolean hasNext() {

                return inode != null;
            }

            @Override
            public E next() {

                if(hasNext() == false){
                    throw new NoSuchElementException("No more elements in the list."); //check
                }
                E ret = inode.get();
                inode = inode.getNext();
                return ret;
            }

            @Override
            public void remove() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'remove'");
            }
            

        };
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();
            sb.append(element.toString());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}