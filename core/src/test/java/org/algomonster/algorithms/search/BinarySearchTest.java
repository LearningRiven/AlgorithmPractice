package org.algomonster.algorithms.search;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void testConstructor() throws NoSuchMethodException {
        Constructor<BinarySearch> constructor = BinarySearch.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }

    @Test
    void testBasicExample(){
        List<Integer> ordered = Arrays.asList(1,3,6,8,9,10);
        assertTrue(BinarySearch.searchListBinary(ordered,8, null).found());
        assertEquals(8,BinarySearch.searchListBinary(ordered,8, null).value());
    }

    @Test
    void testRegularSearchEven(){
        List<Integer> ordered = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        assertTrue(BinarySearch.searchListBinary(ordered,7,null).found());
        assertTrue(BinarySearch.searchListBinary(ordered,10,null).found());
        assertTrue(BinarySearch.searchListBinary(ordered,11,null).found());
        assertTrue(BinarySearch.searchListBinary(ordered,1,null).found());
        assertTrue(BinarySearch.searchListBinary(ordered,20,null).found());
        assertFalse(BinarySearch.searchListBinary(ordered,25,null).found());
        assertFalse(BinarySearch.searchListBinary(ordered,null,null).found());

        assertEquals(7,BinarySearch.searchListBinary(ordered,7,null).value());
        assertEquals(10,BinarySearch.searchListBinary(ordered,10,null).value());
        assertEquals(11,BinarySearch.searchListBinary(ordered,11,null).value());
        assertEquals(1,BinarySearch.searchListBinary(ordered,1,null).value());
        assertEquals(20,BinarySearch.searchListBinary(ordered,20,null).value());
        assertNull(BinarySearch.searchListBinary(ordered,25,null).value());
        assertNull(BinarySearch.searchListBinary(ordered,null,null).value());
    }

    @Test
    void testRegularSearchOdd(){
        List<Integer> ordered = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19);
        assertTrue(BinarySearch.searchListBinary(ordered,7,null).found());
        assertTrue(BinarySearch.searchListBinary(ordered,10,null).found());
        assertTrue(BinarySearch.searchListBinary(ordered,1,null).found());
        assertTrue(BinarySearch.searchListBinary(ordered,19,null).found());
        assertFalse(BinarySearch.searchListBinary(ordered,25,null).found());
        assertFalse(BinarySearch.searchListBinary(ordered,null,null).found());

        assertEquals(7,BinarySearch.searchListBinary(ordered,7,null).value());
        assertEquals(10,BinarySearch.searchListBinary(ordered,10,null).value());
        assertEquals(1,BinarySearch.searchListBinary(ordered,1,null).value());
        assertEquals(19,BinarySearch.searchListBinary(ordered,19,null).value());
        assertNull(BinarySearch.searchListBinary(ordered,25,null).value());
        assertNull(BinarySearch.searchListBinary(ordered,null,null).value());
    }

    @Test
    void testRegularSearchSingle(){
        List<Integer> ordered = List.of(1);
        assertFalse(BinarySearch.searchListBinary(ordered,7,null).found());
        assertFalse(BinarySearch.searchListBinary(ordered,null,null).found());
        assertTrue(BinarySearch.searchListBinary(ordered,1,null).found());

        assertNull(BinarySearch.searchListBinary(ordered,7,null).value());
        assertNull(BinarySearch.searchListBinary(ordered,null,null).value());
        assertEquals(1,BinarySearch.searchListBinary(ordered,1,null).value());
    }

    @Test
    void testRegularSearchNull(){
        List<Integer> ordered = Arrays.asList(null,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19);
        assertTrue(BinarySearch.searchListBinary(ordered,7,null).found());
        assertTrue(BinarySearch.searchListBinary(ordered,null,null).found());
        assertFalse(BinarySearch.searchListBinary(ordered,1,null).found());

        assertEquals(7,BinarySearch.searchListBinary(ordered,7,null).value());
        assertNull(BinarySearch.searchListBinary(ordered,null,null).value());
        assertNull(BinarySearch.searchListBinary(ordered,1,null).value());
    }

    @Test
    void testDuplicateValues(){
        List<Integer> ordered = Arrays.asList(null,null,3,4,5,6,7,7,9,10,11,12,13,14,15,16,17,18,19);
        assertTrue(BinarySearch.searchListBinary(ordered,7,null).found());
        assertTrue(BinarySearch.searchListBinary(ordered,null,null).found());
        assertFalse(BinarySearch.searchListBinary(ordered,1,null).found());

        assertEquals(7,BinarySearch.searchListBinary(ordered,7,null).value());
        assertNull(BinarySearch.searchListBinary(ordered,null,null).value());
        assertNull(BinarySearch.searchListBinary(ordered,1,null).value());
    }

    @Test
    void testEmpty(){
        List<Integer> ordered = new ArrayList<>();
        assertFalse(BinarySearch.searchListBinary(ordered,7,null).found());
        assertFalse(BinarySearch.searchListBinary(ordered,null,null).found());
        assertFalse(BinarySearch.searchListBinary(ordered,1,null).found());

        assertNull(BinarySearch.searchListBinary(ordered,7,null).value());
        assertNull(BinarySearch.searchListBinary(ordered,null,null).value());
        assertNull(BinarySearch.searchListBinary(ordered,1,null).value());
    }

    @Test
    void testNull(){
        List<Integer> ordered = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        assertThrows(IllegalStateException.class,() -> BinarySearch.searchListBinary(null,5, null), "List is null");
        assertThrows(IllegalStateException.class,() -> BinarySearch.searchListBinary(null,null, null), "List is null");
        assertFalse(BinarySearch.searchListBinary(ordered,null,null).found());
        assertNull(BinarySearch.searchListBinary(ordered,null,null).value());
    }

    @Test
    void testComparator(){
        List<String> ordered = Arrays.asList("apple", "banana", "cherry");
        // Natural
        assertTrue(BinarySearch.searchListBinary(ordered, "banana",null).found());
        assertEquals("banana",BinarySearch.searchListBinary(ordered, "banana",null).value());
        // Comparator (case-insensitive)
        Comparator<String> ci = String.CASE_INSENSITIVE_ORDER;
        assertTrue(BinarySearch.searchListBinary(ordered, "Banana", ci).found());
        assertEquals("banana",BinarySearch.searchListBinary(ordered, "Banana", ci).value());
    }
}
