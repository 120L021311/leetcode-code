package leetcode141;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    //思路1：相当于见过一个节点就为这个节点标记
//    public boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null) {
//            return false;
//        }
//        if (head.next == head) {
//            return true;
//        }
//        ListNode dead = new ListNode(0);
//        while (head.next != null) {
//            ListNode nxt = head.next;
//            head.next = dead;
//            head = nxt;
//            if (head.next == dead) {
//                return true;
//            }
//        }
//        return false;
//    }

    //题解思路1：使用HashSet记录见到过的节点
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> seen = new HashSet<ListNode>();
//        while (head != null) {
//            if (!seen.add(head)) {
//                return true;
//            }
//            head = head.next;
//        }
//        return false;
//    }

    //题解思路2：龟兔赛跑（快慢双指针）
//    public boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null) {
//            return false;
//        }
//        ListNode slow = head;
//        ListNode fast = head.next;
//        while (slow != fast) {
//            if (fast == null || fast.next == null) {
//                return false;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return true;
//    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}