import java.util.*;

public class SubsetWithDuplicates {

    public static List<List<Integer>> findSubsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int startIndex = 0; 
        int endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            startIndex = 0;
            if (i > 0 && nums[i] == nums[i-1]){
                startIndex = endIndex + 1;
            }
            endIndex = subsets.size() - 1;
            int n = subsets.size();
            for (int j = startIndex; j <= endIndex; j++) {
                List<Integer> currSet = new ArrayList<>(subsets.get(j));
                currSet.add(nums[i]);
                subsets.add(currSet);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] {1,3,3});
        System.out.println(result);
        result = SubsetWithDuplicates.findSubsets(new int[]{1,5,3,3});
        System.out.println(result);
    }
}
