import java.util.*;

public class AllMissingNumbers {
    
    public static List<Integer> findMissingNumbers(int[] nums){
        List<Integer>  missingNums = new ArrayList<>();
        int i = 0;
        while (i < nums.length){
            if(nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
         }  else {
                i++;
         }
     }
 
        for (int j = 0; j < nums.length; j++){
            if (nums[j] != j + 1){
                missingNums.add(j+1);
            }
        }
        return missingNums; 
     }
 
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
     }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,2,2};
        List<Integer> missingNumber= AllMissingNumbers.findMissingNumbers(nums);
        System.out.println(missingNumber);
    }
}
