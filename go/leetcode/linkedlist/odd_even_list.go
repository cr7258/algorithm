package linkedlist

/**
 * @description 328. 奇偶链表
 * @author chengzw
 * @since 2022/5/22
 * @link https://leetcode.cn/problems/odd-even-linked-list/
 */

/**
给定单链表的头节点 head，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
第一个节点的索引被认为是 奇数， 第二个节点的索引为 偶数， 以此类推。
请注意， 偶数组和奇数组内部的相对顺序应该与输入时保持一致。
你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
*/

/**
思路：
1.使用两个链表分别连接奇数和偶数节点
2.将偶数链表添加到奇数链表末尾

时间复杂度: O(n)
空间复杂度: O(1)
*/
func oddEvenList(head *ListNode) *ListNode {
	odd := new(ListNode)
	tailOdd := odd
	even := new(ListNode)
	tailEven := even
	p := head
	i := 1
	// 使用两个链表分别连接奇数和偶数节点
	for p != nil {
		tmp := p.Next
		p.Next = nil
		if i%2 == 1 {
			tailOdd.Next = p
			tailOdd = p
		} else {
			tailEven.Next = p
			tailEven = p
		}
		p = tmp
		i++
	}
	// 将偶数链表添加到奇数链表末尾
	tailOdd.Next = even.Next
	return odd.Next
}
