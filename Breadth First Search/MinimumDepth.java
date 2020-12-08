import java.util.*;

public class MinimumDepth {
    
    public static int findMinimumDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        int minDepth = 0; 
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            minDepth += 1;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++){
                TreeNode currNode = queue.poll();

                if (currNode.left == null && currNode.right == null){
                    return minDepth;
                }

                if (currNode.left != null){
                    queue.offer(currNode.left);
                }
                if (currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
        } 
        return minDepth;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println(MinimumDepth.findMinimumDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println(MinimumDepth.findMinimumDepth(root));
    }
}
