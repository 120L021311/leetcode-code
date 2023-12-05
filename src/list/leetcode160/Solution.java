package leetcode160;

import java.util.ArrayList;

public class Solution {

    //思路1：哈希集合记录
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ArrayList<ListNode> listA = new ArrayList<>();
//        ArrayList<ListNode> listB = new ArrayList<>();
//        while (headA != null && headB != null) {
//            listA.add(headA);
//            listB.add(headB);
//            if (listA.contains(headB)) {
//                return headB;
//            }
//            if (listB.contains(headA)) {
//                return headA;
//            }
//            headA = headA.next;
//            headB = headB.next;
//        }
//        if (headA != null) {
//            while (headA != null) {
//                if (listB.contains(headA)) {
//                    return headA;
//                }
//                headA = headA.next;
//            }
//        }
//        if (headB != null) {
//            while (headB != null) {
//                if (listA.contains(headB)) {
//                    return headB;
//                }
//                headB = headB.next;
//            }
//        }
//        return null;
//    }

    //思路2：双指针
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        while (ptr1 != ptr2) {
            if (ptr1 == null) {
                ptr1 = headB;
            } else {
                ptr1 = ptr1.next;
            }
            if (ptr2 == null) {
                ptr2 = headA;
            } else {
                ptr2 = ptr2.next;
            }
        }
        return ptr1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}