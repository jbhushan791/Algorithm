package jb.algorithm.tree;

/**
 * This class is responsible for determining level of any given key in binary tree
 * Time complexity is O(n)
 * Space Complexity is O(h) : Balance tree then log(n)
 *
 * @author jbhushan
 */
public class Level {

    public static void main(String[] args){

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);
        treeNode1.left.right =  new TreeNode(12);
        treeNode1.right.left =  new TreeNode(2);

        int level = getLevel(treeNode1, 1, 1);

        if(level == -1 ){
            System.out.println(" Key is not found");
        } else {
            System.out.println("Level "+level);
        }
    }

    public static int getLevel(TreeNode tree, int level, int key){

        if(tree == null){
            return -1;
        }

        if(tree.val == key){
            return level;
        }

        int l = getLevel(tree.left, level+1, key);
        if(l != -1){
            return l;
        }
        return getLevel(tree.right, level+1, key);
    }
}
