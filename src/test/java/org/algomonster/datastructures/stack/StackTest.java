package org.algomonster.datastructures.stack;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testNull(){
        Stack<String> stack = new Stack<String>();
        assertThrows(NoSuchElementException.class,stack::pop, "Stack is empty");
        assertThrows(NoSuchElementException.class,stack::peek, "Stack is empty");
        assertEquals(0,stack.size());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testStack(){
        Stack<String> stack = new Stack<String>();

        //One element, peek
        stack.push("Apple");
        assertEquals("Apple",stack.peek());
        assertEquals(1,stack.size());
        assertFalse(stack.isEmpty());

        //Remove the element
        assertEquals("Apple",stack.pop());
        assertEquals(0,stack.size());
        assertTrue(stack.isEmpty());
        //Make sure we handle nulls still
        assertThrows(NoSuchElementException.class,stack::pop, "Stack is empty");
        assertThrows(NoSuchElementException.class,stack::peek, "Stack is empty");

        //Add multiple elements to make sure the order is correct when popping
        stack.push("Apple");
        stack.push("Orange");
        stack.push("Cherry");
        stack.push("Lemon");
        stack.push("Lime");
        assertEquals(5,stack.size());
        assertEquals("Lime",stack.peek());
        assertFalse(stack.isEmpty());
        assertEquals("Lime",stack.pop());
        assertEquals(4,stack.size());
        assertEquals("Lemon",stack.pop());
        assertEquals(3,stack.size());
        assertEquals("Cherry",stack.pop());
        assertEquals(2,stack.size());
        assertEquals("Orange",stack.pop());
        assertEquals(1,stack.size());
        assertEquals("Apple",stack.pop());
        assertEquals(0,stack.size());
    }
}
