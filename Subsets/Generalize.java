import java.util.*;

class AbbreviatedWord {
    StringBuilder str;
    int start;
    int count;

    public AbbreviatedWord(StringBuilder str, int start, int count) {
        this.str = str;
        this.start = start;
        this.count = count;
    }
}

public class Generalize {
    
    public static List<String> generateAbbreviations(String word) {
        int wordLength = word.length();
        List<String> result = new ArrayList<String>();
        Queue<AbbreviatedWord> queue = new LinkedList<>();
        queue.add(new AbbreviatedWord(new StringBuilder(), 0, 0));
        while (!queue.isEmpty()) {
            AbbreviatedWord currWord = queue.poll();
            if (currWord.start == wordLength) {
                if (currWord.count != 0) {
                    currWord.str.append(currWord.count);
                }
                result.add(currWord.str.toString());
            } else {
                queue.add(new AbbreviatedWord(new StringBuilder(currWord.str), currWord.start + 1, currWord.count + 1));

                if (currWord.count != 0) {
                    currWord.str.append(currWord.count);
                }
                queue.add(new AbbreviatedWord(new StringBuilder(currWord.str.append(word.charAt(currWord.start))), currWord.start + 1, currWord.count));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = Generalize.generateAbbreviations("BAT");
        System.out.println(result);
        result = Generalize.generateAbbreviations("code");
        System.out.println(result);
    }
}
