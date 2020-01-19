package leetcode;

import leetcode.node.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: bxguo
 * @time: 2020/1/19 15:46
 */
public class Solution145 {

    //DFS后序遍历
    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }
    //递归做法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        fun(root, res);
        return res;
    }
    void fun(TreeNode node, List<Integer> res){
        if (node == null) {
            return;
        }
        if (node.left != null) {
            fun(node.left, res);
        }
        if (node.right != null) {
            fun(node.right, res);
        }
        res.add(node.val);
    }
}
