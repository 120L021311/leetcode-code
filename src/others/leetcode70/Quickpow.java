package others.leetcode70;

public class Quickpow {
    //快速幂函数(递归)
    public long quickPow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 1) {
            return quickPow(a, b - 1) * a;
        } else {
            long temp = quickPow(a, b / 2);
            return temp * temp;
        }
    }

    //非递归快速幂函数
    public long binPow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= a;
            }
            a *= a;
            b = b >> 1;
        }
        return res;
    }


    public static void main(String[] args) {
        Quickpow quickpow = new Quickpow();
        System.out.println(quickpow.quickPow(3, 13));
        System.out.println(quickpow.binPow(3, 13));
    }
}
