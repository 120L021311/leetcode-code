package array.leetcode11;

public class Solution {
    /*
最简单思路：二维数组
问题：时间复杂度过高
    public int maxArea(int[] height) {
        int max = 0;
        int length = height.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if ((j - i) * Math.min(height[i], height[j]) > max) {
                    max = (j - i) * Math.min(height[i], height[j]);
                }
            }
        }
        return max;
    }
     */

    /*
题解思路：双指针
如果向内移动长板，则高不变宽减小，无法得到更大的面积。故每一步向内移动短板。
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > max) {
                max = area;
            }
            if (height[left] <= height[right]) { //每次向内移动短板
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
