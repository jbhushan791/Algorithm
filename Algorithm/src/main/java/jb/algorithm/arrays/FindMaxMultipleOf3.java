package jb.algorithm.arrays;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author jbhushan
 */
public class FindMaxMultipleOf3 {

    public static void main(String[] args){
        int[] arr = {3,9,6};

        int num = findMaxMultipleOf3(arr);
        System.out.println(num);

    }

    public static int findMaxMultipleOf3(int[] arr) {
        Arrays.sort(arr);
        LinkedList<Integer> l0 = new LinkedList<Integer>();
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        LinkedList<Integer> l2 = new LinkedList<Integer>();

        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(arr[i] % 3 == 0){
                l0.add(arr[i]);
            }else if(arr[i] % 3 == 1){
                l1.add(arr[i]);
            } else {
                l2.add(arr[i]);
            }
        }

        if(sum % 3 == 1){
            if(!l1.isEmpty()){
                l1.remove();
            } else {
                if(!l2.isEmpty()){
                    l2.remove();
                } else {
                    return 0;
                }

                if(!l2.isEmpty()){
                    l2.remove();
                } else {
                    return 0;
                }
            }
        } else if(sum % 3 == 2){
            if(!l2.isEmpty()){
                l2.remove();
            } else {
                if(!l1.isEmpty()){
                    l1.remove();
                } else {
                    return 0;
                }
                if(!l1.isEmpty()){
                    l1.remove();
                } else {
                    return 0;
                }
            }
        }

        int[] temp = new int[l0.size()+l1.size()+ l2.size()];

        for(int i=0; i<l0.size(); i++){
            temp[i] = l0.get(i);
        }

        for(int i=0; i<l1.size(); i++){
            temp[i] = l1.get(i);
        }

        for(int i=0; i<l1.size(); i++){
            temp[i] = l2.get(i);
        }

        //Sort in descending order
        Arrays.sort(temp);
        StringBuilder str = new StringBuilder(temp.length);
        for(int n : temp){
            str.append(n);
        }

        return Integer.parseInt(str.toString());
    }
}
