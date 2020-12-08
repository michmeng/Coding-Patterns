import java.util.*;

class Node {
    int row; 
    int col;

    Node (int row, int col) {
        this.row = row; 
        this.col = col;
    }
}

public class KthSmallestInMatrix {
    
    public static int find(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1,n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);

        for (int i = 0; i < matrix.length && i < k; i++) {
            minHeap.add(new Node(i,0));
        }

        int count = 0;
        int result = 0;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result = matrix[node.row][node.col];
            if (++count == k) {
                break;
            }
            node.col += 1;
            if (matrix[0].length > node.col) {
                minHeap.add(node);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int matrix[][] = {{2,6,8},{3,7,10},{5,8,11}};
        int result = KthSmallestInMatrix.find(matrix, 5);
        System.out.println(result);
    }
}
