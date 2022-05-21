package linkedlist

/**
 * @description 206. 反转链表
 * @author chengzw
 * @since 2022/5/20
 * @link https://leetcode.cn/problems/reverse-linked-list/
 */

/**
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
示例 1：
输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]
*/

/**
思路：反转操作
p.next = newNode
newNode = p

时间复杂度: O(n)
空间复杂度: O(1)
*/
func reverseList(head *ListNode) *ListNode {
	var newHead *ListNode
	p := head
	for p != nil {
		tmp := p.Next
		p.Next = newHead
		newHead = p
		p = tmp
	}
	return newHead
}
