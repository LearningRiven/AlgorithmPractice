package org.algomonster.datastructures.linkedlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    public void testAddingFirstAndSizeString(){
        LinkedList<String> list = new LinkedList<String>();

        //Empty
        assertEquals(0,list.size());
        assertEquals("null",list.toString(),"List state no elements");

        list.addFirst("Apple");
        assertEquals(1,list.size());
        assertEquals("{Apple} -> null", list.toString(),"List state 1 element");

        list.addFirst("Orange");
        assertEquals(2,list.size());
        assertEquals("{Orange} -> {Apple} -> null",list.toString(),"List state 2 elements");
    }

    @Test
    public void testAddingLastAndSizeString(){
        LinkedList<String> list = new LinkedList<String>();

        //Empty
        assertEquals(0,list.size(),"List size no elements");
        assertEquals("null",list.toString(),"List state no elements");

        list.addLast("Apple");
        assertEquals(1,list.size(),"List size 1 element");
        assertEquals("{Apple} -> null", list.toString(),"List state 1 element");

        list.addLast("Orange");
        assertEquals(2,list.size(),"List size 2 elements");
        assertEquals("{Apple} -> {Orange} -> null",list.toString(),"List state 2 elements");
    }

    @Test
    public void testRemovingFirstAndSizeStringSingleElement(){
        String data;

        LinkedList<String> list = new LinkedList<String>();
        assertEquals("null",list.toString(),"Initialized List Contents");
        list.addLast("Orange");

        data = list.removeFirst();
        assertEquals("Orange",data,"Test removing first: Orange");
        assertEquals(0,list.size(),"List size no elements");
        assertEquals("null", list.toString(),"List state no elements");
    }

    @Test
    public void testRemovingFirstAndSizeStringTwoElements(){
        String data;

        LinkedList<String> list = new LinkedList<String>();
        assertEquals("null",list.toString(),"Initialized List Contents");

        list.addLast("Orange");
        list.addLast("Apple");

        data = list.removeFirst();
        assertEquals("Orange",data,"Test removing first: Orange");
        assertEquals(1,list.size(),"List size 1 element");
        assertEquals("{Apple} -> null", list.toString(),"List state 1 element");

        data = list.removeFirst();
        assertEquals("Apple",data,"Test removing first: Apple");
        assertEquals(0,list.size(),"List size no elements");
        assertEquals("null", list.toString(),"List state no elements");
    }

    @Test
    public void testRemovingFirstAndSizeStringThreeElements(){
        String data;

        LinkedList<String> list = new LinkedList<String>();
        assertEquals("null",list.toString(),"Initialized List Contents");

        list.addLast("Orange");
        list.addLast("Apple");
        list.addLast("Cherry");

        data = list.removeFirst();
        assertEquals("Orange",data,"Test removing: Orange");
        assertEquals(2,list.size(),"List size 2 elements");
        assertEquals("{Apple} -> {Cherry} -> null",list.toString(),"List state 2 elements");

        data = list.removeFirst();
        assertEquals("Apple",data,"Test removing: Apple");
        assertEquals(1,list.size(),"List size 1 element");
        assertEquals("{Cherry} -> null", list.toString(),"List state 1 element");

        data = list.removeFirst();
        assertEquals("Cherry",data,"Test removing: Cherry");
        assertEquals(0,list.size(),"List size no elements");
        assertEquals("null", list.toString(),"List state no elements");
    }

    @Test
    public void testRemovingLastAndSizeStringSingleElement(){
        String data;

        LinkedList<String> list = new LinkedList<String>();
        assertEquals("null",list.toString(),"Initialized List Contents");
        list.addLast("Orange");

        data = list.removeLast();
        assertEquals("Orange",data,"Test removing last: Orange");
        assertEquals(0,list.size(),"List size no elements");
        assertEquals("null", list.toString(),"List state no elements");
    }

    @Test
    public void testRemovingLastAndSizeStringTwoElements(){
        String data;

        LinkedList<String> list = new LinkedList<String>();
        assertEquals("null",list.toString(),"Initialized List Contents");

        list.addLast("Orange");
        list.addLast("Apple");

        data = list.removeLast();
        assertEquals("Apple",data,"Test removing last: Apple");
        assertEquals(1,list.size(),"List size 1 element");
        assertEquals("{Orange} -> null", list.toString(),"List state 1 element");

        data = list.removeLast();
        assertEquals("Orange",data,"Test removing last: Orange");
        assertEquals(0,list.size(),"List size no elements");
        assertEquals("null", list.toString(),"List state no elements");
    }

    @Test
    public void testRemovingLastAndSizeStringThreeElements(){
        String data;

        LinkedList<String> list = new LinkedList<String>();
        assertEquals("null",list.toString(),"Initialized List Contents");

        list.addLast("Orange");
        list.addLast("Apple");
        list.addLast("Cherry");

        data = list.removeLast();
        assertEquals("Cherry",data,"Test removing last: Cherry");
        assertEquals(2,list.size(),"List size 2 elements");
        assertEquals("{Orange} -> {Apple} -> null",list.toString(),"List state 2 elements");

        data = list.removeLast();
        assertEquals("Apple",data,"Test removing last: Apple");
        assertEquals(1,list.size(),"List size 1 element");
        assertEquals("{Orange} -> null", list.toString(),"List state 1 element");

        data = list.removeLast();
        assertEquals("Orange",data,"Test removing last: Orange");
        assertEquals(0,list.size(),"List size no elements");
        assertEquals("null", list.toString(),"List state no elements");
    }

    @Test
    public void testSize(){
        LinkedList<String> list = new LinkedList<String>();

        assertEquals(0,list.size(),"Empty");
        list.addLast("Apple");
        assertEquals(1,list.size(),"1");
        list.addLast("Apple");
        assertEquals(2,list.size(),"2");
        list.addLast("Apple");
        assertEquals(3,list.size(),"3");
        list.removeLast();
        assertEquals(2,list.size(),"2");
        list.removeLast();
        assertEquals(1,list.size(),"1");
        list.removeLast();
        assertEquals(0,list.size(),"0");
    }

    @Test
    public void testExceptionHandling(){
        LinkedList<String> list = new LinkedList<String>();
        assertThrows(IllegalStateException.class,list::removeFirst, "removeFirst on empty throws");
        assertThrows(IllegalStateException.class,list::removeLast, "removeLast on empty throws");
    }
}
