package others.leetcode07;

public class Solution {
    /*
    自己编写思路：转换为字符串，从头到尾按照十进制权值累加。累加过程中判断是否发生溢出，溢出则返回0
    时间复杂度：O((log∣x∣)
    空间复杂度：O((log∣x∣)
     */
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        boolean isPositive = true;
        if (x < 0) {
            isPositive = false;
            x = Math.abs(x);
        }
        int res = 0;
        String number = String.valueOf(x);
        int length = number.length();
        int power = 0;
        for (int i = 0; i < length; i++) {
            int num = number.charAt(i) - 48;
            if ((num * Math.pow(10, power)) > Math.pow(2, 31) - 1 - res) {
                return 0;
            }
            res += num * Math.pow(10, power);
            power++;
        }
        if (isPositive) { // 如果输入的是正数
            return res;
        } else { // 负数
            return -res;
        }
    }


    /*
    官方题解：直接对整数x取最后一位，累加，在累加时判断溢出。注意判断溢出条件的推导！
    时间复杂度：O((log∣x∣)
    空间复杂度：O(1)
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(1534236469));
    }
}
