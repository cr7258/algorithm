package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzw
 * @description 二叉树的前序遍历，https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @since 2021/9/21
 */
public class PreorderTraversal {
    private  List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorderTraversalR(root);
        return result;
    }

    public void preorderTraversalR(TreeNode root) {
        if (root == null) return;
        result.add(root.val);
        preorderTraversalR(root.left);
        preorderTraversalR(root.right);
    }
}
