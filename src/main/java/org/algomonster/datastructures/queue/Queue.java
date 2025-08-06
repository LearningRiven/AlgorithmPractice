package org.algomonster.datastructures.queue;

import org.algomonster.datastructures.Node;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void enqueue(T item){
        Node<T> node = new Node<T>(item);

        //add to tail
        if(this.tail != null){
            this.tail.setNext(node);
        }
        this.tail = node;

        //make head if first element
        if(this.size == 0) {
            this.head = node;
        }

        this.size++;
    }

    public T dequeue(){
        if(this.size == 0){
            throw new NoSuchElementException("Queue is empty");
        }

        //Take the head
        Node<T> curHead = this.head;

        //If there is a next element, make it the new head
        this.head = head.getNext();

        //Handle the last element
        if(this.head == null){
            this.tail = null;
        }
        //subtract the size
        this.size--;

        return curHead.getData();
    }

    public T peek(){
        if(this.size == 0){
            throw new NoSuchElementException("Queue is empty");
        }

        return this.head.getData();
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }
}
