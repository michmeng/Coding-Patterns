import java.util.*;

public class KthSmallest {
    
    public static int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1,n2) -> n2 - n1);
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (maxHeap.peek() > nums[i]) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        } 

        return (maxHeap.peek());
    }

    public static void main(String [] args) {
        int result = KthSmallest.findKthSmallest(new int[] {1,5,12,2,11,5}, 3);
        System.out.println(result);
        result = KthSmallest.findKthSmallest(new int[] {1,5,12,2,11,5}, 4);
        System.out.println(result);
        result = KthSmallest.findKthSmallest(new int[] {5,12,11,-1,12}, 3);
        System.out.println(result);        
    }
}
