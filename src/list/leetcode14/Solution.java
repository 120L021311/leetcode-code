package leetcode14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder("");
        int length = strs.length;
        int shortestLen = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s.length() < shortestLen) {
                shortestLen = s.length();
            }
        }
        for (int i = 0; i < shortestLen; i++) {
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (ch != str.charAt(i)) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
