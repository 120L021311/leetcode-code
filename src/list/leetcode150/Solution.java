package leetcode150;

import java.util.ArrayDeque;

public class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                int value = Integer.parseInt(token);
                stack.push(value);
            } else {
                int op1 = stack.pop();
                int op2 = stack.pop();
                int res = 0;
                switch (token) {
                    case "+":
                        res = op2 + op1;
                        break;
                    case "-":
                        res = op2 - op1;
                        break;
                    case "*":
                        res = op2 * op1;
                        break;
                    case "/":
                        res = op2 / op1;
                        break;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String s){
        return !s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/");
    }

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(new Solution().evalRPN(tokens));
    }
}
