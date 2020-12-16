package jb.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jbhushan
 */
public class LowestCommonAncestorBST {

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

        TreeNode i = iterativeVersion(treeNode1, 13, 9);
        System.out.println("Common Ancestor: " +i.val);
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

    private static TreeNode iterativeVersion(TreeNode t1, int p, int q){
        while (t1!=null){
            if( p > t1.val && q > t1.val) {
                t1 = t1.right;
            } else if( p < t1.val && q < t1.val) {
                t1 = t1.left;
            }else{
                break;
            }
        }
        return t1;
    }
}
