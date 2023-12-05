package leetcode102;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {


//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if(root==null){
//            return new ArrayList<>();
//        }
//        List<List<TreeNode>> levelTreeNodes = new ArrayList<>();
//        List<List<Integer>> result = new ArrayList<>();
//        ArrayList<TreeNode> level1TreeNode = new ArrayList<>();
//        ArrayList<Integer> level1Value = new ArrayList<>();
//        level1TreeNode.add(root);
//        level1Value.add(root.val);
//        levelTreeNodes.add(level1TreeNode);
//        result.add(level1Value);
//        while(true){
//            List<TreeNode> lastLevelTreeNode = levelTreeNodes.get(levelTreeNodes.size()-1);
//            List<TreeNode> thisLevelTreeNode = new ArrayList<>();
//            List<Integer> thisLevelValue=new ArrayList<>();
//            for (TreeNode treeNode : lastLevelTreeNode) {
//                if(treeNode.left!=null){
//                    thisLevelTreeNode.add(treeNode.left);
//                    thisLevelValue.add(treeNode.left.val);
//                }
//                if(treeNode.right!=null){
//                    thisLevelTreeNode.add(treeNode.right);
//                    thisLevelValue.add(treeNode.right.val);
//                }
//            }
//            if(thisLevelTreeNode.isEmpty()){
//                return result;
//            }
//            levelTreeNodes.add(thisLevelTreeNode);
//            result.add(thisLevelValue);
//        }
//    }

    //题解：广度优先搜索BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int thisLevelSize = queue.size();
            List<Integer> thisLevelValue = new ArrayList<>();
            for (int i = 0; i < thisLevelSize; i++) {
                TreeNode node = queue.poll();
                thisLevelValue.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            ret.add(thisLevelValue);
        }
        return ret;
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