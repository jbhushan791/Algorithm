package jb.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jbhushan
 */
public class DuplicateCheckUptoK {

    public static void main(String[] args){
        int[] nums = {1,0,1,9,1,4,6};
        System.out.println(checkDuplicateUsingMap(nums,2));
        int[] n = {1,0,9,8,1,4,6};
        System.out.println(checkDuplicateUsingMap(n,2));
    }

    private static boolean checkDuplicate(int[] nums, int k){
        for(int i=0; i<nums.length; i++){
            int counter =1;
            while(counter <= k){
                if(i+counter < nums.length && nums[i+counter]==nums[i]){
                    return true;
                }
                counter++;
            }
        }
        return false;
    }

    private static boolean checkDuplicateUsingMap(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(k);
        for(int i=0; i<k; i++){
            map.put(i,nums[i]);
        }

        for(int i =k ; i<nums.length; i++){
            if(map.containsValue(nums[i])){
                return true;
            } else {
                map.remove(i-k);
                map.put(i, nums[i]);
            }
        }
        return false;
    }
}
