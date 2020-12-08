public class pairs {
    public static int find(int[] arr){
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num ^ arr[i];
            System.out.println(num);
        }
        return num;
    }

    public static void main(String args[]) {
        System.out.println(pairs.find(new int[] {1,4,2,1,3,2,3}));
    }
}
