package jb.algorithm.dp.knapsack.zerone;

/**
 * @author jbhushan
 */
public class Knapsack01TopDown {

    public static void main(String[] args){
        Knapsack01TopDown knapsack01 = new Knapsack01TopDown();

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
            for(int j=1; j<t[0].length;j++) {
                if(i==0 || j== 0){
                    t[i][j] = 0;
                }
            }
        }


        for(int i=1; i<t.length; i++){
            for(int j=1; j<t[0].length;j++){
                if (wt[i - 1] <= j) {
                    t[i][k] = Math.max(val[i - 1] + t [i-1][j - wt[i - 1]],
                            t[i-1][j]);
                } else {
                    t[i][k] =t[i-1][j];
                }
            }
        }
        return t[wt.length][k];
    }
}


