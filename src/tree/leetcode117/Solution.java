package leetcode117;

public class Solution {
    /*
思路一：层序遍历，非常简单
代码可以同116的层序，不需修改
     */
    /*
思路：访问上一层时把下一层串起来
自己编写的方法，时间效率不理想，findNext复杂度是O(n)
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node leftmost = root;
        Node nextLevelLeftmost = findNextLevelLeftmost(leftmost);
        while (nextLevelLeftmost != null) {
            Node prev = nextLevelLeftmost;
            Node curr = findNext(prev, leftmost);
            while (curr != null) {
                prev.next = curr;
                prev = curr;
                curr = findNext(prev, leftmost);
            }
            leftmost = nextLevelLeftmost;
            nextLevelLeftmost = findNextLevelLeftmost(leftmost);
        }
        return root;
    }

    public Node findNextLevelLeftmost(Node leftmost) {
        while (leftmost != null) {
            if (leftmost.left != null) {
                return leftmost.left;
            } else if (leftmost.right != null) {
                return leftmost.right;
            }
            leftmost = leftmost.next;
        }
        return null;
    }

    public Node findNext(Node nextLevelNode, Node leftmost) {
        Node curr = leftmost;
        Node father = leftmost;
        Node ret;
        while (curr != null) {
            if (curr.left == nextLevelNode || curr.right == nextLevelNode) {
                father = curr;
            }
            curr = curr.next;
        }
        if (father.left == nextLevelNode && father.right != null) {
            return father.right;
        } else {
            father = father.next;
            while (father != null) {
                if (father.left != null) {
                    return father.left;
                } else if (father.right != null) {
                    return father.right;
                }
                father = father.next;
            }
            return null;
        }
    }

    /*
题解方法：其中通过增加哑节点来确定下一层最左节点很巧妙。findNext直接遍历上一层更新cur可以得到。
注意它的两层循环！
    public Node connect(Node root) {
        if (root == null)
            return root;
        //cur我们可以把它看做是每一层的链表
        Node cur = root;
        while (cur != null) {
            //遍历当前层的时候，为了方便操作在下一
            //层前面添加一个哑结点（注意这里是访问
            //当前层的节点，然后把下一层的节点串起来）
            Node dummy = new Node(0);
            //pre表示访下一层节点的前一个节点
            Node pre = dummy;
            //然后开始遍历当前层的链表
            while (cur != null) {
                if (cur.left != null) {
                    //如果当前节点的左子节点不为空，就让pre节点
                    //的next指向他，也就是把它串起来
                    pre.next = cur.left;
                    //然后再更新pre
                    pre = pre.next;
                }
                //同理参照左子树
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                //继续访问这一行的下一个节点
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，
            //后续继续循环，直到cur为空为止
            cur = dummy.next;
        }
        return root;
    }

     */
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