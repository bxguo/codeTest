package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * TODO 参考 https://www.bbsmax.com/A/RnJWmZNEdq/
 * 给定一个二叉查找树和范围[k1, k2]。按照升序返回给定范围内的节点值。
 * 输入：{20,8,22,4,12},10,22
 * 输出：[12,20,22]
 * 解释：
 *         20
 *        /  \
 *       8   22
 *      / \
 *     4   12
 * 它将被序列化为 {20,8,22,4,12}
 * [12,20,22]介于10和22之间
 *
 * @author: bxguo
 * @time: 2019/7/31 11:21
 */
public class Solution11 {
    /**
     * Definition of TreeNode:
     * */
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
      }

    /**
     * 递归解法
     */
    public ArrayList<Integer> searchRange3(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> inorder = inorderTraveral(root);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0;i< inorder.size();i++){
            int tmp = inorder.get(i);
            if(k1<= tmp && tmp <= k2){
                result.add(tmp);
            }
        }
        return result;
    }
    public ArrayList<Integer> inorderTraveral(TreeNode root){
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        if(root == null){
            return inorder;
        }
        inorder.addAll(inorderTraveral(root.left));
        inorder.add(root.val);
        inorder.addAll(inorderTraveral(root.right));
        return inorder;
    }
    /**
     * TODO 测试未通过 非递归解法
     * @param root
     * @param k1
     * @param k2
     * @return
     */
    List<Integer> searchRange2(TreeNode  root, int k1, int k2) {
        List<Integer> list = new ArrayList();
        // write your code here
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.val > k1 && node.val < k2){
                list.add(node.val);
            }
        }
        return list;
    }

    /**
     * TODO 广度优先算法 测试未通过
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        if(root == null){
            return null;
        }

        List<TreeNode> arr = new ArrayList();
        arr.add(root);
        for (int i = 0; i < arr.size(); i++) {
            TreeNode node = arr.get(i);
            if (node.left != null) {
                arr.add(node.left);
            }
            if (node.right != null) {
                arr.add(node.right);
            }
        }
        List<Integer> results = new ArrayList();
        for (TreeNode re : arr) {
            if(re.val > k1 && re.val < k2){
                results.add(re.val);
            }
        }
        return results;
    }
}
