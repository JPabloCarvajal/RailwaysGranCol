package jp.priorityQueue;

import java.util.NoSuchElementException;
import java.util.function.Function;
import jp.array.Array;
import jp.queue.list.QueueList;
import jp.util.collection.Collection;
import jp.util.iterator.Iterator;
import jp.util.priorityQueue.AbstractPriorityQueue;


public class PriorityQueue<E> extends AbstractPriorityQueue<E> {
    
    Array<QueueList<E>> priorityQueue;

    public PriorityQueue(int numPriorities){
        if (numPriorities <= 0) {
            numPriorities = 1;
        }
        priorityQueue = new Array<>(numPriorities);
        for (int i = 0; i < priorityQueue.lenght() ; i++) {
            this.priorityQueue.add(new QueueList<>());
        }
    }

    @Override
    public boolean clear(){
        try{
            for(int i=0; i<priorityQueue.lenght(); i++){
                priorityQueue.get(i).clear();
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean contains(E element){
        Iterator<E> iterator = this.iterator();
        while(iterator.hasNext()){
            if(iterator.next().equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E[] array){
        for (int i =0; i<array.length; i++) {
            if (!this.contains(array[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Collection<E> collection){
        Iterator<E> iterator = collection.iterator();
        while(iterator.hasNext()){
            if(!this.contains(iterator.next())){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty(){
        boolean empty = true;
        for(int i=0; i<priorityQueue.lenght(); i++){
            
            if(!priorityQueue.get(i).isEmpty()){
                empty = false;
            }
        }
        return empty;
    }

    @Override
    public boolean reverse(){
        try{
            boolean reversed = true;
            for(int i=0; i < priorityQueue.lenght(); i++){
                if(!priorityQueue.get(i).reverse()){
                    reversed = false;
                }
            }

            if(!priorityQueue.reverse()){
                reversed = false;
            }
            return reversed;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    //elsise de cada queuelist sumado total
    @Override
    public int size(){

        int size = 0;
        for(int i= 0; i < priorityQueue.lenght(); i++){
            size += priorityQueue.get(i).size();
        }
        return size;
    }

    @Override
    public void forEach(Function<E, Void> action){
        Iterator<E> iterator = this.iterator();
        while(iterator.hasNext()){
            action.apply(this.iterator().next());
        }
    }

    @Override
    public Iterator<E> iterator(){

        return new Iterator<E>(){
            int i = 0;
            QueueList<E> queueList = priorityQueue.get(i);
            Iterator<E> listIterator = queueList.iterator();

            @Override
            public boolean hasNext(){
                while(i<priorityQueue.lenght() && !listIterator.hasNext()){
                    queueList = priorityQueue.get(i);
                    listIterator = queueList.iterator();
                    i++;
                }
                return listIterator.hasNext();
            }

            @Override
            public E next(){
                if(!hasNext()){
                    throw new NoSuchElementException("No more elements in the list");
                }
                return listIterator.next();
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException("Not necessary in this collection");
            }
        };
    }

    @Override
    public boolean insert(E element){
        return insert(priorityQueue.lenght()-1, element);
    }

    @Override
    public boolean insert(int index,E element){
        try{
            if(index<0 || index>=priorityQueue.lenght()){
                index = priorityQueue.lenght()-1;
            }

            return priorityQueue.get(index).insert(element);
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }
    

    @Override
    public E peek(){
        try{
            for(int i=0; i<priorityQueue.lenght(); i++){
                if(!priorityQueue.get(i).isEmpty()){
                    return priorityQueue.get(i).peek();
                }
            }
            return null;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return null;   
        }
    }

    @Override
    public E extract() {
        try{
        for(int i=0; i<priorityQueue.lenght(); i++){

            if(!priorityQueue.get(i).isEmpty()){
                return priorityQueue.get(i).extract();
            }
        } 
        return null;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }  
     }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean firstQueue = true;
        for (int i = 0; i < priorityQueue.lenght(); i++) {
            QueueList<E> queue = priorityQueue.get(i);
            if (!queue.isEmpty()) {
                if (!firstQueue) {
                    sb.append(", ");
                }
                sb.append(queue.toString());
                firstQueue = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public String toStringh() {
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
