package leetcode94;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    //思路一：递归遍历
//    public List<Integer> inorderTraversal(TreeNode root) {
//        ArrayList<Integer> integers = new ArrayList<>();
//        inorder(root, integers);
//        return integers;
//    }

//    public void inorder(TreeNode root, List<Integer> nodeList) {
//        if (root == null) {
//            return;
//        }
//        inorder(root.left, nodeList);
//        nodeList.add(root.val);
//        inorder(root.right, nodeList);
//    }

    //思路二：迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }


    //思路3：Morris中序遍历：predecessor是x的左子树最后一个遍历到的节点
    //算法思路见图片
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        TreeNode predecessor = null;
//
//        while (root != null) {
//            if (root.left != null) {
//                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
//                predecessor = root.left;
//                while (predecessor.right != null && predecessor.right != root) {
//                    predecessor = predecessor.right;
//                }
//
//                // 让 predecessor 的右指针指向 root，继续遍历左子树
//                if (predecessor.right == null) {
//                    predecessor.right = root;
//                    root = root.left;
//                }
//                // 说明左子树已经访问完了，我们需要断开链接
//                else {
//                    res.add(root.val);
//                    predecessor.right = null;
//                    root = root.right;
//                }
//            }
//            // 如果没有左孩子，则直接访问右孩子
//            else {
//                res.add(root.val);
//                root = root.right;
//            }
//        }
//        return res;
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
