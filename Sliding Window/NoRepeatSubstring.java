import java.util.*;

public class NoRepeatSubstring {
    
    public static int no_repeat_substring(String str){
        if (str.length() == 0){
            return 0;
        }
        int longest_sub = 0;
        int starting_index = 0;
        Map<Character, Integer> letters = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            if (letters.containsKey(str.charAt(i))){
                starting_index = Math.max(starting_index, letters.get(str.charAt(i))+1);
            }
            letters.put(str.charAt(i), i);
            if (longest_sub < i - starting_index + 1){
                longest_sub = i - starting_index + 1;
            }
        }
        return longest_sub;
    }    

    public static void main(String[] args) {
        String str = "abccde";
        System.out.println(NoRepeatSubstring.no_repeat_substring(str));
        }   
}
