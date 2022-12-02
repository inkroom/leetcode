package cn.inkroom.study.leetcode;

import cn.inkroom.study.leetcode.data.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {


        ListNode r = head;


        if (head != null) {
            ListNode before = head, after = head.next;

            while (after != null) {
                if (before.val == after.val) {
                    before.next = after.next;
                    after = after.next;
                } else {
                    before = before.next;
                }

            }
        }

        return r;
    }

    public static void main(String[] args) {

        ListNode r = new ListNode(1);
        r.next = new ListNode(1);
        r.next.next = new ListNode(2);
        r.next.next.next = new ListNode(5);
        r.next.next.next.next = new ListNode(6);
        r.next.next.next.next.next = new ListNode(6);
        r.next.next.next.next.next.next = new ListNode(12);


        ListNode listNode = new RemoveDuplicatesFromSortedList().deleteDuplicates(r);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }
}
