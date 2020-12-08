import java.util.*;

class FindMedianSlidingWindow {
    
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public FindMedianSlidingWindow(){
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
        minHeap = new PriorityQueue<>((a,b) -> a - b);

    }

    public void insertNum(int num){
        if(maxHeap.isEmpty() || maxHeap.peek() >= num){
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        ///balance heaps
        if (maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }

    }

    public void rebalance(){
        if (maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek()/2.0 + minHeap.peek()/2.0);
        }
        return maxHeap.peek();
    }

    public double[] findMedianSliding(int[] nums, int k){
        double[] result = new double[nums.length - k + 1];
        int removeIndex = 0;
        int insertIndex = k;
        int resultAddIndex = 1;
        ///build initial heap and add first median
        for (int i = 0; i < k; i++){
            insertNum(nums[i]);
        }
        result[0] = findMedian();
        while(insertIndex < nums.length){
            ///remove element 
            if(nums[removeIndex] <= maxHeap.peek()){
                maxHeap.remove(nums[removeIndex]);
            } else {
                minHeap.remove(nums[removeIndex]);
            }
            removeIndex += 1; 
            rebalance();
            ///add new element 
            insertNum(nums[insertIndex]);
            ///add median to result 
            result[resultAddIndex] = findMedian();
            insertIndex += 1;
            resultAddIndex += 1;
        }
        return result;
    }

    public static void main(String[] args){
        FindMedianSlidingWindow medianOfStream = new FindMedianSlidingWindow();
        double[] result = medianOfStream.findMedianSliding(new int[]{1,2,-1,3,5}, 2);
        for (double num: result){
            System.out.print(num + " ");
        }
        System.out.println();

        FindMedianSlidingWindow medianOfStream2 = new FindMedianSlidingWindow();
        double[] result2 = medianOfStream2.findMedianSliding(new int[]{1,2,-1,3,5}, 3);
        for (double num: result2){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
