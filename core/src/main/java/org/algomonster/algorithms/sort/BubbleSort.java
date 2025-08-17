package org.algomonster.algorithms.sort;

import org.algomonster.Utils;

import java.util.List;

public class BubbleSort {

    private BubbleSort() {

    }

    public static void sortListBubble(List<Integer> unsortedList){
        if(unsortedList == null){
            throw new IllegalStateException("List is null");
        }

        boolean swapped = true;
        //assume that a swap occured to get the process going
        while(swapped){
            //reset the state
            swapped = false;
            //loop through the list
            for(int k = 0; k < unsortedList.size(); k++){
                //If we are not at the end and the current element is larger than the next, swap
                if((k+1) < unsortedList.size() && Utils.compare(unsortedList.get(k),unsortedList.get(k+1)) > 0){
                    Integer temp = unsortedList.get(k);
                    unsortedList.set(k,unsortedList.get(k+1));
                    unsortedList.set(k+1,temp);
                    swapped = true;
                }
            }
        }

    }
}
