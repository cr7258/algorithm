package binary_tree

/**
 * @author chengzw
 * @description 938. 二叉搜索树的范围和
 * @link https://leetcode.cn/problems/range-sum-of-bst/
 * @since 2022/6/12
 */

/**
给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。

示例 1：
输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
输出：32

示例 2：
输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
输出：23
*/

/**
思路：
按深度优先搜索的顺序计算范围和。记当前子树根节点为 root，分以下四种情况讨论：
1.root 节点为空，返回 0。
2.root 节点的值大于 high。由于二叉搜索树右子树上所有节点的值均大于根节点的值，即均大于 high，故无需考虑右子树，返回左子树的范围和。
3.root 节点的值小于 low。由于二叉搜索树左子树上所有节点的值均小于根节点的值，即均小于 low，故无需考虑左子树，返回右子树的范围和。
4.root 节点的值在 [low,high] 范围内。此时应返回 root 节点的值、左子树的范围和、右子树的范围和这三者之和。

时间复杂度：O(n)，其中 n 是二叉搜索树的节点数。
空间复杂度：O(n)。空间复杂度主要取决于栈空间的开销。
*/

func rangeSumBST(root *TreeNode, low int, high int) int {
	if root == nil {
		return 0
	}
	if high < root.Val {
		return rangeSumBST(root.Left, low, high)
	}
	if low > root.Val {
		return rangeSumBST(root.Right, low, high)
	}
	return root.Val + rangeSumBST(root.Left, low, high) + rangeSumBST(root.Right, low, high)
}
