import java.util.*;

public class HappyNumber {
    
    public static boolean happy(int k){
        int slow = k;
        int fast = k;
        do {
            slow = calculate_square(slow);
            fast = calculate_square(fast);
            fast = calculate_square(fast);
        } while (slow != fast);
        return slow == 1;      
    }

    public static int calculate_square(int k){
        int square = 0;
        while (k > 0){
            int curr = k % 10; 
            square += (curr * curr);
            k = k/10;
        }
        return square;
    }

    public static void main(String[] args){
        System.out.println(happy(23));
        System.out.println(happy(12));
    }
}
