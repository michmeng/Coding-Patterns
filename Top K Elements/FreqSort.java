import java.util.*;

public class FreqSort {
    
    public static String sortCharByFreq(String str) {
        Map<Character, Integer> charFreq = new HashMap<>();
        for (char character : str.toCharArray()) {
            charFreq.put(character, charFreq.getOrDefault(character, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>((n1,n2) -> n2.getValue() - n1.getValue());
        maxHeap.addAll(charFreq.entrySet());

        StringBuilder sortedString = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                sortedString.append(entry.getKey());
            }
        }
        return sortedString.toString();
    }

    public static void main(String[] args) {
        String result = FreqSort.sortCharByFreq("Programming");
        System.out.println(result);
        result = FreqSort.sortCharByFreq("abcbab");
        System.out.println(result);
    }
}
