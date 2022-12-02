package cn.inkroom.study.leetcode;

import cn.inkroom.study.leetcode.data.ListNode;

/**
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }


        return false;

    }

    public static void main(String[] args) {

        ListNode r = new ListNode(1);
        r.next = new ListNode(2);
        r.next.next = new ListNode(3);
        r.next.next.next = new ListNode(5);
        r.next.next.next.next = new ListNode(6);
        r.next.next.next.next.next = new ListNode(8);
        r.next.next.next.next.next.next = new ListNode(12);
        r.next.next.next.next.next.next.next = new ListNode(19);


        r.next.next.next.next.next.next.next.next = r.next.next.next.next;


        System.out.println(new LinkedListCycle().hasCycle(r));
    }
}
