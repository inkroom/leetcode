package cn.inkroom.study.leetcode;

import cn.inkroom.study.leetcode.data.ListNode;

/**
 * 面试题 02.04. 分割链表
 * https://leetcode-cn.com/problems/partition-list-lcci/
 */
public class PartitionListLcci {
    /**
     * 自己的版本，总体思路是，将指定节点提取出来单独作为链表，再把原链表节点插入到新链表
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition1(ListNode head, int x) {


        ListNode target = head;
        ListNode parent = null;
        //找到指定节点，以这个节点为头结点，重新构建链表
        while (target != null && target.val != x) {
            parent = target;
            target = target.next;
        }

        boolean hasTarget = true;
        if (target == null) {
            target = new ListNode(-1);
            hasTarget = false;
        }

        //把target从原链表剔除
        if (parent != null) {
            parent.next = target.next;
        } else {//第一个节点
            head = target.next;
        }
        target.next = null;

        ListNode result = new ListNode(-1);

        result.next = target;

        //before始终是target的父节点，after保持是尾节点
        ListNode before = result, after = target;

        while (head != null) {

            if (head.val < x) {
                ListNode next = head.next;


                before.next = head;
                before.next.next = target;

                head = next;
                before = before.next;

            } else if (head.val >= x) {
                ListNode next = head.next;

                after.next = head;
                after = after.next;
                after.next = null;

                head = next;
            }

        }

        if (!hasTarget) {
            before.next = target.next;
        }

        return result.next;

    }

    /**
     * 官方解法，构建两条新链表，分别插入值
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {

        ListNode smallHead = new ListNode(-1), largeHead = new ListNode(-1);
        ListNode small = smallHead, large = largeHead;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }

        // 将两条链表链接，同时断开large尾节点

        small.next = largeHead.next;
        large.next = null;

        return smallHead.next;


    }

    public static void main(String[] args) {


        ListNode r = new ListNode(3);
        r.next = new ListNode(1);
//        r.next.next = new ListNode(92);
//        r.next.next.next = new ListNode(5);
//        r.next.next.next.next = new ListNode(6);
//        r.next.next.next.next.next = new ListNode(6);
//        r.next.next.next.next.next.next = new ListNode(12);


        ListNode listNode = new PartitionListLcci().partition(r, 2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }
}

