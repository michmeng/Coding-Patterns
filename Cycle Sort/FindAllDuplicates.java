import java.util.*;

public class FindAllDuplicates {
    
    public static List<Integer> findAllDuplicates(int[] nums){
        List<Integer>  duplicates = new ArrayList<>();
        int i = 0;
        while (i < nums.length){
            if(nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i]-1); 
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++){
            if (nums[j] != j + 1){
                duplicates.add(nums[j]);
            }
        }
        return duplicates; 

    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,4,4,5,5};
        List<Integer> duplicate= FindAllDuplicates.findAllDuplicates(nums);
        System.out.println(duplicate);
    }
}
