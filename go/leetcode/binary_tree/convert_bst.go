package binary_tree

/**
 * @description 538. 把二叉搜索树转换为累加树
 * @author chengzw
 * @since 2022/6/14
 * @link https://leetcode.cn/problems/convert-bst-to-greater-tree/
 */

/**
给出二叉搜索树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
提醒一下，二叉搜索树满足下列约束条件：
节点的左子树仅包含键 小于 节点键的节点。
节点的右子树仅包含键 大于 节点键的节点。
左右子树也必须是二叉搜索树。
注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同

示例 1：
输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

示例 2：
输入：root = [0,null,1]
输出：[1,null,1]

示例 3：
输入：root = [1,0,2]
输出：[3,3,2]

示例 4：
输入：root = [3,2,4,1]
输出：[7,9,4,10]
*/

/**
思路：
1.中序遍历二叉树，右-头-左，结果按照从大到小的顺序。
2.维护一个外部累加变量 sum，在遍历 BST 的过程中增加 sum，同时把 sum 赋值给 BST 中的每一个节点，就将 BST 转化成累加树了。

时间复杂度：O(n)，其中 n 是二叉搜索树的节点数。每一个节点恰好被遍历一次。
空间复杂度：O(n)，为递归过程中栈的开销，平均情况下为 O(logn)，最坏情况下树呈现链状，为 O(n)。
*/
// 记录累加和
var sum int

func convertBST(root *TreeNode) *TreeNode {
	sum = 0
	inorder(root)
	return root
}

func inorder(root *TreeNode) {
	if root == nil {
		return
	}
	inorder(root.Right)
	// 将 sum 值赋给每个节点
	sum += root.Val
	root.Val = sum
	inorder(root.Left)
}
