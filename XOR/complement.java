import java.util.*;

public class complement {
    public static int bitComplement(int num) {
        int bitCount = 0;
        int n = num;
        while (n > 0) {
            bitCount += 1;
            n = n >> 1;
        }

        int allSet = (int) Math.pow(2, bitCount) - 1; 

        return allSet ^ num;
    }

    public static void main(String[] args) {
        System.out.println(complement.bitComplement(8));
        System.out.println(complement.bitComplement(10));
    }
}
