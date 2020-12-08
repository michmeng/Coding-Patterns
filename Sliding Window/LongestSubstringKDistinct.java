import java.util.*;

public class LongestSubstringKDistinct {

    public static int longest_substring_k_distinct(String str, int k){
        if (str.length() == 0 || k == 0){
            return 0;
        }
        int longest_sub = 0;
        int start_index = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++){
            freq.put(str.charAt(i), freq.getOrDefault(str.charAt(i), i) + 1);
            while (freq.size() > k){
                freq.put(str.charAt(start_index), freq.getOrDefault(str.charAt(start_index), i) - 1);
                if (freq.getOrDefault(str.charAt(start_index), i) == 0) {
                    freq.remove(str.charAt(start_index));
                }
                start_index = start_index + 1;
            }
            if (longest_sub < (i - start_index + 1)){
                longest_sub = i - start_index + 1;
            }
        }
        return longest_sub;    
    }

    public static void main(String[] args) {
        String str = "araaci"; 
        int k = 2;
        System.out.println(LongestSubstringKDistinct.longest_substring_k_distinct(str, k));
        }   
}
