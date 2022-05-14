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
 * 思路：动态规划
 * 1.使用数组 dp 存储每一级台阶的爬法数量，dp[n] = dp[n-1] + dp[n-2]
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
func climbStairs(n int) int {
	if n == 1 {
		return 1
	}
	dp := make([]int, n+2)
	dp[1] = 1
	dp[2] = 2
	for i := 3; i <= n; i++ {
		dp[i] = dp[i-1] + dp[i-2]
	}
	return dp[n]
}
