package main

/**
 * @author chengzw
 * @description 爬楼梯
 * @link https://leetcode.cn/problems/climbing-stairs/
 * @since 2022/5/14
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * <p>
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */

/**
* 思路：
 * 1.爬到第 x 级台阶的方案数是爬到第 x-1 级台阶的方案数和爬到第 x-2 级台阶方案数的和
 * f(x) = f(x-1) + f(x-2)
 * 2.记忆化递归，使用 memo[] 数组记录爬到各级台阶的结果，避免重复计算
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
*/
func climbStairs(n int) int {
	memo := make([]int, n+1)
	return climbStairsMemo(n, memo)
}
func climbStairsMemo(n int, memo []int) int {
	if memo[n] > 0 {
		return memo[n]
	}
	if n == 1 {
		return 1
	} else if n == 2 {
		return 2
	} else {
		memo[n] = climbStairsMemo(n-1, memo) + climbStairsMemo(n-2, memo)
	}
	return memo[n]
}
