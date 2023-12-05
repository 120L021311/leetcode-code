package string.leetcode28;

public class Solution {
    /*
    思路1：朴素方法，时间复杂度O(n*m)
    枚举原串 ss 中的每个字符作为「发起点」，每次从原串的「发起点」和匹配串的「首位」开始尝试匹配：
    匹配成功：返回本次匹配的原串「发起点」。
    匹配失败：枚举原串的下一个「发起点」，重新尝试匹配。
    public int strStr(String haystack, String needle) {
        int length1 = haystack.length();
        int length2 = needle.length();
        char first = needle.charAt(0);
        for (int i = 0; i <= length1 - length2; i++) {
            if (haystack.charAt(i) == first) {
                if (haystack.substring(i, i + length2).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
     */


    //KMP算法时间复杂度：O(n+m)
    //分析：由于主字符串不用回退，故O(n)。处理得到next时间复杂度O(m)。总时间复杂度为O(n+m)
    public int strStr(String haystack, String needle) {
        int length1 = haystack.length();
        int length2 = needle.length();
        int[] next = new int[length2]; //初始化next数组
        getNext(needle, next);
        int i = 0, j = 0;
        while (i < length1 && j < length2) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == length2) {
            return i - j;
        } else {
            return -1;
        }
    }

    public void getNext(String needle, int[] next) {
        next[0] = -1;
        int i = 0, j = -1;
        int length = needle.length();
        while (i < length - 1) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }


    public static void main(String[] args) {
        String s = "1234";
        System.out.println(s.substring(0, 2));
    }
}
