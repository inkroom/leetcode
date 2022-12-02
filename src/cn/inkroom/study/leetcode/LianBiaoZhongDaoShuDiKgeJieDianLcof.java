package cn.inkroom.study.leetcode;

import cn.inkroom.study.leetcode.data.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class LianBiaoZhongDaoShuDiKgeJieDianLcof {


    public ListNode getKthFromEnd(ListNode head, int k) {


        ListNode r = head;

        //前进k步

        for (int i = 0; i < k; i++) {
            r = r.next;
        }

        ListNode r2 = head;

        //同时前进，直到结束，此时r2前进了 n - k 步，执行倒数第k个值

        while (r != null) {
            r = r.next;
            r2 = r2.next;
        }

        return r2;
    }

    public static void main(String[] args) {

        ListNode r = new ListNode(1);
        r.next = new ListNode(2);
        r.next.next = new ListNode(3);
        r.next.next.next = new ListNode(5);
        r.next.next.next.next = new ListNode(6);
        r.next.next.next.next.next = new ListNode(8);
        r.next.next.next.next.next.next = new ListNode(12);

        System.out.println(new LianBiaoZhongDaoShuDiKgeJieDianLcof().getKthFromEnd(r, 2));
    }

}
