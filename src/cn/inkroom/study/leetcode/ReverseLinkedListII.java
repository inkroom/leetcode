package cn.inkroom.study.leetcode;


import cn.inkroom.study.leetcode.data.ListNode;

/**
 * @author 墨盒
 * @Date 19-4-28
 */
public class ReverseLinkedListII {

    /*

    优秀写法，没有我的逻辑绕。重点只需要存一下前置节点，后面直接翻转就行，每次翻转把后续节点连上，省去最后处理流程

     */

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        head = pre.next;
        for(int i = m; i < n; i++){
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }

//    public ListNode reverseBetween(ListNode head, int left, int right) {
//
//        ListNode nh = null, rh = head, nt = null, bf = null, f = null;
//
//        int li = left - 1;
//        int ri = right - 1;
//
//
//        for (int i = 0; i < right; i++) {
//
//
//            if (i == li) {// 第一个要翻转的节点
//
//                nt = head;
//                nh = head;
//
//                bf = f;// 用于之后连接前面的节点
//
//
//                head = head.next;
//
//            } else if (i == ri) {// 要翻转的最后一个节点
//
//                nt.next = head.next;
//                head.next = nh;
//                nh = head;
//
//                if (bf != null)
//                    bf.next = nh;
//                else {// 前面没有节点了
//                    rh = nh;
//                }
//            } else if (i > li) {// 翻转
//
//                ListNode t = head.next;
//
//
//                head.next = nh;
//                nh = head;
//
//                head = t;
//
//
//            } else {
//                f = head;
//                head = head.next;
//            }
//
//
//        }
//        return rh;
//
//
//    }

    public static void main(String[] args) {
        ListNode node, x;

        node = new cn.inkroom.study.leetcode.data.ListNode(1);
        node.next = new cn.inkroom.study.leetcode.data.ListNode(2);
        node.next.next = new cn.inkroom.study.leetcode.data.ListNode(3);
        node.next.next.next = new cn.inkroom.study.leetcode.data.ListNode(4);
        node.next.next.next.next = new cn.inkroom.study.leetcode.data.ListNode(5);

        x = new ReverseLinkedListII().reverseBetween(node, 2, 4);
        System.out.println(x);


//        node = new cn.inkroom.study.leetcode.data.ListNode(3);
//        node.next = new cn.inkroom.study.leetcode.data.ListNode(5);
//
//        x = new ReverseLinkedListII().reverseBetween(node, 1, 2);
//        System.out.println(x);

    }
}
