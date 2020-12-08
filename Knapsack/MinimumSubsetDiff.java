public class MinimumSubsetDiff {
    
    public static boolean canPartition(int[] num) {
        int  n = num.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += num[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum/2;

        boolean[][] dp = new boolean[n][sum+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int s = 1; s <= sum; s++) {
            dp[0][s] = (num[0] == s ? true : false);
        }

        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                if (dp[i-1][s]) {
                    dp[i][s] = dp[i-1][s];
                } else if (s >= num[i]) {
                    dp[i][s] = dp[i-1][s-num[i]];
                }
            }
        }
        int sum1 = 0; 
        for (int i = sum/2; i >= 0; i--) {
            if (dp[n-1][i] == true) {
                sum1 = i;
                break;
            }
        }
        int sum2 = sum - sum1;
        return Math.abs(sum1-sum2);
    }
    

    public static void main(String[] args) {
        MinimumSubsetDiff es = new MinimumSubsetDiff();
        int[] num = {1,2,3,9};
        System.out.println(es.canPartition(num));
        num = new int[] {1,2,7,1,5};
        System.out.println(es.canPartition(num));
        num = new int[] {1,3,100,4};
        System.out.println(es.canPartition(num));
    }
}
