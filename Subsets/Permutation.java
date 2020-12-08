import java.util.*;

public class Permutation {
    
    public static List<List<Integer>> findPermutation(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        for (int num: nums) {
            int n = permutations.size();
            for (int i = 0; i < n; i++) {
                List<Integer> currPerm = permutations.poll();
                for (int j = 0; j <= currPerm.size();j++) {
                    List<Integer> newPerm = new ArrayList<Integer>(currPerm);
                    newPerm.add(j, num);
                    if(newPerm.size() == nums.length) {
                        result.add(newPerm);
                    } else {
                        permutations.add(newPerm);
                    }
                }

            }
        }
        return result; 
    }

    public static void main(String[] args){
        List<List<Integer>> result = Permutation.findPermutation(new int[] {1,3,5});
        System.out.println(result);
    }
}
