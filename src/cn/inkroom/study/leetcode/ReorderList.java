package cn.inkroom.study.leetcode;

import cn.inkroom.study.leetcode.data.ListNode;

/**
 * 143. 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 * <br/>
 * 将链表分成两半，将后半翻转后，再合并两个链表
 */
public class ReorderList {
    public void reorderList(ListNode head) {

        //首先找到中点

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //从中点开始，翻转后半截链表
        ListNode after = reser(slow);
        //合并链表

        ListNode t = head;

        ListNode res = new ListNode(-1);

        while (head != null && head != slow) {

            res.next = head;

            head = head.next;

            res.next.next = after;

            res = after;

            after = after.next;


        }

    }

    public ListNode reser(ListNode head) {

        ListNode pre = head;
        ListNode cur = head.next;

        head.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        return pre;


    }

    public static void main(String[] args) {


        ListNode r = new ListNode(1);
        r.next = new ListNode(2);
        r.next.next = new ListNode(3);
        r.next.next.next = new ListNode(5);
        r.next.next.next.next = new ListNode(6);
        r.next.next.next.next.next = new ListNode(7);
        r.next.next.next.next.next.next = new ListNode(12);
        r.next.next.next.next.next.next.next = new ListNode(15);


        new ReorderList().reorderList(r);

        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }

    }

}
