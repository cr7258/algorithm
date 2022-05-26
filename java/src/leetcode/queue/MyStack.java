package leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chengzw
 * @description 用队列实现栈，https://leetcode-cn.com/problems/implement-stack-using-queues/
 * <p>
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false
 * <p>
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
 * @since 2021/9/1
 */
public class MyStack {

    /**
     * 思路：入栈的时候直接入队列，出栈的时候记住最后一个值，还原的时候去掉最后一个值
     */
    public static class MyStack1 {
        private Queue<Integer> queue = new LinkedList<Integer>();
        private Queue<Integer> tmpQueue = new LinkedList<Integer>();

        public MyStack1() {

        }

        //入栈的时候直接入队
        public void push(int x) {
            queue.add(x);
        }

        //出栈的时候倒腾两个队列
        public int pop() {
            //范围0~9
            int last = -1;
            //记录元素数量
            int count = 0;
            while (!queue.isEmpty()) {
                count++;
                last = queue.poll();
                tmpQueue.add(last);
            }

            //还原队列
            for (int i = 0; i < count - 1; i++) {
                queue.add(tmpQueue.poll());
            }
            //把临时队列的弹出的元素去掉
            tmpQueue.poll();
            return last;
        }

        public int top() {
            //范围0~9
            int last = -1;
            while (!queue.isEmpty()) {
                last = queue.poll();
                tmpQueue.add(last);
            }
            //还原队列
            while (!tmpQueue.isEmpty()) {
                queue.add(tmpQueue.poll());
            }
            return last;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack1 obj = new MyStack1();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}
