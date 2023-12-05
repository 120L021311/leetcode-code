package leetcode61;

public class Solution {

//    public ListNode rotateRight(ListNode head, int k) {
//        if (k == 0) {
//            return head;
//        }
//        if (head == null) {
//            return null;
//        }
//        int length = 0;
//        ListNode ptr = head;
//        while (ptr != null) {
//            length++;
//            ptr = ptr.next;
//        }
//        k = k % length;
//        for (int i = 0; i < k; i++) {
//            head = rotate(head);
//        }
//        return head;
//    }
//
//    public ListNode rotate(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        if (head.next == null) {
//            return head;
//        }
//        if (head.next.next == null) {
//            ListNode tail = head.next;
//            tail.next = head;
//            head.next = null;
//            return tail;
//        }
//        ListNode ptr = head;
//        while (ptr.next.next != null) {
//            ptr = ptr.next;
//        }
//        ListNode newHead = ptr.next;
//        newHead.next = head;
//        ptr.next = null;
//        return newHead;
//    }

    //题解：先把链表闭合为环，再计算出需要断开的位置断开即可
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }

        int length = 1;
        ListNode ptr = head;
        while (ptr.next != null) {
            length++;
            ptr = ptr.next;
        }
        ptr.next = head;
        k = k % length;

        ptr = head;
        int hop = length - k - 1;
        for (int i = 0; i < hop; i++) {
            ptr = ptr.next;
        }
        ListNode newHead=ptr.next;
        ptr.next = null;
        return newHead;
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