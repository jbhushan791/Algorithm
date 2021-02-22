package jb.algorithm.dp.knapsack.zerone;

/**
 * @author jbhushan
 */
public class SubsetSumCount {

    public static void main(String[] args){

        int[] arr = {1,2,3,3};
        subsetCount(arr, 6);

    }

    public static int subsetCount(int[] arr, int k){
        int t[][] = new int[arr.length+1][k+1];

        // Initialize base condition , if sum is 0 or arr is empty
        for(int i=0; i<arr.length+1; i++){
            for(int j=0; j<k; j++) {
                if(i==0){
                    t[i][j] = 0;
                }
                if(j==0){
                    t[i][j] = 1;
                 }
            }
        }

        for(int i=1; i<arr.length+1; i++) {
            for (int j = 1; j < k+1; j++) {
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        System.out.println(" Subset count: "+t[arr.length][k]);
        return t[arr.length][k];
    }


}
