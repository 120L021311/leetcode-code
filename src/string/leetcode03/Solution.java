package string.leetcode03;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    /*
思路一：暴力————计算从每个字符开始的不含重复字符的最长子串，返回最长的
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int longest = 0;
        for (int i = 0; i < length; i++) {
            int temp = longestSubstringLength(chars, i);
            if (temp >longest){
                longest = temp;
            }
        }
        return longest;
    }

    public int longestSubstringLength(char[] chars, int i) {
        int longest = 0;
        HashSet<Character> set = new HashSet<>();
        int length = chars.length;
        for (int j = i; j < length; j++) {
            if (!set.contains(chars[j])) {
                set.add(chars[j]);
                longest++;
            } else {
                break;
            }
        }
        return longest;
    }
     */

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        int longest = 0;
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (!list.contains(chars[i])) {
                list.add(chars[i]);
            } else {
                longest = Math.max(longest, list.size());
                int index = list.indexOf(chars[i]);
                if (index >= 0) {
                    list.subList(0, index + 1).clear();
                }
                //简化之前
//                for (int j = 0; j <= index; j++) {
//                    list.remove(0);
//                }
                list.add(chars[i]);
            }
        }
        return Math.max(longest, list.size());
    }

    /*
题解：滑动窗口
public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}
