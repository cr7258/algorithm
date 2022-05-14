package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 二叉树的最大深度，https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 给定二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3。
 *
 * @since 2021/9/27
 */

/**
 * 思路：使用递归，将问题化简为求子树的最大深度 + 1
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
