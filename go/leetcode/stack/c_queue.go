package stack

/**
 * @description 剑指 Offer 09. 用两个栈实现队列
 * @author chengzw
 * @since 2022/5/25
 * @link https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */

/**
两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

示例 1：
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]

示例 2：
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
*/

/**
思路：
1.两个栈，stack 存放元素，tmpstack 用于倒腾的辅助栈
2.入队列的时候直接入栈 stack
3.出队列的时候把元素从 stack 弹出到 tmpstack，返回最后一个元素，然后再从 tmpstack 弹回 stack

时间复杂度：appendTail 为O(1)，deleteHead 为均摊 O(1)。对于每个元素，至多入栈和出栈各两次，故均摊复杂度为 O(1)。
空间复杂度：O(n)。其中 n 是操作总数。对于有 n 次 appendTail 操作的情况，队列中会有 n 个元素，故空间复杂度为 O(n)。
*/

type CQueue struct {
	stack, tmpStack []int
}

func Constructor() CQueue {
	return CQueue{}
}

func (this *CQueue) AppendTail(value int) {
	this.stack = append(this.stack, value)
}

func (this *CQueue) DeleteHead() int {
	if len(this.stack) == 0 {
		return -1
	}
	for len(this.stack) > 0 {
		this.tmpStack = append(this.tmpStack, this.stack[len(this.stack)-1])
		this.stack = this.stack[:len(this.stack)-1]
	}
	result := this.tmpStack[len(this.tmpStack)-1]
	this.tmpStack = this.tmpStack[:len(this.tmpStack)-1]

	for len(this.tmpStack) > 0 {
		this.stack = append(this.stack, this.tmpStack[len(this.tmpStack)-1])
		this.tmpStack = this.tmpStack[:len(this.tmpStack)-1]
	}
	return result
}
