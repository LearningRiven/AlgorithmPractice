package org.algomonster.algorithms.sort;

import org.algomonster.Utils;

import java.util.List;

public class InsertionSort {

    private InsertionSort() {
        throw new IllegalStateException("InsertionSort class");
    }

    public static void sortListInsertion(List<Integer> unsortedList){
        //Handle junk parameter
        if(unsortedList == null){
            throw new IllegalStateException("List is null");
        }

        //Start from the second element in the list, we assume first element is sorted
        for (int k = 1; k < unsortedList.size(); k++) {
            Integer current = unsortedList.get(k);
            int pointer = k - 1;

            //Move backwards to shift until we reach the first element
            //Limit moving backwards until the previous elements stop being greater than the current value
            while(pointer >= 0 && Utils.compare(unsortedList.get(pointer),current) > 0){
                unsortedList.set(pointer+1,unsortedList.get(pointer)); //Move the current element forward, basically duplicates the same value
//                unsortedList.set(pointer, current); //fill in the earlier duplicate with the current value
                pointer--;
            }

            //Can be done inside of the loop, but unnecessary set that runs multiple times when 1 is enough
            unsortedList.set(pointer+1, current); //fill in the earlier duplicate with the current value
        }
    }
}
