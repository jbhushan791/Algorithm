package jb.algorithm.arrays;

import java.awt.*;
import java.util.Arrays;

/**
 * @author jbhushan
 */
public class ClosestToZero {

    public static void main(String[] args){
        int[] arr = {0,59,-9, 69, -79,84};
        findPair(arr);
    }

    public static void findPair(int[] arr) {

       Arrays.sort(arr);
       int l = 0;
       int r = arr.length -1;

       int minLeft = 0;
       int minRight = arr.length -1;
       int curSum = 0;
       int minSum = Integer.MAX_VALUE;

       while(l < r) {

           curSum = arr[l] + arr[r];

           if(Math.abs(curSum) < Math.abs(minSum)){
                minSum = curSum;
                minLeft =l;
                minRight = r;
           }

           if(curSum < 0){
               l++;
           } else {
               r--;
           }
       }

       System.out.println("Pair: "+arr[minLeft] + " " + arr[minRight] + " Sum: "+minSum);
    }
}
