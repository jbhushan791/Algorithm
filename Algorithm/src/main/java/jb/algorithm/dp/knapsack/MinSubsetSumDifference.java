package jb.algorithm.dp.knapsack;

/**
 * @author jbhushan
 */
public class MinSubsetSumDifference {

    public static void main(String[] args){

        int[] arr = {1,6,11,5};
        minSubsetSumDiff(arr);

    }

    public static int minSubsetSumDiff(int[] arr){
        int range =0;
        for(int a: arr){
            range+=a;
        }

        boolean t[][] = new boolean[arr.length+1][range+1];
        subset(arr,range,t);

        int min = Integer.MAX_VALUE;
        for(int i=0; i<=range/2;i++){
            if(t[arr.length][i]){
                min = Math.min(min, range-(2*i));
            }
        }
        System.out.println("Min difference of subset: "+min);
        return min;
    }

    private static void subset(int[] arr, int k, boolean t[][] ){

        // Initialize base condition , if sum is 0 or arr is empty
        for(int i=0; i<arr.length+1; i++){
            for(int j=0; j<k; j++) {
                if(i==0){
                    t[i][j] = false;
                }
                if(j==0){
                    t[i][j] = true;
                }
            }
        }

        for(int i=1; i<arr.length+1; i++) {
            for (int j = 1; j < k+1; j++) {
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
    }


}
