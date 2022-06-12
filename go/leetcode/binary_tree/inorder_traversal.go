package binary_tree

/**
 * @description 94. 二叉树的中序遍历
 * @author chengzw
 * @since 2022/6/12
 * @link https://leetcode.cn/problems/binary-tree-inorder-traversal/
 */

/**
给定一个二叉树的根节点 root ，返回 它的中序遍历 。

示例 1：
输入：root = [1,null,2,3]
输出：[1,3,2]

示例 2：
输入：root = []
输出：[]

示例 3：
输入：root = [1]
输出：[1]
*/

/**
思路：二叉树中序遍历

时间复杂度：O(n)
空间复杂度：O(n)
*/
func inorderTraversal(root *TreeNode) []int {
	ans := []int{}
	inorder(root, &ans)
	return ans
}

func inorder(root *TreeNode, ans *[]int) {
	if root == nil {
		return
	}

	inorder(root.Left, ans)
	*ans = append(*ans, root.Val)
	inorder(root.Right, ans)
}
