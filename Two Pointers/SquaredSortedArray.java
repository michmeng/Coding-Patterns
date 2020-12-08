import java.util.*;

public class SquaredSortedArray {
    
    public static int[] sorted_square(int[] array){
        int[] squared = new int[array.length];
        int insert_index = array.length - 1;
        int start = 0;
        int end = array.length - 1; 
        while (start <= end){
            if (array[start] * array[start] <= array[end] * array[end]){
                squared[insert_index--] = array[end] * array[end];
                end -= 1;
            }
            else {
                squared[insert_index--] = array[start] * array[start];
                start += 1;
            }
        }
        return squared;
    }
    

    public static void main(String[] args) {
        int[] array = new int[]{-2,-1,0,3,4};
        for (int i = 0; i < array.length; i++){
            System.out.println(SquaredSortedArray.sorted_square(array)[i]);
        }
    }  
}
