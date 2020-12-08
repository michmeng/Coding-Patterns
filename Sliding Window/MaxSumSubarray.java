import java.util.*;

public class MaxSumSubarray {

    public static int maxSumSubarray(int[] array, int k){
        if (array.length == 0 || array.length < k){
            return -1; 
        }
        int curr_sum = 0;
        for (int i = 0; i < k; i++){
            curr_sum = curr_sum + array[i];
        }
        int max_sum = curr_sum;
        for (int i = k; i < array.length; i++){
            curr_sum = curr_sum - array[i - k] + array[i];
            if (curr_sum > max_sum){
                max_sum = curr_sum;
            }
        }
        return max_sum;
        }

    public static void main(String[] args) {
        int[] array = new int[] {0,4,2,7,1,1,0,6};
        int k = 3;
        System.out.println("HI");
        System.out.println(MaxSumSubarray.maxSumSubarray(array, k));
        }   
}
