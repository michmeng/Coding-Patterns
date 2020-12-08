import java.util.*;

public class SmallestSubarray {

    public static int smallest_subarray(int[] array, int S){
        if (array.length == 0){
            return 0;
        }
        int min_length = Integer.MAX_VALUE;
        int curr_sum = 0;
        int start_index = 0;
        for (int i = 0; i < array.length; i++){
            curr_sum = curr_sum + array[i];
            while (curr_sum >= S){
                if (min_length > (i - start_index + 1)){
                    min_length = i - start_index + 1;
                }
                curr_sum = curr_sum - array[start_index];
                start_index = start_index + 1;
            }
        if (min_length != Integer.MAX_VALUE){
            return min_length;
        }
        }
        return 0;    
    }

    public static void main(String[] args) {
        int[] array = new int[] {0,2,5,9,4,1,1,0,4};
        int S = 5;
        System.out.println(SmallestSubarray.smallest_subarray(array, S));
        }   
}