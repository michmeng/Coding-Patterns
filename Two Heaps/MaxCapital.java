import java.util.*;

public class MaxCapital {
    public static int findMaxCapital(int[] capital, int[] profits, int n, int initialCap) {
        int numProjects = profits.length;
        PriorityQueue<Integer> minCapital = new PriorityQueue<>(n, (a,b) -> capital[a] - capital[b]);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(n, (a,b) -> profit[b] - profit[a]);

        for(int i = 0; i < numProjects; i++){
            minCapital.offer(capital[i]);
        }

        int currCapital = initialCap;
        for (int i = 0; i < n; i++) {
            while(!minCapital.isEmpty() && capital[minCapital.peek()] <= currCapital) {
                maxProfit.add(minCapital.poll());
            }

            if(maxProfit.isEmpty()){
                break;
            }

            currCapital += profits[maxProfit.poll)];
        }
        
        return currCapital;
    }

    public static void main(String[] args) {
        int result = MaxCapital.findMaxCapital(new int[] {0,1,2}, new int[] {1,2,3}, 2, 1);
        System.out.println(result);
        result = MaxCapital.findMaxCapital(new int[] {0,1,2,4}, new int[] {1,2,3,5}, 3, 0);
        System.out.println(result);
    }
}
