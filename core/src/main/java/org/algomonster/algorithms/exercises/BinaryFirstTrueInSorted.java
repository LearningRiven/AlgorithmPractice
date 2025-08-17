package org.algomonster.algorithms.exercises;

import org.algomonster.Utils;

public class BinaryFirstTrueInSorted {

    private BinaryFirstTrueInSorted() {

    }

    public static int searchIndex(boolean[] sortedList, boolean value){
        if(sortedList == null){
            throw new IllegalStateException("List is null");
        }

        int start = 0;
        int end = sortedList.length - 1;
        int index = -1;

        while(start <= end){
            //Calculate the mid point
            int middle = Utils.calculateMiddle(start,end);

            //The value matches, we cut the right since this could be the earliest already
            if(Utils.compare(sortedList[middle],value) == 0){
                index = middle;
                end = middle-1;
            }
            else if(Utils.compare(sortedList[middle],value) > 0){ //current value is larger than what we are looking for, cut the right
                end = middle-1;
            }
            else{ //current value is smaller than what we are looking for, cut the left
                start = middle+1;
            }

        }

        return index;
    }

}
