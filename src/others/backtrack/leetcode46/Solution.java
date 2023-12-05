package others.backtrack.leetcode46;

import java.util.*;

public class Solution {

    public List<List<Integer>> res = new ArrayList<>();

    /*
    回溯算法+优化标记数组降低空间复杂度
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        if (nums.length == 1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            ArrayList<List<Integer>> res = new ArrayList<>();
            res.add(list);
            return res;
        }

        ArrayList<Integer> input = new ArrayList<>();
        for (int num : nums) {
            input.add(num);
        }
        int length = input.size();
        iterate(length, input, 0);
        return res;
    }

    public void iterate(int length, List<Integer> input, int index) {
        //递归终止条件，说明已经得到了一个全排列
        if (index == length) {
            res.add(new ArrayList<>(input));
            return;
        }


        for (int i = index; i < length; i++) {
            Collections.swap(input, index, i);
            iterate(length, input, index + 1);
            Collections.swap(input, index, i);
        }
    }
     */

    /*
    回溯算法+标记数组
     */
//    public List<List<Integer>> permute(int[] nums) {
//        int length = nums.length;
//        if (length == 0) {
//            return new ArrayList<>();
//        }
//        if (length == 1) {
//            ArrayList<Integer> list = new ArrayList<>();
//            list.add(nums[0]);
//            res.add(list);
//            return res;
//        }
//
//        int[] visited = new int[length];
//        for (int i = 0; i < length; i++) {
//            visited[i] = 0;
//        }
//
//        iterate(length, nums, visited, new ArrayList<>());
//        return res;
//    }
//
//    public void iterate(int length, int[] nums, int[] visited, List<Integer> output) {
//        //递归终止条件，说明已经得到了一个全排列
//        if (output.size() == length) {
//            res.add(new ArrayList<>(output));
//            return;
//        }
//
//        for (int i = 0; i < length; i++) {
//            if (visited[i] == 0) {
//                output.add(nums[i]);
//                visited[i] = 1;
//                iterate(length, nums, visited, output);
//                output.remove(output.size() - 1);
//                visited[i] = 0;
//            }
//        }
//    }
//
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums = {1, 2, 3};
//        System.out.println(solution.permute(nums));
//    }

    /*
    题解：回溯算法+标记数组
    可以对题解单步跟踪来观察回溯算法每一步的动作
     */
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                System.out.println("  递归之前 => " + path);
                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.removeLast();
                System.out.println("递归之后 => " + path);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

}
