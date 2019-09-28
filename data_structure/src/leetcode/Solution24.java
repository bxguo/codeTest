package leetcode;

import leetcode.node.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * @author: bxguo
 * @time: 2019/9/28 10:12
 */
public class Solution24 {
public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode aux = new ListNode(0);
    aux.next = head;
    ListNode temp = aux;
    while (temp.next != null && temp.next.next != null) {
        ListNode node = temp.next.next;
        temp.next.next = temp.next.next.next;
        node.next = temp.next;
        temp.next = node;
        temp = temp.next.next;
    }
    return aux.next;
}

    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(4);

        t1.next = t2;
        t1.next.next = t3;
        t1.next.next.next = t4;

        Solution24 solution24 = new Solution24();
        solution24.swapPairs(t1);
    }


}
