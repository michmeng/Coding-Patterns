public class Range {
    
    public static int[] findRange(int[] arr, int key){
        int[] result = new int[] {-1,-1};
        int start = 0; 
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]){
                start = mid + 1;
            } else { 
                for (int i = mid + 1; i < arr.length; i++){
                    if (arr[i] != key) {
                        end = i - 1; 
                        break;
                    }
                }
                for (int i = mid ; i >= 0; i--){
                    if (arr[i] != key) {
                        start = i + 1; 
                        break;
                    }
                }
                return new int[] {start, end};
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] result = Range.findRange(new int[] {4,6,6,6,7}, 6);
        System.out.println(result[0] + " " + result[1]);
        result = Range.findRange(new int[] {1,3,8,10,15}, 10);
        System.out.println(result[0] + " " + result[1]);
        result = Range.findRange(new int[] {1,3,8,10,15}, 12);
        System.out.println(result[0] + " " + result[1]);
    }
}
