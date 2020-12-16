package jb.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jbhushan
 */
public class LowestCommonAncestor {

    public static void main(String[] args){

        TreeNode treeNode1 = new TreeNode(20);
        treeNode1.left = new TreeNode(7);
        treeNode1.right = new TreeNode(21);
        treeNode1.left.right =  new TreeNode(11);
        treeNode1.left.left =  new TreeNode(3);
        treeNode1.left.right.left =  new TreeNode(9);
        treeNode1.left.right.right =  new TreeNode(13);

        LevelOrderTraversal.levelOrderTraversal(treeNode1);

        TreeNode ancestor = lowestCommonAncestor(treeNode1, 13, 9);
        System.out.println();
        System.out.println("Common Ancestor: " +ancestor.val);
    }

    private static TreeNode lowestCommonAncestor(TreeNode t1, int p, int q){
        if(t1 == null){
            return null;
        }
        if( p > t1.val && q > t1.val) {
            return lowestCommonAncestor(t1.right, p, q);
        }
        if( p < t1.val && q < t1.val) {
            return lowestCommonAncestor(t1.left, p, q);
        }
        return t1;

    }
}
