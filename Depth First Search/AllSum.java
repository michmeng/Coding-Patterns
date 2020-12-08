import java.util.*;

public class AllSum {
    
    public static List<List<Integer>> AllPath(TreeNode root, int sum){
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<Integer>();
        findRecursivePath(root, sum, currentPath, allPaths);
        return allPaths;
    }

    public static void findRecursivePath(TreeNode curr, int sum, List<Integer> currentPath, List<List<Integer>> allPaths){
        if (curr == null){
            return;
        }

        currentPath.add(curr.val);

        if (curr.val == sum && curr.left == null && curr.right == null){
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            findRecursivePath(curr.left, sum - curr.val, currentPath, allPaths);
            findRecursivePath(curr.right, sum - curr.val, currentPath, allPaths);
        }

        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println(AllSum.AllPath(root, 23));
    }
}
