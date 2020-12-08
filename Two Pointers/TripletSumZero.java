import java.util.*;

public class TripletSumZero {
    
    public static List<List<Integer>> triplet_sum_zero(int[] array){
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++){
            if (i > 0 && array[i] == array[i-1]){
                continue; 
            }
            pair_target_sum(array, (array[i] * -1), i+1, triplets);
        }
        return triplets;
    }
    
    public static void pair_target_sum(int[] array, int target, int start, List<List<Integer>> triplets){
        int end = array.length - 1; 
        while (start < end){
            if (array[start] + array[end] == target){
            triplets.add(Arrays.asList((-1 * target), array[start], array[end]));
            start += 1; 
            end -= 1; 
            while (start < end && array[start] == array[start - 1]){
                start += 1; 
            }
            while (start < end && array[end] == array[end - 1]){
                end -= 1; 
            }
            } else if (target > array[start] + array[end]){
                start += 1; 
            } else {
                end -= 1; 
            }
        }
    }
    

    public static void main(String[] args) {
        int[] array = new int[]{-3, 0, 1, 2, -1, 1, -2};
        System.out.println(TripletSumZero.triplet_sum_zero(array));
    }
}
