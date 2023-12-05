package leetcode82;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        boolean duplicateFlag = false;
        ListNode prev = new ListNode(0);
        ListNode hair = prev;
        prev.next = head;
        ListNode ptr = head.next;
        int lastValue = head.val;
        while (ptr != null) {
            if (ptr.val == lastValue) {
                duplicateFlag = true;
            } else {
                if (duplicateFlag) {
                    lastValue = ptr.val;
                    prev.next = ptr;
                } else {
                    lastValue = ptr.val;
                    prev = prev.next;
                }
                duplicateFlag = false;
            }
            ptr = ptr.next;
        }
        if (duplicateFlag) {
            prev.next = null;
        }
        return hair.next;
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