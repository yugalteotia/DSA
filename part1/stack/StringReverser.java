import java.util.Stack;

public class StringReverser {

    public static String reverse(String inp) {

        if (inp == null)
            throw new IllegalArgumentException("Can not reverse a null string object");

        Stack<Character> stk = new Stack<>();
        for (char ch : inp.toCharArray()) {
            stk.push(ch);
        }

        StringBuffer result = new StringBuffer();
        while (!stk.isEmpty()) {
            result.append(stk.pop());
        }

        return result.toString();
    }
}