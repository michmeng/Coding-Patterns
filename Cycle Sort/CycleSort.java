public class CycleSort {
    
    public static int[] cycleSort(int[] nums){
        int i = 0;
        while (i != nums.length){
            if (nums[i] != (i+1)){
                int temp = nums[i];
                nums[i] = (i+1);
                nums[nums[i]] = temp; 
            } else {
                i++;
            }
        }
        return nums;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,4,2,3,5};
        int[] sortedNums = CycleSort.cycleSort(nums);
        for (int i = 0; i < sortedNums.length; i++){
            System.out.println(sortedNums[i]);
        }
    }
}
