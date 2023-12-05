package leetcode110;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    /*
自己编写：二叉树后序遍历+对遍历到的节点依次判断
注意：掌握二叉树后序遍历的迭代方法
时间复杂度：O(n*n) 问题：多次重复调用getHeight函数
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.offerFirst(root);
                root = root.left;
            }
            root = stack.pollFirst();
            if (root.right == null || root.right == prev) {
                if(Math.abs(getHeight(root.left)-getHeight(root.right)) > 1){
                    return false;
                }
                prev = root;
                root = null;
            } else {
                stack.offerFirst(root);
                root = root.right;
            }
        }
        return true;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(1 + getHeight(root.left), 1 + getHeight(root.right));
    }

    /*
官方题解：自底向上的递归
自底向上递归的做法类似于后序遍历，对于当前遍历到的节点，先递归地判断其左右子树是否平衡，再判断以当前节点为根的子树是否平衡。
如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），否则返回−1。如果存在一棵子树不平衡，则整个二叉树一定不平衡。
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

     */
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