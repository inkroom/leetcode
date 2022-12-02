package cn.inkroom.study.leetcode;

import cn.inkroom.study.leetcode.data.ListNode;

import java.util.Arrays;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class CongWeiDaoTouDaYinLianBiaoLcof {

    public int[] reversePrint(ListNode head) {

        if (head == null) {
            return new int[0];
        }
        if (head.next != null) {
            int[] ints = reversePrint(head.next);
            int[] r = new int[ints.length + 1];
            System.arraycopy(ints, 0, r, 0, ints.length);
            r[r.length - 1] = head.val;
            return r;
        }
        return new int[]{head.val};
    }

    public static void main(String[] args) {
        ListNode r = new ListNode(1);
        r.next = new ListNode(2);
        r.next.next = new ListNode(3);
        r.next.next.next = new ListNode(4);
        r.next.next.next.next = new ListNode(5);
        r.next.next.next.next.next = new ListNode(6);
        r.next.next.next.next.next.next = new ListNode(7);

        System.out.println(Arrays.toString(new CongWeiDaoTouDaYinLianBiaoLcof().reversePrint(r)));
    }
}
