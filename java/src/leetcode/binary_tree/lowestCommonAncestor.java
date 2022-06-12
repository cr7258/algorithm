package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 236. 二叉树的最近公共祖先
 * @link https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 * @since 2022/6/12
 */

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * <p>
 * 示例 2：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 */

/**
 思路：
 情况 1，如果 p 和 q 都在以 root 为根的树中，那么 left 和 right 一定分别是 p 和 q（从 base case 看出来的）。
 情况 2，如果 p 和 q 都不在以 root 为根的树中，直接返回 null。
 情况 3，如果 p 和 q 只有一个存在于 root 为根的树中，函数返回该节点。

 时间复杂度：O(n)，其中 n 是二叉树的节点数。二叉树的所有节点有且只会被访问一次，因此时间复杂度为 O(n)。
 空间复杂度：O(n) ，其中 n 是二叉树的节点数。递归调用的栈深度取决于二叉树的高度，二叉树最坏情况下为一条链，此时高度为 NN，因此空间复杂度为 O(n)。
 */
public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 情况 1：p 和 q 都在以 root 为根的树中，找到最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 情况 2：p 和 q 都不在以 root 为根的树中
        if (left == null && right == null) {
            return null;
        }
        // 情况 3：p 和 q 只有一个存在于 root 为根的树中，函数返回该节点
        return left == null ? right : left;
    }
}
