package jb.algorithm.hash.occurrence;


import java.util.HashMap;
import java.util.Map;

/**
 * @author jbhushan
 */
public class GroupElement {

    public static void main(String[] args){
        int[] nums = {1,2,9,5,6,5,5,2,4,3,9};
        group(nums);
    }

    public static void group(int[] nums){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        for(int n : nums){
            if(map.containsKey(n)){
                int frequency = map.get(n);
                while(frequency>0){
                    System.out.print(n+" ");
                    frequency--;
                }
                map.remove(n);
            }
        }
    }
}
