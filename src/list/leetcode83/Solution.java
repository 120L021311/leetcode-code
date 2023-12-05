package leetcode83;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ptr = head;
        ListNode prev = ptr;
        int lastValue = ptr.val;
        while (ptr != null) {
            if (ptr.val == lastValue) {
                prev.next = ptr.next;
            } else {
                prev = ptr;
                lastValue = ptr.val;
            }
            ptr = ptr.next;
        }

        return head;
    }

    //题解，写的更加简练一些
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null) {
//            return head;
//        }
//
//        ListNode cur = head;
//        while (cur.next != null) {
//            if (cur.val == cur.next.val) {
//                cur.next = cur.next.next;
//            } else {
//                cur = cur.next;
//            }
//        }
//
//        return head;
//    }
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