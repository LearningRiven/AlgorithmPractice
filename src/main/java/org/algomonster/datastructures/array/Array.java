package org.algomonster.datastructures.array;

import org.algomonster.datastructures.Node;

public class Array<T> {

    int size;
    Node<T> head;
    Node<T> tail;


    public Array(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public T getHead(){
        return this.head.getData();
    }

    public T getTail(){
        return this.tail.getData();
    }

    public void setHead(T data){
        this.head = new Node<>(data);
    }

    public void setTail(T data){
        this.tail = new Node<>(data);
    }

}
