package cn.inkroom.study.leetcode;

import cn.inkroom.study.leetcode.data.ListNode;

/**
 * 876. 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

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
        System.out.println(new MiddleOfTheLinkedList().middleNode(r));


    }

}
