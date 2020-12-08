public class twounpaired {
    
    public static int[] find(int[] nums) {
        int check = 0;
        for (int num : nums) {
            check = check ^ num;
        }

        int rightMost = 1;
        while ((rightMost & 0) == 0) {
            rightMost = rightMost << 1;
        }
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if ((num & rightMost) != 0) {
                num1 = num1 ^ num;
            } else {
                num2 = num2 ^ num;
            }
        }
        return new int[] {num1, num2};
    }

    public static void main (String[] args) {
        int[] arr = new int[] {1,4,21,3,5,6,2,3,7};
        int[] result = twounpaired.find(arr);
        System.out.println(result[0] + ", " + result[1]);

        arr = new int[] {2,1,3,2};
        result = twounpaired.find(arr);
        System.out.println(result[0] + ", " + result[1]);


    }
}
