import java.util.*;

public class Subsets {
    
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int num : nums) {
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> currSet = new ArrayList<>(subsets.get(i));
                currSet.add(num);
                subsets.add(currSet);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[] {1,3});
        System.out.println(result);
        result = Subsets.findSubsets(new int[]{1,5,3});
        System.out.println(result);
    }
}
