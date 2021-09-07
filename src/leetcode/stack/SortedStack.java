package leetcode.stack;

import java.util.Stack;

/**
 * @author chengzw
 * @description 栈排序，https://leetcode-cn.com/problems/sort-of-stacks-lcci/
 *
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek返回 -1。
 *
 *  输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 *  输出：
 * [null,null,null,1,null,2]
 *
 * @since 2021/9/2
 */
public class SortedStack {

    /**
     * 思路1：使用一个临时栈存放小于val的值，原先大于val的值先弹出到临时栈，插入val后，将临时栈的值弹回原栈
     */
    public static class SortedStack1{
        Stack<Integer> stack;
        Stack<Integer> tmpStack;

        public SortedStack1() {
            stack = new Stack<>();
            tmpStack = new Stack<>();
        }

        public void push(int val) {
            if(stack.empty() || val <= stack.peek()){
                stack.push(val);
            }else{
                while(!stack.empty() && val > stack.peek()){
                    tmpStack.push(stack.pop());
                }
                stack.push(val);
                while(!tmpStack.empty()){
                    stack.push(tmpStack.pop());
                }
            }
        }

        public void pop() {
            if(stack.empty()) return;
            stack.pop();
        }

        public int peek() {
            if(stack.empty()) return -1;
            return stack.peek();
        }

        public boolean isEmpty() {
            return stack.empty();
        }
    }

    public static void main(String[] args) {
        SortedStack1 obj = new SortedStack1();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        obj.pop();
        System.out.println(obj.peek());
    }
}
