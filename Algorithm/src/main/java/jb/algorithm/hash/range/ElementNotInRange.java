package jb.algorithm.hash.range;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jbhushan
 */
public class ElementNotInRange {

    public static void main(String[] args){
        int arr[] = {10, 12, 11, 15};
        int range[] = {10, 11, 12, 13,14,15};
        findMissingUsingSort(arr,range);

    }

    /**
     * Time complexity : O(n) + O(m)
     * Space complexity : O(n)
     * @param nums
     *          Given array
     * @param range
     *          give range
     */
    public void findMissingUsingHash(int[] nums, int[] range){
        Set<Integer> set = new HashSet<Integer>();
        for(int n : nums){
            set.add(n);
        }

        for(int n : range){
            if(!set.contains(n)){
               System.out.println(n+" ");
            }
        }
    }


    /**
     * Time complexity : O(n) + O(m)
     * Space complexity : O(n)
     * @param nums
     *          Given array
     * @param range
     *          give range
     */
    public static void findMissingUsingSort(int[] nums, int[] range){
        Arrays.sort(nums);
        int index = search(nums,range[0],0,nums.length-1);
        int x = range[0];

        while(index< nums.length && x<=range[range.length-1]){
            if(nums[index] != x){
                System.out.print(x+" ");
            } else {
                index++;
            }
        }
        x++;

        while (x<=range[range.length-1]) {
            System.out.print(x + " ");
            x++;
        }
    }

    private static int search(int[] nums, int val, int l, int r){
        int mid = l + (r-l)/2;
        if(nums[mid] == val){
            return mid;
        } else if(nums[mid] < val){
            if (mid + 1 < r && nums[mid + 1] >= val){
                return mid + 1;
            }
            return search(nums, val, mid + 1, r);
        } else {
            if (mid - 1 >= l && nums[mid - 1] < val){
                return mid;
            }
            return search(nums, val, l, mid-1);
        }
    }
}
