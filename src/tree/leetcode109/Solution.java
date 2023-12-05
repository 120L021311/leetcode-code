package leetcode109;

public class Solution {
    /*
方法一：分治
在找出了中位数节点之后，我们将其作为当前根节点的元素，并递归地构造其左侧部分的链表对应的左子树，以及右侧部分的链表对应的右子树。
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode hair = new ListNode(100000, head);
        ListNode slow = hair;
        ListNode fast = hair;
        ListNode slowPrev = new ListNode(100000, hair);
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            slowPrev = slowPrev.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        slowPrev = slowPrev.next;
        TreeNode root = new TreeNode(slow.val);
        ListNode rightChildHead = slow.next;
        slow.next = null;
        slowPrev.next = null;
        hair.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rightChildHead);
        return root;
    }
    /*
    方法一题解
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
     */


    /*
方法二：分治 + 中序遍历优化
可以将分治和中序遍历结合起来，减少时间复杂度。

具体地，设当前链表的左端点编号为left，右端点编号为right，包含关系为「双闭」，即left 和right 均包含在链表中。链表节点的编号为[0,n)。
中序遍历的顺序是「左子树 - 根节点 - 右子树」，那么在分治的过程中，我们不用急着找出链表的中位数节点，而是使用一个占位节点，等到中序遍历到该节点时，再填充它的值。

我们可以通过计算编号范围来进行中序遍历：
中位数节点对应的编号为 mid=(left+right+1)/2；（根据方法一中对于中位数的定义，编号为(left+right)/2 的节点同样也可以是中位数节点。）
左右子树对应的编号范围分别为[left,mid−1] 和[mid+1,right]。
如果left>right，那么遍历到的位置对应着一个空节点，否则对应着二叉搜索树中的一个节点。

这样一来，我们其实已经知道了这棵二叉搜索树的结构，并且题目给定了它的中序遍历结果，那么我们只要对其进行中序遍历，就可以还原出整棵二叉搜索树了。

    ListNode globalHead;

    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }

    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }
     */


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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