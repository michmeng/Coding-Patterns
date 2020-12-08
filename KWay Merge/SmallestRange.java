import java.util.*;

class Node {
    int elementIndex;
    int arrayIndex;

    Node(int elementIndex, int arrayIndex) {
        this.elementIndex = elementIndex;
        this.arrayIndex = arrayIndex;
    }
}

class SmallestRange {
    
    public static int[] find(List<Integer[]> lists) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1,n2) -> lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);
        int start = 0; 
        int end = Integer.MAX_VALUE;
        int currMax = Integer.MIN_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                minHeap.add(new Node(0, i));
                currMax = Math.max(currMax, lists.get(i)[0]);
            }  
        }

        while (minHeap.size() == lists.size()) {
            Node node = minHeap.poll();
            if (end - start > currMax - lists.get(node.arrayIndex)[node.elementIndex]) {
                start = lists.get(node.arrayIndex)[node.elementIndex];
                end = currMax;
            }
            node.elementIndex += 1;

            if (lists.get(node.arrayIndex).length > node.elementIndex) {
                minHeap.add(node);
                currMax = Math.max(currMax, lists.get(node.arrayIndex)[node.elementIndex]);
            }
        }
        return new int[] {start, end};
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] {1,5,8};
        Integer[] l2 = new Integer[] {4,12};
        Integer[] l3 = new Integer[] {7,8,10};
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = SmallestRange.find(lists);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
