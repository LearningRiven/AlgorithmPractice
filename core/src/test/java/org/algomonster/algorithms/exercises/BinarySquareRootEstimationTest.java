package org.algomonster.algorithms.exercises;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySquareRootEstimationTest {

    @Test
    void testConstructor() throws NoSuchMethodException {
        Constructor<BinarySquareRootEstimation> constructor = BinarySquareRootEstimation.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }

    @Test
    void testBaseCase(){
        assertEquals(2,BinarySquareRootEstimation.sqrtEstimation(8));
    }

    @Test
    void testActualSquares(){
        assertEquals(2,BinarySquareRootEstimation.sqrtEstimation(4));
        assertEquals(3,BinarySquareRootEstimation.sqrtEstimation(9));
        assertEquals(4,BinarySquareRootEstimation.sqrtEstimation(16));
        assertEquals(5,BinarySquareRootEstimation.sqrtEstimation(25));
        assertEquals(6,BinarySquareRootEstimation.sqrtEstimation(36));
    }

    @Test
    void testCloseSquares(){
        assertEquals(2,BinarySquareRootEstimation.sqrtEstimation(5));
        assertEquals(3,BinarySquareRootEstimation.sqrtEstimation(10));
        assertEquals(4,BinarySquareRootEstimation.sqrtEstimation(17));
        assertEquals(5,BinarySquareRootEstimation.sqrtEstimation(26));
        assertEquals(6,BinarySquareRootEstimation.sqrtEstimation(37));


        assertEquals(2,BinarySquareRootEstimation.sqrtEstimation(7));
        assertEquals(3,BinarySquareRootEstimation.sqrtEstimation(12));
        assertEquals(4,BinarySquareRootEstimation.sqrtEstimation(19));
        assertEquals(5,BinarySquareRootEstimation.sqrtEstimation(28));
        assertEquals(6,BinarySquareRootEstimation.sqrtEstimation(39));
    }
}
