package leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author chengzw
 * @description 有效的括号，https://leetcode-cn.com/problems/valid-parentheses/
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * @since 2021/9/1
 */
public class IsValid {
    public static boolean solution1(String s) {
        //队列存放前一半元素
        Queue<Character> queue = new LinkedList<>();
        //栈存放后一半元素
        Stack<Character> stack = new Stack<>();

        int length = s.length();
        //如果字符串长度是奇数直接返回无效
        if (length % 2 == 1) return false;

        for (int i = 0; i < length / 2; i++) {
            queue.add(s.charAt(i));
            stack.push(s.charAt(length - 1 - i));
        }

        //比较元素
        while (!queue.isEmpty()) {
            int val1 = queue.poll();
            int val2 = stack.pop();
            if (!compare(val1, val2)) return false;
        }
        return true;
    }

    public static boolean compare(int val1, int val2) {
        return (val1 == '(' && val2 == ')') || (val1 == '{' && val2 == '}') || (val1 == '[' && val2 == ']');
    }

    public static void main(String[] args) {
        System.out.println(solution1("()"));
    }
}
