package jb.algorithm.tree;

/**
 * @author jbhushan
 */
public class IdenticalTree {

    public static void main(String[] args){

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);
        treeNode1.left.right =  new TreeNode(12);
        treeNode1.right.left =  new TreeNode(2);

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(3);
        //treeNode2.left.right =  new TreeNode(12);
        treeNode2.right.left =  new TreeNode(2);

        boolean identical =  isIdentical(treeNode1,treeNode2);
        System.out.println(identical);
    }

    private static boolean isIdentical(TreeNode t1, TreeNode t2){

        if(t1==null && t2==null){
            return true;
        }

        if(t1==null || t2==null){
            return false;
        }
        return (t1.val == t2.val) && isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right);
    }
}
