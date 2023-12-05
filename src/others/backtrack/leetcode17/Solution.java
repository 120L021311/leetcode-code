package others.backtrack.leetcode17;

import java.util.*;

public class Solution {
    /*
    自己编写思路：不断遍历数字串，转成letter串，用一个队列保存当前遍历转化的结果。（类似层序遍历、广度优先搜索）
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        int length = digits.length();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char ch = digits.charAt(i);
            String letters = map.get(ch);
            if (queue.isEmpty()) {
                for (int j = 0; j < letters.length(); j++) {
                    queue.offer(String.valueOf(letters.charAt(j)));
                }
            } else {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    String str = queue.poll();
                    for (int k = 0; k < letters.length(); k++) {
                        queue.offer(str + letters.charAt(k));
                    }
                }
            }
        }
        return new ArrayList<>(queue);
    }
     */

    /*
    题解思路：回溯算法
    回溯算法适用于：找出所有可能的组合/找出所有可行解的问题
    遍历完返回之后，删去这一步增加的这个字母，继续遍历
    时间复杂度：O(3^m * 4^n)其中 m 是输入中对应 3 个字母的数字个数，n 是输入中对应 4 个字母的数字个数，m+n 是输入数字的总个数。当输入包含 m 个对应 3 个字母的数字和 n 个对应 4 个字母的数字时，不同的字母组合一共有 3^m * 4^n 种，需要遍历每一种字母组合。
    空间复杂度：O(m+n)，其中 m 是输入中对应 3 个字母的数字个数，n 是输入中对应 4 个字母的数字个数，m+n 是输入数字的总个数。除了返回值以外，空间复杂度主要取决于哈希表以及回溯过程中的递归调用层数，哈希表的大小与输入无关，可以看成常数，递归调用层数最大为 m+n。

     */
    ArrayList<String> res = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<>();


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        iterateStr(digits,new StringBuilder());
        return res;
    }

    public void iterateStr(String str, StringBuilder letters) {
        //递归终止条件
        if (str.length() == 0) {
            res.add(letters.toString());
            return;
        }

        char ch = str.charAt(0);
        String letter = map.get(ch);
        str = str.substring(1);
        for (int i = 0; i < letter.length(); i++) {
            iterateStr(str, letters.append(letter.charAt(i)));
            letters.deleteCharAt(letters.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }
}

