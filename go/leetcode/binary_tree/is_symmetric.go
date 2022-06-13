package binary_tree

/**
 * @description 101. 对称二叉树
 * @author chengzw
 * @since 2022/6/13
 * @link https://leetcode.cn/problems/symmetric-tree/
 */

/**
给你一个二叉树的根节点 root ， 检查它是否轴对称。

示例 1：
输入：root = [1,2,2,3,4,4,3]
输出：true

示例 2：
输入：root = [1,2,2,null,3,null,3]
输出：false
*/

/**
思路：
如果同时满足下面的条件，两个树互为镜像：
1.它们的两个根结点具有相同的值。
2.每个树的右子树都与另一个树的左子树镜像对称。

时间复杂度：这里遍历了这棵树，渐进时间复杂度为 O(n)。
空间复杂度：这里的空间复杂度和递归使用的栈空间有关，这里递归层数不超过 n，故渐进空间复杂度为 O(n)。
*/
func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}
	// 检查两棵子树是否对称
	return helper(root.Left, root.Right)

}

func helper(left *TreeNode, right *TreeNode) bool {
	if left == nil || right == nil {
		return left == right
	}
	// 两个根节点需要相同
	if left.Val != right.Val {
		return false
	}
	// 左右子节点需要对称相同
	return helper(left.Left, right.Right) && helper(left.Right, right.Left)

}
