package jb.algorithm.arrays;

/**
 * @author jbhushan
 */
public class FindMaxDifference {

    public static void main(String[] args){
        int[] arr = {3,1,4,7,5,100,10};

        int num = findMaxDifference(arr);
        System.out.println(num);

        num = efficient(arr);
        System.out.println(num);

        num = findMaxDiff(arr);
        System.out.println(num);
    }

    public static int findMaxDifference(int[] arr) {
        int maxDifference = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] < arr[j]){
                    maxDifference = Math.max(maxDifference, arr[j] - arr[i]);
                }
            }
        }
        return maxDifference;
    }

    public static int efficient(int[] arr) {

        int[] diffArray = new int[arr.length-1];
        for(int i=0; i<arr.length-1; i++){
            diffArray[i] = arr[i+1]-arr[i];
        }

        int maxDiff = diffArray[0];
        for(int i=1; i<arr.length-1; i++){
            if(diffArray[i-1] > 0){
                diffArray[i] = diffArray[i]+ diffArray[i-1];
            }
            maxDiff = Math.max(maxDiff, diffArray[i]);
        }
        return maxDiff;
    }

    public static int findMaxDiff(int[] arr){
        int minNumSoFar = arr[0];
        int maxDiffSoFar = arr[1]-arr[0];
        int currentDiff = arr[1]-arr[0];

        for(int i =1; i< arr.length; i++){
            if(arr[i] < minNumSoFar){
                minNumSoFar = arr[i];
            } else {
                currentDiff = arr[i] - minNumSoFar;
                if(currentDiff > maxDiffSoFar){
                    maxDiffSoFar = currentDiff;
                }
            }
        }
        return maxDiffSoFar;
    }
}
