package leetcode105;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    /*
自己编写的方法
    问题：
    1.每次查找根节点在中序遍历的位置需要顺序扫描数组，效率低
    2.在递归构造时出现了很多数组元素的复制，效率低
    解决方法：
    1.首先将中序遍历顺序中节点值与数组下标存储在一个哈希表中，查找效率变高
    2.在多次构造时不进行复制，在原数组上进行构造，通过下标指定构造的数组范围
     */
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if(preorder.length==0){
//            return null;
//        }
//        if (preorder.length == 1) {
//            return new TreeNode(preorder[0]);
//        }
//        int rootValue = preorder[0];
//        TreeNode root = new TreeNode(rootValue);
//        int index = 0;
//        for (int i = 0; i < inorder.length; i++) {
//            if (rootValue == inorder[i]) {
//                index = i;
//                break;
//            }
//        }
//        int[] leftPreorder = new int[index];
//        int[] leftInorder;
//        int[] rightPreorder = new int[preorder.length - index - 1];
//        int[] rightInorder = new int[preorder.length - index - 1];
//        System.arraycopy(preorder, 1, leftPreorder, 0, index);
//        for (int i = preorder.length - 1; i > index; i--) {
//            rightPreorder[i - index - 1] = preorder[i];
//        }
//        leftInorder = Arrays.copyOfRange(inorder, 0, index);
//        for (int i = index + 1; i < inorder.length; i++) {
//            rightInorder[i - index - 1] = inorder[i];
//        }
//        root.left=buildTree(leftPreorder,leftInorder);
//        root.right=buildTree(rightPreorder,rightInorder);
//        return root;
//    }


    /*
    题解：递归遍历，实现很漂亮
     */
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
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