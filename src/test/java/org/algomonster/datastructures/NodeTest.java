package org.algomonster.datastructures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    @Test
    public void testSetGetNext(){
        Node<String> n1 = new Node<>(null);
        Node<String> n2 = new Node<>(null);

        assertNull(n1.getData());
        assertNull(n2.getData());
        assertNull(n1.getNext());
        assertNull(n2.getNext());

        n1.setNext(n2);

        assertNull(n1.getData());
        assertNull(n2.getData());
        assertNotNull(n1.getNext());
        assertNull(n2.getNext());
    }

    @Test
    public void testSetGetData(){
        Node<String> n1 = new Node<String>(null);
        assertNull(n1.getData());
        n1.setData("test");
        assertNotNull(n1.getData());
        assertEquals("test",n1.getData());
    }

    @Test
    public void testNextConstructor(){
        Node<String> tail = new Node<String>("end");
        Node<String> head = new Node<String>("start",tail);
        assertEquals("start",head.getData());
        assertNotNull(head.getNext());
        assertEquals("end",head.getNext().getData());
    }

    @Test
    public void testToString(){
        Node<String> n1 = new Node<String>("test1");

        assertEquals("{test1}",n1.toString());

    }
}