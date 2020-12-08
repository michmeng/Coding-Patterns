import java.util.*;

public class TopKFreq {
    
    public static List<Integer> findTopKFreq(int[] nums, int k) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int num : nums) {
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((n1, n2) -> n1.getValue() - n2.getValue());
        for (Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Integer> topNums = new ArrayList<>(k);
        while (!minHeap.isEmpty()) {
            topNums.add(minHeap.poll().getKey());
        }
        return topNums;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFreq.findTopKFreq(new int[] {1,3,5,12,11,11}, 2);
        System.out.println(result);
        result = TopKFreq.findTopKFreq(new int[] {5,12,11,3,11}, 2);
        System.out.println(result);
    } 
}
