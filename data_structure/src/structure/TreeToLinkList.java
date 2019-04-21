package structure;

/**
 * 二叉树转链表(快手)
 * Created by bxguo on 2019/4/10 23:30
 */
public class TreeToLinkList {
    class TreeNode{
        TreeNode left, right;
        int val;
    }

    /**
     * 自底向上，以pre为指针始终指向头节点
     * @param root
     */
    TreeNode prev = null;
    public void solution(TreeNode root){

        if (root == null) return;

        solution(root.right);
        solution(root.left);

        root.right = prev;  // 右子树指向链表的头
        root.left = null; // 把左子树置空
        prev = root; // 当前结点为链表头
    }
}
