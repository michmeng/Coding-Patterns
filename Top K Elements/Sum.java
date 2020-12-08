import java.util.*;

public class Sum {
    
    public static int findSum(int[] nums, int k1, int k2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1,n2) -> n1 - n2);
        
        for (int num : nums) {
            minHeap.add(num);
        }

        for (int i = 0; i < k1; i++) {
            minHeap.poll();
        }

        int totalSum = 0;
        for (int i = 0; i < k2 - k1 - 1; i++) {
            totalSum += minHeap.poll();
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int result = Sum.findSum(new int[] {1,3,12,5,15,11}, 3, 6);
        System.out.println(result);
        result = Sum.findSum(new int[] {3,5,8,7}, 1, 4);
        System.out.println(result);
    }
}
