package main

/**
 * @description 剑指 Offer 06. 从尾到头打印链表
 * @author chengzw
 * @since 2022/6/6
 * @link https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */

/**
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：
输入：head = [1,3,2]
输出：[2,3,1]
*/

type ListNode struct {
	Val  int
	Next *ListNode
}

/**
思路：递归找链表节点的值，将 head 的 val 加上递归调用的结果上
时间复杂度：O(n)
空间复杂度：O(n)
*/

func reversePrint(head *ListNode) []int {
	if head == nil {
		return nil
	}
	return append(reversePrint(head.Next), head.Val)
}
