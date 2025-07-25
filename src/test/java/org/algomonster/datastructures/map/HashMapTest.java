package org.algomonster.datastructures.map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    @Test
    //Tests the initial state of the map
    void testInitialization(){
        HashMap<String,Integer> map = new HashMap<>();
        assertNotNull(map);
        assertTrue(map.isEmpty());
        assertEquals(0,map.size());
    }

    @Test
    //Tests both put and get as well as size
    void testPutGetInsert(){
        HashMap<String,Integer> map = new HashMap<>();

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
        HashMap<String,Integer> map = new HashMap<>();

        //Single Insert
        map.put("first",1);
        assertEquals(1, map.size());
        assertFalse(map.isEmpty());
        assertEquals(1,map.get("first"));

        //Adding different entry
        map.put("first",2);
        assertEquals(1, map.size());
        assertFalse(map.isEmpty());
        assertEquals(2,map.get("first"));
    }

    @Test
    //Tests how null values are handled with put and get as well as size
    void testPutGetNull(){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("first",1);
        map.put("second",null);
        map.put(null,3);

        //Correct size
        assertEquals(3,map.size());

        //Structure
        assertNotNull(map.get("first"));
        assertNull(map.get("second"));
        assertNotNull(map.get(null));

        //Values
        assertEquals(1,map.get("first"));
        assertEquals(null,map.get("second"));
        assertEquals(3,map.get(null));
    }

    @Test
    //Tests how collisions work with put and get as well as size
    void testPutCollisions(){
        HashMap<String, Integer> map = new HashMap<>(); // Move to @BeforeEach later
        map.put("Aa", 1); //2112
        map.put("BB", 2); //2112

        // Verify the collision is handled correctly
        assertEquals(1, map.get("Aa"));
        assertEquals(2, map.get("BB"));
        assertEquals(2, map.size());

        // Remove from chain, verify that the bucket is updated correctly
        assertEquals(1, map.remove("Aa"));
        assertNull(map.get("Aa"));
        assertEquals(2, map.get("BB"));
        assertEquals(1, map.size());
    }

    @Test
    //Tests removing, handles null and missing as well as size changes
    void testRemove(){
        HashMap<Integer,Integer> map = new HashMap<>();

        //Test remove on empty hashmap
        assertEquals(0, map.size());
        assertNull(map.remove(0));
        assertEquals(0, map.size());

        //Test removing
        map.put(0,0);
        map.put(16,0);
        map.put(32,0);
        map.put(64,0);
        map.put(80,0);
        map.put(1,0);
        map.put(17,0);

        //Collisions at the start, map buckets are built backwards
        assertEquals(7, map.size());
        assertEquals(0,map.remove(80)); //remove the first element
        assertEquals(0,map.remove(0)); //remove the last element
        assertEquals(0,map.remove(32)); //remove the middle element
        assertEquals(4, map.size()); //verify only the right bucket was targeted
        //Empty a bucket
        assertEquals(0,map.remove(17));
        assertEquals(0,map.remove(1));
        assertEquals(2, map.size()); //verify size still good
    }

    @Test
    //Tests checking whether a map contains a key or not
    void testContains(){
        HashMap<String,Integer> map = new HashMap<>();
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
        HashMap<String,Integer> map = new HashMap<>();
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
