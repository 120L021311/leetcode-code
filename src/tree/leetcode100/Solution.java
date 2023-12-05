package leetcode100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    //自己写的（深度优先搜索）
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        return compare(p, q);
//    }
//
//    public boolean compare(TreeNode p, TreeNode q) {
//        if (p == null && q == null) {
//            return true;
//        }
//        if (p == null || q == null) {
//            return false;
//        }
//        if (p.val != q.val) {
//            return false;
//        }
//        boolean leftSame = compare(p.left, q.left);
//        boolean rightSame = compare(p.right, q.right);
//        return leftSame && rightSame;
//    }


    //题解：深度优先搜索
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p == null && q == null) {
//            return true;
//        } else if (p == null || q == null) {
//            return false;
//        } else if (p.val != q.val) {
//            return false;
//        } else {
//            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//        }
//    }

    //题解：广度优先搜索
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            Deque<TreeNode> queue1 = new LinkedList<>();
            Deque<TreeNode> queue2 = new LinkedList<>();
            queue1.add(p);
            queue2.add(q);
            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();
                if (node1.val != node2.val) {
                    return false;
                }
                if ((node1.left == null ^ node2.left == null) || (node1.right == null ^ node2.right == null)) {
                    return false;
                }
                if (node1.left != null) {
                    queue1.add(node1.left);
                    queue2.add(node2.left);
                }
                if (node1.right != null) {
                    queue1.add(node1.right);
                    queue2.add(node2.right);
                }
            }
            return queue1.isEmpty() && queue2.isEmpty();
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