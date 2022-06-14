package binary_tree

/**
 * @description 剑指 Offer 54. 二叉搜索树的第k大节点
 * @author chengzw
 * @since 2022/6/13
 * @link https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */

/**
给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
示例 1:
输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4

示例 2:
输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4
*/

/**
思路：在 kthLargest 的基础上，用变量存放结果，而不是数组，节省使用空间
借助二叉搜索树中序遍历结果为有序序列的特点来解题：
1.左-根-右，从小到大排列
2.右-根-左，从大到小排列
本题中序遍历时，将节点的值添加到数组中，然后获取第 K 个值

时间复杂度 O(n) ：当树退化为链表时（全部为右子节点），无论 k 的值大小，递归深度都为 n ，占用 O(n) 时间。
空间复杂度 O(n)： 当树退化为链表时（全部为右子节点），系统使用 O(n) 大小的栈空间。
*/

// 计数
var count int

// 最终结果
var result int

func kthLargest(root *TreeNode, k int) int {
	count = 0
	result = 0
	inorder(root, k)
	return result
}

func inorder(root *TreeNode, k int) {
	if root == nil {
		return
	}
	// 增加计数，只在遍历右节点的时候计数
	inorder(root.Right, k)
	count++

	// 提前返回，剪枝
	if count > k {
		return
	}

	// 当遍历到第 k 个值时，记录下 result，后面提前返回，剪枝
	if count == k {
		result = root.Val
		return
	}
	inorder(root.Left, k)
}
