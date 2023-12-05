package string.leetcode58;

public class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0;
        int length = s.length();
        for (int i = length - 1; i >= 0; i--) {
            if (res == 0 && s.charAt(i) == ' ') {
                continue;
            }
            if (s.charAt(i) != ' ') {
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}
