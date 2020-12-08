import java.util.*;

public class MaxDistinct {
    
    public static int findMaxDistinct(int[] nums, int k) {
        int distinctCount = 0;
        if (nums.length <= k) {
            return distinctCount;
        }

        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int num : nums){
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((n1, n2) -> n1.getValue() - n2.getValue());

        for (Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {
            if (entry.getValue() == 1) {
                distinctCount += 1;
            } else {
                minHeap.add(entry);
            }
        }

        while (k > 0 && !minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> currEntry = minHeap.poll();
            k -= currEntry.getValue() - 1;
            if (k >= 0) {
                distinctCount += 1;
            }
        }

        if (k > 0) {
            distinctCount -= k;
        }
        return distinctCount;
    }

    public static void main(String[] args) {
        int result = MaxDistinct.findMaxDistinct(new int[] {7,3,5,8,5,3,3}, 2);
        System.out.println(result);
        result = MaxDistinct.findMaxDistinct(new int[] {3,5,12,11,12}, 3);
        System.out.println(result);
        result = MaxDistinct.findMaxDistinct(new int[] {1,2,3,3,3,3,4,4,5,5,5}, 2);
        System.out.println(result);
    }
}
