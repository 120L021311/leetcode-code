package leetcode08;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    //题解：通过自动机状态转移
//    public int myAtoi(String str) {
//        Automaton automaton = new Automaton();
//        int length = str.length();
//        for (int i = 0; i < length; ++i) {
//            automaton.get(str.charAt(i));
//        }
//        return (int) (automaton.sign * automaton.ans);
//    }



    public static int myAtoi(String s) {
        if (s.equals("")) {
            return 0;
        }

        int length = s.length();
        int start = 0;
        int end = length;
        boolean spaceFlag = false;
        boolean symbolFlag = false;
        StringBuilder number = new StringBuilder("");
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != ' ') {
                start = i;
                spaceFlag = true;
                break;
            }
        }
        s = s.substring(start);

        length = s.length();
        start = 0;
        end = length;
        for (int i = 0; i < length; i++) {
            if (!symbolFlag) {//判断下一个字符是否为正负号
                if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    number.append(s.charAt(i));
                    start++;
                    symbolFlag = true;
                    continue;
                }
                symbolFlag = true;
            }
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                end = i;
                break;
            }
        }
        number.append(s.substring(start, end));
        String numString = number.toString();

        if(numString.equals("")){
            return 0;
        }

        boolean isPositive = true;
        boolean hasSymbol = false;
        if (number.charAt(0) == '-') {
            isPositive = false;
            hasSymbol = true;
        } else if (number.charAt(0) == '+') {
            hasSymbol = true;
        }

        length = numString.length();
        int value = 0;
        int bit = 0;
        if (!isPositive) { //负数
            for (int i = length - 1; i >= 1; i--) {
                if (numString.charAt(i) < '0' || number.charAt(i) > '9') {
                    return 0;
                }
                if (value > Integer.MAX_VALUE - (((int) numString.charAt(i)) - 48) * Math.pow(10, bit)) {
                    return Integer.MIN_VALUE;
                } else {
                    value += ((int) (numString.charAt(i)) - 48) * Math.pow(10, bit);
                }
                bit++;
            }
            return -value;
        } else {
            if (!hasSymbol) {
                for (int i = length - 1; i >= 0; i--) {
                    if (numString.charAt(i) < '0' || number.charAt(i) > '9') {
                        return 0;
                    }
                    if (value > Math.abs(Integer.MAX_VALUE) - ((int) (numString.charAt(i)) - 48) * Math.pow(10, bit)) {
                        return Integer.MAX_VALUE;
                    } else {
                        value += ((int) (numString.charAt(i)) - 48) * Math.pow(10, bit);
                    }
                    bit++;
                }
                return value;
            } else {
                for (int i = length - 1; i >= 1; i--) {
                    if (numString.charAt(i) < '0' || number.charAt(i) > '9') {
                        return 0;
                    }
                    if (value > Math.abs(Integer.MAX_VALUE) - ((int) (numString.charAt(i)) - 48) * Math.pow(10, bit)) {
                        return Integer.MAX_VALUE;
                    } else {
                        value += ((int) (numString.charAt(i)) - 48) * Math.pow(10, bit);
                    }
                    bit++;
                }
                return value;
            }
        }
    }

    public static void main(String[] args) {
        String string1 = new String("42");
        String string2 = new String("   -42");
        String string3 = new String("4193 with words");
        String string4 = new String("-91283472332");
        System.out.println(Solution.myAtoi(string1));
        System.out.println(Solution.myAtoi(string2));
        System.out.println(Solution.myAtoi(string3));
        System.out.println(Solution.myAtoi(string4));
        System.out.println(Solution.myAtoi(" b11228552307"));

    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}

