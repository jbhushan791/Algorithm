package jb.algorithm.arrays;

/**
 * @author jbhushan
 */
public class FindElementWithN2Times {

    public static void main(String[] args){
        int[] arr = {1,5,5,5,5,5,6,6};
        int num = efficient(arr);
        System.out.println(num);

        num = findMaxElement(arr);
        System.out.println(num);
    }

    public static int findMaxElement(int[] arr) {
        int l = 0;
        if(arr.length % 2 == 0){
            l = arr.length/2;
        } else {
           l = (arr.length/2) +1;
        }
        for(int i=0; i<l; i++){
            if(arr[i] == arr[i+((arr.length/2))]) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int efficient(int[] arr) {
        int voter = arr[0];
        int count = 1;
        for(int i=1; i<arr.length; i++){
            if(arr[i] != voter){
                count--;
            } else {
                count++;
            }
            if(count == 0){
                voter = arr[i];
            }
        }
        int c = 0;
        for(int num: arr){
            if(voter == num){
                c++;
            }
        }

        if(c  > arr.length/2){
            return voter;
        }
        return -1;
    }

}
