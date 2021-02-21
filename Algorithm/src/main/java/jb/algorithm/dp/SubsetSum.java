package jb.algorithm.dp;

/**
 * @author jbhushan
 */
public class SubsetSum {

    public static void main(String[] args){

        int[] arr = {1,8,4,6,9};
        subsetExists(arr, 5);

    }

    public static boolean subsetExists(int[] arr, int k){
        boolean t[][] = new boolean[arr.length+1][k+1];

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
            for (int j = 1; j < k; j++) {
                if(arr[i-1] <= j){
                    t[i][j] = t[i][j-arr[i-1]] || t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        System.out.println(" SUbset Exists: "+t[arr.length][k]);
        return t[arr.length][k];
    }


}
