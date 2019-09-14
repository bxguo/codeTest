package leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 * Created by bxguo on 2019/9/14 19:16
 */
public class Solution2 {

    /*
     * 没有保留原始参数数据，不太好
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode node = result;
        int sum = 0;

        while (l1 != null || l2 != null){
            int a = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            int b = 0;
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            sum = sum + a + b;
            node.next = new ListNode(sum % 10);
            sum /= 10;
            node = node.next;
        }
        if (sum > 0) {
            node.next = new ListNode(sum);
        }
        return result.next;
    }

    /*
     * result必须始终指向头节点，node为过程变量
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode node = result;
        int sum = 0;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            node.next = new ListNode(sum % 10);
            sum /= 10;
            node = node.next;
        }
        if (sum == 1) {
            node.next = new ListNode(1);
        }
        return result.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
