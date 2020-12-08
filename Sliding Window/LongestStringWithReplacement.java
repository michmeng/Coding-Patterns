import java.util.*;

public class LongestStringWithReplacement {
    
    public static int longest_same_letter_substring(String str, int k){
        Map<Character, Integer> freq = new HashMap<>();
        int longest_sub = 0;
        int max_letter_count = 0; 
        int starting_index = 0;
        for (int i = 0; i < str.length(); i++){
            freq.put(str.charAt(i), freq.getOrDefault(str.charAt(i), 0) + 1);
            max_letter_count = Math.max(max_letter_count, freq.get(str.charAt(i)));
            if (i - starting_index + 1 - max_letter_count > k){
                freq.put(str.charAt(starting_index), freq.get(str.charAt(starting_index)) - 1);
                starting_index += 1;
            }
            longest_sub = Math.max(longest_sub, i - starting_index + 1);
        }
        return longest_sub;
    }
    

    public static void main(String[] args) {
        String str = "aabccbb";
        int k = 2;
        System.out.println(LongestStringWithReplacement.longest_same_letter_substring(str,k));
    }   
}
