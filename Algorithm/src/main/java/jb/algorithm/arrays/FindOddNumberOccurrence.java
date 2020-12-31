package jb.algorithm.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jbhushan
 */
public class FindOddNumberOccurrence {

    public static void main(String[] args){
        int[] arr = {1,1,3,3,2,2,1};
        System.out.println(findPair(arr));
    }

    public static int findPair(int[] arr) {
       int n = 0;
       for(int num : arr){
           n = n ^ num;
       }
       return n;
    }
}
