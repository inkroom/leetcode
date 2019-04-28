package cn.inkroom.study.leetcode;


/**
 * @author 墨盒
 * @Date 19-4-28
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode res = null;

        //反转
        while (head != null) {
            if (res == null) {
                res = new ListNode(head.val);
            } else {
                ListNode temp = res;
                res = new ListNode(head.val);
                res.next = temp;
            }
            head = head.next;
        }

        //输出
//        if (res == null) {
//            System.out.println("NULL");
//        } else {
//            res = res.next;
//            while (res != null) {
//                System.out.println("->" + res.val);
//                res = res.next;
//            }
//        }

        return res;

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

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}