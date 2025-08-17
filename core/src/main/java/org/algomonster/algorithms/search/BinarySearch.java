package org.algomonster.algorithms.search;

import org.algomonster.Utils;

import java.util.Comparator;
import java.util.List;

public class BinarySearch {

    private BinarySearch() {

    }

    public static <T> Utils.SearchResult<T> searchListBinary(List<T> sortedList, T value, Comparator<? super T> comparator){
        int index = search(sortedList, value, comparator);
        return new Utils.SearchResult<>(index >= 0, index >= 0 ? sortedList.get(index) : null);
    }

    private static <T> int search(List<T> sortedList, T value, Comparator<? super T> comparator){
        if(sortedList == null){
            throw new IllegalStateException("List is null");
        }

        //Fallback comparator
        Comparator<? super T> effectiveComparator = comparator;
        if (effectiveComparator == null) {
            // Safe: Only called from bounded overloads where T extends Comparable<? super T>
            @SuppressWarnings("unchecked")
            Comparator<? super T> naturalComparator = (Comparator<? super T>) Utils.naturalNullsFirst();
            effectiveComparator = naturalComparator;
        }

        //Boundaries of our array to be resized
        int index = -1;
        int start = 0;
        int end = sortedList.size()-1;

        while(start <= end){
            //Check the middle slot
            int middle = Utils.calculateMiddle(start,end);
            if(effectiveComparator.compare(value, sortedList.get(middle)) == 0){ //we found it
                index = middle;
                break;
            }
            else if(effectiveComparator.compare(value,sortedList.get(middle)) < 0){ //value is less
                end = middle - 1; //drop the right side
            }
            else{ //its bigger
                start = middle + 1; //drop the left side
            }
        }

        return index;
    }
}
