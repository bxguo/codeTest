package leetcode;

import leetcode.node.ListNode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * https://leetcode.cn/problems/rotate-list/
 *
 * @author 郭丙侠
 * @date 2023年03月16日 17:03
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = new ListNode(1);
        temp.next = head.next;
        ListNode poi = new ListNode(1);
        while (head.next != null) {
            poi = head.next;
        }
        poi.next = head;
        return temp.next;
    }
}
