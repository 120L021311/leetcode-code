package array.leetcode16;

import java.util.Arrays;

public class Solution {
    /*
思路：排序数组+双指针
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int sum = nums[0]+nums[1]+nums[2];
        for (int first = 0; first < length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = length - 1;
            int newTarget = target - nums[first];
            for (int second = first + 1; second < length - 1; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && Math.abs(nums[second] + nums[third - 1] - newTarget) <= Math.abs(nums[second] + nums[third] - newTarget)) {
                    third--;
                }
                if (second == third) {
                    third++;
                }
                if (Math.abs(nums[first] + nums[second] + nums[third] - target) < Math.abs(sum - target)) {
                    sum = nums[first] + nums[second] + nums[third];
                }
            }
        }
        return sum;
    }
     */

    /*
题解：对排序+双指针进行优化
当我们枚举到恰好等于 target的 a+b+c 时，可以直接返回 target 作为答案，因为不会有再比这个更接近的值了
另一个优化与 15 中类似。当我们枚举 a,b,c 中任意元素并移动指针时，可以直接将其移动到下一个与这次枚举到的不相同的元素，减少枚举的次数
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }

}
