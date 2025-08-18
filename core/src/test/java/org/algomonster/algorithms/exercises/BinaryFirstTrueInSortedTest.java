package org.algomonster.algorithms.exercises;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class BinaryFirstTrueInSortedTest {

    @Test
    void testConstructor() throws NoSuchMethodException {
        Constructor<BinaryFirstTrueInSorted> constructor = BinaryFirstTrueInSorted.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }

    @Test
    void testRegularSearchEven(){
        boolean[] evenSplit = {false,false,false,false,false,true,true,true,true,true};
        boolean[] singleValue = {true,true,true,true,true,true,true,true,true,true};

        assertEquals(0, BinaryFirstTrueInSorted.searchIndex(evenSplit, false));
        assertEquals(5, BinaryFirstTrueInSorted.searchIndex(evenSplit, true));
        assertEquals(0, BinaryFirstTrueInSorted.searchIndex(singleValue, true));
        assertEquals(-1, BinaryFirstTrueInSorted.searchIndex(singleValue, false));
    }

    @Test
    void testRegularSearchOdd(){
        boolean[] evenSplit1 = {false,false,false,false,true,true,true,true,true};
        boolean[] evenSplit2 = {false,false,false,false,false,true,true,true,true};
        boolean[] singleValue = {true,true,true,true,true,true,true,true,true};

        assertEquals(0, BinaryFirstTrueInSorted.searchIndex(evenSplit1, false));
        assertEquals(4, BinaryFirstTrueInSorted.searchIndex(evenSplit1, true));
        assertEquals(0, BinaryFirstTrueInSorted.searchIndex(evenSplit2, false));
        assertEquals(5, BinaryFirstTrueInSorted.searchIndex(evenSplit2, true));
        assertEquals(0, BinaryFirstTrueInSorted.searchIndex(singleValue, true));
        assertEquals(-1, BinaryFirstTrueInSorted.searchIndex(singleValue, false));
    }

    @Test
    void testRegularSearchSingle(){
        boolean[] sorted = {false};
        assertEquals(-1,BinaryFirstTrueInSorted.searchIndex(sorted, true));
        assertEquals(0,BinaryFirstTrueInSorted.searchIndex(sorted, false));
    }

    @Test
    void testEmpty(){
        boolean[] sorted = new boolean[0];
        assertEquals(-1,BinaryFirstTrueInSorted.searchIndex(sorted, true));
    }

    @Test
    void testNull(){
        assertThrows(IllegalStateException.class,() -> BinaryFirstTrueInSorted.searchIndex(null,true), "List is null");
    }

}
