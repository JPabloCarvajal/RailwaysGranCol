package jp.linkedlist.node.doubly;

import jp.util.node.AbstractNode;

public class LinkedNode<E> extends AbstractNode<E>{
    
    public LinkedNode<E> next;
    public LinkedNode<E> prev;

    public LinkedNode() {
        super();
        this.next = null;
        this.prev = null;
    }
 
    public LinkedNode(E element) {
        super(element);
        this.next = null;
        this.prev = null;
    }

    public void setNext(LinkedNode<E> next) {
        this.next = next;
    }

    public LinkedNode<E> getNext() {
        return next;
    }

    public LinkedNode<E> getPrev() {
        return prev;
    }

    public void setPrev(LinkedNode<E> prev) {
        this.prev = prev;
    }
}
