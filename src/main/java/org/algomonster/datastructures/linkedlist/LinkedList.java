package org.algomonster.datastructures.linkedlist;

import org.algomonster.datastructures.Node;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void addFirst(T data){
        //Create the new node
        Node<T> newNode = new Node<>(data);
        newNode.setNext(this.head);
        this.head = newNode;
        //Update size
        this.size++;
    }

    public void addLast(T data){
        //Create the new node
        Node<T> newNode = new Node<>(data);

        //Place it last
        Node<T> cur = this.head;

        //Handle empty case
        if(cur == null){
            this.head = newNode;
        }
        else{
            while(cur.getNext() != null){
                cur = cur.getNext();
            }

            cur.setNext(newNode);
        }
        this.size++;
    }

    public T removeFirst(){
        if (this.head == null) {
            throw new IllegalStateException("List is empty");
        }

        Node<T> curHead = this.head;
        this.head = curHead.getNext();
        this.size--;
        return curHead.getData();
    }

    public T removeLast(){
        if(this.head == null){
            throw new IllegalStateException("List is empty");
        }

        T data;
        if (head.getNext() == null) {
            data = head.getData();
            head = null;
        } else {
            Node<T> cur = head;
            while (cur.getNext().getNext() != null) {
                cur = cur.getNext();
            }
            data = cur.getNext().getData();
            cur.setNext(null);
        }

        size--;
        return data;
    }

    public int size(){
        return this.size;
    }

    @Override
    public String toString(){
        if(this.head == null){
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        Node<T> cur = this.head;

        sb.append(cur.toString());
        while(cur.getNext() != null){
            cur = cur.getNext();
            sb.append(" -> ").append(cur.toString());
        }

        sb.append(" -> null");

        return sb.toString();
    }
}
