package leetcode20;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    //    public static boolean isValid(String s) {
//        int n = s.length();
//        if (n % 2 != 0) {
//            return false;
//        }
//        MyStack<Character> stack = new MyStack<>();
//        Map<Character, Character> map = new HashMap<>();
//        map.put(')', '(');
//        map.put(']', '[');
//        map.put('}', '{');
//        for (int i = 0; i < n; i++) {
//            Character character = s.charAt(i);
//            if (map.containsValue(character)) {
//                stack.push(character);
//            } else {
//                if (stack.isEmpty()) {
//                    return false;
//                }
//                if (!map.get(character).equals(stack.top())) {
//                    return false;
//                }
//                stack.pop();
//            }
//        }
//        return stack.isEmpty();
//    }


    //使用双端队列Deque
    public static boolean isValid(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        ArrayDeque<Character> characters = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (characters.isEmpty() || !map.get(ch).equals(characters.peek())) {
                    return false;
                }
                characters.pop();
            } else {
                characters.push(ch);
            }
        }
        return characters.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(){[()]()}";
        System.out.println(isValid(s));
    }
}




