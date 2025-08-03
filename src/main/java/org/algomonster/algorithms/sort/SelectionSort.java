package org.algomonster.algorithms.sort;


import org.algomonster.Utils;

import java.util.List;

public class SelectionSort {
    public static void sortListSelection(List<Integer> unsortedList){
        if(unsortedList == null){
            throw new IllegalStateException("List is null");
        }

        for(int j = 0; j < unsortedList.size(); j++){
            //Current position is assumed to be the minimum
            int min = j;

            //Find the actual minimum, starting from the index
            for(int k = j; k < unsortedList.size(); k++){
                //looks like K is actually the minimum, update the index
                if(Utils.compare(unsortedList.get(k),unsortedList.get(min)) < 0){
                    min = k;
                }
            }

            //now that we have the minimum, we swap, current j goes to min spot, found min goes to j spot
            Integer minElement = unsortedList.get(min); //pull min element out
            unsortedList.set(min,unsortedList.get(j));
            unsortedList.set(j,minElement);
        }
    }
}
