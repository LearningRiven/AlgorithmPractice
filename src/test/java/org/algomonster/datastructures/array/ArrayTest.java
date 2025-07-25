package org.algomonster.datastructures.array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayTest {

    @Test
    public void testGetSetHead(){
        Array<String> ar = new Array<String>();
        ar.setHead("Test");
        assertNotNull(ar.getHead());
        assertEquals("Test",ar.getHead());
    }

    @Test
    public void testGetSetTail(){
        Array<String> ar = new Array<String>();
        ar.setTail("Test");
        assertNotNull(ar.getTail());
        assertEquals("Test",ar.getTail());
    }
}
