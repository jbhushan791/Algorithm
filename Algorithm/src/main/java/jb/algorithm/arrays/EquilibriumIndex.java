package jb.algorithm.arrays;


/**
 * It is also called pivot index
 *
 * @author jbhushan
 */
public class EquilibriumIndex {

    public static void main(String[] args){
        int[] arr = {7,2,1,4,6,4,0};
        int index = equilibriumIndex(arr);
        System.out.println(index);
    }

    public static int equilibriumIndex(int[] arr) {

        int sum = 0;
        int leftSum = 0;
        for(int i=0; i< arr.length; i++){
            sum+=arr[i];
        }

        for(int i=0; i< arr.length; i++){
            sum -= arr[i];
            if(leftSum == sum){
                return i;
            }
            leftSum += arr[i];
        }

       return -1;
    }
}
