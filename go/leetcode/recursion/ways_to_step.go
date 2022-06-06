package main

/**
 * @description 面试题 08.01. 三步问题
 * @author chengzw
 * @since 2022/6/6
 * @link https://leetcode.cn/problems/three-steps-problem-lcci/
 */

/**
三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
示例1:
 输入：n = 3
 输出：4
 说明: 有四种走法

示例2:
 输入：n = 5
 输出：13

提示:
n范围在[1, 1000000]之间
*/

/**
思路1：递归方式实现
时间复杂度：
1.递归树总节点的个数，如果不用备忘录，时间复杂度是 3^(n/3) - 1 ~ 3^n - 1；
2.使用备忘录的话，需要计算的节点被剪枝了，时间复杂度是 O(n)，因为只有左边的一排节点需要计算

空间复杂度：O(n)，递归树的高度，最左边一排
*/

// 备忘录
var memWays = [1000000]int{1, 1, 2, 4}

const mod = 1000000007

func waysToStep(n int) int {
	if memWays[n] != 0 {
		return memWays[n]
	}
	memWays[n] = ((waysToStep(n-1)+waysToStep(n-2))%mod + waysToStep(n-3)) % mod
	return memWays[n]
}
