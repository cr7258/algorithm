package binary_tree

/**
 * @description 700. 二叉搜索树中的搜索
 * @author chengzw
 * @since 2022/6/12
 * @link https://leetcode.cn/problems/search-in-a-binary-search-tree/
 */

/**
给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null。

示例 1:

输入：root = [4,2,7,1,3], val = 2
输出：[2,1,3]

示例 2:
输入：root = [4,2,7,1,3], val = 5
输出：[]
*/

/**
思路：
利用 BST 左小右大的特性，可以避免搜索整棵二叉树去寻找元素，从而提升效率。

时间复杂度：O(n)，其中 n 是二叉搜索树的节点数。最坏情况下二叉搜索树是一条链，且要找的元素比链末尾的元素值还要小（大），这种情况下我们需要递归 n 次。
空间复杂度：O(n)。最坏情况下递归需要 O(n) 的栈空间。
*/
func searchBST(root *TreeNode, val int) *TreeNode {
	if root == nil {
		return nil
	}
	if root.Val > val {
		return searchBST(root.Left, val)
	}
	if root.Val < val {
		return searchBST(root.Right, val)
	}
	return root
}
