package stack

import "container/list"

/**
 * @description 155. 最小栈
 * @author chengzw
 * @since 2022/5/27
 * @link https://leetcode.cn/problems/min-stack/
 */

/**
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

实现 MinStack 类:
MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。

示例 1:
输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]
解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
*/

/**
思路：
1.stack 数据栈正常入栈，如果 val 小于最小值栈 minStack 的栈顶元素，则同时将 val 压入 minStack
2.删除数据栈栈顶元素时，如果数据栈栈顶元素等于最小值栈栈顶元素，最小值栈顶元素也删除

时间复杂度：O(1)
空间复杂度：O(N)
*/

type MinStack struct {
	stack, minStack *list.List
}

func Constructor() MinStack {
	return MinStack{
		stack:    list.New(),
		minStack: list.New(),
	}
}

func (this *MinStack) Push(val int) {
	this.stack.PushBack(val)
	if this.minStack.Len() == 0 || this.minStack.Back().Value.(int) >= val {
		this.minStack.PushBack(val)
	}
}

func (this *MinStack) Pop() {
	if this.stack.Len() != 0 {
		value := this.stack.Back()
		this.stack.Remove(value)
		if this.minStack.Len() != 0 && this.minStack.Back().Value.(int) == value.Value.(int) {
			this.minStack.Remove(this.minStack.Back())
		}
	}
}

func (this *MinStack) Top() int {
	if this.stack.Len() != 0 {
		return this.stack.Back().Value.(int)
	}
	return 0
}

func (this *MinStack) GetMin() int {
	if this.minStack.Len() != 0 {
		return this.minStack.Back().Value.(int)
	}
	return 0
}
