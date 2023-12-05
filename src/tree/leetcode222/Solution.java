package leetcode222;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
思路一：层序遍历（BFS） 复杂度O(n)
不足：没有利用上完全二叉树的性质
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int num = 1;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while(!nodeQueue.isEmpty()){
            TreeNode node= nodeQueue.poll();
            if(node.left!=null){
                nodeQueue.offer(node.left);
                num++;
            }
            if(node.right!=null){
                nodeQueue.offer(node.right);
                num++;
            }
        }
        return num;
    }
     */

    /*
思路二：利用完全二叉树的特点
对 root 节点的左右子树进行高度统计，分别记为 left 和 right，有以下两种结果：
    left == right。这说明，左子树一定是满二叉树，因为节点已经填充到右子树了，左子树必定已经填满了。所以左子树的节点总数我们可以直接得到，是 2^left - 1，加上当前这个 root 节点，则正好是 2^left。再对右子树进行递归统计。
    left != right。说明此时最后一层不满，但倒数第二层已经满了，可以直接得到右子树的节点个数。同理，右子树节点 +root 节点，总数为 2^right。再对左子树进行递归查找。

     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftHeight = countLevel(root.left);
        int rightHeight = countLevel(root.right);
        if (leftHeight == rightHeight) {
            return (int) (countNodes(root.right) + Math.pow(2, leftHeight));
        } else {
            return (int) (countNodes(root.left) + Math.pow(2, rightHeight)); // 后面的乘方可以用移位
        }
    }

    public int countLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 1;
        while (root.left != null) {
            height++;
            root = root.left;
        }
        return height;
    }

    /*
官方题解方法：二分查找+位运算
时间复杂度：O(logn的平方)
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
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