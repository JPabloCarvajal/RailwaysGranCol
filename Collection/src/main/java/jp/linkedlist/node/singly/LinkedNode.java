package jp.linkedlist.node.singly;

import jp.util.node.AbstractNode;

public class LinkedNode<E> extends AbstractNode<E> {
    
    public LinkedNode<E> next;

    public LinkedNode() {
        super();
        this.next = null;
    }
 
    public LinkedNode(E element) {
        super(element);
        this.next = null;
    }

    public void setNext(LinkedNode<E> next) {
        this.next = next;
    }

    public LinkedNode<E> getNext() {
        return next;
    }


}
