package jb.algorithm.dp.knapsack.unbounded;

/**
 * @author jbhushan
 */
public class CoinChangeMax {

    public static void main(String[] args){

        CoinChangeMax coinChangeMax = new CoinChangeMax();
        int[] coin = {1,2,3};
        coinChangeMax.coinChangeMax(coin,4);

    }

    private int coinChangeMax(int[] coin, int sum){
        int[][] t = new int[coin.length+1][sum+1];
        for(int i=0; i<coin.length+1; i++){
            for(int j =0; j<sum+1; j++){
                if(i==0){
                    t[i][j] = 0;
                }
                if(j==0){
                    t[i][j] = 1;
                }
            }
        }

        for(int i=1; i<coin.length+1; i++){
            for(int j =1; j<sum+1; j++){
                if(coin[i-1] <= j){
                    t[i][j] = t[i][j-coin[i-1]] + t[i-1][j];
                } else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        System.out.println(" Max number of ways: "+t[coin.length][sum]);
        return t[coin.length][sum];
    }
}
