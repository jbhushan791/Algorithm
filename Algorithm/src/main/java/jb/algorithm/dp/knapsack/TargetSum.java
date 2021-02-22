package jb.algorithm.dp.knapsack;

/**
 * Assign signs such that two subset difference is given difference
 *
 * @author jbhushan
 */
public class TargetSum {

    public static void main(String[] args){

        int[] arr = {1,1,2,3};
        targetSum(arr,1);

    }

    public static int targetSum(int[] arr, int diff){
        int sum =0;
        for(int a: arr){
            sum+=a;
        }

        int s1 = (sum+diff)/2;
        int s2 = sum-s1;

      // int count = SubsetSumCount.subsetCount(arr,s1);
       // boolean t[][] = new boolean[arr.length+1][range+1];
        int count = subsetCount(arr,s1);

        System.out.println("count "+count);
       return count;
    }

    private static int subsetCount(int[] arr, int s1) {
        int[][] t = new int[arr.length+1][s1+1];
        for(int i=0; i<arr.length+1;i++){
            for(int j=0; j<s1+1; j++){
                if(i==0){
                    t[i][j]=0;
                }
                if(j==0){
                    t[i][j]=1;
                }
            }
        }

        for(int i=1; i< arr.length+1;i++) {
            for (int j=1; j<s1+1; j++) {
                if(arr[i-1] <= j){
                    t[i][j]=t[i-1][j-arr[i-1]] + t[i-1][j];
                } else {
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[arr.length][s1];
    }

}
