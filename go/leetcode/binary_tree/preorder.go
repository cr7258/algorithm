package binary_tree

/**
 * @description 589. N 叉树的前序遍历
 * @author chengzw
 * @since 2022/6/10
 * @link https://leetcode.cn/problems/n-ary-tree-preorder-traversal/
 */

/**
给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。

示例 1：
输入：root = [1,null,3,2,4,null,5,6]
输出：[1,3,5,6,2,4]

示例 2：
输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
*/

/**
思路：每次递归时，先访问根节点，然后依次递归访问每个孩子节点即可
时间复杂度：O(n)，其中 n 为 N 叉树的节点。每个节点恰好被遍历一次。
空间复杂度：O(n)，递归过程中需要调用栈的开销，平均情况下为 O(logn)，最坏情况下树的深度为 n-1，此时需要的空间复杂度为 O(n)。
*/
type Node struct {
	Val      int
	Children []*Node
}

func preorder2(root *Node) []int {
	ans := []int{}
	preorderR(root, &ans)
	return ans
}

func preorderR(root *Node, ans *[]int) {
	if root == nil {
		return
	}
	*ans = append(*ans, root.Val)
	for _, node := range root.Children {
		preorderR(node, ans)
	}
}
