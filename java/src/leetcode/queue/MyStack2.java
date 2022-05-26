package leetcode.queue;

/**
 * @description 225. 用队列实现栈
 * @author chengzw
 * @link https://leetcode.cn/problems/implement-stack-using-queues/
 * <p>
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * <p>
 * 注意：
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 * <p>
 * 示例
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 * <p>
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 * @since 2022/5/26
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

import java.util.LinkedList;
import java.util.Queue;

/**
 思路：
 1.两个队列，queue 和 tmpQueue
 2.入栈的时候直接入队列 queue
 3.出栈的时候 queue 倒腾到 tmpQueue，然后去掉 queue 最后一个元素，最后再从 tmpQueue 还原回 queue

 时间复杂度：O(1)，入栈操作 O(1)，出栈 O(n)，均摊 O(1)
 空间复杂度：O(n)，其中 n 是栈内的元素个数。需要使用两个队列存储栈内的元素。
 */

public class MyStack2 {
    Queue<Integer> queue;
    Queue<Integer> tmpQueue;
    // 变量记录栈顶元素
    int topNum = 0;

    public MyStack2() {
        queue = new LinkedList<>();
        tmpQueue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        topNum = x;
    }

    public int pop() {
        // 记录队列元素个数，出栈倒腾的时候去掉最后一个元素
        int count = 0;
        while (!queue.isEmpty()) {
            tmpQueue.offer(queue.poll());
            count++;
        }

        while (count > 1) {
            topNum = tmpQueue.poll();
            queue.offer(topNum);
            count--;
        }
        return tmpQueue.poll();
    }

    public int top() {
        return topNum;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
