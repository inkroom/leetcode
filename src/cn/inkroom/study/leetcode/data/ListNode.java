package cn.inkroom.study.leetcode.data;


/**
 * 这个不是某道题的解法，只是解题中常用的数据类型——链表
 *
 * @author 墨盒
 * @Date 19-4-28
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
