package leetcode199;

import java.util.*;

public class Solution {

    /*
思路1：广度优先搜索
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offerLast(root);
        while (!nodeQueue.isEmpty()) {
            res.add(nodeQueue.peekLast().val);
            TreeNode node;
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                node = nodeQueue.poll();
                if (node.left != null) {
                    nodeQueue.offerLast(node.left);
                }
                if (node.right != null) {
                    nodeQueue.offerLast(node.right);
                }
            }
        }
        return res;
    }
     */


    /*
思路2：深度优先搜索
     */
    List<Integer> res=new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return res;
    }

    public void dfs(TreeNode root,int depth){
        if(root==null){
            return ;
        }
        if(depth==res.size()){
            res.add(root.val);
        }
        depth++;
        dfs(root.right,depth);
        dfs(root.left,depth);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node2.right=node5;
        node3.right=node4;
        System.out.println(new Solution().rightSideView(node1));
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