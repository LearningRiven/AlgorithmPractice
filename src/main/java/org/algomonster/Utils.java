package org.algomonster;

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

}
