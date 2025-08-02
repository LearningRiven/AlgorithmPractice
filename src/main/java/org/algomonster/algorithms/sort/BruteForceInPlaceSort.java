package org.algomonster.algorithms.sort;

import java.util.List;

/**
 * This algorithm runs in n^2 time
 * very inefficient since quicksort is also an inplace sorting algorithm but runs in nlogn time
 */
public class BruteForceInPlaceSort {
    public static void sortListBrute(List<Integer> unsortedList){
        for(int j = 0; j < unsortedList.size(); j++){
            //Loop through and find the true smallest
            for(int k = 0; k < unsortedList.size(); k++){
                //We found an element smaller, swap them
                if(unsortedList.get(j) < unsortedList.get(k)){
                    Integer prevSmallest = unsortedList.get(j);
                    unsortedList.set(j,unsortedList.get(k));
                    unsortedList.set(k,prevSmallest);
                }
            }
        }
    }
}
