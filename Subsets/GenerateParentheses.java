import java.util.*;

class Parenthesis {
    String str; 
    int openCount; 
    int closeCount;

    public Parenthesis(String s, int openCount, int closeCount) {
        str = s;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}

public class GenerateParentheses {

    public static List<String> generateValidParentheses(int n) {
        List<String> result = new ArrayList<String>();
        Queue<Parenthesis> queue = new LinkedList<>();
        queue.add(new Parenthesis("", 0, 0));
        while (!queue.isEmpty()) {
            Parenthesis curr = queue.poll();
            if (curr.openCount == n && curr.closeCount == n) {
                result.add(curr.str);
            } else {
                if (curr.openCount < n) {
                    queue.add(new Parenthesis(curr.str + "(", curr.openCount + 1, curr.closeCount));
                }
                if (curr.openCount > curr.closeCount) {
                    queue.add(new Parenthesis(curr.str + ")", curr.openCount, curr.closeCount + 1));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        System.out.println(result);

        result = GenerateParentheses.generateValidParentheses(3);
        System.out.println(result);
    }
}

