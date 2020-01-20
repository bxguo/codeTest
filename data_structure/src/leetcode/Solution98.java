package leetcode;

import leetcode.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>想·
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: bxguo
 * @time: 2020/1/19 16:44
 */
public class Solution98 {

    //方法二优化
    public boolean isValidBST2_GOOD(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int max = Integer.MIN_VALUE;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (max > cur.val) {
                return false;
            }
            max = cur.val;
            cur = cur.right;
        }
        return true;
    }
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return false;
        }
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (!res.isEmpty() && res.peekLast() > cur.val) {
                return false;
            }
            res.add(cur.val);
            cur = cur.right;
        }
        return true;
    }


    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            if (!res.isEmpty() && res.peekLast() > node.val) {
                return false;
            }
            res.add(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return true;
    }
}
