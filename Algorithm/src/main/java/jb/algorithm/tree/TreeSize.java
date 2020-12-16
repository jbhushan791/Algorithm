package jb.algorithm.tree;

/**
 * @author jbhushan
 */
public class TreeSize {

    public static void main(String[] args){

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.right =  new TreeNode(2);

        treeNode.right.left =  new TreeNode(2);

        int size = getSize(treeNode);
        System.out.println(size);
    }

    private static  int getSize(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        return 1 + getSize(treeNode.left) + getSize(treeNode.right);
    }
}
