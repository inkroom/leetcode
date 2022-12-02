package cn.inkroom.study.leetcode;

import cn.inkroom.study.leetcode.data.ListNode;

/**
 * 面试题 02.01. 移除重复节点
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 */
public class RemoveDuplicateNodeLcci {

    public ListNode removeDuplicateNodes(ListNode head) {

        int[] r = new int[20000];


        ListNode res = new ListNode(-1);
        ListNode result = res;

        while (head != null) {

            if (r[head.val] == 0) {
                //第一次出现
                res.next = head;
                res = res.next;
                r[head.val] = 1;
                ListNode t = head.next;
                head.next = null;//需要把后续节点断开，避免重复的节点删除起来麻烦
                head = t;
            } else {
                head = head.next;
            }
        }

        return result.next;


    }

    public static void main(String[] args) {
        ListNode r = new ListNode(1);
        r.next = new ListNode(2);
        r.next.next = new ListNode(3);
        r.next.next.next = new ListNode(4);
        r.next.next.next.next = new ListNode(3);
        r.next.next.next.next.next = new ListNode(2);
        r.next.next.next.next.next.next = new ListNode(1);

        System.out.println(new RemoveDuplicateNodeLcci().removeDuplicateNodes(r));

    }
}
