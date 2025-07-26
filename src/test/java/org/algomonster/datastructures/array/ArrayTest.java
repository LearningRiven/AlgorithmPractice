package org.algomonster.datastructures.array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    @Test
    void testGetSetHead(){
        Array<String> ar = new Array<String>();
        ar.setHead("Test");
        assertNotNull(ar.getHead());
        assertEquals("Test",ar.getHead());
    }

    @Test
    void testGetSetTail(){
        Array<String> ar = new Array<String>();
        ar.setTail("Test");
        assertNotNull(ar.getTail());
        assertEquals("Test",ar.getTail());
    }
}
