package linkedlist

/**
 * @description 160. 相交链表
 * @author chengzw
 * @since 2022/5/24
 * @link https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */

/**
给你两个单链表的头节点 headA 和 headB， 请你找出并返回两个单链表相交的起始节点。 如果两个链表不存在相交节点， 返回 null。
题目数据 保证 整个链式结构中不存在环。注意，函数返回结果后，链表必须保持其原始结构 。
*/

/**
思路：
1.分别计算 a 链表和 b 链表的长度
2.让长度长的链表先走差值
3.然后两个指针一起走，遇到相等的节点就是第一个相交的节点

时间复杂度：O(m+n)
空间复杂度：O(1)
*/

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	a := headA
	b := headB
	countA := 0
	countB := 0

	//计算链表 a 的长度
	for a != nil {
		a = a.Next
		countA++
	}

	//计算链表 b 的长度
	for b != nil {
		b = b.Next
		countB++
	}

	//长的链表的指针先走差值步
	a = headA
	b = headB
	if countA > countB {
		count := countA - countB
		for count > 0 {
			a = a.Next
			count--
		}
	} else if countA < countB {
		count := countB - countA
		for count > 0 {
			b = b.Next
			count--
		}
	}
	//两个链表一起走
	for a != nil && b != nil {
		if a == b {
			return a
		}
		a = a.Next
		b = b.Next
	}
	return nil
}
