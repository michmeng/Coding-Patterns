import java.util.*;

public class CountPathsWithSum {
    public static int countPaths(TreeNode root, int S){
        List<Integer> currPath = new LinkedList<>();
        return countPathsRec(root, S, currPath);
    }
    
    public static int countPathsRec(TreeNode currNode, int S, List<Integer> currPath){
        if (currNode == null){
            return 0;
        }

        currPath.add(currNode.val);
        int currPathCount = 0;
        int pathSum = 0;
        ListIterator<Integer> pathIterator = currPath.listIterator(currPath.size());
        while(pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();
            if (pathSum == S) {
                currPathCount += 1;
            }
        }

        currPathCount += countPathsRec(currNode.left, S, currPath);
        currPathCount += countPathsRec(currNode.right, S, currPath);

        currPath.remove(currPath.size() - 1);

        return pathCount;
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println(CountPathsWithSum.countPaths(root, 11));
    }   
}
