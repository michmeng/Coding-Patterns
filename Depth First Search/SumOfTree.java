import java.util.*;

public class SumOfTree {

    public static int treeSum(TreeNode root) {
        return findTreeSum(root, 0);
    }

    public static int findTreeSum(TreeNode curr, int totalSum){
        if (curr == null){
            return 0; 
        }

        totalSum = 10 * totalSum + curr.val;

        if (curr.left == null && curr.right == null){
            return totalSum;
        } 

        return findTreeSum(curr.left, totalSum) + findTreeSum(curr.right, totalSum);
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println(SumOfTree.treeSum(root));
    }
}
