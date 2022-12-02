package cn.inkroom.study.leetcode;

import cn.inkroom.study.leetcode.data.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates1(ListNode head) {

        ListNode h = new ListNode(-1);

        h.next = head;

        if (head == null) return null;
        ListNode t = h;
        ListNode c = head;
        ListNode n = head.next;
        boolean exist = false;

        while (n != null) {

            if (c.val == n.val) {
                c.next = n.next;
                exist = true;
            } else {//遇到不重复的值
                if (exist) {//如果当前节点已经重复过，就把c给删除，
                    t.next = n;
                    exist = false;
                } else {
                    t = t.next;
                }
                c = n;
            }
            n = n.next;
        }
        if (exist){//判断重复后，后续没有值再做判断了。所以需要处理最后一个重复的值
            t.next = null;
        }
        return h.next;


    }

    public ListNode deleteDuplicates(ListNode head) {

        // 使用新链表存储不重复的值，第一次遇到值加入新链表，每次和尾巴对比，重复则标记

        ListNode n = new ListNode(-1);

        n.next = head;

        ListNode after = head;


        return n.next;

    }

    public static void main(String[] args) {


        ListNode r = new ListNode(1);
        r.next = new ListNode(1);
        r.next.next = new ListNode(1);
        r.next.next.next = new ListNode(2);
        r.next.next.next.next = new ListNode(3);
        r.next.next.next.next.next = new ListNode(4);
        r.next.next.next.next.next.next = new ListNode(5);
        r.next.next.next.next.next.next.next = new ListNode(15);


        r = new RemoveDuplicatesFromSortedListII().deleteDuplicates(r);

        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}

