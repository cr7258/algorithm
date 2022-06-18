package main

import (
	"fmt"
)

/**
 * @author chengzw
 * @description 剑指 Offer 36. 二叉搜索树与双向链表
 * @link https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * @since 2022/6/16
 */

/**
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
*/

/**
思路：中序遍历，遍历到的节点放到结果链表中

时间复杂度：O(n)
空间复杂度：O(n)
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var newNode, tail *TreeNode

func treeToDoublyList(node *TreeNode) *TreeNode {
	newNode = new(TreeNode)
	tail = newNode
	inorder(node)
	// 连接头尾节点
	tail.Right = newNode.Right
	newNode.Right.Left = tail
	return newNode.Right
}

func inorder(node *TreeNode) {
	if node == nil {
		return
	}

	inorder(node.Left)

	// 将遍历到的节点添加到结果链表中
	tail.Right = node
	node.Left = tail
	tail = node

	inorder(node.Right)
}

func main() {
	root := &TreeNode{4, nil, nil}
	node1 := &TreeNode{2, nil, nil}
	node2 := &TreeNode{5, nil, nil}
	node3 := &TreeNode{1, nil, nil}
	node4 := &TreeNode{3, nil, nil}
	root.Left = node1
	root.Right = node2
	node1.Left = node3
	node1.Right = node4
	result := treeToDoublyList(root)
	for i := 0; i < 5; i++ {
		fmt.Println(result.Val)
		result = result.Right
	}
}
