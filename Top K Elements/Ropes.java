import java.util.*;

public class Ropes {
    
    public static int minCostConnect(int[] ropeLengths) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer> ((n1,n2) -> n1 - n2);
        for (int i = 0; i < ropeLengths.length; i++) {
            minHeap.add(ropeLengths[i]);
        }
        int cost = 0;
        int currLength = 0;
        while (minHeap.size() > 1) {
            currLength = minHeap.poll() + minHeap.poll();
            cost += currLength;
            minHeap.add(currLength);
        }
        return cost;
    }

    public static void main(String[] args) {
        int result = Ropes.minCostConnect(new int[] {1,3,11,5});
        System.out.println(result);
        result = Ropes.minCostConnect(new int[] {3,4,5,6}); 
        System.out.println(result);
        result = Ropes.minCostConnect(new int[] {1,3,11,5,2});
        System.out.println(result);
    }
}
