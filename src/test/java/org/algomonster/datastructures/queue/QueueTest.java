package org.algomonster.datastructures.queue;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void testNull(){
        Queue<String> queue = new Queue<String>();
        assertThrows(NoSuchElementException.class,queue::dequeue, "Queue is empty");
        assertThrows(NoSuchElementException.class,queue::peek, "Queue is empty");
        assertEquals(0,queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testQueue(){
        Queue<String> queue = new Queue<String>();

        //One element, peek
        queue.enqueue("Apple");
        assertEquals("Apple",queue.peek());
        assertEquals(1,queue.size());
        assertFalse(queue.isEmpty());

        //Remove the element
        assertEquals("Apple",queue.dequeue());
        assertEquals(0,queue.size());
        assertTrue(queue.isEmpty());
        //Make sure we handle nulls still
        assertThrows(NoSuchElementException.class,queue::dequeue, "Queue is empty");
        assertThrows(NoSuchElementException.class,queue::peek, "Queue is empty");

        //Add multiple elements to make sure the order is correct when dequeueping
        queue.enqueue("Apple");
        queue.enqueue("Orange");
        queue.enqueue("Cherry");
        queue.enqueue("Lemon");
        queue.enqueue("Lime");
        assertEquals(5,queue.size());
        assertEquals("Apple",queue.peek());
        assertFalse(queue.isEmpty());
        assertEquals("Apple",queue.dequeue());
        assertEquals(4,queue.size());
        assertEquals("Orange",queue.dequeue());
        assertEquals(3,queue.size());
        assertEquals("Cherry",queue.dequeue());
        assertEquals(2,queue.size());
        assertEquals("Lemon",queue.dequeue());
        assertEquals(1,queue.size());
        assertEquals("Lime",queue.dequeue());
        assertEquals(0,queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testDequeueLastElement(){
        Queue<String> queue = new Queue<String>();
        queue.enqueue("Banana");
        assertEquals("Banana", queue.peek());
        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());
        assertEquals("Banana", queue.dequeue());
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

}
