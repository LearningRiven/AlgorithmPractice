package org.algomonster.algorithms.sort;

import org.algomonster.Utils;

import java.util.ArrayList;
import java.util.List;

public class MergeSort{

    private MergeSort() {
        throw new IllegalStateException("MergeSort class");
    }

    public static List<Integer> sortListMerge(List<Integer> unsortedList){
        if(unsortedList == null){
            throw new IllegalStateException("List is null");
        }

        return sortHelper(unsortedList,0,unsortedList.size());
    }

    //Recursive method, rule 1 is to have a base condition, then the recursion condition, and then either having a return or doing in place
    //Helper method here so i don't have to break the overall strategy i have been using for algorithms. (my tests only accept a list)
    private static List<Integer> sortHelper(List<Integer> unsortedList, int start, int end){
        //Base condition
        if((end - start) <= 1){ //size 1 or 0 means its sorted
            return unsortedList.subList(start,end);
        }

        //Find the mid point to split on
        int midPoint = start + (end - start)/2;
        List<Integer> leftList = sortHelper(unsortedList, start, midPoint);
        List<Integer> rightList = sortHelper(unsortedList, midPoint, end);

        List<Integer> sorted = new ArrayList<>();
        int left = 0;
        int right = 0;

        //Both lists arent completed yet
        while(left < leftList.size() && right < rightList.size()){
            //Case when left is bigger
            if(Utils.compare(leftList.get(left),rightList.get(right)) < 0){
                sorted.add(leftList.get(left));
                left++;
            }
            //Case when right is bigger
            else if(Utils.compare(leftList.get(left),rightList.get(right)) > 0){
                sorted.add(rightList.get(right));
                right++;
            }
            //Case when both are the same, add left first for stability
            else{
                sorted.add(leftList.get(left));
                sorted.add(rightList.get(right));
                left++;
                right++;
            }
        }

        //Finish off the left list if there are any elements
        while(left < leftList.size()){
            sorted.add(leftList.get(left));
            left++;
        }

        //Finish off the right list if there are any elements
        while(right < rightList.size()){
            sorted.add(rightList.get(right));
            right++;
        }

        return sorted;
    }
}