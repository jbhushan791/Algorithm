package jb.algorithm.arrays.sort;

import java.util.Arrays;

/**
 * @author jbhushan
 */
public class SmallestNumberGreaterThanGivenNumber {

    public static void main(String[] args){
        int[] nums = {5,3,4,9,7,6};
        findSmallestNumber(nums);
    }

    private static void findSmallestNumber(int[] nums){

        // 1. Start from right most digit and find the first digit that
        // is smaller than the digit next to it
        int index =-1;
        for(int i=nums.length-1; i>0 ; i--){
            if(nums[i-1] < nums[i]){
                index = i;
                break;
            }
        }

        // if no such digit is found then all digits are in descending order means
        // there cannot be a greater number with same set of digits
        if(index == 0){
            System.out.print("Not possible");
        } else{
            int x = nums[index-1];
            int minIndex = index;
            // 2. Find the smallest digit on right
            // side of (i-1)'th digit that is greater
            // than number[i-1]
            for(int i = index+1; i< nums.length; i++){
                if(nums[i]> x && nums[i] < nums[index]){
                    minIndex = i;
                }
            }

            // 3. Swap the above found smallest
            // digit with number[i-1]
            int temp = nums[minIndex];
            nums[minIndex] = nums[index-1];
            nums[index-1] = temp;

            // 4. Sort the digits after (i-1) in ascending order
            Arrays.sort(nums, index, nums.length-1);

            for(int n : nums){
                System.out.print(n);
            }
        }



    }
}
