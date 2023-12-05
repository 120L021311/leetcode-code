package tree.leetcode230;

import java.util.*;

public class Solution {

    /*
 思路一：递归
    List<TreeNode> nodes = new ArrayList<>();
    TreeNode node = null;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return node.val;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k);
        nodes.add(root);
        if (nodes.size() == k) {
            node=root;
            return;
        }
        inorder(root.right, k);
    }
     */

    /*
思路二：迭代
好处：不需要遍历整棵树
    List<TreeNode> nodes = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            nodes.add(root);
            k--;
            if (0 == k) {
                break;
            }
            root=root.right;
        }
        return root.val;
    }
     */

    /*
思路三：对于每个节点，记录下以它为根的子树的节点数
是针对与二叉搜索树经常被修改且需要频繁查找第k小的值的情况做出的优化
public int kthSmallest(TreeNode root, int k) {
        MyBst bst = new MyBst(root);
        return bst.kthSmallest(k);
    }
     */



    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.right = node2;
        node3.left = node1;
        node3.right = node4;
        Solution solution = new Solution();
        int res = solution.kthSmallest(node3, 1);
    }

    /*
思路四：AVL树(平衡二叉搜索树)
     */
    public int kthSmallest(TreeNode root, int k) {
        // 中序遍历生成数值列表
        List<Integer> inorderList = new ArrayList<Integer>();
        inorder(root, inorderList);

        // 构造平衡二叉搜索树
        AVL avl = new AVL(inorderList);

        // 模拟1000次插入和删除操作
        int[] randomNums = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; ++i) {
            randomNums[i] = random.nextInt(10001);
            avl.insert(randomNums[i]);
        }
        shuffle(randomNums); // 列表乱序
        for (int i = 0; i < 1000; ++i) {
            avl.delete(randomNums[i]);
        }

        return avl.kthSmallest(k);
    }

    private void inorder(TreeNode node, List<Integer> inorderList) {
        if (node.left != null) {
            inorder(node.left, inorderList);
        }
        inorderList.add(node.val);
        if (node.right != null) {
            inorder(node.right, inorderList);
        }
    }

    private void shuffle(int[] arr) {
        Random random = new Random();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int randIndex = random.nextInt(length);
            int temp = arr[i];
            arr[i] = arr[randIndex];
            arr[randIndex] = temp;
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

class MyBst {
    TreeNode root;
    Map<TreeNode, Integer> nodeNum;

    public MyBst(TreeNode root) {
        this.root = root;
        this.nodeNum = new HashMap<TreeNode, Integer>();
        countNodeNum(root);
    }

    // 返回二叉搜索树中第k小的元素
    public int kthSmallest(int k) {
        while (root != null) {
            int leftNodeNum = getNodeNum(root.left);
            if (leftNodeNum == k - 1) {
                break;
            } else if (leftNodeNum < k - 1) {
                root = root.right;
                k = k - leftNodeNum - 1;
            } else {
                root=root.left;
            }
        }
        return root.val;
    }

    // 统计以node为根结点的子树的结点数
    private int countNodeNum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int num = countNodeNum(node.left) + countNodeNum(node.right) + 1;
        nodeNum.put(node, num);
        return num;
    }

    // 获取以node为根结点的子树的结点数
    private int getNodeNum(TreeNode node) {
        return nodeNum.getOrDefault(node, 0);
    }
}