package leetcode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4\
 *
 * @author: bxguo
 * @time: 2019/9/25 15:46
 */
public class Solution21 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 递归解法
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

    /**
     * 基础归并排序
     */
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode res = new ListNode(0);
    ListNode head = res;
    while (l1 != null || l2 != null) {
        if (l1 == null) {
            head.next = l2;
            l2 = l2.next;
        } else if (l2 == null) {
            head.next = l1;
            l1 = l1.next;
        } else if (l1.val < l2.val) {
            head.next = l1;
            l1 = l1.next;
        } else {
            head.next = l2;
            l2 = l2.next;
        }
        head = head.next;
    }
    return res.next;
}

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(4);
        Solution21 solution21 = new Solution21();
        solution21.mergeTwoLists(a, b);
    }

}
