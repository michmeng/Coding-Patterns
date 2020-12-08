import java.util.*;

public class TaskOrder {
    
    public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>(); 
        if (tasks <= 0) {
            return sortedOrder;
        }

        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            adjList.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];
            adjList.get(parent).add(child);
            inDegree.put(child, inDegree.get(child)+1);
        }

        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = adjList.get(vertex);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        if (sortedOrder.size() != tasks) {
            return new ArrayList<>();
        }

        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = TaskOrder.findOrder(3, new int[][]
            {new int[] {0,1}, new int[] {1,2}});
        System.out.println(result);

        result = TaskOrder.findOrder(3, new int[][]
            {new int[] {0,1}, new int[] {1,2}, new int[] {2,0}});
        System.out.println(result);

        result = TaskOrder.findOrder(6, new int[][]
            {new int[] {2,5}, new int[] {0,5}, new int[] {0,4}, new int[] {1,4}, new int[] {3,2}, new int[] {1,3}});
        System.out.println(result);
    }
    
}
