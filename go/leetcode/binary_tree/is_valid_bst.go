package binary_tree

/**
 * @description 98. 验证二叉搜索树
 * @author chengzw
 * @since 2022/6/13
 * @link https://leetcode.cn/problems/validate-binary-search-tree/
 */

/**
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

示例 1：
输入：root = [2,1,3]
输出：true

示例 2：
输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。
*/

/**
思路：
1.左子树的最大值是 root.val，右子树的最小值是 root.val。
2.左右子树同时满足 max 和 min 的限制说明是合法 BST。

时间复杂度：O(n)，其中 n 为二叉树的节点个数。在递归调用的时候二叉树的每个节点最多被访问一次，因此时间复杂度为 O(n)。
空间复杂度：O(n)，其中 n 为二叉树的节点个数。递归函数在递归过程中需要为每一层递归函数分配栈空间，
所以这里需要额外的空间且该空间取决于递归的深度，即二叉树的高度。
最坏情况下二叉树为一条链，树的高度为 n ，递归最深达到 n 层，故最坏情况下空间复杂度为 O(n) 。
*/
func isValidBST(root *TreeNode) bool {
	return helper2(root, nil, nil)
}

//使用辅助函数
func helper2(root *TreeNode, min *TreeNode, max *TreeNode) bool {
	//二叉树可以为空
	if root == nil {
		return true
	}
	// 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
	if min != nil && root.Val <= min.Val {
		return false
	}
	if max != nil && root.Val >= max.Val {
		return false
	}
	//左子树的最大值是 root.val，右子树的最小值是 root.val
	//左右子树同时满足 max 和 min 的限制说明是合法 BST
	return helper2(root.Left, min, root) && helper2(root.Right, root, max)
}
