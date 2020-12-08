import java.util.*;

public class Sort {
    
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (vertices <= 0) {
            return sortedOrder;
        }

        HashMap<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        HashMap<Integer, Integer> inDegree = new HashMap<Integer, Integer>();
        for (int i = 0; i < vertices; i++){
            inDegree.put(i,0);
            adjList.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            adjList.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
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

        if (sortedOrder.size() != vertices) {
            return new ArrayList<>();
        }
        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = Sort.sort(4, 
            new int[][] {new int[] {3,2}, new int[] {3,0}, new int[] {2,0}, new int[] {2,1}});
        System.out.println(result);
        result = Sort.sort(5, 
            new int[][] {new int[] {4,2}, new int[] {4,3}, new int[] {2,0}, new int[] {2,1}, new int[] {3,1}});
        System.out.println(result);
        result = Sort.sort(7, 
            new int[][] {new int[] {6,4}, new int[] {6,2}, new int[] {5,3}, new int[] {5,4}, new int[] {3,0}, new int[] {3,2}, new int[] {4,1}});
        System.out.println(result);
    }
}
