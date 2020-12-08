import java.util.*;

public class PairWithTargetSum {

    public static int[] pair_target_sum(int[] array, int target){
        if (array.length == 0){
            return new int[] {-1,-1};
        }
        int start = 0;
        int end = array.length - 1; 
        while (start < end){ 
            if (array[start] + array[end] < target){
                start += 1;
            }
            else if (array[start] + array[end] > target){
                end -= 1;
            }
            else {
                return new int[] {start, end};
            }
        }
        return new int[] {-1,-1};
    }
    
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6};
        int target = 6;
        System.out.println(PairWithTargetSum.pair_target_sum(array, target)[0]);
        System.out.println(PairWithTargetSum.pair_target_sum(array, target)[1]);
    }  
}
