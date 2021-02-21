package jb.algorithm.dp.kanpsack;

import java.util.Arrays;

/**
 * @author jbhushan
 */
public class Knapsack01 {

    public static void main(String[] args){
        Knapsack01 knapsack01 = new Knapsack01();

        int[] wt = {10,20,30};
        int[] val = {60,100,120};
        System.out.println(knapsack01.knapsack(wt,val,50));

    }

    public int knapsack(int[] wt, int[] val, int k){
        // we need to choice

        // Base Condition when store is empty or no capacity in bag
        if(wt.length == 0 || val.length ==0){
            return 0;
        }

        // initialize array except 1st row and 1st column
        int t[][] = new int[wt.length+1][k+1];
        for(int i=1; i<t.length; i++){
            for(int j=1; j<t[0].length;j++){
                t[i][j] = -1;
            }
        }
       // Arrays.fill(t,-1);

        return recursive(wt,val,k,wt.length,t);
    }

    private int recursive(int[] wt, int[] val, int k, int size, int[][] t){
        if(t[size][k] != -1){
            return t[size][k];
        }
        if(size > 0) {
            if (wt[size - 1] <= k) {
                t[size][k] = Math.max(val[size - 1] + recursive(wt, val, k - wt[size - 1], size - 1, t),
                        recursive(wt, val, k, size - 1, t));
            } else {
                t[size][k] = recursive(wt, val, k, size - 1, t);
            }
        }

        return t[size][k];
    }
}


