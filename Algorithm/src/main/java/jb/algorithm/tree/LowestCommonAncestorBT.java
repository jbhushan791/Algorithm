package jb.algorithm.tree;

/**
 * @author jbhushan
 */
public class LowestCommonAncestorBT {

    public static void main(String[] args){

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);
        treeNode1.left.right =  new TreeNode(5);
        treeNode1.left.left =  new TreeNode(5);
        treeNode1.left.right.left =  new TreeNode(6);
        treeNode1.left.right.right =  new TreeNode(7);

        LevelOrderTraversal.levelOrderTraversal(treeNode1);

        TreeNode ancestor = lowestCommonAncestor(treeNode1, 4, 5);
        System.out.println();
        System.out.println("Common Ancestor: " +ancestor.val);
    }

    private static TreeNode lowestCommonAncestor(TreeNode t1, int p, int q){
        if(t1 == null){
            return null;
        }
        if( p  == t1.val || q == t1.val) {
            return t1;
        }
        TreeNode leftLCA = lowestCommonAncestor(t1.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(t1.right, p, q);
        if( leftLCA != null && rightLCA != null) {
            return t1;
        }
        return (leftLCA != null) ? leftLCA :rightLCA;
    }

}
