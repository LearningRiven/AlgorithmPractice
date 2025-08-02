package org.algomonster.datastructures.map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.algomonster.datastructures.Node;

class HashMapTest {

    @Test
    void testMapEntryEquals() {
        HashMap.MapEntry<String, Integer> entry1 = new HashMap.MapEntry<>("key", 1);
        HashMap.MapEntry<String, Integer> entry2 = new HashMap.MapEntry<>("key", 1);
        HashMap.MapEntry<String, Integer> entry3 = new HashMap.MapEntry<>("diff", 2);
        HashMap.MapEntry<String, Integer> nullKey = new HashMap.MapEntry<>(null, 1);
        HashMap.MapEntry<String, Integer> nullValue = new HashMap.MapEntry<>("key", null);

        // Reflexive
        assertEquals(entry1, entry1);

        // Symmetric
        assertEquals(entry1, entry2);
        assertEquals(entry2, entry1);

        // Transitive (via equals)
        HashMap.MapEntry<String, Integer> entry4 = new HashMap.MapEntry<>("key", 1);
        assertEquals(entry1, entry4);
        assertEquals(entry2, entry4);

        // Not equal
        assertNotEquals(entry1, entry3);
        assertNotEquals(entry1, nullKey);
        assertNotEquals(entry1, nullValue);
        assertNotEquals(nullKey, nullValue);

        // Null handling
        assertNotEquals(entry1, null);
        assertEquals(nullKey, new HashMap.MapEntry<>(null, 1)); // Same null key, same value
        assertNotEquals(nullKey, new HashMap.MapEntry<>(null, 2)); // Diff value
    }

    @Test
    void testMapEntryHashCode() {
        HashMap.MapEntry<String, Integer> entry1 = new HashMap.MapEntry<>("key", 1);
        HashMap.MapEntry<String, Integer> entry2 = new HashMap.MapEntry<>("key", 1);
        HashMap.MapEntry<String, Integer> nullKey = new HashMap.MapEntry<>(null, 1);
        HashMap.MapEntry<String, Integer> nullValue = new HashMap.MapEntry<>("key", null);

        // Consistent with equals
        assertEquals(entry1.hashCode(), entry2.hashCode());

        // Null handling
        assertEquals(31 * 0 + (nullKey == null ? 0 : nullKey.hashCode()), nullKey.hashCode()); // 0 for null key + value hash
        assertEquals(31 * "key".hashCode() + (null == null ? 0 : nullKey.hashCode()), nullValue.hashCode()); // key hash * 31 + 0 for null value

        // Changes affect hash
        assertNotEquals(entry1.hashCode(), new HashMap.MapEntry<>("diff", 1).hashCode());
        assertNotEquals(entry1.hashCode(), new HashMap.MapEntry<>("key", 2).hashCode());
    }

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

        //Make sure if conditions are hit correctly
        // Identity vs equals
        String key1 = new String("test"); // New object
        String key2 = new String("test"); // Separate but equals(true)
        map.put(key1, 10);
        assertEquals(10, map.get(key1)); // Hits == (same object)
        assertEquals(10, map.get(key2)); // Hits equals (different object)

