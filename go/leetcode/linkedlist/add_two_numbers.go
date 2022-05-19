package linkedlist

/**
 * @description 2. 两数相加
 * @author chengzw
 * @since 2022/5/19
 * @link https://leetcode.cn/problems/add-two-numbers/
 */

/**
给你两个非空的链表， 表示两个非负的整数。 它们每位数字都是按照逆序的方式存储的， 并且每个节点只能存储一位数字。
请你将两个数相加， 并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外， 这两个数都不会以 0 开头。

示例 1：
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.

示例 2：
输入：l1 = [0], l2 = [0]
输出：[0]

示例 3：
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
*/

/**
思路：
两个指针分别遍历两个链表，遍历时候按位相加，满 10 进 1
时间复杂度: O(m+n)，m 和 n 是两个链表的长度
空间复杂度: O(1)
*/
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	// 上一位相加的进位数
	carry := 0
	newNode := new(ListNode)
	tail := newNode
	for l1 != nil || l2 != nil {
		// 当前位的和
		sum := 0
		if l1 != nil {
			sum += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			sum += l2.Val
			l2 = l2.Next
		}

		sum += carry
		carry = sum / 10
		node := &ListNode{Val: sum % 10}
		tail.Next = node
		tail = tail.Next
	}
	if carry != 0 {
		node := &ListNode{Val: carry}
		tail.Next = node
	}
	return newNode.Next
}
