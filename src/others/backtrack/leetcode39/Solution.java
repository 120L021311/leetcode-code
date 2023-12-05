package others.backtrack.leetcode39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> res = new ArrayList<>();


    /*
    思路：回溯算法+排序剪枝
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return res;
        }

        int length = candidates.length;
        dfs(length, candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(int length, int[] candidates, int target, int index, List<Integer> temp, int sum) {
        if (target == sum) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < length; i++) {
            if (candidates[i] + sum > target) {
                break;
            }
            temp.add(candidates[i]);
            sum += candidates[i];
            dfs(length, candidates, target, i, temp, sum);
            temp.remove(temp.size() - 1);
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {2, 3, 6, 7};
        System.out.println(solution.combinationSum(candidates, 7));
    }
}
