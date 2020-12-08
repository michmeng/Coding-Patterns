import java.util.*;

public class Rearrange {
    
    public static String findRearrangement(String str) {
        HashMap<Character, Integer> charFreq  = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new  
            PriorityQueue<Map.Entry<Character, Integer>>((n1,n2) -> n2.getValue() - n1.getValue());        
            
        for (char character : str.toCharArray()) {
            charFreq.put(character, charFreq.getOrDefault(character, 0) + 1);
        }

        maxHeap.addAll(charFreq.entrySet());

        Map.Entry<Character, Integer> prevEntry = null;
        StringBuilder result = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currEntry = maxHeap.poll();
            if (prevEntry != null && prevEntry.getValue() > 0) {
                maxHeap.offer(prevEntry);
            }
            result.append(currEntry.getKey());
            currEntry.setValue(currEntry.getValue() - 1);
            prevEntry = currEntry;
        }
        return result.length() == str.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(Rearrange.findRearrangement("aappp"));
        System.out.println(Rearrange.findRearrangement("Programming"));
        System.out.println(Rearrange.findRearrangement("aapa"));
    }
}
