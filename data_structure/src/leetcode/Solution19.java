package leetcode;

import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 *
 * @author: bxguo
 * @time: 2019/9/23 16:36
 */
public class Solution19 {

    /**
     * 双指针滑动窗口,快慢指针
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l = dummy;
        ListNode r = dummy;
        while (n > 0) {
            r = r.next;
        }
        while (r.next != null) {
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return dummy.next;
    }

    //单指针两次循环
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //计算总长度
        ListNode first = head;
        int length = 0;
        while (first != null) {
            first = first.next;
            length++;
        }

        //删除倒数第n个节点
        int loc = length - n;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        first = dummy;
        while (loc > 0) {
            first = first.next;
            loc--;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }
}
