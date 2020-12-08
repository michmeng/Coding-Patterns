import java.util.*;

public class AllSchedules {
    public static void printOrders(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>(); 
        if (tasks <= 0) {
            return;
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

        printAll(adjList, inDegree, sources, sortedOrder);
    }
    
    public static void printAll(HashMap<Integer, List<Integer>> adjList, HashMap <Integer, Integer> inDegree, Queue<Integer> sources, List<Integer> sortedOrder) {
        if (!sources.isEmpty()) {
            for (Integer vertex : sources) {
                sortedOrder.add(vertex);
                Queue<Integer> sourcesNext = cloneQueue(sources);
                sourcesNext.remove(vertex);
                List<Integer> children = adjList.get(vertex);
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0) {
                        sourcesNext.add(child);
                    }
                }
                printAll(adjList, inDegree, sourcesNext, sortedOrder);
                sortedOrder.remove(vertex);
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) + 1);
                }
            }
        }
        if (sortedOrder.size() == inDegree.size()) {
            System.out.println(sortedOrder);
        }
    }

    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue) {
            clone.add(num);
        }
        return clone;
    }

    public static void main(String[] args) {
        AllSchedules.printOrders(3, new int[][]
            {new int[] {0,1}, new int[] {1,2}});

        System.out.println();

        AllSchedules.printOrders(4, new int[][]
            {new int[] {3,2}, new int[] {3,0}, new int[] {2,0} , new int[] {2,1}});

        System.out.println();

        AllSchedules.printOrders(6, new int[][]
            {new int[] {2,5}, new int[] {0,5}, new int[] {0,4}, new int[] {1,4}, new int[] {3,2}, new int[] {1,3}});
    }
}
