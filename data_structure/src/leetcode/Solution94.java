package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author: bxguo
 * @time: 2019/9/24 10:38
 */
public class Solution94 {


    //利用栈遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
    //利用栈遍历  空间复杂度少了一个 TreeNode cur 稍好于inorderTraversal2
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (stack.peek().left != null) {
                stack.push(stack.peek().left);
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            if (!stack.isEmpty()) {
                stack.peek().left = null;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return res;
    }

    //递归方法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> aux = new ArrayList<>();
        fun(root, aux);
        return aux;
    }

    private void fun(TreeNode root, List<Integer> aux) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            fun(root.left, aux);
        }
        aux.add(root.val);
        if (root.right != null) {
            fun(root.right, aux);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
