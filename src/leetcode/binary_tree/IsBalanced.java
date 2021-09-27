package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 平衡二叉树，https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * <p>
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true。
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false。
 *
 * @since 2021/9/27
 */

/**
 * 思路：使用递归，化简问题求子树的左右子树深度是否超过 1
 * balanced 变量作为全局变量，height 方法中如果判断全局变量 balanced 为 false 了，快速返回，返回什么值不重要
 */
public class IsBalanced {
    //全局变量
    boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return balanced;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        //提前终止递归，返回什么值不重要
        if (balanced == false) return 0;
        int leftMaxDepth = height(root.left);
        int rightMaxDepth = height(root.right);
        //如果左右子树的最大深度相差超过 1，就不是平衡二叉树
        if (Math.abs(leftMaxDepth - rightMaxDepth) > 1) {
            balanced = false;
        }
        //返回左右子树的最大深度 + 自己
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}
