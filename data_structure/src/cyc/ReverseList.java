package cyc;

import leetcode.node.ListNode;

import java.util.Stack;

/**
 * 反转链表
 * @author: bxguo
 * @time: 2019/10/20 15:11
 */
public class ReverseList {
    //头插法反转链表
    public ListNode reverseList(ListNode head) {
        ListNode newList = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }
    //利用栈反转
    public ListNode reverseList2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode newList = new ListNode(-1);
        ListNode p = newList;
        while (stack.size() != 0) {
            p.next = stack.pop();
            p = p.next;
        }
        return newList.next;
    }
}
