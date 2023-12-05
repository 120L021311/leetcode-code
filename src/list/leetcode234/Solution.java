package leetcode234;

public class Solution {
    //快慢双指针+反转后一半链表+再把后一半链表重新反转接回去恢复原链表
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode hair = new ListNode(0, head);
        ListNode slow = hair;
        ListNode fast = hair;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next == null) {
            ListNode backHead = slow.next;
            slow.next = null;
            ListNode backTail = fast;
            reverse(backHead, backTail);
            ListNode tmp;
            tmp = backHead;
            backHead = backTail;
            backTail = tmp;
            while (head != null && backHead != null) {
                if (head.val != backHead.val) {
                    reverse(backHead, backTail);
                    tmp = backHead;
                    backHead = backTail;
                    backTail = tmp;
                    slow.next=backHead;
                    return false;
                }
                head = head.next;
                backHead = backHead.next;
            }
            reverse(backHead, backTail);
            tmp = backHead;
            backHead = backTail;
            backTail = tmp;
            slow.next=backHead;
            return true;
        } else {
            ListNode backHead = slow.next.next;
            ListNode slowNext=slow.next;
            slow.next = null;
            ListNode backTail = fast.next;
            reverse(backHead, backTail);
            ListNode tmp;
            tmp = backHead;
            backHead = backTail;
            backTail = tmp;
            while (head != null && backHead != null) {
                if (head.val != backHead.val) {
                    slow.next=slowNext;
                    reverse(backHead, backTail);
                    tmp = backHead;
                    backHead = backTail;
                    backTail = tmp;
                    slowNext.next=backHead;
                    return false;
                }
                head = head.next;
                backHead = backHead.next;
            }
            slow.next=slowNext;
            reverse(backHead, backTail);
            tmp = backHead;
            backHead = backTail;
            backTail = tmp;
            slowNext.next=backHead;
            return true;
        }
    }

    public void reverse(ListNode head, ListNode tail) {
        if (head == null || tail == null || head == tail) {
            return;
        }
        if (head.next == tail) {
            tail.next = head;
            head.next = null;
            return;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr.next != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        curr.next = prev;
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