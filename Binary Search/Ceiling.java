public class Ceiling {
    public static int searchCeiling(int[] arr, int key) {
        if (key > arr[arr.length - 1]) {
            return -1;
        }
        
        int start = 0; 
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(Ceiling.searchCeiling(new int[] {4,6,10}, 6));
        System.out.println(Ceiling.searchCeiling(new int[] {1,3,8,10,15}, 12));
        System.out.println(Ceiling.searchCeiling(new int[] {4,6,10}, 17));
        System.out.println(Ceiling.searchCeiling(new int[] {4,6,10}, -1));
    }
}
