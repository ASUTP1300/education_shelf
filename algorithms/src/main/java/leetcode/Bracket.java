package leetcode;

import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        String open = "({[";
        String closed = "(){}[]";

        String t1 = "()[]{}";
        String t2 = ")";

        for (String s : t1.split("")) {
            if (open.contains(s)) {
                stack.push(s);
            } else if (closed.contains(stack.peek() + s)) {
                stack.pop();
            }
        }

        System.out.println("stack " + stack);
        System.out.println('(' + ')' + " Код ()");
        System.out.println('[' + ']' + " Код []");
        System.out.println('{' + '}' + " Код {}");
    }
}
