import java.util.*;

class Point {
    int x;
    int y; 

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distFromOrigin() {
        // this ignores square root 
        return (x * x) + (y * y);
    }
}

public class KClosestPoints {
    
    public static List<Point> findClosest(Point[] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());
        for (int i = 0; i < k; i++) {
            maxHeap.add(points[i]);
        }

        for (int i = k; i < points.length; i++) {
            if (points[i].distFromOrigin() < maxHeap.peek().distFromOrigin()) {
                maxHeap.poll();
                maxHeap.add(points[i]);
            }
        }
        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        Point[] points = new Point[] {new Point(1,3), new Point(3,4), new Point (2,-1)};
        List<Point> result = KClosestPoints.findClosest(points, 2);
        for (Point p : result) {
            System.out.print("[" + p.x + " , " + p.y + "]");
        }
    }
}
