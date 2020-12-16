package jb.algorithm.tree;

/**
 * @author jbhushan
 */
public class MirrorTree {

    public static void main(String[] args){

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);
        treeNode1.left.right =  new TreeNode(12);
        treeNode1.right.left =  new TreeNode(2);

        System.out.println(treeNode1.val+" "+treeNode1.left.val+" "
                +treeNode1.right.val+" "+treeNode1.left.right.val+" "+treeNode1.right.left.val);
        mirror(treeNode1);
        System.out.println(treeNode1.val+" "+treeNode1.left.val+" "
                +treeNode1.right.val+" "+treeNode1.left.right.val+" "+treeNode1.right.left.val);
    }

    private static void mirror(TreeNode t1){
        if( t1 == null){
            return;
        }
        mirror(t1.left);
        mirror(t1.right);
        TreeNode temp = t1.left;
        t1.left = t1.right;
        t1.right = temp;
    }
}
