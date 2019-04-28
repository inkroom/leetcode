package cn.inkroom.study.leetcode;


import cn.inkroom.study.leetcode.data.ListNode;

/**
 * @author 墨盒
 * @Date 19-4-28
 */
public class ReverseLinkedListII {

    public ListNode reverseList(ListNode head, int count) {


        ListNode prev = null;
        ListNode now = null;
        int i = 0;
        //反转
        while (head != null && i < count) {
            now = head;
            head = head.next;

            now.next = prev;
            prev = now;
            i++;
        }

        return now;

    }

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

//        ListNode prev = null;
//        ListNode now = null;
//
//        ListNode root = head;
//        ListNode start = null;
//        ListNode end = null;
//        int i = 0;
//        while (head != null) {
//
//            i++;
//            now = head;
//            head = head.next;
//
//            if (i == m - 1) {//记录第一个翻转的前一个节点
//                start = now;
//            }
//            if (i == m) {//记录第一个翻转的节点
//                end = now;
//            }
//            if (i > m && i <= n) {//翻转
//                now.next = prev;
//            }
//            if (i == n) {//最后一个节点
//                if (end != null)
//                    end.next = head;
//                if (start != null)
//                    start.next = now;
//            }
//
//            prev = now;
//
//
//        }
//        return root;
    }

    public static void main(String[] args) {
        ListNode node = new cn.inkroom.study.leetcode.data.ListNode(1);
        node.next = new cn.inkroom.study.leetcode.data.ListNode(2);
        node.next.next = new cn.inkroom.study.leetcode.data.ListNode(3);
        node.next.next.next = new cn.inkroom.study.leetcode.data.ListNode(4);
        node.next.next.next.next = new cn.inkroom.study.leetcode.data.ListNode(5);

        System.out.println(new ReverseLinkedListII().reverseBetween(node, 2,4));

    }
}
