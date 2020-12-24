package jb.algorithm.tree;

/**
 * @author jbhushan
 */
public class Diameter {

    private int height;

    public static void main(String[] args){

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        Diameter diameter = new Diameter();
        int h = 0;
        int d =  diameter.diameter(tree,h);
        System.out.println(d);
        System.out.println(h);
    }

    public int diameter(TreeNode t1, int height){
       // this.height = height;

        int leftHeight =0;
        int rightHeight =0;
        int leftDiameter =0;
        int rightDiameter =0;

        if(t1.left==null && t1.right==null){
            height = 1;
            return 1;
        }
         leftDiameter = diameter(t1.left, leftHeight);
         rightDiameter = diameter(t1.right, rightHeight);
        height = Math.max(leftHeight,rightHeight)+1;
        return Math.max(rightHeight+leftHeight+1,Math.max(leftDiameter, rightDiameter));
    }
}
