package org.algomonster.algorithms.exercises;

import org.algomonster.Utils;

public class BinaryFirstElementNotSmaller {
    private BinaryFirstElementNotSmaller() {

    }

    public static int searchIndex(int[] sortedList, int value){
        if(sortedList == null){
            throw new IllegalStateException("List is null");
        }

        int start = 0;
        int end = sortedList.length - 1;
        int index = -1;

        while(start <= end){
            int middle = Utils.calculateMiddle(start,end);
            if(Utils.compare(sortedList[middle],value) >= 0) {
                index = middle;
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }

        return index;
    }
}
