package linkedlist

/**
 * @description 剑指 Offer 25. 合并两个排序的链表
 * @author chengzw
 * @since 2022/5/18
 * @link https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 */

/**
输入两个递增排序的链表， 合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：
输入： 1 - > 2 - > 4, 1 - > 3 - > 4
输出： 1 - > 1 - > 2 - > 3 - > 4 - > 4
*/

/**
思路：
1.使用两个指针遍历原本的两个链表，进行比较
2.再使用一个新链表来添加节点

时间复杂度：O(n+m)，n 和 m 分别是两个链表的长度
空间复杂度：O(1)
*/

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	// 遍历原本的两个链表
	p1 := l1
	p2 := l2
	newHead := new(ListNode)
	// 新链表的指针
	tail := newHead
	for p1 != nil && p2 != nil {
		if p1.Val < p2.Val {
			tmp := p1.Next
			p1.Next = nil
			tail.Next = p1
			tail = p1
			p1 = tmp
		} else {
			tmp := p2.Next
			p2.Next = nil
			tail.Next = p2
			tail = p2
			p2 = tmp
		}
	}
	// 把剩下一条链表的所有节点接到新链表上
	if p1 != nil {
		tail.Next = p1
	} else {
		tail.Next = p2
	}
	return newHead.Next
}
