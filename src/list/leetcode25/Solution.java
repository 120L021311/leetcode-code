package leetcode25;

import java.util.ArrayList;

public class Solution {


    //投机取巧的解法
//    public ListNode reverseKGroup(ListNode head, int k) {
//        if (head == null) {
//            return null;
//        }
//        if(k==1){
//            return head;
//        }
//        int length = 0;
//        ArrayList<Integer> list = new ArrayList<>();
//        ListNode ptr = head;
//        while (ptr != null) {
//            length++;
//            list.add(ptr.val);
//            ptr = ptr.next;
//        }
//        int times = list.size() / k;
//        ListNode newHead = new ListNode(0);
//        ListNode newTail = newHead;
//        for (int i = 0; i < times; i++) {
//            for (int j = k - 1; j >= 0; j--) {
//                newTail.next = new ListNode(list.get(i * k   + j));
//                newTail = newTail.next;
//            }
//        }
//        if (list.size() % k != 0) {
//            ptr = head;
//            for (int i = 0; i < times * k - 1; i++) {
//                ptr = ptr.next;
//            }
//            newTail.next = ptr.next;
//        }
//        return newHead.next;
//    }

    //k个一组反转列表
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 1) {
            return head;
        }

        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode tail = hair;
        ListNode prev = tail;

        while (head != null) {
            for (int i = 0; i < k; i++) {
                if (tail.next == null) {
                    return hair.next;
                }
                tail = tail.next;
            }
            ListNode nxt = tail.next;
            ListNode[] reverse = reverseList(head, tail);
            head = reverse[0];
            tail = reverse[1];
            prev.next = tail;
            prev = head;
            tail = prev;
            head.next = nxt;
            head = nxt;
        }
        return hair.next;
    }


    public ListNode[] reverseList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
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

    //题解
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode hair = new ListNode(0);
//        hair.next = head;
//        ListNode pre = hair;
//
//        while (head != null) {
//            ListNode tail = pre;
//            // 查看剩余部分长度是否大于等于 k
//            for (int i = 0; i < k; ++i) {
//                tail = tail.next;
//                if (tail == null) {
//                    return hair.next;
//                }
//            }
//            ListNode nex = tail.next;
//            ListNode[] reverse = myReverse(head, tail);
//            head = reverse[0];
//            tail = reverse[1];
//            // 把子链表重新接回原链表
//            pre.next = head;
//            tail.next = nex;
//            pre = tail;
//            head = tail.next;
//        }
//
//        return hair.next;
//    }
//
//    public ListNode[] myReverse(ListNode head, ListNode tail) {
//        ListNode prev = tail.next;
//        ListNode p = head;
//        while (prev != tail) {
//            ListNode nex = p.next;
//            p.next = prev;
//            prev = p;
//            p = nex;
//        }
//        return new ListNode[]{tail, head};
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