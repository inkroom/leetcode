package cn.inkroom.study.leetcode;

import cn.inkroom.study.leetcode.data.ListNode;

/**
 * 61. 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/
 * <br>
 * 这道题表面上是旋转k，实际上可以看作是把后面k个节点一起放到链表开头
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        int length = 0;

        ListNode t = head;
        //首先获取长度
        while (t != null) {
            length++;
            t = t.next;
        }

        if (length==0) return head;
        k = k % length;//可能比较大，但是不重要

        if (k == 0) return head;
        t = head;
        k = length - k;

        length = 0;

        ListNode nHead = null;


        while (t != null) {
            //找到第k个元素，然后再将最后一个节点指向原头结点，第k-1个节点指向null，第k个节点重新作为头结点
            if (length == k - 1) {
                nHead = t.next;
                t.next = null;
                t = nHead;
            } else if (t.next == null) {
                t.next = head;
                break;
            } else {
                t = t.next;
            }
            length++;
        }

        return nHead;

    }

    public static void main(String[] args) {

        ListNode r = new ListNode(0);
        r.next = new ListNode(1);
        r.next.next = new ListNode(2);

        System.out.println(new RotateList().rotateRight(r, 4));

    }
}
