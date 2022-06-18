package binary_tree

/**
 * @author chengzw
 * @description 面试题 04.03. 特定深度节点链表
 * @link https://leetcode.cn/problems/list-of-depth-lcci/
 * @since 2022/6/16
 */

/**
 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。

 示例：
 输入：[1,2,3,4,5,null,7,8]

 1
 /  \
 2    3
 / \    \
 4   5    7
 /
 8
 */

/**
 思路：层序遍历，每层创建一个链表

 时间复杂度：O(n)
 空间复杂度：O(n)
 */

func listOfDepth(tree *TreeNode) []*ListNode {
	var ans []*ListNode
	var queue []*TreeNode
	queue = append(queue, tree)
	for len(queue) != 0 {
		levelAns := new(ListNode)
		tail := levelAns
		size := len(queue)
		for i := 0; i < size; i++ {
			// 将子节点添加到队列中，下一轮层序遍历使用
			node := queue[0]
			tail.Next = &ListNode{Val: node.Val}
			tail = tail.Next
			queue = queue[1:]
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		// 将每层的结果加到结果数组中
		ans = append(ans, levelAns.Next)
	}
	return ans
}

type ListNode struct {
	Val  int
	Next *ListNode
}
