package array.leetcode01;

import java.util.*;

public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // (值，下标)
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int j = map.get(target - nums[i]);
                return new int[]{i, j};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
