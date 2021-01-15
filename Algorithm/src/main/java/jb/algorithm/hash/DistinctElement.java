package jb.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jbhushan
 */
public class DistinctElement {

    public static void main(String[] args){
        int[] nums = {10,10,20,30,30,40,10};
        distinctCount(nums, 3);
    }

    public static void distinctCount(int[] arr, int k){
        // Creates an empty hashMap hM
        Map<Integer, Integer> hM = new HashMap<Integer, Integer>();
        int count =0;
        // Traverse the first window and store count
        // of every element in hash map
        for (int i = 0; i < k; i++){
            if(hM.containsKey(arr[i])){
                count--;
                hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);
            } else {
                hM.put(arr[i],  1);
                count++;
            }
        }

        // Print count of first window
        System.out.print(count +" ");

        // Traverse through the remaining array
        for (int i = k; i < arr.length; i++) {

            // Remove first element of previous window
            // If there was only one occurrence
            if (hM.get(arr[i - k]) == 1) {
                hM.remove(arr[i - k]);
                count--;
            }else{
                // reduce count of the removed element
                hM.put(arr[i - k],  hM.get(arr[i - k]) - 1);
                if(hM.get(arr[i-k]) == 1){
                    count++;
                }
            }

            // Add new element of current window
            // If this element appears first time,
            // set its count as 1,
            if(hM.containsKey(arr[i])){
                count--;
                hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);
            } else {
                hM.put(arr[i],  1);
                count++;
            }

            // Print count of current window
            System.out.print(count+" ");
        }
    }
}
