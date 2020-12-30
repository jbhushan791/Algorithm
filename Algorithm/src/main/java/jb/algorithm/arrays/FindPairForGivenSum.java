package jb.algorithm.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jbhushan
 */
public class FindPairForGivenSum {

    public static void main(String[] args){
        int[] arr = {1,4,3,3,5,2,6};
        findPair(arr, 6);
    }

    public static void findPair(int[] arr, int sum) {
        Map<Integer, Integer> map =new HashMap<Integer, Integer>(arr.length);
//        for(int num : arr){
//            map.put(num, null);
//        }

        for(int num : arr){
            int n = sum-num;
            if(map.containsKey(n)){
                System.out.println("("+num+","+n+")");
            }
            map.put(num, null);

        }
    }
}
