package cyc;

import leetcode.node.ListNode;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。要求不能使用额外的空间。
 * @author: bxguo
 * @time: 2019/10/20 15:02
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;

        while (fast != slow) {
            fast = fast.next.next;
            slow = fast.next;
        }

        slow = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
