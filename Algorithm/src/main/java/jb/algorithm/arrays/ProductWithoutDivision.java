package jb.algorithm.arrays;

/**
 * @author jbhushan
 */
public class ProductWithoutDivision {

    public static void main(String[] args){
        int[] arr = {10,20,30,40};
        product(arr);
        System.out.println();
        method2(arr);
    }

    public static void product(int[] arr) {
        int[] leftProduct = new int[arr.length];
        leftProduct[0] = 1;
        for(int i =1; i< arr.length; i++){
            leftProduct[i] = leftProduct[i-1]*arr[i-1];
        }

        int[] rightProduct = new int[arr.length];
        rightProduct[arr.length-1]=1;
        for(int i =arr.length-2; i>=0; i--){
            rightProduct[i] = rightProduct[i+1] * arr[i+1];
        }

        for(int i =0; i< arr.length; i++){
            arr[i] = rightProduct[i] *leftProduct[i];
        }

        for(int i =0; i< arr.length; i++){
            System.out.print(arr[i] +" ");
        }

    }

    private static int[] method2(int[] nums){
        int[] product = new int[nums.length];
        product[0]=1;
        for(int i=1; i< nums.length; i++){
            product[i] = product[i-1] * nums[i-1];
        }

        int p =1;
        for(int i=nums.length-1; i>=0; i--){
            product[i] = product[i] * p;
            p *= nums[i];
        }

        for(int i =0; i< nums.length; i++){
            System.out.print(nums[i] +" ");
        }
        return product;
    }
}
