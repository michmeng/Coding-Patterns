import java.util.*;

public class LongestSubarrayReplaceOnes {
    
    public static int longest_sub_one_rep(int[] array, int k){
        int longest_sub = 0;
        int starting_index = 0;
        int max_ones = 0; 
        for (int i = 0; i < array.length; i++){
            if (array[i] == 1){
                max_ones += 1;
    } 
    if (i - starting_index + 1 - max_ones > k){
        if (array[starting_index] == 1){
            max_ones -= 1;
        }
        starting_index += 1;
        }
        longest_sub = Math.max(longest_sub, i - starting_index + 1);
        }
        return longest_sub;
    } 
    

    public static void main(String[] args) {
        int[] array = new int[]{0,1,1,1,0,0,0,1,1,0,1};
        int k = 3;
        System.out.println(LongestSubarrayReplaceOnes.longest_sub_one_rep(array,k));
    }   
}
