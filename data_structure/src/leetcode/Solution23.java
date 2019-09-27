package leetcode;

import leetcode.node.ListNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: bxguo
 * @time: 2019/9/27 10:06
 */
public class Solution23 {


    /**
     * 效率低
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode aus = new ListNode(0);
        ListNode head = aus;
        boolean flag = true;
        ListNode min = null;
        while (flag) {
            int minloc = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (min == null || min.val >= lists[i].val) {
                        min = new ListNode(lists[i].val);
                        minloc = i;
                    }
                }
            }
            if (lists[minloc] != null) {
                lists[minloc] = lists[minloc].next;
            }
            if (min != null) {
                head.next = new ListNode(min.val);
            }
            min = null;
            head = head.next;
            flag = false;
            for (ListNode list : lists) {
                flag = (list != null) || flag;
            }
        }
        return aus.next;
    }

    /**
     * 递归解法。也不咋地比上边的好一些
     */
    private ListNode aus = null;
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return aus;
        }
        fun(lists, 0);
        return aus;
    }

    private void fun(ListNode[] lists, int cur) {
        if (lists.length == cur) {
            return;
        }
        ListNode test = new ListNode(0);
        ListNode head = test;
        ListNode t1 = aus;
        ListNode t2 = lists[cur];
        while (t1 != null || t2 != null) {
            if (t1 == null) {
                head.next = new ListNode(t2.val);
                t2 = t2.next;
            } else if (t2 == null) {
                head.next = new ListNode(t1.val);
                t1 = t1.next;
            } else if (t1.val > t2.val) {
                head.next = new ListNode(t2.val);
                t2 = t2.next;
            } else {
                head.next = new ListNode(t1.val);
                t1 = t1.next;
            }
            head = head.next;
        }
        aus = test.next;
        fun(lists, cur + 1);
    }

    /**
     * 优先队列高级轮子，笑哭
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        queue.addAll(Stream.of(lists).filter(Objects::nonNull).collect(Collectors.toList()));
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return dummy.next;
    }



    public static void main(String[] args) {

        Solution23 solution23 = new Solution23();
        ListNode t1 = new ListNode(2);
        ListNode t2 = new ListNode(-1);
        ListNode[] lists = {t1,null,t2};
        ListNode mergeKLists = solution23.mergeKLists3(lists);
        System.out.println(mergeKLists);






        /*ListNode t1 = new ListNode(1);
        ListNode t11 = new ListNode(4);
        t1.next = t11;
        t11.next = new ListNode(5);


        ListNode t2 = new ListNode(1);
        ListNode t22 = new ListNode(3);
        t2.next = t22;
        t22.next = new ListNode(4);

        ListNode t3 = new ListNode(2);
        t3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];

        lists[0] = t1;
        lists[1] = t2;
        lists[2] = t3;*/





    }
}
