package jb.algorithm.tree;

/**
 * This class is responsible for determining distance of any given key from root in binary tree
 * Time complexity is O(2^k)
 * Space Complexity is O(k)
 *
 * @author jbhushan
 */
public class kDistance {

    public static void main(String[] args){

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);
        treeNode1.left.right =  new TreeNode(12);
        treeNode1.right.left =  new TreeNode(2);

        kDistanceFromRoot(treeNode1, 1, 0);
    }

    public static void kDistanceFromRoot(TreeNode tree, int k, int distance){

        if(tree != null){
            if(k == distance){
                System.out.print(tree.val+ " ");
            }
            kDistanceFromRoot(tree.left, k , distance+1);
            kDistanceFromRoot(tree.right, k , distance+1);
        }
    }

    public static void kDistanceFromKey(TreeNode tree, int k, int distance) {
        if(tree != null){
            if(distance == 0){
                System.out.print(tree.val+ " ");
            } else {
                kDistanceFromKey(tree.left, k , distance-1);
                kDistanceFromKey(tree.right, k , distance-1);
            }

        }
    }
}
