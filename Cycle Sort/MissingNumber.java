import java.util.*;

public class MissingNumber {
    
    public static int findMissingNumber(int[] nums){
       int i = 0;
        while (i < nums.length){
            if(nums[i] < nums.length && nums[i] != nums[nums[i]]){
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++){
            if (nums[j] != j){
                return j;
            }
       }
       return nums.length; 
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] nums = new int[]{0,1,3,4};
        int missingNumber= MissingNumber.findMissingNumber(nums);
        System.out.println(missingNumber);
    }
}
