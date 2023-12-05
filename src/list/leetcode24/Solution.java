package leetcode24;

import java.util.ArrayList;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        ListNode ptr = head;
        int count = 0;
        while (ptr != null) {
            if (ptr.next != null) {
                newTail.next = new ListNode(ptr.next.val);
                newTail = newTail.next;
                newTail.next = new ListNode(ptr.val);
                newTail = newTail.next;
                ptr = ptr.next.next;
            } else {
                newTail.next = new ListNode(ptr.val, null);
                ptr = ptr.next;
            }
        }
        return newHead.next;
    }

//    public ListNode swapPairs(ListNode head) {
//        ArrayList<Integer> original = new ArrayList<>();
//        ListNode ptr = head;
//        while (ptr != null) {
//            original.add(ptr.val);
//            ptr = ptr.next;
//        }
//
//        int length = original.size();
//        int pairs = length / 2;
//        ArrayList<Integer> newList = new ArrayList<>();
//        for (int i = 0; i < pairs; i++) {
//            newList.add(original.get(i * 2 + 1));
//            newList.add(original.get(i * 2));
//        }
//        if (length % 2 != 0) {
//            newList.add(original.get(length - 1));
//        }
//
//        ListNode newHead = new ListNode(0);
//        ListNode newTail = newHead;
//        for (Integer integer : newList) {
//            newTail.next = new ListNode(integer);
//            newTail = newTail.next;
//        }
//        return newHead.next;
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