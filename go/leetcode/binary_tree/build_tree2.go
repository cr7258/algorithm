package binary_tree

/**
 * @author chengzw
 * @description 106. 从中序与后序遍历序列构造二叉树
 * @link https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @since 2022/6/18
 */

/**
给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。

示例 1:
输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
输出：[3,9,20,null,null,15,7]

示例 2:
输入：inorder = [-1], postorder = [-1]
输出：[-1]
*/

/**
思路：
后续遍历结果最后一个就是根节点的值，然后再根据中序遍历结果确定左右子树的节点。
题解链接：https://labuladong.github.io/algo/2/19/35/

时间复杂度：O(n)，其中 n 是树中的节点个数。
空间复杂度：O(n)，除去返回的答案需要的 O(n) 空间之外，我们还需要使用 O(n) 的空间存储哈希映射，以及 O(h)（其中 h 是树的高度）的空间表示递归时栈空间。
这里 h<n，所以总空间复杂度为 O(n)。
*/

var inorderIndex map[int]int

func buildTree(inorder []int, postorder []int) *TreeNode {
	inorderIndex = make(map[int]int)
	// 根据中序遍历数组构建哈希表
	for i := 0; i < len(inorder); i++ {
		inorderIndex[inorder[i]] = i
	}
	return build(postorder, 0, len(postorder)-1, inorder, 0, len(inorder)-1)
}

func build(postorder []int, postStart int, postEnd int, inorder []int, inStart int, inEnd int) *TreeNode {
	if postStart > postEnd {
		return nil
	}

	// 构建根节点
	rootVal := postorder[postEnd]
	root := &TreeNode{Val: rootVal}

	// 计算左子树的长度
	index, _ := inorderIndex[rootVal]
	leftSize := index - inStart

	// 递归构建左右子树
	root.Left = build(postorder, postStart, postStart+leftSize-1, inorder, inStart, index-1)
	root.Right = build(postorder, postStart+leftSize, postEnd-1, inorder, index+1, inEnd)

	return root
}
