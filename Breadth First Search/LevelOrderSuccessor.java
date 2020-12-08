import java.util.*;

public class LevelOrderSuccessor {
    
    public static TreeNode findSuccessor(TreeNode root, int key){
        boolean nextIsSuccessor = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++){
                TreeNode currNode = queue.poll();
                if (nextIsSuccessor == true){
                    return currNode;
                }
                if (currNode.val == key){
                    nextIsSuccessor = true;
                }

                if (currNode.left != null){
                    queue.offer(currNode.left);
                }
                if (currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null){
            System.out.println(result.val + " ");
        }
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null){
            System.out.println(result.val + " ");
        }
    }
}
