package binary_tree

/**
 * @description 144. 二叉树的前序遍历
 * @author chengzw
 * @since 2022/6/9
 * @link https://leetcode.cn/problems/binary-tree-preorder-traversal/
 */

/**
给你二叉树的根节点 root ，返回它节点值的前序遍历。

示例 1：
输入：root = [1,null,2,3]
输出：[1,2,3]

示例 2：
输入：root = []
输出：[]

示例 3：
输入：root = [1]
输出：[1]

示例 4：
输入：root = [1,2]
输出：[1,2]

示例 5：
输入：root = [1,null,2]
输出：[1,2]
*/

/**
思路：递归

时间复杂度：O(n)，其中 n 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
空间复杂度：O(n)。空间复杂度取决于递归的栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n) 的级别。
*/
func preorderTraversal(root *TreeNode) []int {
	var ans []int
	preorder(root, &ans)
	return ans
}

func preorder(root *TreeNode, ans *[]int) {
	if root == nil {
		return
	}
	*ans = append(*ans, root.Val)
	preorder(root.Left, ans)
	preorder(root.Right, ans)
}
