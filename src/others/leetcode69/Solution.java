package others.leetcode69;

public class Solution {
    /*
    思路：二分查找
     */
    public int mySqrt(int x) {
        int left = 0, right = x;
        int ret = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ret = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ret;
    }

    /*
    思路：换底公式
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
    时间复杂度：O(1)
    空间复杂度：O(1)
     */

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(1));
    }
}
