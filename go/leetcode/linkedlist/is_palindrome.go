package linkedlist

/**
 * @description 234. 回文链表
 * @author chengzw
 * @since 2022/5/21
 * @link https://leetcode.cn/problems/palindrome-linked-list/
 */

/**
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true；否则，返回 false 。

示例 1：
输入：head = [1,2,2,1]
输出：true

示例 2：
输入：head = [1,2]
输出：false
*/

/**
思路：
1.首先找通过快慢指针到中间节点。
2.然后反转中间节点右边的链表，再比较左边和右边是否相等。
*/
func isPalindrome(head *ListNode) bool {
	slow := head
	fast := head

	// 找到中间节点
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}

	// 反转中间节点后边的链表
	var newHead *ListNode
	for slow != nil {
		tmp := slow.Next
		slow.Next = newHead
		newHead = slow
		slow = tmp
	}

	// 比较两个链表
	for newHead != nil && head != nil {
		if newHead.Val != head.Val {
			return false
		}
		newHead = newHead.Next
		head = head.Next
	}
	return true
}
