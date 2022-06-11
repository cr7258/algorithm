package binary_tree

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
思路：深度优先搜索，问题化简为合并子树。
有点像链表合并，最后还要把剩余的子树拼接上去。
时间复杂度：O(min(m,n))，其中 m 和 n 分别是两个二叉树的节点个数。
对两个二叉树同时进行深度优先搜索，只有当两个二叉树中的对应节点都不为空时才会对该节点进行显性合并操作，因此被访问到的节点数不会超过较小的二叉树的节点数。

空间复杂度：O(min(m,n))，其中 m 和 n 分别是两个二叉树的节点个数。
空间复杂度取决于递归调用的层数，递归调用的层数不会超过较小的二叉树的最大高度，最坏情况下，二叉树的高度等于节点数。
*/

func mergeTrees(root1 *TreeNode, root2 *TreeNode) *TreeNode {
	if root1 == nil {
		return root2
	}
	if root2 == nil {
		return root1
	}

	// 类似链表的虚拟头节点
	newNode := &TreeNode{Val: root1.Val + root2.Val}
	newNode.Left = mergeTrees(root1.Left, root2.Left)
	newNode.Right = mergeTrees(root1.Right, root2.Right)
	return newNode
}
