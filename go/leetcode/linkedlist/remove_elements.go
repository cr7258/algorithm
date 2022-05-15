package linkedlist

/**
 * @description 移除链表元素
 * @author chengzw
 * @since 2022/5/15
 * @Link https://leetcode.cn/problems/remove-linked-list-elements/
 */

/**
给你一个链表的头节点 head 和一个整数 val ，
请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
*/

type ListNode struct {
	Val  int
	Next *ListNode
}

/**
思路：
1.引入虚拟头节点 newHead，这样可以不用处理头节点 == val 的情况
2.使用 prev 指针遍历，遍历结束条件 prev.Next == nil
3.当 Val 等于 val 时，prev.Next = prev.Next.Next 跳过该节点

时间复杂度：O(n)，其中 n 是链表的长度。需要遍历链表一次。
空间复杂度：O(1)。
*/
func removeElements(head *ListNode, val int) *ListNode {
	newHead := new(ListNode) // 虚拟头节点
	newHead.Next = head
	prev := newHead
	for prev.Next != nil {
		// 如果值等于 val，跳过（相当于删除该节点）
		if prev.Next.Val == val {
			prev.Next = prev.Next.Next
		} else {
			prev = prev.Next
		}
	}
	return newHead.Next
}
