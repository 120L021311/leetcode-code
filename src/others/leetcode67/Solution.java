package others.leetcode67;

public class Solution {
    /*
    自我编写方法：模拟列竖式计算加法
     */
    public String addBinary(String a, String b) {
        StringBuilder answer = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0; i--, j--) {
            int bit = (a.charAt(i) - 48) + (b.charAt(j) - 48) + carry;
            answer.insert(0, bit % 2);
            carry = bit / 2;
        }
        if(a.length()>b.length()){
            for (int i = a.length()-b.length()-1; i >=0 ; i--) {
                int bit = (a.charAt(i) - 48)+ carry;
                answer.insert(0, bit % 2);
                carry = bit / 2;
            }
        } else if(b.length()>a.length()){
            for (int i = b.length()-a.length()-1; i >=0 ; i--) {
                int bit = (b.charAt(i) - 48)+ carry;
                answer.insert(0, bit % 2);
                carry = bit / 2;
            }
        }
        if(carry==1){
            answer.insert(0, 1);
        }
        return answer.toString();
    }

    /*
    题解：同样是模拟，但在此基础上增加了一些技巧。
    整体思路是将两个字符串较短的用 0 补齐，使得两个字符串长度一致，然后从末尾进行遍历计算，得到最终结果。
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0; // 这两行就是在判断是否需要在字符串前面补0
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

     */

    public static void main(String[] args) {
        String a = "100";
        String b = "110010";
        System.out.println(new Solution().addBinary(a, b));
    }
}
