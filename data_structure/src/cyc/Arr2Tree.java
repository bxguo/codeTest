package cyc;

import structure.ToutiaoTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 前序遍历和中序遍历恢复二叉树
 * @author: bxguo
 * @time: 2019/10/20 12:36
 */
public class Arr2Tree {
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public ToutiaoTree.TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private ToutiaoTree.TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        ToutiaoTree.TreeNode root = new ToutiaoTree.TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }
}
