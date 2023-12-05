package leetcode129;

import java.util.*;

public class Solution {
    /*
自己编写思路一：层序遍历（广度优先搜索）
    public int sumNumbers(TreeNode root) {
        int ret = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();

        nodeQueue.offer(root);
        valueQueue.offer(root.val);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                int value = valueQueue.poll();
                if (node.left == null && node.right == null) {
                    ret += value;
                }
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    valueQueue.offer(value * 10 + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    valueQueue.offer(value * 10 + node.right.val);
                }
            }
        }
        return ret;
    }
     */

    /*
    思路二：深度优先搜索+递归
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if(root.left==null && root.right==null){
            return sum;
        } else {
            return dfs(root.left,sum)+dfs(root.right,sum);
        }
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