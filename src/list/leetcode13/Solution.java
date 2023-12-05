package leetcode13;

import java.util.HashMap;

public class Solution {
    public static int romanToInt(String s) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        map.put('I', 1);
//        map.put('V', 5);
//        map.put('X', 10);
//        map.put('L', 50);
//        map.put('C', 100);
//        map.put('D', 500);
//        map.put('M', 1000);
//        int length = s.length();
//        int res = 0;
//        for (int i = 0; i < length; i++) {
//            if ((s.charAt(i) == 'I' || s.charAt(i) == 'X' || s.charAt(i) == 'C') && i < length - 1) {
//                if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
//                    res -= map.get(s.charAt(i));
//                } else {
//                    res += map.get(s.charAt(i));
//                }
//                continue;
//            }
//            res += map.get(s.charAt(i));
//        }
//        return res;

        int sum = 0;
        int preNum = getValue(s.charAt(0));
        int length = s.length();
        for (int i = 1; i < length; i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        int res = romanToInt("MCMXCIV");
        System.out.println(res);
    }
}
