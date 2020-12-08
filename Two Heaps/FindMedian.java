import java.util.*;

class FindMedian {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public FindMedian(){
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

    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek()/2.0 + minHeap.peek()/2.0);
        }
        return maxHeap.peek();
    }

    public static void main(String[] args){
        FindMedian medianOfStream = new FindMedian();
        medianOfStream.insertNum(3);
        medianOfStream.insertNum(1);
        System.out.println(medianOfStream.findMedian());
        medianOfStream.insertNum(5);
        System.out.println(medianOfStream.findMedian());
        medianOfStream.insertNum(4);
        System.out.println(medianOfStream.findMedian());
    }

}
