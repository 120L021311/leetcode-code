package leetcode02;


import java.math.BigInteger;

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
public class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        String s1="",s2="";
//        while(l1!=null)
//        {
//            s1=s1+l1.val;
//            l1=l1.next;
//        }
//        while(l2!=null)
//        {
//            s2=s2+l2.val;
//            l2=l2.next;
//        }
//
//        StringBuilder stringBuilder1 = new StringBuilder(s1);
//        StringBuilder stringBuilder2 = new StringBuilder(s2);
//        BigInteger b1 = new BigInteger(stringBuilder1.reverse().toString());
//        BigInteger b2 = new BigInteger(stringBuilder2.reverse().toString());
//        BigInteger res = b1.add(b2);
//        String result = res.toString();
//        ListNode head = new ListNode(), p = head;
//        for (int i = result.length() - 1; i >= 0; i--) {
//            ListNode q = new ListNode(result.charAt(i) - '0');
//            p.next = q;
//            p = q;
//        }
//        return head.next;
//    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(), cur = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = 0;
            int y = 0;
            if (l1 != null) {
                x = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
            }
            int sum = x + y + carry;
            carry = sum / 10;

            int num = sum % 10;
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return head.next;
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