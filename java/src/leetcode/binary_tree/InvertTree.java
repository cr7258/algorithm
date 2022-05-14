package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 翻转二叉树，https://leetcode-cn.com/problems/invert-binary-tree/
 * <p>
 * 翻转一棵二叉树。
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * @since 2021/9/27
 */

/**
 * 思路：使用递归，问题简化为翻转子树
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        //翻转
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
}
