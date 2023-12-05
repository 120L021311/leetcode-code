package leetcode387;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, i);
                queue.add(ch);
            } else {
                map.put(ch, -1);
            }
        }
        while (!queue.isEmpty()) {
            if (map.get(queue.peek()) != -1) {
                return map.get(queue.peek());
            } else {
                queue.poll();
            }
        }
        return -1;
    }
}
