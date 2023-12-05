package leetcode106;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        ready(inorder);
        return mybuildTree(inorder, postorder, 0, length - 1, 0, length - 1);
    }

    public TreeNode mybuildTree(int[] inorder, int[] postorder, int inorderLeft, int inorderRight, int postorderLeft, int postorderRight) {
        if (inorderRight < inorderLeft) {
            return null;
        }
        int rootValue = postorder[postorderRight];
        TreeNode root = new TreeNode(rootValue);
        int index = indexMap.get(rootValue);
        int rightChildSize = inorderRight - index;
        root.left = mybuildTree(inorder, postorder, inorderLeft, index - 1, postorderLeft, postorderRight - rightChildSize - 1);
        root.right = mybuildTree(inorder, postorder, index + 1, inorderRight, postorderRight - rightChildSize, postorderRight - 1);
        return root;
    }

    public void ready(int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
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