package org.algomonster.algorithms.exercises;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryFirstElementNotSmallerTest {
    @Test
    void testConstructor() throws NoSuchMethodException {
        Constructor<BinaryFirstElementNotSmaller> constructor = BinaryFirstElementNotSmaller.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }

    @Test
    void testRegularSearchEven(){
        int[] increasing = {0,1,2,3,4,5,6,7,8,9};
        int[] decreasing = {9,8,7,6,5,4,3,2,1,0};
        int[] duplicate = {5,5,5,5,5,5,5,5,5,5};

        assertEquals(0,BinaryFirstElementNotSmaller.searchIndex(increasing,-10));
        assertEquals(0,BinaryFirstElementNotSmaller.searchIndex(increasing,0));
        assertEquals(4,BinaryFirstElementNotSmaller.searchIndex(increasing,4));
        assertEquals(8,BinaryFirstElementNotSmaller.searchIndex(increasing,8));
        assertEquals(9,BinaryFirstElementNotSmaller.searchIndex(increasing,9));
        assertEquals(-1,BinaryFirstElementNotSmaller.searchIndex(increasing,10));

        assertEquals(0,BinaryFirstElementNotSmaller.searchIndex(duplicate,4));
        assertEquals(0,BinaryFirstElementNotSmaller.searchIndex(duplicate,5));
        assertEquals(-1,BinaryFirstElementNotSmaller.searchIndex(duplicate,6));
    }

    @Test
    void testRegularSearchOdd(){
        int[] increasing = {0,1,2,3,4,5,6,7,8};
        int[] decreasing = {8,7,6,5,4,3,2,1,0};
        int[] duplicate = {5,5,5,5,5,5,5,5,5};

        assertEquals(0,BinaryFirstElementNotSmaller.searchIndex(increasing,-10));
        assertEquals(0,BinaryFirstElementNotSmaller.searchIndex(increasing,0));
        assertEquals(4,BinaryFirstElementNotSmaller.searchIndex(increasing,4));
        assertEquals(7,BinaryFirstElementNotSmaller.searchIndex(increasing,7));
        assertEquals(8,BinaryFirstElementNotSmaller.searchIndex(increasing,8));
        assertEquals(-1,BinaryFirstElementNotSmaller.searchIndex(increasing,10));

        assertEquals(0,BinaryFirstElementNotSmaller.searchIndex(duplicate,4));
        assertEquals(0,BinaryFirstElementNotSmaller.searchIndex(duplicate,5));
        assertEquals(-1,BinaryFirstElementNotSmaller.searchIndex(duplicate,6));
    }

    @Test
    void testRegularSearchSingle(){
        int[] increasing = {5};

        assertEquals(0,BinaryFirstElementNotSmaller.searchIndex(increasing,4));
        assertEquals(0,BinaryFirstElementNotSmaller.searchIndex(increasing,5));
        assertEquals(-1,BinaryFirstElementNotSmaller.searchIndex(increasing,6));
    }

    @Test
    void testRegularSearchNotExists(){
        int[] increasing = {5};

        assertEquals(0,BinaryFirstElementNotSmaller.searchIndex(increasing,5));
        assertEquals(-1,BinaryFirstElementNotSmaller.searchIndex(increasing,6));
        assertEquals(-1,BinaryFirstElementNotSmaller.searchIndex(increasing,7));

    }

    @Test
    void testEmpty(){
        int[] sorted = new int[0];
        assertEquals(-1,BinaryFirstElementNotSmaller.searchIndex(sorted, 10));
    }

    @Test
    void testNull(){
        assertThrows(IllegalStateException.class,() -> BinaryFirstElementNotSmaller.searchIndex(null,10), "List is null");
    }
}
