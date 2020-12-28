package jb.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jbhushan
 */
public class RootToLeafSum {

    public static void main(String[] args){

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);
        treeNode1.left.right =  new TreeNode(12);
        treeNode1.right.left =  new TreeNode(2);

        boolean present = false;
        if(treeNode1 != null) {
            int sum = 0;
            present = rootToLeafSum(treeNode1, sum, 7);
        }
      System.out.println(present);
    }

    public static boolean rootToLeafSum(TreeNode t1, int sum, int givenSum){
        if( t1 != null){
            sum = sum + t1.val;
            if((t1.left == null && t1.right == null) && sum == givenSum){
                return true;
            }
           boolean present = rootToLeafSum(t1.left, sum , givenSum);
            if(present){
                return present;
            }
            present = rootToLeafSum(t1.right, sum , givenSum);
            if(present){
                return present;
            }
        }
        return false;
    }

    public static boolean approach2(TreeNode t1, int sum, int givenSum){
        return  false;
    }
}
