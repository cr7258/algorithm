package linkedlist

/**
 * @description 141. 环形链表
 * @author chengzw
 * @since 2022/5/24
 * @link https://leetcode.cn/problems/linked-list-cycle/
 */

/**
给你一个链表的头节点 head，判断链表中是否有环。
如果链表中有某个节点， 可以通过连续跟踪 next 指针再次到达， 则链表中存在环。 为了表示给定链表中的环， 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（ 索引从 0 开始）。
注意： pos 不作为参数进行传递。 仅仅是为了标识链表的实际情况。
如果链表中存在环， 则返回 true。否则，返回 false。
*/

/**
思路：Floyd 判圈算法，我们定义两个指针，一快一满。
慢指针每次只移动一步，而快指针每次移动两步。初始时，慢指针在位置 head，而快指针在位置 head.next。
这样一来，如果在移动的过程中，快指针反过来追上慢指针，就说明该链表为环形链表
否则快指针将到达链表尾部，该链表不为环形链表。

时间复杂度：O(N)， 其中 N 是链表中的节点数。
当链表中不存在环时， 快指针将先于慢指针到达链表尾部， 链表中每个节点至多被访问两次。
当链表中存在环时， 每一轮移动后， 快慢指针的距离将减小一。 而初始距离为环的长度， 因此至多移动 N 轮。

空间复杂度： O(1)。 我们只使用了两个指针的额外空间。
*/
func hasCycle(head *ListNode) bool {
	if head == nil {
		return false
	}
	fast := head.Next
	slow := head
	//快指针要先走一步，避免一开始 slow == fast
	//可以假想一个在 head 之前的虚拟节点，慢指针从虚拟节点移动一步到达 head，快指针从虚拟节点移动两步到达 head.next
	for fast != nil && fast.Next != nil && fast != slow {
		fast = fast.Next.Next
		slow = slow.Next
	}
	if fast == slow {
		return true
	}
	return false
}
