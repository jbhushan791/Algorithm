package jb.algorithm.dp.knapsack;

/**
 * @author jbhushan
 */
public class EqualSumPartition {

    public static void main(String[] args){
        EqualSumPartition knapsack01 = new EqualSumPartition();

        int[] wt = {10,20,32};
        int[] val = {60,100,120};
        System.out.println(knapsack01.isEqualPartition(wt));

    }

    private boolean isEqualPartition(int[] nums){
        int sum=0;
        for(int n: nums){
            sum+=n;
        }
        if(sum%2 != 0){
            return false;
        }

      return  SubsetSum.subsetExists(nums,sum/2);
    }


}


