import java.util.*;

public class LargestK {
    
    public static List<Integer> findLargestK(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1,n2) -> n1 - n2);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        List<Integer> result = LargestK.findLargestK(new int[] {3,1,5,12,2,11,3}, 3);
        System.out.println(result);

        result = LargestK.findLargestK(new int[] {5,12,11,-1,12}, 3);
        System.out.println(result);
    }
}
 