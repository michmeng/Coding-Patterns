import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }

void printLevelOrder(){
    TreeNode nextLevelRoot = this;
    while (nextLevelRoot != null){
        TreeNode current = nextLevelRoot;
        nextLevelRoot = null;
        while (current != null){
            System.out.println(current.val + " ");
            if (nextLevelRoot == null) {
                if (curr.left != null){
                    nextLevelRoot = current.left;
                } else if (current.right != null) {
                    nextLevelRoot = current.right;
                }
            } 
            current = current.next;
        }
        System.out.println();
    }
}
};

public class LevelTraversal {
    public static List<List<Integer>> traverse(TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null){
            return result;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while(!nodeQueue.isEmpty()){
            int levelSize = nodeQueue.size();
            List<Integer> currLevel = new ArrayList<Integer>(levelSize);
            for (int i = 0; i < levelSize; i++){
                TreeNode currNode = nodeQueue.poll();
                currLevel.add(currNode.val);

                if (currNode.left != null){
                    nodeQueue.offer(currNode.left);
                if (currNode.right != null){
                    nodeQueue.offer(currNode.right);
                }
                }
            }
            result.add(currLevel);
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
        List<List<Integer>> result = LevelTraversal.traverse(root);
        System.out.println(result);
    }
}
