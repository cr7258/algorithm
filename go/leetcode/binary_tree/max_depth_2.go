package binary_tree

/**
 * @description 559. N 叉树的最大深度
 * @author chengzw
 * @since 2022/6/13
 * @link https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/
 */

/**
给定一个 N 叉树，找到其最大深度。
最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。

示例 1：
输入：root = [1,null,3,2,4,null,5,6]
输出：3

示例 2：
输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：5
*/

/**
思路：根据子树的最大深度推出原二叉树的最大深度

时间复杂度：O(n)，其中 n 为二叉树节点的个数。每个节点在递归中只被遍历一次。
空间复杂度：O(n)，其中 n 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度，高度最差情况是 n。
*/
func maxDepth2(root *Node) int {
	if root == nil {
		return 0
	}
	depth := 0
	for _, v := range root.Children {
		depth = max(maxDepth2(v), depth)
	}
	return depth + 1
}
