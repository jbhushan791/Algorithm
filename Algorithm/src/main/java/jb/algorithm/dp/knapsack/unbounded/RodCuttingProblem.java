package jb.algorithm.dp.knapsack.unbounded;

/**
 * @author jbhushan
 */
public class RodCuttingProblem {

    public static void main(String[] args){
        RodCuttingProblem rodCuttingProblem = new RodCuttingProblem();
        int[] price = {1,5,8,9,10,17,17,20};
        rodCuttingProblem.rodCutting(price, 8);
    }

    public int rodCutting(int[] price, int length){
        // populate length array
        int[] len = new int[length];
        for(int i =0; i<length;i++){
            len[i]=i+1;
        }

        // base condition when length and price is 0
        int[][] t = new int[price.length+1][length+1];
        for(int i=0; i<price.length+1; i++){
            for(int j=0; j<length+1; j++){
                if(i==0){
                    t[i][j]=0;
                }
                if(j==0){
                    t[i][j]=0;
                }
            }
        }

        // calculate profit
        for(int i=1; i<len.length+1; i++) {
            for (int j = 1; j < length + 1; j++) {
                if(len[i-1] <= j){
                    t[i][j] = Math.max(price[i-1] + t[i][j-len[i-1]],t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        System.out.println("Profit: "+t[price.length][length]);
        return t[price.length][length];
    }
}
