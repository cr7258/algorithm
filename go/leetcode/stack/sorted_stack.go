package stack

import "container/list"

/**
 * @description 面试题 03.05. 栈排序
 * @author chengzw
 * @since 2022/5/27
 * @link https://leetcode.cn/problems/sort-of-stacks-lcci/
 */

/**
栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。

示例1:
 输入：
["SortedStack", "push", "push", "peek", "pop", "peek"]
[[], [1], [2], [], [], []]
 输出：
[null,null,null,1,null,2]

示例2:
 输入：
["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
[[], [], [], [1], [], []]
 输出：
[null,null,null,null,null,true]
说明:

栈中的元素数目在[0, 5000]范围内。
*/

/**
思路：
1.使用一个临时栈存放小于 val 的值，原先大于 val 的值先弹出到临时栈，插入 val 后，将临时栈的值弹回原栈

时间复杂度：O(1)
空间复杂度：O(N)
*/
type SortedStack struct {
	stack, tmpStack *list.List
}

func Constructor() SortedStack {
	return SortedStack{
		stack:    list.New(),
		tmpStack: list.New(),
	}
}

func (this *SortedStack) Push(val int) {
	for this.stack.Len() != 0 && this.stack.Back().Value.(int) < val {
		this.tmpStack.PushBack(this.stack.Remove(this.stack.Back()))
	}
	this.stack.PushBack(val)
	for this.tmpStack.Len() != 0 {
		this.stack.PushBack(this.tmpStack.Remove(this.tmpStack.Back()))
	}
}

func (this *SortedStack) Pop() {
	if this.stack.Len() != 0 {
		this.stack.Remove(this.stack.Back())
	}
}

func (this *SortedStack) Peek() int {
	if this.stack.Len() != 0 {
		return this.stack.Back().Value.(int)
	}
	return -1
}

func (this *SortedStack) IsEmpty() bool {
	return this.stack.Len() == 0
}
