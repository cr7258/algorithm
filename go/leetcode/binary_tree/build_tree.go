package binary_tree

/**
 * @author chengzw
 * @description 105. 从前序与中序遍历序列构造二叉树
 * @link https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @since 2022/6/18
 */

/**
给定两个整数数组 preorder 和 inorder，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。

示例 1:
输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]

示例 2:
输入: preorder = [-1], inorder = [-1]
输出: [-1]
*/

/**
思路：
前序遍历结果第一个就是根节点的值，然后再根据中序遍历结果确定左右子树的节点。
题解链接：https://labuladong.github.io/algo/2/19/35/

时间复杂度：O(n)，其中 n 是树中的节点个数。
空间复杂度：O(n)，除去返回的答案需要的 O(n) 空间之外，我们还需要使用 O(n) 的空间存储哈希映射，以及 O(h)（其中 h 是树的高度）的空间表示递归时栈空间。
这里 h<n，所以总空间复杂度为 O(n)。
*/
var inorderIndex map[int]int

func buildTree(preorder []int, inorder []int) *TreeNode {
	inorderIndex = make(map[int]int)
	// 构建哈希表，存储中序遍历的值和索引的对应关系
	for i := 0; i < len(inorder); i++ {
		inorderIndex[inorder[i]] = i
	}
	return build(preorder, 0, len(preorder)-1, inorder, 0, len(inorder)-1)
}

func build(preorder []int, preStart int, preEnd int, inorder []int, inStart int, inEnd int) *TreeNode {
	if preStart > preEnd {
		return nil
	}

	// 先序遍历数组的第一个元素就是 root
	rootVal := preorder[preStart]
	// 获取 root 节点在中序遍历数组中的索引
	index, _ := inorderIndex[rootVal]
	leftSize := index - inStart

	// 先构建 root 节点
	root := &TreeNode{Val: rootVal}
	// 递归构建左右子树
	root.Left = build(preorder, preStart+1, preStart+leftSize, inorder, inStart, index-1)
	root.Right = build(preorder, preStart+leftSize+1, preEnd, inorder, index+1, inEnd)
	return root
}
