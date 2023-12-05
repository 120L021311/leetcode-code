package leetcode19;


public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode ptr = head;
        while (ptr != null) {
            length++;
            ptr = ptr.next;
        }

        if (length == 1) {
            return null;
        } else {
            if (length == n) {
                return head.next;
            }
            int position = length - n;
            ptr = head;
            for (int i = 1; i < position; i++) {
                ptr = ptr.next;
            }
            ptr.next = ptr.next.next;
        }
        return head;
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