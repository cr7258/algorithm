package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzw
 * @description 二叉树的中序遍历，https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @since 2021/9/21
 */
public class InorderTraversal {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTraversalR(root);
        return result;
    }

    public void inorderTraversalR(TreeNode root) {
        if (root == null) return;
        inorderTraversalR(root.left);
        result.add(root.val);
        inorderTraversalR(root.right);
    }
}
