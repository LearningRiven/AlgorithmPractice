package org.algomonster.algorithms.search;

import org.algomonster.algorithms.sort.BruteForce;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    @Test
    void testConstructor() throws NoSuchMethodException {
        Constructor<BinarySearch> constructor = BinarySearch.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }

    @Test
    void testRegularSearchEven(){
        List<Integer> ordered = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        assertTrue(BinarySearch.searchListBinary(ordered,7));
        assertTrue(BinarySearch.searchListBinary(ordered,10));
        assertTrue(BinarySearch.searchListBinary(ordered,11));
        assertTrue(BinarySearch.searchListBinary(ordered,1));
        assertTrue(BinarySearch.searchListBinary(ordered,20));
        assertFalse(BinarySearch.searchListBinary(ordered,25));
        assertFalse(BinarySearch.searchListBinary(ordered,null));
    }

    @Test
    void testRegularSearchOdd(){
        List<Integer> ordered = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19);
        assertTrue(BinarySearch.searchListBinary(ordered,7));
        assertTrue(BinarySearch.searchListBinary(ordered,10));
        assertTrue(BinarySearch.searchListBinary(ordered,1));
        assertTrue(BinarySearch.searchListBinary(ordered,19));
        assertFalse(BinarySearch.searchListBinary(ordered,25));
        assertFalse(BinarySearch.searchListBinary(ordered,null));
    }

    @Test
    void testRegularSearchSingle(){
        List<Integer> ordered = Arrays.asList(1);
        assertFalse(BinarySearch.searchListBinary(ordered,7));
        assertFalse(BinarySearch.searchListBinary(ordered,null));
        assertTrue(BinarySearch.searchListBinary(ordered,1));
    }

    @Test
    void testRegularSearchNull(){
        List<Integer> ordered = Arrays.asList(null,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19);
        assertFalse(BinarySearch.searchListBinary(ordered,7));
        assertTrue(BinarySearch.searchListBinary(ordered,null));
        assertFalse(BinarySearch.searchListBinary(ordered,1));
    }

    @Test
    void testEmpty(){
        List<Integer> ordered = new ArrayList<>();
        assertFalse(BinarySearch.searchListBinary(ordered,7));
        assertFalse(BinarySearch.searchListBinary(ordered,null));
        assertFalse(BinarySearch.searchListBinary(ordered,1));
    }

    @Test
    void testNull(){
        assertThrows(IllegalStateException.class,() -> BinarySearch.searchListBinary(null,5), "List is null");
        assertThrows(IllegalStateException.class,() -> BinarySearch.searchListBinary(null,null), "List is null");
    }
}
