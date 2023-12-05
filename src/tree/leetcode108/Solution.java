package leetcode108;

import java.awt.*;

public class Solution {


    public TreeNode sortedArrayToBST(int[] nums) {
        return mySortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode mySortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int index = (left+right) / 2;
        int rootValue = nums[index];
        TreeNode root = new TreeNode(rootValue);
        root.left = mySortedArrayToBST(nums, left, index - 1);
        root.right = mySortedArrayToBST(nums, index + 1, right);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}