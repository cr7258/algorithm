package binary_tree

/**
 * @description 104. 二叉树的最大深度
 * @author chengzw
 * @since 2022/6/13
 * @link https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */

/**
给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
*/

/**
思路：根据左右子树的最大深度推出原二叉树的最大深度

时间复杂度：O(n)，其中 n 为二叉树节点的个数。每个节点在递归中只被遍历一次。
空间复杂度：O(n)，其中 n 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度，高度最差情况是 n。
*/
func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}

	leftMax := maxDepth(root.Left)
	rightMax := maxDepth(root.Right)

	// 根据左右子树的最大深度推出原二叉树的最大深度
	return max(leftMax, rightMax) + 1
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
