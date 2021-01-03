package jb.algorithm.arrays;

import java.util.Arrays;

/**
 * @author jbhushan
 */
public class TripletSum {

    public static void main(String[] args){
        int[] arr = {0,3,44, 5, 9,7};
        boolean present = findTripletForGivenSum(arr,20);
        System.out.println(present);
    }

    public static boolean findTripletForGivenSum(int[] arr, int target) {

       Arrays.sort(arr);

       for(int i=0; i<arr.length; i++){
           int left = i+1;
           int right = arr.length -1;
           while(left<right){
               int currentSum = arr[i] + arr[left] +arr[right];
               if(currentSum == target){
                   return true;
               } else if (currentSum < target){
                   left++;
               }else if (currentSum > target){
                   right--;
               }
           }
       }
       return false;
    }
}
