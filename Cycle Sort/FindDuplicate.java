public class FindDuplicate {
    
    public static int findDuplicate(int[] nums){
        int i = 0;
        while (i < nums.length){
            if(nums[i] != (i+1)){
                if(nums[i] == nums[nums[i] - 1]){
                    swap(nums, i, nums[i]); 
                } else {
                    return nums[i];
            }
        } else {
            i++;
        }
    }
    return - 1;
}

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,4,4,3,2};
        int duplicate= FindDuplicate.findDuplicate(nums);
        System.out.println(duplicate);
    }
}
