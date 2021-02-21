package jb.algorithm.arrays.rotate;

/**
 * @author jbhushan
 */
public class LeftRotateUsingGcd {

    public static void main(String[] args){
        int[] n2 = {1,2,3,4,5,6,7,8,9};
        rotateUsingGcd(n2,3);


    }

    public static void rotateUsingGcd(int[] arr, int k){
        int length = arr.length;
        int gcd = gcd(length, k);
        System.out.println(gcd+" -> GCD");

        int j =0;
        int temp=0;
        int d = -1;
        for(int i =0; i<gcd; i++){
            temp = arr[i];
            j=i;
          while(true){
            d = (j+k) % length;
              System.out.println(d+" -> d");
            if(d==i){
                break;
            }
            arr[j] = arr[d];
            j=d;
          }
          arr[j] = temp;
        }

       for(int n : arr){
           System.out.print(n+" ");
       }
    }

   private static int gcd(int length, int k){
        if(k ==0){
            return length;
        } else {
            return gcd(k, length%k);
        }
   }

}
