package leetcode103;

import java.util.*;

public class Solution {

    //102+反转偶数层的List
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> ret = new ArrayList<List<Integer>>();
//        if (root == null) {
//            return ret;
//        }
//
//        Deque<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        int length = 1;
//        while (!queue.isEmpty()) {
//            int thisLevelSize = queue.size();
//            List<Integer> thisLevelValue = new ArrayList<>();
//            for (int i = 0; i < thisLevelSize; i++) {
//                TreeNode node = queue.poll();
//                thisLevelValue.add(node.val);
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//            if (length % 2 == 0) {
//                Collections.reverse(thisLevelValue);
//            }
//            ret.add(thisLevelValue);
//            length++;
//        }
//        return ret;
//    }

    //102+插入返回值顺序不同
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int length = 1;
        while (!deque.isEmpty()) {
            List<Integer> thisLevelValue = new ArrayList<>();
            int thisLevelSize = deque.size();
            for (int i = 0; i < thisLevelSize; i++) {
                TreeNode node = deque.poll();
                if (length % 2 != 0) {
                    thisLevelValue.add(node.val);
                } else {
                    thisLevelValue.add(0, node.val);
                }
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            ret.add(thisLevelValue);
            length++;
        }
        return ret;
    }

    //题解：双端队列
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> ans = new LinkedList<List<Integer>>();
//        if (root == null) {
//            return ans;
//        }
//
//        Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
//        nodeQueue.offer(root);
//        boolean isOrderLeft = true;
//
//        while (!nodeQueue.isEmpty()) {
//            Deque<Integer> levelList = new LinkedList<Integer>();
//            int size = nodeQueue.size();
//            for (int i = 0; i < size; ++i) {
//                TreeNode curNode = nodeQueue.poll();
//                if (isOrderLeft) {
//                    levelList.offerLast(curNode.val);
//                } else {
//                    levelList.offerFirst(curNode.val);
//                }
//                if (curNode.left != null) {
//                    nodeQueue.offer(curNode.left);
//                }
//                if (curNode.right != null) {
//                    nodeQueue.offer(curNode.right);
//                }
//            }
//            ans.add(new LinkedList<Integer>(levelList));
//            isOrderLeft = !isOrderLeft;
//        }
//
//        return ans;
//    }
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