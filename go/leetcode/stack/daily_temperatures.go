package stack

/**
 * @description 739. 每日温度
 * @author chengzw
 * @since 2022/6/2
 * @link https://leetcode.cn/problems/daily-temperatures/
 */

/**
给定一个整数数组 temperatures，表示每天的温度，返回一个数组 answer，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。
如果气温在这之后都不会升高，请在该位置用 0 来代替。

示例 1:
输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]

示例 2:
输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]

示例 3:
输入: temperatures = [30,60,90]
输出: [1,1,0]
*/

/**
思路：单调栈
1.当输入温度大于栈顶温度时，依次弹出栈顶温度，计算差值，直到输入温度小于栈顶温度，最后压入输入温度
2.如果栈为空或者输入温度小于栈顶温度时，直接入栈

时间复杂度：O(n)，其中 n 是温度列表的长度。正向遍历温度列表一遍，对于温度列表中的每个下标，最多有一次进栈和出栈的操作。
空间复杂度：O(n)，其中 n 是温度列表的长度。需要维护一个单调栈存储温度列表中的下标。
*/
func dailyTemperatures(temperatures []int) []int {
	stack := []int{}
	result := make([]int, len(temperatures))
	for i, v := range temperatures {
		for len(stack) > 0 && v > temperatures[stack[len(stack)-1]] {
			idx := stack[len(stack)-1]
			result[idx] = i - idx
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, i)
	}
	return result
}
