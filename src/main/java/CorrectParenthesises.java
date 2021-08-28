
import java.util.*;

public class CorrectParenthesises {

    public static boolean analyze(String s) {
        Stack<String> stringStack = new Stack<>();
        Map<String, String> parenthesises = Map.of("[", "]", "(", ")", "{", "}");
        for (int i = 0; i < s.length(); i++) {
            String stackValue = null;
            if (!stringStack.empty()) {
                stackValue = stringStack.peek();
            }
            String nextSymbol = s.substring(i, i + 1);
            if ((stackValue == null || !nextSymbol.equals(parenthesises.get(stackValue)))
                    && parenthesises.containsValue(nextSymbol)) {
                //stack is empty or top of stack does no matсh the next symbol and the next symbol is a closing parenthesis
                return false;
            } else if (parenthesises.containsKey(nextSymbol)) {
                //else - next symbol is an opening parenthesis - push to the stack
                stringStack.push(nextSymbol);
            } else if (parenthesises.containsValue(nextSymbol)) {
                //else - next symbol is a closing parenthesis - pop from the stack
                stringStack.pop();
            }
        }
        return stringStack.empty();
    }

    public static void josephus(int n, int step) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = step - 1;
        while (list.size() > 0) {
            System.out.println(list.get(i));
            list.remove(i);
            i += step - 1;
            if (i >= list.size()) {
                i = Math.min(i - list.size(), list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(CorrectParenthesises.analyze("[(([])())]"));
        josephus(7, 4);
    }
}

