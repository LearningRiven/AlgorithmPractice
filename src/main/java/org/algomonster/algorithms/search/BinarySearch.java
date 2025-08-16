package org.algomonster.algorithms.search;

import org.algomonster.Utils;

import java.util.List;

public class BinarySearch {

    private BinarySearch() {

    }

    public static boolean searchListBinary(List<Integer> sortedList, Integer value){
        if(sortedList == null){
            throw new IllegalStateException("List is null or empty");
        }

        boolean found = false;

        //Boundaries of our array to be resized
        int start = 0;
        int end = sortedList.size()-1;

        while(start <= end){
            //Check the middle slot
            int middle = Utils.calculateMiddle(start,end);
            if(Utils.compare(value, sortedList.get(middle)) == 0){ //we found it
                found = true;
                break;
            }
            else if(Utils.compare(value,sortedList.get(middle)) < 0){ //value is less
                end = middle - 1; //drop the right side
            }
            else{ //its bigger
                start = middle + 1; //drop the left side
            }
        }

        return found;
    }


}
