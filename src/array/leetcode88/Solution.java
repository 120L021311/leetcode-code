package array.leetcode88;

import java.util.Arrays;

public class Solution {
    /*
思路一：双指针
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] nums = new int[m + n];
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums[k] = nums1[i];
                i++;
                k++;
            } else {
                nums[k] = nums2[j];
                j++;
                k++;
            }
        }
        if (i < m) {
            while (i < m) {
                nums[k] = nums1[i];
                i++;
                k++;
            }
        }
        if (j < n) {
            while (j < n) {
                nums[k] = nums2[j];
                j++;
                k++;
            }
        }
        System.arraycopy(nums,0,nums1,0,k);
    }
     */


    /*
思路二：逆向双指针
指针设置为从后向前遍历，每次取两者之中的较大者放进nums1的最后面。
优化原因：直接在nums1上原地修改，空间复杂度为O(1)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[k] = nums2[j];
                j--;
                k--;
                continue;
            }
            if (j < 0) {
                break;
            }
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
                k--;
            } else {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
    }
}
