package others.leetcode12;

import java.util.HashMap;

public class Solution {
    /*
    自己编写：暴力从大到小将num拆分成各个权值的加和，拼接成字符串
    思路类似于题解中的硬编码表，对十进制表示中的每一位数字单独处理。
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        StringBuilder res = new StringBuilder("");

        //先看最高位
        if (num / 1000 != 0) {
            int thousand = num / 1000;
            for (int i = 0; i < thousand; i++) {
                res.append(map.get(1000));
            }
        }
        num = num % 1000;

        //再看百位
        if (num / 100 != 0) {
            int hundred = num / 100;
            if (hundred == 9) {
                res.append(map.get(900));
            } else if (hundred >= 5) {
                res.append(map.get(500));
                hundred -= 5;
                for (int i = 0; i < hundred; i++) {
                    res.append(map.get(100));
                }
            } else if (hundred == 4) {
                res.append(map.get(400));
            } else {
                for (int i = 0; i < hundred; i++) {
                    res.append(map.get(100));
                }
            }
        }
        num = num % 100;

        //再看十位
        if (num / 10 != 0) {
            int ten = num / 10;
            if (ten == 9) {
                res.append(map.get(90));
            } else if (ten >= 5) {
                res.append(map.get(50));
                ten -= 5;
                for (int i = 0; i < ten; i++) {
                    res.append(map.get(10));
                }
            } else if (ten == 4) {
                res.append(map.get(40));
            } else {
                for (int i = 0; i < ten; i++) {
                    res.append(map.get(10));
                }
            }
        }
        num = num % 10;

        //最后看个位
        if(num != 0){
            if (num == 9) {
                res.append(map.get(9));
            } else if (num >= 5) {
                res.append(map.get(5));
                num -= 5;
                for (int i = 0; i < num; i++) {
                    res.append(map.get(1));
                }
            } else if (num == 4) {
                res.append(map.get(4));
            } else {
                for (int i = 0; i < num; i++) {
                    res.append(map.get(1));
                }
            }
        }

        return res.toString();
    }
     */

    /*
    题解思路1：硬编码表，将每一位硬编码即可
    相较于自己编写优点：同样处理每一位时拼接字符串时不用循环
    时间复杂度：O(1)
    空间复杂度：O(1)
    public String intToRoman(int num) {
        String[] thousand = {"", "M", "MM", "MMM"};
        String[] hundred = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] one = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        StringBuilder res = new StringBuilder("");
        res.append(thousand[num / 1000]);
        num %= 1000;
        res.append(hundred[num / 100]);
        num %= 100;
        res.append(ten[num / 10]);
        num %= 10;
        res.append(one[num]);
        return res.toString();
    }
     */

    /*
    题解思路2：贪心。每次选择当前可选的权值最大的符号，拼接在一起
     */
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int length = values.length;
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            for (int i = 0; i < length; i++) {
                int value = values[i];
                String symbol = symbols[i];
                while (num >= value) {
                    res.append(symbol);
                    num = num - value;
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(1994));
    }
}
