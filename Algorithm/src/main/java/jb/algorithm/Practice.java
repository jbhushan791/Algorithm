package jb.algorithm;

/**
 * @author jbhushan
 */
public class Practice {

    public static void main(String[] args){
        int[] n2 = {1,2,3,4,5,6,7,8,9};
        rotationByGcd(n2,3);
    }

    public static void rotationByGcd(int[] nums, int k){
        int len = nums.length;
        int gcd = gcd(len, k);
        int j =-1;
        int temp =-1;
        int d =-1;
        for(int i=0; i<gcd;i++){
            temp = nums[i];
            j=i;
            while(true){
                d = (j+k) % len;
                if(d==i){
                    break;
                }
                nums[j] = nums[d];
                j=d;
            }
            nums[j]=temp;
        }

        for(int n : nums){
            System.out.print(n +" ");
        }
    }

    public static int gcd(int length, int k){
        if(k==0){
            return length;
        } else{
            return gcd(k, length%k);
        }
    }
}
