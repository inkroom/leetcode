package cn.inkroom.study.leetcode;

import cn.inkroom.study.leetcode.data.ListNode;

/**
 * 1721. 交换链表中的节点
 * https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list/
 */
public class SwappingNodesInALinkedList {


    public ListNode swapNodes1(ListNode head, int k) {

        int length = 0;
        ListNode t = head;
        while (t != null) {
            length++;
            t = t.next;
        }
        t = head;
        int i = 0;
        ListNode r = null;
        while (t != null) {
            i++;
            if (i == Math.min(k, length - k + 1)) {
                r = t;
            } else if (i == Math.max(k, length - k + 1)) {
                int val = t.val;
                t.val = r.val;
                r.val = val;
                break;
            }

            t = t.next;
        }

        return head;
    }


    /**
     * 快慢指针
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        //走k步，找到第k个节点
        for (int i = 1; i < k; i++) {
            left = left.next;

        }

        //从第k个开始，走到结束，即走了n-k步。同时慢指针从头开始，也走了n-k步，即倒数第k个元素
        ListNode t = left;
        while (t.next != null) {
            t = t.next;
            right = right.next;
        }

        int val = left.val;
        left.val = right.val;
        right.val = val;

        return head;
    }


    public static void main(String[] args) {
        ListNode r = new ListNode(100);
        r.next = new ListNode(90);


        ListNode listNode = new SwappingNodesInALinkedList().swapNodes(r, 2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
