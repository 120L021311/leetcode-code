package others.leetcode118;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(1);
                res.add(temp);
            } else if (i == 2) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(1);
                temp.add(1);
                res.add(temp);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(1);
                List<Integer> lastRow = res.get(i - 2);
                for (int j = 0; j < i - 2; j++) {
                    temp.add(lastRow.get(j) + lastRow.get(j + 1));
                }
                temp.add(1);
                res.add(temp);
            }
        }
        return res;
    }

//    题解
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> ret = new ArrayList<List<Integer>>();
//        for (int i = 0; i < numRows; ++i) {
//            List<Integer> row = new ArrayList<Integer>();
//            for (int j = 0; j <= i; ++j) {
//                if (j == 0 || j == i) {
//                    row.add(1);
//                } else {
//                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
//                }
//            }
//            ret.add(row);
//        }
//        return ret;
//    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(5));
    }
}
