package org.algomonster.algorithms.sort;

import java.util.List;

public class QuickSort {

    private QuickSort() {

    }

    public static void sortListQuickSort(List<Integer> unsortedList){
        if(unsortedList == null){
            throw new IllegalStateException("List is null");
        }

        sortHelper(unsortedList,0,unsortedList.size());
    }

    public static void sortHelper(List<Integer> unsortedList, int start, int end){

    }


}
