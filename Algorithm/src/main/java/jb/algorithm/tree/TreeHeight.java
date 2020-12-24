package jb.algorithm.tree;

/**
 * @author jbhushan
 */
public class TreeHeight {

    public static void main(String[] args){

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.right =  new TreeNode(2);

        treeNode.right.left =  new TreeNode(2);

        int size = height(treeNode);
        System.out.println(size);
    }

    private static  int height(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
         if(treeNode.left == null && treeNode.right == null){
             return 0;
         }
         int left, right = 0;
         left = height(treeNode.left);
         right= height(treeNode.right);
        return 1 + (left>right ? left:right);
    }
}
