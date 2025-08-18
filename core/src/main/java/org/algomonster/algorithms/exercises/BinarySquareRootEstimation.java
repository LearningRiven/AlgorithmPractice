package org.algomonster.algorithms.exercises;

import org.algomonster.Utils;

public class BinarySquareRootEstimation {

    private BinarySquareRootEstimation() {

    }

    public static int sqrtEstimation(int squared){

        int start = 1;
        int end = squared;
        int result = -1;

        while(start <= end){
            int middle = Utils.calculateMiddle(start,end);

            //We found the exact square root
            if(middle == (squared/middle)){
                return middle;
            }
            else if(middle > (squared/middle)){ //we can still continue searching
                result = middle;
                end = middle - 1;
            }
            else{ //we overshot
                start = middle + 1;
            }
        }


        return result - 1;

    }
}
