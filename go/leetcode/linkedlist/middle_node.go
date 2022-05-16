package linkedlist

/**
 * @description 876. 链表的中间结点
 * @author chengzw
 * @since 2022/5/16
 * @link https://leetcode.cn/problems/middle-of-the-linked-list/
 */

/**
给定一个头结点为 head 的非空单链表，返回链表的中间结点。
如果有两个中间结点，则返回第二个中间结点。
给定链表的结点数介于 1 和 100 之间。

示例 1：
输入：[1, 2, 3, 4, 5]
输出： 此列表中的结点 3(序列化形式：[3, 4, 5])
返回的结点值为 3。(测评系统对该结点序列化表述是[3, 4, 5])。
注意， 我们返回了一个 ListNode 类型的对象 ans， 这样：
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.

示例 2：
输入：[1, 2, 3, 4, 5, 6]
输出： 此列表中的结点 4(序列化形式：[4, 5, 6])
由于该列表有两个中间结点， 值分别为 3 和 4， 我们返回第二个结点。
*/

/**
思路：快慢指针
1.慢指针一次走 1 步，快指针一次走 2 步
2.当快指针到末尾时，慢指针正好到中点

时间复杂度：O(N)，其中 N 是给定链表的结点数目。
空间复杂度：O(1)，只需要常数空间存放 slow 和 fast 两个指针。
*/
func middleNode(head *ListNode) *ListNode {
	fast := head
	slow := head

	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow
}
