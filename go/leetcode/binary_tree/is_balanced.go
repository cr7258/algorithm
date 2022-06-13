package binary_tree

/**
 * @description 剑指 Offer 55 - II. 平衡二叉树
 * @author chengzw
 * @since 2022/6/13
 * @link https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/
 */

/**
输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

示例 1:
给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:
给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
*/

/**
思路：
1.将问题转换为子问题：左子树和右子树是不是平衡二叉树？
2.全局变量 balanced 表示是否是平衡二叉树，一旦判断不是，直接递归返回 false。

时间复杂度：O(n)，其中 n 是二叉树中的节点个数。使用自底向上的递归，每个节点的计算高度和判断是否平衡都只需要处理一次，最坏情况下需要遍历二叉树中的所有节点，因此时间复杂度是 O(n)。
空间复杂度：O(n)，其中 n 是二叉树中的节点个数。空间复杂度主要取决于递归调用的层数，递归调用的层数不会超过 n。
*/
var balanced bool

func isBalanced(root *TreeNode) bool {
	balanced = true
	if root == nil {
		return true
	}
	height(root)
	return balanced
}

// 计算子树的高度
func height(root *TreeNode) int {
	if root == nil {
		return 0
	}
	// 提前终止，返回值不重要，重要的是 balanced 设置为了 false
	if !balanced {
		return -1
	}

	// 计算左右子树高度
	leftHeight := height(root.Left)
	rightHeight := height(root.Right)
	if abs(leftHeight-rightHeight) > 1 {
		balanced = false
	}
	return max(leftHeight, rightHeight) + 1
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func abs(x int) int {
	if x > 0 {
		return x
	}
	return -x
}