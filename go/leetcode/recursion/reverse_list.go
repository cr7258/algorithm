package main

/**
 * @description 剑指 Offer 24. 反转链表
 * @author chengzw
 * @since 2022/6/7
 * @link https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
 */

/**
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
*/

/**
思路：
递归解法，把反转问题分解成子链表的反转

时间复杂度：O(n)，递归树的节点数，链表的长度
空间复杂度：O(n)，递归树的高度
*/
func reverseList(head *ListNode) *ListNode {
	// 递归退出条件
	if head == nil {
		return nil
	}
	if head.Next == nil {
		return head
	}
	// 递归后继节点
	newHead := reverseList(head.Next)
	// 子链表反转
	head.Next.Next = head
	head.Next = nil
	// 返回反转链表的头节点，实际上是一开始的节点一直返回
	return newHead
}
