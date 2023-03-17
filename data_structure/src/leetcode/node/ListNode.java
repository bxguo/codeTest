package leetcode.node;


/**
 * @author: bxguo
 * @time: 2019/9/27 10:24
 */
public class ListNode {

    public int val;
    public ListNode next;
    ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
