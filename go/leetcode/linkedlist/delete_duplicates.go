package linkedlist

/**
 * @description 83. 删除排序链表中的重复元素
 * @author chengzw
 * @since 2022/5/17
 * @link https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 */

/**
给定一个已排序的链表的头 head，删除所有重复的元素，使每个元素只出现一次 。返回已排序的链表 。
*/

/**
思路：
1.使用一个新链表添加元素
2.使用一个 int 类型的变量记录元素的值，因为是有序链表，所以只需要一个值记录即可
3.遍历原链表，当遇到重复元素跳过

时间复杂度：O(n)，其中 n 是链表的长度。
空间复杂度：O(1)。
*/
func deleteDuplicates(head *ListNode) *ListNode {
	// 新链表头节点
	newHead := new(ListNode)
	// 新链表移动的指针
	tail := newHead
	// 记录当前值
	val := -101 // -100 <= Node.val <= 100
	// 遍历原链表的指针
	p := head

	for p != nil {
		// 临时记录 p 的下一个节点
		tmp := p.Next
		if p.Val != val {
			// val 重新赋值
			val = p.Val
			// 原链表去掉节点
			p.Next = nil
			// 新链表添加节点
			tail.Next = p
			tail = p
		}
		// 还原
		p = tmp
	}
	return newHead.Next
}
