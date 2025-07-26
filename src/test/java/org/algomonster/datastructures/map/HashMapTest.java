package org.algomonster.datastructures.map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    @Test
    //Tests the initial state of the map
    void testInitialization(){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        assertNotNull(map);
        assertTrue(map.isEmpty());
        assertEquals(0,map.size());
    }

    @Test
    //Tests both put and get as well as size
    void testPutGetInsert(){
        HashMap<String,Integer> map = new HashMap<String,Integer>();

        //Single Insert
        map.put("first",1);
        assertEquals(1, map.size());
        assertFalse(map.isEmpty());
        assertEquals(1,map.get("first"));

        //Adding different entry
        map.put("second",2);
        assertEquals(2, map.size());
        assertFalse(map.isEmpty());
        assertEquals(2,map.get("second"));
    }

    @Test
    //Tests how overwriting works with put and get as well as size
    void testPutGetOverwrite(){
        HashMap<String,Integer> map = new HashMap<String,Integer>();

        //Single Insert
        map.put("first",1);
        assertEquals(1, map.size());
        assertFalse(map.isEmpty());
        assertEquals(1,map.get("first"));

        //Adding different entry
        map.put("first",2);
        assertEquals(1, map.size());
        assertFalse(map.isEmpty());
        assertEquals(1,map.get("first"));
    }

    @Test
    //Tests how null values are handled with put and get as well as size
    void testPutGetNull(){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("first",null);

        assertNull(map.get("second"));
        assertTrue(map.containsKey("first"));
        assertNull(map.get("first"));
        assertEquals(1,map.size());
    }

    @Test
    //Tests how collisions work with put and get as well as size
    void testPutCollisions(){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        assertTrue(false); //Place holder
    }

    @Test
    //Tests removing, handles null and missing as well as size changes
    void testRemove(){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("first",1);
        map.put("second",2);

        //Initial state
        assertEquals(2, map.size());
        assertNotNull(map.get("first"));
        assertNotNull(map.get("second"));

        //Test removing
        assertEquals(2, map.remove("second"));
        assertEquals(1, map.size());

        //Test removing null
        assertNull(map.remove("second"));
        assertEquals(1, map.size());
    }

    @Test
    //Tests checking whether a map contains a key or not
    void testContains(){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("first",1);
        map.put("second",2);
        map.put("third",3);

        //Test whether it finds a key in the map
        assertTrue(map.containsKey("first"));
        assertEquals(1, map.get("first"));

        //Test whether it handles not finding the key correctly
        assertFalse(map.containsKey("fourth"));
        assertNull(map.get("fourth"));

        //Test the size
        assertEquals(3,map.size());
    }

    @Test
    //Tests whether clear returns to the initial state of the map
    void testClear(){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("first",1);
        map.put("second",2);
        map.put("third",3);

        //Initial state is populated
        assertNotNull(map);
        assertEquals(3, map.size());
        assertFalse(map.isEmpty());

        map.clear();

        //After clear is empty
        assertNotNull(map);
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }
}
