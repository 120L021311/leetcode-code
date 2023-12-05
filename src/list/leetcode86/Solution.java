package leetcode86;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode hair1 = new ListNode(0);
        ListNode hair2 = new ListNode(0);
        ListNode ptr = head;
        ListNode ptr1 = hair1;
        ListNode ptr2 = hair2;

        while (ptr != null) {
            if (ptr.val < x) {
                ptr1.next = ptr;
                ptr1 = ptr1.next;
            } else {
                ptr2.next = ptr;
                ptr2 = ptr2.next;
            }
            ptr=ptr.next;
        }
        ptr1.next = hair2.next;
        ptr2.next=null;
        return hair1.next;
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