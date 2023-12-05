package leetcode328;

import java.util.Queue;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode oddPrev = new ListNode(0);
        ListNode oddHair = oddPrev;
        ListNode evenPrev = new ListNode(0);
        ListNode evenHair = evenPrev;
        while (odd.next != null && even.next != null) {
            oddPrev.next = odd;
            oddPrev = odd;
            odd = odd.next.next;
            evenPrev.next = even;
            evenPrev = even;
            even = even.next.next;
        }
        if (odd.next == null) {
            oddPrev.next = odd;
            evenPrev.next = null;
            odd.next = evenHair.next;
            return oddHair.next;
        } else {
            oddPrev.next = odd;
            evenPrev.next = even;
            odd.next = evenHair.next;
            return oddHair.next;
        }
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