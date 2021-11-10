package cn.inkroom.study.leetcode;

import cn.inkroom.study.leetcode.data.ListNode;

/**
 * 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode l = headA;
        ListNode r = headB;


        //两个指针实际访问的链表是 A+B，由于前进的步数相同，所以能同时访问到相交节点
        while (l != r) {

            if (l != null) {
                l = l.next;
            } else {
                l = headB;
            }

            if (r != null) {
                r = r.next;
            } else {
                r = headA;
            }
        }

        return l;

    }

    public static void main(String[] args) {


        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(12);
        l2.next.next.next = new ListNode(19);


        ListNode l3 = new ListNode(97);
        l3.next = new ListNode(5);
        l3.next.next = new ListNode(12);
        l3.next.next.next = new ListNode(19);


        // 相交，后续节点可以合并，也可以直接岔开，只相交一个节点
        l2.next.next.next.next = l3;
        l1.next.next.next = l3;


        System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(l1, l2));


    }
}
