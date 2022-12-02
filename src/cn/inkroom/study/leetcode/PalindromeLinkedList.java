package cn.inkroom.study.leetcode;

import cn.inkroom.study.leetcode.data.ListNode;

/**
 * 234. 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        return false;
    }

    public static void main(String[] args) {
        ListNode r = new ListNode(1);
        r.next = new ListNode(2);
        r.next.next = new ListNode(3);
        r.next.next.next = new ListNode(4);
        r.next.next.next.next = new ListNode(3);
        r.next.next.next.next.next = new ListNode(2);
        r.next.next.next.next.next.next = new ListNode(1);

        System.out.println(new PalindromeLinkedList().isPalindrome(r));
    }
}
