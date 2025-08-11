package org.algomonster.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSystemTest {

    @Test
    void testEnum(){
        //Test get index
        assertEquals(0,ParkingSystem.CarType.SMALL.getIndex());
        assertEquals(1,ParkingSystem.CarType.MEDIUM.getIndex());
        assertEquals(2,ParkingSystem.CarType.BIG.getIndex());

        //Test ordinal consistency
        assertEquals(ParkingSystem.CarType.SMALL.getIndex(),ParkingSystem.CarType.SMALL.ordinal());
        assertEquals(ParkingSystem.CarType.MEDIUM.getIndex(),ParkingSystem.CarType.MEDIUM.ordinal());
        assertEquals(ParkingSystem.CarType.BIG.getIndex(),ParkingSystem.CarType.BIG.ordinal());

        //Test values
        ParkingSystem.CarType[] expected = {ParkingSystem.CarType.SMALL, ParkingSystem.CarType.MEDIUM, ParkingSystem.CarType.BIG};
        assertArrayEquals(expected, ParkingSystem.CarType.values());

        //Test value of
        assertEquals(ParkingSystem.CarType.BIG, ParkingSystem.CarType.valueOf("BIG"));
        assertThrows(IllegalArgumentException.class, () -> ParkingSystem.CarType.valueOf("INVALID"));
    }

    @Test
    void testParkingLot(){
        ParkingSystem pk = new ParkingSystem(3,2,1);

        //Test initialization
        assertEquals(3, pk.getSmallSlots());
        assertEquals(2, pk.getMediumSlots());
        assertEquals(1,pk.getBigSlots());

        //Add a small and verify state
        assertTrue(pk.attemptParking(ParkingSystem.CarType.SMALL));
        assertEquals(2, pk.getSmallSlots());
        assertEquals(2, pk.getMediumSlots());
        assertEquals(1,pk.getBigSlots());

        //Add a medium and verify state
        assertTrue(pk.attemptParking(ParkingSystem.CarType.MEDIUM));
        assertEquals(2, pk.getSmallSlots());
        assertEquals(1, pk.getMediumSlots());
        assertEquals(1,pk.getBigSlots());

        //Add a big and verify state
        assertTrue(pk.attemptParking(ParkingSystem.CarType.BIG));
        assertEquals(2, pk.getSmallSlots());
        assertEquals(1, pk.getMediumSlots());
        assertEquals(0,pk.getBigSlots());

        //Add a big again and verify state
        assertFalse(pk.attemptParking(ParkingSystem.CarType.BIG));
        assertEquals(2, pk.getSmallSlots());
        assertEquals(1, pk.getMediumSlots());
        assertEquals(0,pk.getBigSlots());

        //Add more to 0
        assertTrue(pk.attemptParking(ParkingSystem.CarType.SMALL));
        assertTrue(pk.attemptParking(ParkingSystem.CarType.SMALL));
        assertFalse(pk.attemptParking(ParkingSystem.CarType.SMALL));
        assertTrue(pk.attemptParking(ParkingSystem.CarType.MEDIUM));
        assertFalse(pk.attemptParking(ParkingSystem.CarType.MEDIUM));
        assertFalse(pk.attemptParking(ParkingSystem.CarType.BIG));
        assertEquals(0, pk.getSmallSlots());
        assertEquals(0, pk.getMediumSlots());
        assertEquals(0,pk.getBigSlots());
    }

    @Test
    void testParkingLotNegative(){
        ParkingSystem pk = new ParkingSystem(-3,-2,-1);
        assertEquals(0, pk.getSmallSlots());
        assertEquals(0, pk.getMediumSlots());
        assertEquals(0,pk.getBigSlots());
        assertFalse(pk.attemptParking(ParkingSystem.CarType.SMALL));
        assertFalse(pk.attemptParking(ParkingSystem.CarType.MEDIUM));
        assertFalse(pk.attemptParking(ParkingSystem.CarType.BIG));
    }

    @Test
    void testParkingLotZero(){
        ParkingSystem pk = new ParkingSystem(0,0,0);
        assertEquals(0, pk.getSmallSlots());
        assertEquals(0, pk.getMediumSlots());
        assertEquals(0,pk.getBigSlots());
        assertFalse(pk.attemptParking(ParkingSystem.CarType.SMALL));
        assertFalse(pk.attemptParking(ParkingSystem.CarType.MEDIUM));
        assertFalse(pk.attemptParking(ParkingSystem.CarType.BIG));
    }

    @Test
    void testParkingLotAddNullType(){
        ParkingSystem pk = new ParkingSystem(10,10,10);
        assertFalse(pk.attemptParking(null));
    }
}
