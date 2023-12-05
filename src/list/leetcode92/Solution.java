package leetcode92;

public class Solution {

//    //题解：使用头插法
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        // 设置 dummyNode 是这一类问题的一般做法
//        ListNode dummyNode = new ListNode(-1);
//        dummyNode.next = head;
//        ListNode pre = dummyNode;
//        for (int i = 0; i < left - 1; i++) {
//            pre = pre.next;
//        }
//        ListNode cur = pre.next;
//        ListNode next;
//        for (int i = 0; i < right - left; i++) {
//            next = cur.next;
//            cur.next = next.next;
//            next.next = pre.next;
//            pre.next = next;
//        }
//        return dummyNode.next;
//    }



    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode hair = new ListNode(0, head);
        ListNode ptr1 = head;
        ListNode prev;
        if (left == 1) {
            prev = hair;
        } else {
            for (int i = 0; i < left - 2; i++) {
                ptr1 = ptr1.next;
            }
            prev = ptr1;
            ptr1 = ptr1.next;
        }

        ListNode ptr2 = ptr1;
        for (int i = 0; i < right - left; i++) {
            ptr2 = ptr2.next;
        }
        ListNode nxt = ptr2.next;

        ListNode[] reverse = reverse(ptr1, ptr2);
        prev.next = reverse[1];
        ListNode node = reverse[0];
        node.next = nxt;
        return hair.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        if (head == tail) {
            return new ListNode[]{head, tail};
        }
        if (head.next == tail) {
            head.next = null;
            tail.next = head;
            return new ListNode[]{head, tail};
        }

        ListNode prev = null;
        ListNode curr = head;
        while (curr != tail) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        curr.next = prev;
        return new ListNode[]{head, tail};
    }
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