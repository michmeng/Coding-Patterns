import java.util.*;

public class TripleSumSmaller {

    public static int triple_sum_smaller(int[] array, int target){
        int count = 0; 
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++){
            count += pair_sum_smaller(array, i, target - array[i]);
        }
        return count;
    }
    
    public static int pair_sum_smaller(int[] array, int start, int target){
        start += 1; 
        int end = array.length - 1;
        int add_count = 0;
        while(start < end){
            if (array[start] + array[end] < target){
                add_count += end - start;
                start += 1;
            }
            else {
                end -= 1;
            }
        }
        return add_count;
    }
        
    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 2, 3};
        int target = 3;
        System.out.println(TripleSumSmaller.triple_sum_smaller(array, target));
    }
}
