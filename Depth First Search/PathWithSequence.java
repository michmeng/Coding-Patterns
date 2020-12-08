import java.util.*;

public class PathWithSequence {
    public static boolean findPath(TreeNode root, int[] sequence){
        if (root == null){
            return sequence.length == 0;
        }
        return findPathRecursive(root, sequence, 0);
    }

    public static boolean findPathRecursive(TreeNode curr, int[] sequence, int sequenceIndex){
        if (curr == null){
            return false;
        }

        if (sequenceIndex >= sequence.length || curr.val != sequence[sequenceIndex]){
            return false;
        }

        if (curr.left == null && curr.right == null && sequenceIndex == sequence.length - 1){
            return true;
        }

        return findPathRecursive(curr.left, sequence, sequenceIndex + 1) ||
                findPathRecursive(curr.right, sequence, sequenceIndex + 1);
    }


    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println(PathWithSequence.findPath(root, new int[]{1,0,1}));
        System.out.println(PathWithSequence.findPath(root, new int[]{2,1,1}));
    }
}
