package leetcode143;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //递归
//    public void reorderList(ListNode head) {
//        if (head == null || head.next == null) {
//            return;
//        }
//        if (head.next.next == null) {
//            return;
//        } else {
//            ListNode headNext = head.next;
//            ListNode ptr = head;
//            while (ptr.next.next != null) {
//                ptr = ptr.next;
//            }
//            ListNode tailPrev = ptr;
//            ListNode tail = ptr.next;
//            tail.next = headNext;
//            head.next = tail;
//            tailPrev.next = null;
//            reorderList(headNext);
//        }
//    }

    //思路2：迭代
    //想法与递归大致相同
//    public void reorderList(ListNode head) {
//        if (head == null || head.next == null) {
//            return;
//        }
//        if (head.next.next == null) {
//            return;
//        }
//        while(head.next.next!=null) {
//            ListNode ptr = head;
//            ListNode headNext = head.next;
//            while (ptr.next.next != null) {
//                ptr = ptr.next;
//            }
//            ListNode tailPrev = ptr;
//            ListNode tail = ptr.next;
//            tail.next = headNext;
//            head.next = tail;
//            tailPrev.next = null;
//            head = headNext;
//            if (head.next == null) {
//                return;
//            }
//        }
//    }

    //思路3：线性表
//    public void reorderList(ListNode head) {
//        if (head == null || head.next == null) {
//            return;
//        }
//        ArrayList<ListNode> listNodes = new ArrayList<>();
//        int length = 1;
//        ListNode ptr = head;
//        listNodes.add(ptr);
//        while (ptr.next != null) {
//            length++;
//            ptr = ptr.next;
//            listNodes.add(ptr);
//        }
//        int i = 0;
//        int j = length - 1;
//        while (i < j) {
//            if (i + 1 >= j) {
//                break;
//            }
//            ListNode node1 = listNodes.get(i);
//            ListNode node2 = listNodes.get(j);
//            node2.next = node1.next;
//            node1.next = node2;
//            i++;
//            j--;
//        }
//        listNodes.get(j).next = null;
//    }

    //思路4：寻找链表中点+反转链表+合并两个链表
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        //寻找中点
        ListNode hair = new ListNode(0, head);
        ListNode slow = hair;
        ListNode fast = hair;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }


        ListNode reverseHead = slow.next;
        ListNode reverseTail = fast;
        slow.next = null;

        //反转后面的链表
        ListNode[] reverse = reverse(reverseHead, reverseTail);
        ListNode backHead = reverse[1];
        ListNode backTail = reverse[0];

        //合并两个链表
        ListNode ptr2 = backHead;
        ListNode ptr1 = head;
        while (ptr2 != null) {
            ListNode tempPtr2 = ptr2.next;
            ptr2.next = ptr1.next;
            ptr1.next = ptr2;
            ptr1 = ptr2.next;
            ptr2 = tempPtr2;
        }
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        if (head == null || head.next == null) {
            return new ListNode[]{head, tail};
        }
        if (head.next == tail) {
            tail.next = head;
            head.next = null;
            return new ListNode[]{head, tail};
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
        return new ListNode[]{head, tail};
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