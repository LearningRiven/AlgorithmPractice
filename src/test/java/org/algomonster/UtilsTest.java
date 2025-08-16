package org.algomonster;

import static org.junit.jupiter.api.Assertions.*;

import org.algomonster.algorithms.sort.BruteForce;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

class UtilsTest {

    @Test
    void testConstructor() throws NoSuchMethodException {
        Constructor<Utils> constructor = Utils.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }

    @Test
    void testCompare(){
        //String
        assertEquals(0,Utils.compare("Apple","Apple"));
        assertTrue(Utils.compare("Orange","Apple") > 0);
        assertTrue(Utils.compare("Apple","Orange") < 0);
        assertTrue(Utils.compare(null,"Orange") < 0);
        assertTrue(Utils.compare("Orange",null) > 0);
        assertEquals(0,Utils.compare(null,null));

        //Integer
        assertEquals(0,Utils.compare(1,1));
        assertTrue(Utils.compare(10,1) > 0);
        assertTrue(Utils.compare(1,10) < 0);
        assertTrue(Utils.compare(null,10) < 0);
        assertTrue(Utils.compare(10,null) > 0);
        assertEquals(0,Utils.compare(null,null));
    }

    @Test
    void testCalculateMiddle(){
        assertEquals(5, Utils.calculateMiddle(0,11));
        assertEquals(5, Utils.calculateMiddle(0,10));
        assertEquals(0, Utils.calculateMiddle(0,0));
        assertEquals(5, Utils.calculateMiddle(5,5));
        assertEquals(5, Utils.calculateMiddle(4,6));
    }

    @Test
    void testCalculateMiddleBadValues(){
        assertThrows(IllegalArgumentException.class,() -> Utils.calculateMiddle(-1,5), "Negative values not accepted: start=-1, end=5");
        assertThrows(IllegalArgumentException.class,() -> Utils.calculateMiddle(5,-1), "Negative values not accepted: start=5, end=1");
        assertThrows(IllegalArgumentException.class,() -> Utils.calculateMiddle(6,5), "Start must be equal to or less than end: start=6, end=5");
    }
}
