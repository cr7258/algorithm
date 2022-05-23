package linkedlist

/**
 * @description 25. K 个一组翻转链表
 * @author chengzw
 * @since 2022/5/23
 * @link https://leetcode.cn/problems/reverse-nodes-in-k-group/
 */

/**
给你链表的头节点 head， 每 k 个节点一组进行翻转， 请你返回修改后的链表。
k 是一个正整数， 它的值小于或等于链表的长度。 如果节点总数不是 k 的整数倍， 那么请将最后剩余的节点保持原有顺序。
你不能只是单纯的改变节点内部的值， 而是需要实际进行节点交换。

示例 1：
输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]

示例 2：
输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]
*/

/**
思路：
1.两个指针，p 遍历原链表，q 遍历 k 个一组链表
2.如果是 q == nil 退出的，说明剩下的几点不到 k 个，直接接到新链表后面，不反转。否则先反转后再接到新链表后面。

时间复杂度: O(n)
空间复杂度: O(1)
*/
func reverseKGroup(head *ListNode, k int) *ListNode {
	// 新链表
	newHead := new(ListNode)
	tail := newHead
	// 遍历原链表
	p := head
	for p != nil {
		// 遍历 k 个一组链表
		q := p
		count := 0
		for q != nil {
			count++
			if count == k {
				break
			}
			q = q.Next
		}

		// 处理 k 个链表
		// 如果是 q == nil 退出的，说明剩下的几点不到 k 个，直接接到新链表后面，不反转
		if q == nil {
			tail.Next = p
			return newHead.Next
		} else { // 先反转后再接到新链表后面
			tmp := q.Next
			reverseHead, reverseTail := reverseKList(p, q)
			tail.Next = reverseHead
			tail = reverseTail
			p = tmp
		}
	}
	return newHead.Next
}

// 反转链表
func reverseKList(head, tail *ListNode) (*ListNode, *ListNode) {
	var k *ListNode
	p := head
	for p != tail {
		tmp := p.Next
		p.Next = k
		k = p
		p = tmp
	}
	tail.Next = k
	return tail, head
}
