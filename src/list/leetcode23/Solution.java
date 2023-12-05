package leetcode23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int[] minValue = new int[lists.length];
        boolean[] finish = new boolean[lists.length];
        for (int i = 0; i < minValue.length; i++) {
            if (lists[i] == null) {
                minValue[i] = Integer.MAX_VALUE;
                finish[i] = true;
                continue;
            }
            minValue[i] = lists[i].val;
            finish[i] = false;
        }

        ListNode head = new ListNode();
        ListNode tail = head;

        boolean flag = true;
        while (flag) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < minValue.length; i++) {
                if (min > minValue[i]) {
                    min = minValue[i];
                    index = i;
                }
            }
            tail.next = lists[index];
            tail = tail.next;
            if (lists[index].next == null) {
                minValue[index] = Integer.MAX_VALUE;
                finish[index] = true;
            } else {
                lists[index] = lists[index].next;
                minValue[index] = lists[index].val;
            }

            for (int i = 0; i < finish.length; i++) {
                if (finish[i] == false) {
                    break;
                }
                flag = false;
            }
        }
        tail.next = null;
        return head.next;
    }

    //题解：优先级队列
//    public ListNode mergeKLists(ListNode[] lists) {
//
//        if (lists.length == 0) {
//            return null;
//        }
//
//        ListNode dummyHead = new ListNode(0);
//        ListNode curr = dummyHead;
//        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        });
//
//        for (ListNode list : lists) {
//            if (list == null) {
//                continue;
//            }
//            pq.add(list);
//        }
//
//        while (!pq.isEmpty()) {
//            ListNode nextNode = pq.poll();
//            curr.next = nextNode;
//            curr = curr.next;
//            if (nextNode.next != null) {
//                pq.add(nextNode.next);
//            }
//        }
//        return dummyHead.next;
//    }

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */