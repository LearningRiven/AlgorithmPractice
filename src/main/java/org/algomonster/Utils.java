package org.algomonster;

import java.util.Comparator;

public final class Utils {

    private Utils() {

    }

    //Generic comparator, handles null
    public static <T extends Comparable<? super T>> int compare(T a, T b) {
        if (a == null && b == null) return 0;
        if (a == null) return -1;  // Nulls first
        if (b == null) return 1;
        return a.compareTo(b);
    }

    //Helps handle custom search criteria
    public static <T extends Comparable<? super T>> Comparator<T> naturalNullsFirst() {// Safe: Only called from bounded overloads where T extends Comparable<? super T>
        return (a, b) -> compare(a, b);
    }

    //Custom record
    public record SearchResult<T>(boolean found, T value) {

    }

    public static int calculateMiddle(int start, int end){
        if(start < 0 || end < 0){
            throw new IllegalArgumentException("Negative values not accepted: start=" + start + ", end=" + end);
        }
        if(start > end){
            throw new IllegalArgumentException("Start must be equal to or less than end: start=" + start + ", end=" + end);
        }

        return (start+((end-start)/2));
    }

}
