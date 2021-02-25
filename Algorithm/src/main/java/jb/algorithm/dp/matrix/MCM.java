package jb.algorithm.dp.matrix;

/**
 * @author jbhushan
 */
public class MCM {

    public static void main(String[] args){
        MCM mcm = new MCM();
        int[] a = {10,20,30,40,30};
        mcm.mcm(a);

    }

    private int mcm(int[] arr){
        int i = 1;
        int j = arr.length-1;
        int[][] t = new int[arr.length+1][arr.length+1];

        for(int m=0; m<arr.length+1;m++){
            for(int n=0; n<arr.length+1;n++){
                t[i][j] = -1;

            }
        }
        int cost =calculateCost(arr, i, j,t);
        System.out.println("Cost "+cost);
        return cost;
    }

    private int calculateCost(int[] arr, int i, int j, int[][] t) {
        if(i>=j){
            return 0;
        }
        if(t[i][j] != -1){
            return t[i][j];
        }

        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j-1;k++){
            int temp = calculateCost(arr,i,k,t)+calculateCost(arr,k+1,j,t)+
                    (arr[i-1]*arr[k]*arr[j]);
            if(temp<min){
               min = temp;
            }
        }
        t[i][j] = min;
        return  min;
    }
}
