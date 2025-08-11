package org.algomonster.problems;

import java.util.EnumMap;

public class ParkingSystem {

  private final EnumMap<CarType, Integer> slots;

    public ParkingSystem(int small, int medium, int big){
        //Handle less than 0 scenario
        small = Math.max(small, 0);
        medium = Math.max(medium, 0);
        big = Math.max(big, 0);

        slots = new EnumMap<>(CarType.class);
        slots.put(CarType.SMALL, small);
        slots.put(CarType.MEDIUM, medium);
        slots.put(CarType.BIG, big);
    }

    public boolean attemptParking(CarType type){
        Integer available = slots.get(type);
        if(available != null && available > 0){
            slots.put(type,available-1);
            return true;
        }
        return false;
    }

    public Integer getSmallSlots(){
        return slots.get(CarType.SMALL);
    }

    public Integer getMediumSlots(){
        return slots.get(CarType.MEDIUM);
    }

    public Integer getBigSlots(){
        return slots.get(CarType.BIG);
    }

    public enum CarType{
        SMALL(0),
        MEDIUM(1),
        BIG(2);

        private final int index;

        CarType(int index){
            this.index = index;
        }

        public int getIndex(){
            return index;
        }
    }

}
