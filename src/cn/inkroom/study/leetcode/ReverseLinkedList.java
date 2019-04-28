package cn.inkroom.study.leetcode;


import cn.inkroom.study.leetcode.data.ListNode;

/**
 * @author 墨盒
 * @Date 19-4-28
 */
public class ReverseLinkedList {


    public ListNode reverseList(ListNode head) {


        ListNode prev = null;
        ListNode now = null;
        //反转
        while (head != null) {
            now = head;
            head = head.next;

            now.next = prev;
            prev = now;
        }

        return now;

    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        node = new ReverseLinkedList().reverseList(node);
        System.out.println(node);
    }
}
