package jb.algorithm.arrays.subarray;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jbhushan
 */
public class SubarraySum {

    public static void  main(String[] args){
        SubarraySum s = new SubarraySum();
        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };

        System.out.println("--------------------------------------->");
        s.subArray(arr, 23);

        System.out.println("--------------------------------------->");
        s.subArrayUsingMap(arr,23);

        System.out.println("--------------------------------------->");
        s.efficientApproach(arr,23);
    }

    /**
     * This solution will work when all elements are positive
     * @param nums
     * @param target
     */
    public void subArray(int[] nums, int target){

        int startIndex = 0;
        int currSum = nums[0];

        for(int i=1; i<nums.length; i++){

            // if current sum is greater than target then shift start position
            while(currSum > target && startIndex < i-1){
                currSum -= nums[startIndex];
                startIndex++;
            }

            // found sub array , return start and end index
            if(currSum == target){
                int end = i-1;
                System.out.println("startIndex: "+startIndex +" endIndex: "+end);
                break;
            }

            // if not found means currentsum is less than target, update it
            if(i < nums.length){
                currSum += nums[i];
            }
        }
    }

    /**
     * this will handle all cases (+ve and -ve)
     *
     * This uses a Map to store data : Space cpmplexity : O(n)
     * @param nums
     * @param target
     */
    public void subArrayUsingMap(int[] nums, int target){

        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        int startIndex = -1;
        int endIndex = -1;
        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];

            //check whether cur_sum - sum = 0, if 0 it means
            //the sub array is starting from index 0- so stop
            if (target - sum == 0) {
                startIndex = 0;
                endIndex = i;
                break;
            }
            if (map.containsKey(sum - target)) {
                startIndex = map.get(sum - target) +1;
                endIndex = i;
                System.out.println("startIndex: "+startIndex +" endIndex: "+i);
                break;
            }
            map.put(sum, i);
        }

        if (endIndex == -1) {
            System.out.println("No subarray with given sum exists");
        } else {
            System.out.println("Sum found between indexes "
                    + startIndex + " to " + endIndex);
        }
    }


    public void efficientApproach(int[] nums, int target){

        // find minimum element in given array
        int minElement = Integer.MAX_VALUE;
        for(int n: nums){
            minElement = Math.min(minElement,n);
        }

        int currentSum = Math.abs(minElement)+nums[0];
        int startIndex = 0;

        for(int i=1; i<= nums.length; i++){

            // check if current sum is greater than target, if yes then subtract start element
            while (target < (currentSum - (i - startIndex) * Math.abs(minElement)) &&
                    startIndex < i - 1) {
                currentSum = currentSum -nums[startIndex]- Math.abs(minElement);
                startIndex++;
            }

            if(currentSum-(i-startIndex)*Math.abs(minElement) == target){
                System.out.println("Sum found between indexes " +
                        startIndex + " and " + (i - 1));
                return;
            }

            if(i < nums.length){
                currentSum = currentSum + nums[i]+ Math.abs(minElement);
            }
        }

        // If we reach here, then no subarray
        System.out.println("No subarray found");
    }
}
