package leetcode09;

public class Solution {
    public static boolean isPalindrome(int x) {
//        String s1 = Integer.toString(x);
//        StringBuilder stringBuilder = new StringBuilder(s1);
//        stringBuilder.reverse();
//        String s2 = new String(stringBuilder);
//        return s1.equals(s2);


//        String s1 = Integer.toString(x);
//        int numLength = s1.length();
//        for (int i = 0, j = numLength - 1; i < numLength / 2; i++, j--) {
//            if (s1.charAt(i) != s1.charAt(j)) {
//                return false;
//            }
//        }
//        return true;

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertNum = 0;
        while (revertNum < x) {
            revertNum = x % 10 + revertNum * 10;
            x /= 10;
        }

        return x == revertNum || x == revertNum / 10;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-10));
    }
}
