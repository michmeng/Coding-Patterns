class ArrayReader { 
    int[] arr;

    ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length) {
            return Integer.MAX_VALUE;
        }
        return arr[index];
    }
}

public class InfiniteArray {

    public static int search(ArrayReader reader, int key) {
        // get bounds 
        int start = 0;
        int end = 1;
        while (reader.get(end) < key) {
            int currStart = end + 1;
            end += (end - start + 1) * 2;
            start = currStart;
        }
        while (start <= end) {
            int mid = start + (end - start)/2; 
            if (key < reader.get(mid)) {
                end = mid - 1;
            } else if (key > reader.get(mid)) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader(new int[] {4,6,8,10,12,14,16,18,20,22,24,26,28,30});
        System.out.println(InfiniteArray.search(reader, 16));
        System.out.println(InfiniteArray.search(reader, 11));
        reader = new ArrayReader(new int[] {1,3,8,10,15});
        System.out.println(InfiniteArray.search(reader, 15));
        System.out.println(InfiniteArray.search(reader, 200));
    }
    
}
