import java.util.*;

public class StringPermutationCase {
    
    public static List<String> findPermutationCase(String str) {
        List<String> results = new ArrayList<>();
        Queue<String> permutations = new LinkedList<>();
        permutations.add("");
        for (int i = 0; i < str.length(); i++){
            int n = permutations.size();
            char currChar = str.charAt(i);
            if (!Character.isDigit(currChar)){
                for (int j = 0; j < n; j++) {
                    String currPerm = permutations.poll();
                    String newLower = currPerm + Character.toLowerCase(currChar);
                    String newUpper = currPerm + Character.toUpperCase(currChar);
                    if (newLower.length() == str.length()) {
                        results.add(newLower);
                        results.add(newUpper);
                    } else {
                        permutations.add(newLower);
                        permutations.add(newUpper);
                    }
                }
            } else {
                for (int j = 0; j < n; j++) {
                    String currPerm = permutations.poll();
                    String newPerm = currPerm + currChar;
                    if (newPerm.length() == str.length()){
                        results.add(newPerm);
                    } else {
                        permutations.add(newPerm);
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<String> result = StringPermutationCase.findPermutationCase("ad52");
        System.out.println(result);

        result = StringPermutationCase.findPermutationCase("ab7c");
        System.out.println(result);
    }
}
