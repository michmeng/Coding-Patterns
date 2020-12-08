import java.util.*;

public class ZigZagTraversal {

    public static List<List<Integer>> zigZagTraverse(TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null){
            return result;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int level = 0;
        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();
                List<Integer> currLevel = new LinkedList<Integer>();
                for (int i = 0; i < levelSize; i++){
                    TreeNode currNode = nodeQueue.poll();
                    if (level % 2 == 0){
                        currLevel.add(currNode.val);
                    } else {
                        currLevel.add(0, currNode.val);
                    }
                    if (currNode.left != null){
                        nodeQueue.offer(currNode.left);
                    if (currNode.right != null){
                        nodeQueue.offer(currNode.right);
                    }
                    }
                }   
            result.add(currLevel);
            level += 1; 
            }
        return result;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigZagTraversal.zigZagTraverse(root);
        System.out.println(result);
    }
}