        // Null key
        map.put(null, 20);
        assertEquals(20, map.get(null)); // Hits key == null branch
    }

    @Test
    //Tests how null values are handled with put and get as well as size
    void testPutGetContainsNull(){
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

        //Test overwrite
        map.put(null,4);
        assertEquals(4,map.get(null));
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

        //Manually empty the rest of the map to make sure no negative size
        Integer sixtyFour = map.remove(64);
        Integer sixteen = map.remove(16);
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        map.remove(0);
        map.remove(16);
        map.remove(32);
        map.remove(64);
        map.remove(80);
        map.remove(1);
        map.remove(17);
        assertEquals(0,map.size());
        assertTrue(map.isEmpty());

        // Remove null from middle of chain
        map.put(0, 0); // Index 0
        map.put(16, 16); // Collides at 0
        map.put(null, null); // Fixed at 0, add to chain
        assertEquals(null, map.remove(null)); // Remove middle (assuming order)
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

        //Test contains
        map.put(null,5);
        assertTrue(map.containsKey(null));
        assertFalse(map.containsKey("blah"));
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

    @Test
    void testClearLarge(){
        HashMap<String,Integer> map = new HashMap<>();
        for(int j = 0; j < 50; j++){
            map.put("key " + j, j);
        }

        assertEquals(50, map.size());
        assertNull(map.get("key 100")); // Spotcheck non existant
        map.clear();
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        assertNull(map.get("key 0")); // Spot-check a few
        assertNull(map.get("key 3")); // Spot-check a few
    }

    @Test
    void testGeneric(){
        HashMap<Integer,Node<Integer>> map = new HashMap<>();
        Node<Integer> one = new Node<Integer>(1);
        Node<Integer> two = new Node<Integer>(2);
        Node<Integer> three = new Node<Integer>(3);

        map.put(1,one);
        map.put(2,two);
        map.put(3,three);

        assertEquals(3,map.size());
        assertFalse(map.isEmpty());

        assertEquals(one, map.get(1));
        assertEquals(3, map.size());
        assertEquals(two, map.remove(2));
        assertEquals(2, map.size());
        assertTrue(map.containsKey(3));
        assertFalse(map.isEmpty());
    }

    @Test
    void testResizing(){
        HashMap<String, Integer> map = new HashMap<>();

        // Verify initial state
        assertEquals(16, map.getCapacity()); // INITIAL_CAPACITY
        assertEquals(0, map.size());

        // Insert up to threshold (12 elements for 16*0.75=12)
        for (int i = 0; i < 12; i++) {
            map.put("key" + i, i);
        }
        assertEquals(12, map.size());
        assertEquals(16, map.getCapacity()); // No resize yet

        // Insert one more to trigger resize (13 > 12)
        map.put("key12", 12);
        assertEquals(13, map.size());
        assertEquals(32, map.getCapacity()); // Should double to 32

        // Verify all elements are still accessible post-resize
        for (int i = 0; i < 13; i++) {
            assertEquals(i, map.get("key" + i));
        }

        // Edge case: Add null key before/after resize
        map.put(null, -1);
        assertEquals(14, map.size());
        assertEquals(32, map.getCapacity()); // No further resize yet
        assertEquals(-1, map.get(null));

        // Force another resize (insert up to 25 for 32*0.75=24)
        for (int i = 13; i < 25; i++) {
            map.put("key" + i, i);
        }
        assertEquals(26, map.size()); // 14 previous + 12 new = 26
        assertEquals(64, map.getCapacity()); // Doubled again

        // Collision during resize: Use keys with same hash (like "Aa" and "BB")
        map.put("Aa", 100);
        map.put("BB", 200);
        assertEquals(100, map.get("Aa"));
        assertEquals(200, map.get("BB"));
    }

    @Test
    void testLargeInserts(){
        HashMap<Integer, String> map = new HashMap<>();

        // Insert 1000 elements (will trigger multiple resizes)
        int numInserts = 1000;
        for (int i = 0; i < numInserts; i++) {
            map.put(i, "value" + i);
        }
        assertEquals(numInserts, map.size());
        assertTrue(map.getCapacity() >= 1024); // After multiple doubles (16->32->64->128->256->512->1024)

        // Verify retrieval and contains (spot-check 10%)
        for (int i = 0; i < numInserts; i += 10) {
            assertTrue(map.containsKey(i));
            assertEquals("value" + i, map.get(i));
        }
        assertFalse(map.containsKey(numInserts + 1)); // Non-existent

        // Overwrites in large set
        map.put(500, "overwritten");
        assertEquals("overwritten", map.get(500));
        assertEquals(numInserts, map.size()); // Size unchanged

        // Null handling in large set
        map.put(null, "nullValue");
        map.put(1001, null);
        assertEquals(numInserts + 2, map.size()); // Only +1 for null key
        assertEquals("nullValue", map.get(null));
        assertNull(map.get(1001));

        // Removals in large set
        for (int i = 0; i < 100; i += 2) { // Remove evens
            assertEquals("value" + i, map.remove(i));
        }
        assertEquals(numInserts + 2 - 50, map.size()); // Removed 50
        assertNull(map.get(0)); // Spot-check removal

        // Collision stress: Insert many with same hash bucket
        // Assuming simple hash, but for test, use keys like multiples of 16 (index 0)
        for (int i = 0; i < 50; i++) {
            map.put(i * 16, "collision" + i);
        }
        for (int i = 0; i < 50; i += 5) {
            assertEquals("collision" + i, map.get(i * 16));
        }
    }
}
