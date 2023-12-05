package others.backtrack.leetcode47;

import java.util.*;

public class Solution {

    /*
    排序+回溯算法+剪枝
    小trick：考虑重复元素一定要优先排序，将重复的都放在一起，便于找到重复元素和剪枝！！！
    推广至 --> 如果涉及考虑重复元素，或者大小比较的情况，对列表排序是一个不错的选择
     */
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return res;
        }
        if (length == 1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            res.add(list);
            return res;
        }
        boolean[] visited = new boolean[length];
        Arrays.sort(nums);

        iterate(length, nums, visited, new ArrayList<>());
        return res;
    }

    public void iterate(int length, int[] nums, boolean[] visited, List<Integer> output) {
        //递归终止条件：说明已经往排列中添加了n个元素，说明得到了一个排列，添加一个结果
        if (output.size() == length) {
            res.add(new ArrayList<>(output));
            return;
        }

        List<Integer> values = new ArrayList<>(); // 用来记录当前这一层中看到过什么元素，如果之后在同一层再查相同元素则剪枝
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                output.add(nums[i]);
                visited[i] = true;
                iterate(length, nums, visited, output);
                output.remove(output.size() - 1);
                visited[i] = false;
            }
        }
    }


    /*
    题解：回溯算法+剪枝
    优化：先通过排序使得剪枝时可以只看当前元素和上一个元素是否相同。从而避免使用集合判断是否重复，降低空间复杂度。
    搜索的数也和上一次一样，但是上一次的 1 刚刚被撤销，正是因为刚被撤销，下面的搜索中还会使用到，因此会产生重复，剪掉的就应该是这样的分支
     public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, used, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }

            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, used, path, res);
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            used[i] = false;
            path.removeLast();
        }
    }
     */


    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] array1 = {1, 2, 3};
//        System.out.println(solution.permuteUnique(array1));
        int[] array2 = {1, 2, 1};
        System.out.println(solution.permuteUnique(array2));
    }
}
