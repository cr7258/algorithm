package binary_tree

/**
 * @author chengzw
 * @description 543. 二叉树的直径
 * @link https://leetcode.cn/problems/diameter-of-binary-tree/
 * @since 2022/6/14
 */

/**
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

示例 :
给定二叉树
1
/ \
2   3
/ \
4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
*/

/**
思路：所谓二叉树的直径，就是左右子树的最大深度之和。
1.L 和 R 分别为左右子树的深度，以该节点为根的子树深度为 max(L, R) + 1。
2.以该节点为起点的最大直径为 L + R + 1。
3.全局变量 ans 记录最大直径。

时间复杂度：O(n)
空间复杂度：O(n)
*/
var ans int

func diameterOfBinaryTree(root *TreeNode) int {
	ans = 0
	depth(root)
	return ans
}
func depth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	L := depth(root.Left)
	R := depth(root.Right)
	// 计算最大直径
	ans = max(ans, L+R)
	// 返回以该节点为根的子树深度
	return max(L, R) + 1
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
