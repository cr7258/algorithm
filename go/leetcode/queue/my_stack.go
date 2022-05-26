package queue

/**
 * @description 225. 用队列实现栈
 * @author chengzw
 * @since 2022/5/26
 * @link https://leetcode.cn/problems/implement-stack-using-queues/
 */

/**
请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。

实现 MyStack 类：
void push(int x) 将元素 x 压入栈顶。
int pop() 移除并返回栈顶元素。
int top() 返回栈顶元素。
boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。

注意：
你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。

示例
输入：
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
输出：
[null, null, null, 2, 2, false]

解释：
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // 返回 2
myStack.pop(); // 返回 2
myStack.empty(); // 返回 False
*/

/**
思路：
1.两个队列，queue 和 tmpQueue
2.入栈的时候直接入队列 queue
3.出栈的时候 queue 倒腾到 tmpQueue，然后去掉 queue 最后一个元素，最后再从 tmpQueue 还原回 queue

时间复杂度：O(1)，入栈操作 O(1)，出栈 O(n)，均摊 O(1)
空间复杂度：O(n)，其中 n 是栈内的元素个数。需要使用两个队列存储栈内的元素。
*/

type MyStack struct {
	queue, tmpQueue []int
}

func Constructor() MyStack {
	return MyStack{}
}

func (this *MyStack) Push(x int) {
	this.queue = append(this.queue, x)
}

func (this *MyStack) Pop() int {
	for len(this.queue) > 0 {
		this.tmpQueue = append(this.tmpQueue, this.queue[len(this.queue)-1])
		this.queue = this.queue[:len(this.queue)-1]
	}
	for len(this.tmpQueue) > 1 {
		this.queue = append(this.queue, this.tmpQueue[len(this.tmpQueue)-1])
		this.tmpQueue = this.tmpQueue[:len(this.tmpQueue)-1]
	}
	// 去掉最后一个元素
	result := this.tmpQueue[0]
	this.tmpQueue = []int{}
	return result
}

func (this *MyStack) Top() int {
	// 先通过 Pop 方法得到栈顶元素
	topNum := this.Pop()
	// 然后把栈顶元素添加回去
	this.Push(topNum)
	return topNum
}

func (this *MyStack) Empty() bool {
	return len(this.queue) == 0
}
