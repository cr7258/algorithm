package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzw
 * @description 二叉树的后续遍历，https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @since 2021/9/21
 */
public class PostorderTraversal {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postorderTraversalR(root);
        return result;
    }

    public void postorderTraversalR(TreeNode root) {
        if (root == null) return;
        postorderTraversalR(root.left);
        postorderTraversalR(root.right);
        result.add(root.val);
    }
}
