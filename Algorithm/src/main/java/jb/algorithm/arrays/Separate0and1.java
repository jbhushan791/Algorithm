package jb.algorithm.arrays;

/**
 * @author jbhushan
 */
public class Separate0and1 {

    public static void main(String[] args){
        int[] arr = {1,1,0,1,0,0,1};
        separate(arr);

        for(int n : arr){
            System.out.print(n + " ");
        }
    }

    public static void separate(int[] arr) {
       int l = 0;
       int r = arr.length -1;

       while(l < r){
            while((arr[l] == 0) && (l < r) ){
                l++;
            }
           while((arr[r] == 1) && (l < r) ){
               r--;
           }

           if(l<r){
               arr[l++]=0;
               arr[r--]=1;
           }
       }
    }
}
