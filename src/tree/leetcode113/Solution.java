package leetcode113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /*
自己编写思路：广度优先搜索
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<List<TreeNode>> pathQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();
        List<TreeNode> rootList = new ArrayList<>();
        rootList.add(root);
        pathQueue.offer(rootList);
        valueQueue.offer(root.val);
        while (!pathQueue.isEmpty()) {
            List<TreeNode> thisPath = pathQueue.poll();
            List<TreeNode> tempPath1 = new ArrayList<>(thisPath);
            List<TreeNode> tempPath2 = new ArrayList<>(thisPath);
            int currPathValue = valueQueue.poll();
            TreeNode lastNode = thisPath.get(thisPath.size() - 1);
            if (lastNode.left == null && lastNode.right == null) {
                if (currPathValue == targetSum) {
                    List<Integer> temp = new ArrayList<>();
                    for (TreeNode node : thisPath) {
                        temp.add(node.val);
                    }
                    result.add(temp);
                }
            }
            if (lastNode.left != null) {
                tempPath1.add(lastNode.left);
                pathQueue.offer(tempPath1);
                valueQueue.offer(currPathValue+lastNode.left.val);
            }
            if (lastNode.right != null) {
                tempPath2.add(lastNode.right);
                pathQueue.offer(tempPath2);
                valueQueue.offer(currPathValue+lastNode.right.val);
            }
        }
        return result;
    }

    /*
题解思路：广度优先搜索
为了节省空间，我们使用哈希表记录树中的每一个节点的父节点。
每次找到一个满足条件的节点，我们就从该节点出发不断向父节点迭代，即可还原出从根节点到当前节点的路径。
class Solution {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueSum = new LinkedList<Integer>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == targetSum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }

        return ret;
    }

    public void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<Integer>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret.add(new LinkedList<Integer>(temp));
    }
}
     */

    /*
题解思路：递归深度优先搜索
采用深度优先搜索的方式，枚举每一条从根节点到叶子节点的路径。
当我们遍历到叶子节点，且此时路径和恰为目标和时，我们就找到了一条满足条件的路径。

注意：我们要理解递归的本质，当递归往下传递的时候他最后还是会往回走，
      我们把这个值使用完之后还要把它给移除，这就是回溯！！！
class Solution {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast();
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