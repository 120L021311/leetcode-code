package leetcode112;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
思路一：递归
     */
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) {
//            return false;
//        }
//        if (root.left == null && root.right == null && root.val == targetSum) {
//            return true;
//        }
//        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
//    }

    /*
思路二：广度优先搜索
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();
        nodeQueue.offer(root);
        valueQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int nowValue = valueQueue.poll();
            if (node.left == null && node.right == null) {
                if (nowValue == targetSum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                nodeQueue.offer(node.left);
                valueQueue.offer(nowValue + node.left.val);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                valueQueue.offer(nowValue + node.right.val);
            }
        }
        return false;
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
