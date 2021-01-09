package jb.algorithm.arrays.rotate;

/**
 * @author jbhushan
 */
public class LeftRotateByDElements {

    public static void main(String[] args){

        int[] nums = {1,2,3,4,5,6};
        rotateUsingArray(nums,3);

        System.out.println();

        int[] n = {1,2,3,4,5,6};
        rotateUsingConstant(n,3);

        System.out.println();

        int[] n2 = {1,2,3,4,5,6};
        rotateUsingGcd(n2,3);

        System.out.println();
        
        int[] n1 = {1,2,3,4,5,6};
        rotateUsingReverse(n1,3);

    }

    public static void rotateUsingArray(int[] arr, int d){

        int[] temp = new int[d];
        for(int i = 0; i<d; i++){
            temp[i] = arr[i];
        }

        for(int i = 0; i< arr.length-d; i++){
            arr[i] = arr[i+d];
        }

        int j =0;
        for(int i = arr.length-d; i< arr.length; i++){
            arr[i] = temp[j];
            j++;
        }

        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void rotateUsingConstant(int[] nums, int k){
        while( k !=0){
            rotate(nums);
            k--;
        }

        for(int n : nums){
            System.out.print(n+" ");
        }
    }

    private static void rotate(int[] nums){
        int temp = nums[nums.length-1];
        for(int i = nums.length-1; i>=1; i--){
            nums[i] = nums[i-1];
        }
        nums[0]=temp;
    }

    public static void rotateUsingGcd(int[] arr, int d){
        int length = arr.length;
        int gcd = 0;
        for(int i = 1; i <= length && i <= d; i++){
            if(length%i==0 && d%i==0)
                gcd = i;
        }

        for(int i =0; i<gcd; i++){
            int t = arr[i];
            arr[i] = arr[i+d];
            arr[i+d] = t;
        }

       for(int n : arr){
           System.out.print(n+" ");
       }
    }

    public static void rotateUsingReverse(int[] arr, int d){
        int length = arr.length;
        int l = 0;
        int r = d-1;
        reverse(arr, l, r);

        l = d;
        r = length-1;
        reverse(arr, l, r);

        reverse(arr, 0, length-1);

        for(int i=0; i<length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }


}
