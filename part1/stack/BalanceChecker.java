package part1.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalanceChecker {

    // --------------------------------------------------------Sample_input:-------------------------------------
    // System.out.println(BalanceChecker.isBalanced("([}{}])")); // u
    // System.out.println(BalanceChecker.isBalanced("{} (hello) [world] [ ({} {} {})
    // ([])]")); // b
    // System.out.println(BalanceChecker.isBalanced("[{()}]")); // b
    // System.out.println(BalanceChecker.isBalanced("{[()]}")); // b
    // System.out.println(BalanceChecker.isBalanced("{[()]}{")); // u
    // System.out.println(BalanceChecker.isBalanced("[[[[]]]]")); // b
    // System.out.println(BalanceChecker.isBalanced("((()))")); // b
    // System.out.println(BalanceChecker.isBalanced("({[()]})[")); // u
    // ----------------------------------------------------------------------------------------------------------



    // basic implementation for only one type of bracket


    // Stack<Character> stack = new Stack<>();

    // for (char ch : inp.toCharArray()) {
    // if (ch == '(')
    // stack.push(ch);

    // if (ch == ')') {
    // if (stack.isEmpty())
    // return false;
    // stack.pop();
    // }

    // }
    // return stack.isEmpty();

    private static final List<Character> closingBracesList = Arrays.asList(')', '}', ']', '>');
    private static final List<Character> openingBracesList = Arrays.asList('(', '{', '[', '<');

    public static boolean isBalanced(String inp) {

        Stack<Character> stack = new Stack<>();

        for (char ch : inp.toCharArray()) {

            if (isOpeningBracket(ch))
                stack.push(ch);

            if (isClosingBracket(ch)) {

                if (stack.isEmpty())
                    return false;

                var top = stack.peek();

                if (isBracesCancellingOut(ch, top)) { // the moment they are matching/cancelling out each other, just
                                                      // pop the
                    // opening one
                    stack.pop();
                } else // here they are of different types so the expression is not balanced
                    return false;

            }
        }

        return stack.isEmpty();

    }

    private static boolean isBracesCancellingOut(char closingBrace, char openingBrace) {
        // return top == '(' && ch == ')' ||
        // top == '{' && ch == '}' ||
        // top == '[' && ch == ']' ||
        // top == '<' && ch == '>';
        return closingBracesList.indexOf(closingBrace) == openingBracesList.indexOf(openingBrace);
    }

    private static boolean isClosingBracket(char ch) {
        return closingBracesList.contains(ch);
    }

    private static boolean isOpeningBracket(char ch) {
        return openingBracesList.contains(ch);
    }
}