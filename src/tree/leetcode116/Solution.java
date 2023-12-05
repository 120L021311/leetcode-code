package leetcode116;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
自己编写思路：层序遍历
题解编写的代码：
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {

            // 记录当前队列大小
            int size = queue.size();

            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {

                // 从队首取出元素
                Node node = queue.poll();

                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        // 返回根节点
        return root;
    }
}
     */
//    public Node connect(Node root) {
//        if (root == null) {
//            return null;
//        }
//        Queue<Node> nodeQueue = new LinkedList<>();
//        nodeQueue.offer(root);
//        while (!nodeQueue.isEmpty()) {
//            int size = nodeQueue.size();
//            Node prev, curr;
//            if (size == 1) {
//                curr = nodeQueue.poll();
//                if (curr.left != null) {
//                    nodeQueue.offer(curr.left);
//                }
//                if (curr.right != null) {
//                    nodeQueue.offer(curr.right);
//                }
//            } else {
//                prev = nodeQueue.poll();
//                if (prev.left != null) {
//                    nodeQueue.offer(prev.left);
//                }
//                if (prev.right != null) {
//                    nodeQueue.offer(prev.right);
//                }
//                curr = nodeQueue.poll();
//                if (curr.left != null) {
//                    nodeQueue.offer(curr.left);
//                }
//                if (curr.right != null) {
//                    nodeQueue.offer(curr.right);
//                }
//                prev.next = curr;
//                for (int i = 0; i < size - 2; i++) {
//                    prev = curr;
//                    curr = nodeQueue.poll();
//                    prev.next = curr;
//                    if (curr.left != null) {
//                        nodeQueue.offer(curr.left);
//                    }
//                    if (curr.right != null) {
//                        nodeQueue.offer(curr.right);
//                    }
//                }
//            }
//        }
//        return root;
//    }


    /*
题解方法二：使用已建立的 next 指针
一棵树中，存在两种类型的 next 指针。
    第一种情况是连接同一个父节点的两个子节点。它们可以通过同一个节点直接访问到，因此执行下面操作即可完成连接。node.left.next = node.right
    第二种情况是连接不同父节点之间子节点的情况。更具体地说，连接的是第一个父节点的右孩子和第二父节点的左孩子。由于已经在父节点这一层建立了 next 指针，因此可以直接通过第一个父节点的 next 指针找到第二个父节点，然后在它们的孩子之间建立连接。node.right.next = node.next.left
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node leftmost = root;
        while (leftmost.left != null) { // 注意！当我们为第 N 层节点建立next 指针时，处于第N−1 层。当第 N 层节点的 next 指针全部建立完成后，移至第 N 层，建立第 N+1 层节点的 next 指针。所以要注意循环终止条件！
//            所以要注意循环终止条件！
            Node curr = leftmost;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            leftmost = leftmost.left;
        }

        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};