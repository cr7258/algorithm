package leetcode.stack;

import java.util.Stack;

/**
 * @author chengzw
 * @description 最小栈，https://leetcode-cn.com/problems/min-stack/
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 *
 * @since 2021/9/1
 */
public class MinStack {

    /**
     * 思路1：使用辅助栈存放最小值
     * 时间复杂度：O(1)
     * 空间复杂度：O(N)
     */
    public static class MinStack1{
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public MinStack1() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        //数据栈正常入栈
        //如果该值小于最小值栈的栈顶元素，则压入该值
        public void push(int val) {
            dataStack.push(val);
            if(minStack.isEmpty() || minStack.peek() > val){
                minStack.push(val);
            }
        }

        //删除数据栈栈顶元素
        //如果数据栈栈顶元素等于最小值栈栈顶元素，最小值栈顶元素也删除
        public void pop() {
            if(dataStack.isEmpty()) return;
            int val = dataStack.pop();
            if(minStack.isEmpty()) return;
            if(val == minStack.peek()){
                minStack.pop();
            }
        }

        //正常返回数据栈栈顶元素
        public int top() {
            return dataStack.peek();
        }

        //返回最小值栈栈顶元素
        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack1 obj = new MinStack1();
        obj.push(0);
        obj.push(1);
        obj.push(0);
        System.out.println(obj.getMin());
        obj.pop();
        obj.pop();

    }
}
