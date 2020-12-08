public class basic {
    
    public int solveKnapsack(int[] profit, int[] weights, int capacity) {
        if (capacity <= 0 || profit.length == 0 || weights.length == 0)  {
            return 0;
        }

        int n = profit.length; 
        int[][] dp = new int[n][capacity + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] = profit[0];
            } 
        }

        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0; 
                int profit2 = 0; 
                if (weights[i] <= c) {
                    profit1 = profit[i] + dp[i-1][c-weights[i]];
                }
                profit2 = dp[i-1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }    
        }
        return dp[n-1][capacity];
    }

    public static void main(String[] args) {
        basic b = new basic();
        int[] profits = {1,6,10,16};
        int[] weights = {1,2,3,5};
        int maxProfit = b.solveKnapsack(profits, weights, 7);
        System.out.println(maxProfit);
        maxProfit = b.solveKnapsack(profits, weights, 6);
        System.out.println(maxProfit);
    }
}
