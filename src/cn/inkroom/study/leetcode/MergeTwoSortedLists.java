package cn.inkroom.study.leetcode;

import cn.inkroom.study.leetcode.data.ListNode;

/**
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        ListNode l = l1;
        ListNode r = l2;

        ListNode res = new ListNode(-1);

        ListNode t = res;

        while (l != null && r != null) {

            if (l.val < r.val) {
                t.next = l;

                l = l.next;
            } else {
                t.next = r;
                r = r.next;
            }
            t = t.next;
        }

        if (l != null) {
            t.next = l;
        }
        if (r != null) {
            t.next = r;
        }

        return res.next;

    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(12);
        l2.next.next.next = new ListNode(19);

        ListNode listNode = new MergeTwoSortedLists().mergeTwoLists(l1, l2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }
}
