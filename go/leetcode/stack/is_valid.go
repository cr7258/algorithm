package stack

import (
	"container/list"
)

/**
 * @description 20. 有效的括号
 * @author chengzw
 * @since 2022/5/29
 * @link https://leetcode.cn/problems/valid-parentheses/
 */

/**
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。

示例 1：
输入：s = "()"
输出：true

示例 2：

输入：s = "()[]{}"
输出：true

示例 3：
输入：s = "(]"
输出：false

示例 4：
输入：s = "([)]"
输出：false

示例 5：
输入：s = "{[]}"
输出：true
*/

/**
思路：
1.遇到左边括号就往栈压入对应的右边括号
2.当遇到右边括号时，弹出栈顶元素，判断是否相同

时间复杂度：O(n)，其中 n 是字符串 s 的长度。
空间复杂度：O(1)
*/
func isValid(s string) bool {
	stack := list.New()
	for _, c := range s {
		if c == '(' {
			stack.PushBack(')')
		} else if c == '{' {
			stack.PushBack('}')
		} else if c == '[' {
			stack.PushBack(']')
		} else if stack.Len() == 0 || stack.Remove(stack.Back()) != c {
			return false
		}
	}
	// 如果循环结束后，栈为空，说明对称
	return stack.Len() == 0
}
