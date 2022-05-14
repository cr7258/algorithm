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
    /**
     * 思路1：遇到左边括号就压入对应的右边括号，当遇到右边括号时判断和栈顶元素是否相同
     * @param s
     * @return
     */
    public static boolean solution1(String s) {
        //特殊情况
        if (s.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();
        //遇到左边括号压入对应的右边括号
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
                //当遇到右边括号时，看是否和栈顶相同
            } else if (stack.empty() || stack.pop() != c) {
                return false;
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution1("()"));
        System.out.println(solution1("{[()]}"));
        System.out.println(solution1("[()]}"));
        System.out.println(solution1("[](){}"));
    }
}
