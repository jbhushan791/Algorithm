package jb.algorithm.arrays.sort;

/**
 * @author jbhushan
 */
public class WaveSort {

    public static void main(String[] args){
        int[] nums = {20,8,10,6,4,2};
        waveSort(nums);
    }

    private static void waveSort(int[] nums){

        int temp =0;
        for(int i=0; i< nums.length; i=i+2){
            if(i != 0 && nums[i-1] > nums[i]){
                temp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = temp;
            }
            if(i < nums.length -1 && nums[i+1] > nums[i]){
                temp = nums[i+1];
                nums[i+1] = nums[i];
                nums[i] = temp;
            }
        }

        for(int n : nums){
            System.out.print(n+" ");
        }

    }
}
