package binary_tree

/**
 * @description 226. 翻转二叉树
 * @author chengzw
 * @since 2022/6/13
 * @link https://leetcode.cn/problems/invert-binary-tree/
 */

/**
给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。

示例 1：
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]

示例 2：
输入：root = [2,1,3]
输出：[2,3,1]

示例 3：
输入：root = []
输出：[]
*/

/**
思路：
我们从根节点开始，递归地对树进行遍历，并从叶子节点先开始翻转。
如果当前遍历到的节点 root 的左右两棵子树都已经翻转，那么我们只需要交换两棵子树的位置，即可完成以 root 为根节点的整棵子树的翻转。

时间复杂度：O(n)，其中 n 为二叉树节点的数目。我们会遍历二叉树中的每一个节点，对每个节点而言，我们在常数时间内交换其两棵子树。
空间复杂度：O(n)。使用的空间由递归栈的深度决定，它等于当前节点在二叉树中的高度。在平均情况下，二叉树的高度与节点个数为对数关系，即 O(logn)。而在最坏情况下，树形成链状，空间复杂度为 O(n)。
*/
func invertTree(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}

	// 利用函数定义，先翻转左右子树
	left := invertTree(root.Left)
	right := invertTree(root.Right)

	// 然后交换左右子节点
	root.Left = right
	root.Right = left

	// 以 root 为根的这棵二叉树已经被翻转，返回 root
	return root
}
