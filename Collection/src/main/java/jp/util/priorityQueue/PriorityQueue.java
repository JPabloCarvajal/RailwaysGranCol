
package jp.util.priorityQueue;

import jp.util.queue.Queue;

public interface PriorityQueue<E> extends Queue<E>{
    
    public boolean insert(E element);
    public boolean insert(int index ,E element);
    
}
