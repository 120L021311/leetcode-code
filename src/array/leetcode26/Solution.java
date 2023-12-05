package array.leetcode26;

public class Solution {
    /*
与题解思路相同：双指针
     */
    public int removeDuplicates(int[] nums) {
        int[] expectedNums = new int[nums.length];
        int count = 0;
        int prevElement = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != prevElement) {
                nums[count] = nums[i];
                prevElement = nums[i];
                count++;
            }
        }
        return count;
    }
}
