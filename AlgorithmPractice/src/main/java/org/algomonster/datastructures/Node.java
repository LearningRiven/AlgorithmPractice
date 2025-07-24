package org.algomonster.datastructures;

/**
 * Generic Node Class for single pointed Nodes
 * @param <T>
 */
public class Node<T> {
    private Node<T> next;
    private T data;

    public Node(T data){
        this.next = null;
        this.data = data;
    }

    public Node(T data, Node<T> next){
        this.next = next;
        this.data = data;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public void setData(T data){
        this.data = data;
    }

    public Node<T> getNext(){
        return this.next;
    }

    public T getData(){
        return this.data;
    }

    @Override
    public String toString(){
        return "{" + data + "}";
    }
}
