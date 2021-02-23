package jb.algorithm.dp.knapsack.unbounded;

/**
 * @author jbhushan
 */
public class CoinChangeMin {

    public static void main(String[] args){

        CoinChangeMin coinChangeMin = new CoinChangeMin();
        int[] coin = {25,10,5};
        coinChangeMin.coinChangeMin(coin,30);

        int[] coin1 = {9,6,5,1};
        coinChangeMin.coinChangeMin(coin1,11);

    }

    private int coinChangeMin(int[] coin, int sum){
        int[][] t = new int[coin.length+1][sum+1];
        for(int i=0; i<coin.length+1; i++){
            for(int j =0; j<sum+1; j++){
                if(j==0){
                    t[i][j] = 0;
                }
                if(i==0){
                    t[i][j] = Integer.MAX_VALUE-1;
                }
            }
        }
        for(int i =1; i< coin.length+1; i++) {
            if(i==2){
                break;
            }
            for (int j = 1; j < sum + 1; j++) {
                if (coin[0] % j == 0) {
                    t[1][j] = coin[0] / j;
                } else {
                    t[1][j] = Integer.MAX_VALUE - 1;
                }
            }
        }

        for(int i=2; i<coin.length+1; i++){
            for(int j =1; j<sum+1; j++){
                if(coin[i-1] <= j){
                    t[i][j] = Math.min((t[i][j-coin[i-1]] +1),t[i-1][j]);
                } else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        System.out.println(" Min number of ways: "+t[coin.length][sum]);
        return t[coin.length][sum];
    }
}
