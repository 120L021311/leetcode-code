package others.leetcode70;

public class Solution {
    /*
    思路1：排列组合
    问题：当n较大时，计算会发生溢出
    public int climbStairs(int n) {
        int methods = 0;
        if (n % 2 == 0) {
            int two = n / 2;
            int one = 0;
            for (int i = one, j = two; i < n && j > 0; i += 2, j--) {
                methods += combination(i + j, j);
            }
        } else {
            int two = n / 2;
            int one = 1;
            for (int i = one, j = two; i < n && j > 0; i += 2, j--) {
                methods += combination(i + j, j);
            }
        }
        methods++;
        return methods;
    }

    public int arrangement(int n, int m) {
        int res = 1;
        for (int i = n; i > n - m; i--) {
            res *= i;
        }
        return res;
    }

    public int combination(int n, int m) {
        if (m > n / 2) {
            m = n - m;
        }
        int molecular = 1;
        for (int i = n; i > n - m; i--) {
            molecular *= i;
        }
        return molecular / arrangement(m, m);
    }
     */

    /*
    动态规划
    转移方程：f(x)=f(x−1)+f(x−2)
    由于这里的 f(x) 只和 f(x−1) 与 f(x−2) 有关，所以我们可以用「滚动数组思想」把空间复杂度优化成 O(1)
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
     */


    /*
    矩阵快速幂
     public int climbStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
     */

    public int climbStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(4));
    }
}
