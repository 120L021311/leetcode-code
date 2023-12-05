package others.leetcode06;

public class Solution {
    /*
    思路1：用二维矩阵模拟
    时间复杂度：O(numRows*n)
    空间复杂度：O(numRows*n)

    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        int length = s.length();
        int t = 2 * numRows - 2;
        int c = (length + t - 1) / t * (numRows - 1);
        char[][] chars = new char[numRows][c];
        int row = 0, col = 0;
        boolean upFlag = false;
        for (int i = 0; i < s.length(); i++) {
            chars[row][col] = s.charAt(i);
            if (row == numRows - 1) {
                upFlag = true;
            }
            if (row == 0) {
                upFlag = false;
            }
            if (upFlag) {
                row--;
                col++;
            } else {
                row++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < length; j++) {
                if (chars[i][j] != '\u0000') {
                    stringBuilder.append(chars[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }
     */

    /*
    优化：压缩矩阵空间(使用StringBuilder)
    时间复杂度：O(n)
    空间复杂度：O(n)
     */
    public String convert(String s, int numRows) {
        int length = s.length();
        if (numRows == 1 || numRows >= length) {
            return s;
        }

        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i]=new StringBuilder();
        }
        int row = 0;
        boolean upFlag = false;
        for (int i = 0; i < length; i++) {
            stringBuilders[row].append(s.charAt(i));
            if (upFlag) {
                row--;
            } else {
                row++;
            }
            if (row == numRows - 1) {
                upFlag = true;
            }
            if (row == 0) {
                upFlag = false;
            }
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : stringBuilders) {
             res.append(stringBuilder);
        }
        return res.toString();
    }

    /*
    思路二：用每个字符属于的行下标的规律直接构造
    时间复杂度：O(n)
    空间复杂度：O(n)
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }

     */

    public static void main(String[] args) {
//        char[] chars=new char[3];
//        System.out.println(chars[0]);
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }
}
