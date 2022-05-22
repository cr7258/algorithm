package linkedlist

/**
 * @description 19. 删除链表的倒数第 N 个结点
 * @author chengzw
 * @since 2022/5/22
 * @link https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */

/**
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

示例 1：
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]

示例 2：
输入：head = [1], n = 1
输出：[]

示例 3：
输入：head = [1,2], n = 1
输出：[1]
*/

/**
思路：
1.快慢指针，快指针先走 n 步，然后快慢指针一起走，快指针走到尾部，慢指针正好走到第 n 个
2.用一个 prev 记录慢指针的前一个节点，最后使用 prev.next = slow.next 跳过第 n 个节点

时间复杂度: O(n)
空间复杂度: O(1)
*/
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	fast := head
	slow := head
	//记录慢指针的前一个节点
	var prev *ListNode

	// 快指针先走 n 步
	count := n
	for count > 1 && fast != nil {
		fast = fast.Next
		count--
	}

	// 节点数量不够
	if fast == nil {
		return nil
	}

	// 两个指针一起走
	for fast.Next != nil {
		prev = slow
		fast = fast.Next
		slow = slow.Next
	}

	// 如果头结点是倒数第 n 个
	if prev == nil {
		head = head.Next
	} else {
		prev.Next = slow.Next
	}
	return head
}
