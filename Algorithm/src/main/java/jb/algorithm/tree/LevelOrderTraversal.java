package jb.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jbhushan
 */
public class LevelOrderTraversal {

    public static void main(String[] args){

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);
        treeNode1.left.right =  new TreeNode(12);
        treeNode1.right.left =  new TreeNode(2);

        System.out.println(treeNode1.val+" "+treeNode1.left.val+" "
                +treeNode1.right.val+" "+treeNode1.left.right.val+" "+treeNode1.right.left.val);
        levelOrderTraversal(treeNode1);
//        System.out.println(treeNode1.val+" "+treeNode1.left.val+" "
//                +treeNode1.right.val+" "+treeNode1.left.right.val+" "+treeNode1.right.left.val);
    }

    private static void levelOrderTraversal(TreeNode t1){
        if( t1 != null){
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(t1);
            TreeNode temp;
            while(!queue.isEmpty()){
                temp = queue.poll();
                System.out.println(" "+temp.val);
                if(temp.left !=null){
                    queue.add(temp.left);
                }
                if(temp.right !=null){
                    queue.add(temp.right);
                }
            }
        }

    }
}
