package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 合并二叉树，https://leetcode-cn.com/problems/merge-two-binary-trees/
 * <p>
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 * @since 2021/9/27
 */

/**
 * 思路：使用递归，问题化简为合并子树。
 * 有点像链表合并，最后还要把剩余的子树拼接上去。
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //当其中一颗数为 null 时，返回另一颗子树，把这颗子树拼接到上层中
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        //新数来连接，类似链表中的虚拟头结点
        TreeNode newNode = new TreeNode(root1.val + root2.val);
        TreeNode leftNode = mergeTrees(root1.left, root2.left);
        TreeNode rightNode = mergeTrees(root1.right, root2.right);
        newNode.left = leftNode;
        newNode.right = rightNode;
        return newNode;
    }
}
