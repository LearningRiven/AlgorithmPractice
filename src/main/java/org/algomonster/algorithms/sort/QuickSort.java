package org.algomonster.algorithms.sort;

import org.algomonster.Utils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class QuickSort {

    private QuickSort() {

    }

    public static void sortListQuickSort(List<Integer> unsortedList, String selectionType){
        if(unsortedList == null){
            throw new IllegalStateException("List is null");
        }

        sortHelper(unsortedList,0,unsortedList.size()-1,selectionType);
    }

    private static void sortHelper(List<Integer> unsortedList, int start, int end, String selectionType){
        //Recursive so need base condition
        if(start >= end){
            return;
        }

        //Run the pivot helper to figure out the median and put it into the end slot
        pivotHelper(unsortedList,start,end,selectionType);
        int newPivot = partitionHelper(unsortedList,start,end);

        //sort left and right of the pivot
        sortHelper(unsortedList, start, newPivot - 1, selectionType);
        sortHelper(unsortedList,newPivot + 1, end, selectionType);
    }

    private static void pivotHelper(List<Integer> unsortedList, int start, int end, String selectionType){
        //Median of 3 implementation, better then just selecting the last element
        //We basically do a little comparison first, and then swap the median to the last element and proceed like with Lomuto
        if(StringUtils.equals("MedianOf3",selectionType) && (end - start) >= 2){
            //Take the first/middle/last
            int middleSlot = start + ((end - start)/2);

            //Do a quick sort to get the median
            if(Utils.compare(unsortedList.get(start),unsortedList.get(middleSlot)) > 0){
                swap(unsortedList, start, middleSlot);
            }
            if(Utils.compare(unsortedList.get(start),unsortedList.get(end)) > 0){
                swap(unsortedList, start, end);
            }
            if(Utils.compare(unsortedList.get(middleSlot),unsortedList.get(end)) > 0){
                swap(unsortedList, middleSlot, end);
            }

            //Now put the median into the last slot
            swap(unsortedList,middleSlot,end);
        }
    }

    private static int partitionHelper(List<Integer> unsortedList, int start, int end){
        Integer pivot = unsortedList.get(end);  // Pivot at end (from Mo3)
        int lessThanBoundaryIndex = start - 1;  // Boundary of smaller elements (starts outside)
        for (int ptr = start; ptr < end; ptr++) {  // Scan from start to end-1
            if (Utils.compare(unsortedList.get(ptr),pivot) <= 0) {  // Found smaller/equal? Grow left side
                lessThanBoundaryIndex++;
                swap(unsortedList, lessThanBoundaryIndex, ptr);
            }
        }
        swap(unsortedList, lessThanBoundaryIndex + 1, end);  // Final swap: Place pivot after smaller section
        return lessThanBoundaryIndex + 1;  // Pivot's final index
    }

    private static void swap(List<Integer> unsortedList, int slot1, int slot2){
        Integer temp = unsortedList.get(slot1);
        unsortedList.set(slot1,unsortedList.get(slot2));
        unsortedList.set(slot2,temp);
    }
}
