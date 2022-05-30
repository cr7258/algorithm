package stack

import "container/list"

/**
 * @description 面试题 16.26. 计算器
 * @author chengzw
 * @since 2022/5/30
 * @link https://leetcode.cn/problems/calculator-lcci/
 */

/**
给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
表达式仅包含非负整数，+， - ，*，/ 四种运算符和空 。 整数除法仅保留整数部分。

示例 1:
输入: "3+2*2"
输出: 7

示例 2:
输入: " 3/2 "
输出: 1

示例 3:
输入: " 3+5 / 2 "
输出: 5
*/

/**
思路：
1.两个栈，一个是数字栈 numStack，一个是符号栈 opStack
2.数字直接入栈。
3.运算符如果优先级高于栈顶符号，直接入栈；如果优先级等于或低于栈顶元素，计算。
4.当遍历完字符串后，剩余的运算符优先级相同，弹出计算

时间复杂度：O(n)
空间复杂度：O(n)
*/

func calculate(s string) int {
	numStack := list.New()
	opStack := list.New()

	i := 0
	n := len(s)
	for i < n {
		// 如果是空格，跳过
		if s[i] == ' ' {
			i++
			// 数字直接入栈
		} else if isNum(s[i]) {
			num := 0
			for i < n && isNum(s[i]) {
				num = num*10 + int(s[i]-'0')
				i++
			}
			numStack.PushBack(num)
		} else {
			// 如果符号比栈顶优先级高，直接入栈
			if opStack.Len() == 0 || prior(s[i], opStack.Back().Value.(byte)) {
				opStack.PushBack(s[i])
			} else { // 如果符号比栈顶优先级低或者相等，计算
				for opStack.Len() != 0 && !prior(s[i], opStack.Back().Value.(byte)) {
					fetchAndCal(numStack, opStack)
				}
				opStack.PushBack(s[i])
			}
			i++
		}
	}
	// 剩余符号优先级相同
	for opStack.Len() != 0 {
		fetchAndCal(numStack, opStack)
	}
	return numStack.Back().Value.(int)
}

// 判断符号优先级
func prior(opA, opB byte) bool {
	return (opA == '*' || opA == '/') && (opB == '+' || opB == '-')
}

// 判断是否是数字
func isNum(c byte) bool {
	return c >= '0' && c <= '9'
}

// 计算
func cal(op byte, numA int, numB int) int {
	switch op {
	case '+':
		return numA + numB
	case '-':
		return numA - numB
	case '*':
		return numA * numB
	case '/':
		return numA / numB
	}
	return 0
}

// 计算并将结果压入数字栈
func fetchAndCal(numStack, opStack *list.List) {
	// 注意顺序，numB 是先弹出来的，/ 符号计算顺序会有影响
	numB := numStack.Remove(numStack.Back()).(int)
	numA := numStack.Remove(numStack.Back()).(int)
	op := opStack.Remove(opStack.Back()).(byte)
	numStack.PushBack(cal(op, numA, numB))
}
