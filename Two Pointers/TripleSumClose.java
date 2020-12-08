import java.util.*;

public class TripleSumClose {

    public static int triplet_closest_sum(int[] array, int target){
        if (array.length < 2){
            return 0;
        }
        int closest_sum = Integer.MAX_VALUE;
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++){
            int start = i+1;
            int end = array.length - 1;
            while (start < end){
                int diff = target - array[i] - array[start] - array[end];
                if (diff == 0){
                    return target - diff;
                }
                if (Math.abs(diff) < Math.abs(closest_sum) || 
                    (Math.abs(diff) == Math.abs(closest_sum) && target > closest_sum)){
                    closest_sum = diff;
                }

                if (diff > 0){
                    start += 1;
                } else {
                    end -= 1;
                }
            }
        }
        return target - closest_sum; 
    }
    
    
    public static void main(String[] args) {
        int[] array = new int[]{-2, 0, 1, 2};
        int target = 2;
        System.out.println(TripleSumClose.triplet_closest_sum(array, target));
    }
}
