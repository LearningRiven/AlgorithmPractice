package org.algomonster.datastructures.stack;

import org.algomonster.datastructures.Node;

import java.util.NoSuchElementException;

public class Stack<T> {

    private Node<T> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(T item){
        Node<T> node = new Node<>(item);
        node.setNext(this.top);
        this.top = node;
        this.size++;
    }

    public T pop(){
        if(size == 0){
            throw new NoSuchElementException("Stack is empty");
        }

        Node<T> next = top.getNext();
        T data = top.getData();
        this.top = next;
        this.size--;

        return data;
    }

    public T peek(){
        if(this.size == 0){
            throw new NoSuchElementException("Stack is empty");
        }

        return this.top.getData();
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }
}