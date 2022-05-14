package leetcode.stack;

import java.util.Stack;

/**
 * @author chengzw
 * @description 用两个栈实现队列，https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * <p>
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * @since 2021/9/1
 */


public class CQueue {

    /**
     * 思路1：入队列直接入栈，出队列的时候倒腾两个栈
     */
    public static class CQueue1 {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> tmpStack = new Stack<>();

        public CQueue1() {
        }

        //入队列直接入栈
        public void appendTail(int value) {
            stack.push(value);
        }

        //出队列的时候倒腾两个栈
        public int deleteHead() {
            if (stack.isEmpty()) return -1;
            while (!stack.isEmpty()) {
                tmpStack.push(stack.pop());
            }
            int result = tmpStack.pop();
            while (!tmpStack.isEmpty()) {
                stack.push(tmpStack.pop());
            }
            return result;
        }
    }

    /**
     * 思路2：入队列的时候倒腾两个栈，出队列直接出栈
     */
    public static class CQueue2 {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> tmpStack = new Stack<>();

        public CQueue2() {

        }

        //入队列的时候倒腾两个栈，把刚入队的元素置于栈底
        public void appendTail(int value) {
            while (!stack.isEmpty()) {
                tmpStack.push(stack.pop());
            }
            //新入队的元素置于栈底
            stack.push(value);
            while (!tmpStack.isEmpty()) {
                stack.push(tmpStack.pop());
            }
        }

        //出队列的时候直接出栈
        public int deleteHead() {
            if (stack.isEmpty()) return -1;
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        CQueue1 obj = new CQueue1();
        obj.appendTail(1);
        obj.appendTail(2);
        obj.appendTail(3);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());

        System.out.println("####################");

        CQueue2 obj2 = new CQueue2();
        obj2.appendTail(1);
        obj2.appendTail(2);
        obj2.appendTail(3);
        System.out.println(obj2.deleteHead());
        System.out.println(obj2.deleteHead());
        System.out.println(obj2.deleteHead());
    }
}
