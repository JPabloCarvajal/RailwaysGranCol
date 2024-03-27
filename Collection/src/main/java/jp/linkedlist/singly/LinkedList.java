package jp.linkedlist.singly;

import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import jp.util.collection.Collection;
import jp.util.list.AbstractList;
import jp.util.list.List;
import jp.linkedlist.node.singly.LinkedNode;
import jp.util.iterator.Iterator;

public class LinkedList<E> extends AbstractList<E>{
    
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
        LinkedNode<E> node = new LinkedNode<>(element);        
        if(isEmpty()){
            head = node;
            tail = node;  
        }
        else{
            node.set(element);
            tail.setNext(node);
            tail= node;
        }
        size++;
        return true;
    }
    catch(Exception e){
        System.err.println(e.getMessage());
    }
    return false;
    }
    
    //OK! //AbstractList
    // public boolean add(E[] elements)
 
    //OK! //AbstractList
    // public boolean add(Collection<E> collection) 

    //OK!
    @Override
    public boolean addFirst(E element){
        try {
            LinkedNode<E> node = new LinkedNode<>(element);
            if (isEmpty()) {
                head = node;
                tail = node;          
            } 
            else {
                node.set(element);
                node.setNext(head);
                head = node;
            }
            size++;
            return true;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    //OK!
    //public boolean addFirst(E[] elements)

    //OK!
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
    public E peekLast(){
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
    //public E[] peekArray(int n)

    //OK!
    //public E[] peekLastArray(int n)

    //okk
    @Override
    public List<E> peekCollection(int n){
        try {
            if (isEmpty() || n <= 0) {
                return new LinkedList<>();
            }    
            if (n > size) {
                n = size;
            }
            List<E> collection = new LinkedList<>();
            Iterator<E> iterator = iterator();

            int cnt = 0;
            while (iterator.hasNext() && cnt < n) {
                E element = iterator.next();
                collection.add(element);
                cnt++;
            }
            return collection;       
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    //okk
    @Override
    public List<E> peekLastCollection(int n) {        
        if (isEmpty() || n <= 0) {
            return new LinkedList<>();
        }    
        if (n > size) {
            n = size;
        }
        List<E> List = new LinkedList<>();
        Iterator<E> iterator = this.iterator();
        int num=0;
        while (iterator.hasNext()) {
            if ( num >= size - n) {
                E element = iterator.next();
                List.add(element);
            } 
            else{
                iterator.next();
            }
            num++;
        }
        return List;
    }

    //OK!
    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        E element = peek();
        remove(element);
        return element;
    }

    //OK!
    @Override
    public E pollLast() {
        try {
            if (isEmpty()) {
                return null;
            }
            if (size == 1) {
                E element = tail.get();
                head = null;
                tail = null;
                size--;
                return element;
            } else {
                E element = tail.get();
                inode = head;
                while (inode.getNext() != tail) {
                    inode = inode.getNext();
                }
                tail = inode;
                tail.setNext(null);
                size--;
                return element;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    //OK!
    //public E[] pollArray(int n)
    
    //OK!
    //public E[] pollLastArray(int n) 
    
    //not sure pero revisar!!! 
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
                collection.add(poll());
            }
            return collection;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    //not sure pero revisar!!! 
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
            LinkedNode<E> previous = null;
            while (inode != null) {
                if (element.equals(inode.get())) {
                    if (previous == null) {
                        head = inode.getNext();
                        if (head == null) {
                            tail = null;
                        }
                    } 
                    else {
                        previous.setNext(inode.getNext());
                        if (inode.getNext() == null) {
                            tail = previous;
                        }
                    }
                    size--;
                    return true;
                }
                previous = inode;
                inode = inode.getNext();
            }
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    //OK!
    //public boolean remove(E[] elements)

    //OK!
    //public boolean remove(Collection<E> collection)

    //OK!
    @Override
    public boolean remove(Predicate<E> filter) {
        try {
            if (isEmpty() || filter == null) {
                return false;
            }
            LinkedNode<E> inode = head;
            LinkedNode<E> previous = null;
            boolean removed = false;
            while (inode != null) {
                if (filter.test(inode.get())) {
                    if (previous == null) {
                        head = inode.getNext();
                        if (head == null) {
                            tail = null;
                        }
                    } 
                    else {
                        previous.setNext(inode.getNext());
                        if (inode.getNext() == null) {
                            tail = previous;
                        }
                    }
                    size--;
                    removed = true;
                } 
                else {
                    previous = inode;
                }
                inode = inode.getNext();
            }
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
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    //OK!
    @Override
    public boolean replace(E[] array, E[] newArray, Predicate<E> comparator) {
        try {
            int newArraySizeLimit = array.length;
            boolean replaced = true;
            if (array.length > newArray.length) {
                newArraySizeLimit = newArray.length;
                replaced = false;
            }
            for (int i = 0; i < newArraySizeLimit; i++) {
                if (!replace(array[i], newArray[i], comparator)) {
                    replaced = false;
                } 
            }
            return replaced;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    //okk preguntarrr
    @Override
    public boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator) {
        try {
            int CollectionSizeLimit = collection.size();
            boolean replaced = true;
            if (collection.size() < newCollection.size()) {
                replaced = false;
                CollectionSizeLimit = newCollection.size();
            }
            Iterator<E> iterator = collection.iterator();
            Iterator<E> SecondIterator = newCollection.iterator();
            for (int ii = 0; ii < CollectionSizeLimit; ii++) {
                if (!replace(iterator.next(), SecondIterator.next(), comparator)) {
                    replaced = false;
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
                        break; // rompe para que solo se agregue 1 vez xd
                    }
                }
                inode = inode.getNext();
            } 
            while (inode != null);

            head = retainedList.head;
            size = retainedList.size;
            return true;
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    //revisar!!!!!
    @Override
    public boolean retain(Collection<E> collection) {
        try{
            inode = head;
            LinkedList<E> retain = new LinkedList<>();
            while (inode != null) {
                Iterator<E> iterator = collection.iterator();
                while (iterator.hasNext()) {
                    E element = iterator.next();
                    if (inode.get().equals(element)) {
                        retain.add(element);
                    }
                }
                inode = inode.getNext();
            }
            head = retain.head;
            tail = retain.tail;
            size = retain.size;
            return contains(collection);
        }
        catch(Exception e){
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
                    next.setNext(inode);

                    prev = next;
                    next = inode.getNext();

                    swapped = true;
                } 
                else {
                    prev = inode;
                    inode = next;
                    next = next.getNext();
                }
            }
        } 
        while (swapped);
        tail = head;
        while (tail.getNext() != null) {
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
            while (iterator.hasNext()) {
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
            }
            return subList;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    //OK!
    //public E[] toArray()

    //OK!
    @Override
    public boolean isEmpty(){
        return size()==0;
    }

    //Lenin ok!
    @Override
    public Iterator<E> iterator() {
        inode = head;
        return new Iterator<E>() {
            private LinkedNode<E> prev = null;
            private LinkedNode<E> current = head;
    
            @Override
            public boolean hasNext() {
                return inode!=null;
            }

            @Override
            public E next(){
            if(!hasNext()){
                throw new NoSuchElementException("No more elements in the list ");
            }
                E element = inode.get();
                inode = inode.getNext();
                return element; 
            }

            @Override
            public void remove() {
                if (prev == null) {
                    head = head.getNext();
                    if (head == null) {
                        tail = null;
                    }
                } else {
                    prev.setNext(current);
                    if (current == null) {
                        tail = prev;
                    }
                }
                size--;
            }
        };
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
    //public boolean contains(E element)
    
    //OK!
    //public boolean contains(E[] array) 

    //nn
    //public boolean contains(Collection<E> collection)
    
    //OK!
    @Override
    public boolean reverse() {
        try{
            if (isEmpty() || size == 1) {
                return true;
            }
            LinkedNode<E> prev = null;
            LinkedNode<E> current = head;
            LinkedNode<E> next = null;
            while (current != null) {
                next = current.getNext();
                current.setNext(prev);
                prev = current;
                current = next;
            }
            LinkedNode<E> temp = head;
            head = tail;
            tail = temp;
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
    //public void forEach(Function<E, Void> action)

    //agregado nuevo
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        LinkedNode<E> inode = head;
        for (int i = 0; i < index; i++) {
            inode = inode.getNext();
        }
        return inode.get();
    }

    public int indexOf(E element) {
        int index = 0;
        LinkedNode<E> current = head;
        
        while (current != null) {
            if (current.get().equals(element)) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        
        return -1;
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

    
