package main

/**
 * @description 剑指 Offer 10- I. 斐波那契数列
 * @author chengzw
 * @since 2022/6/5
 * @link https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/
 */

/**
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

F(0) = 0,F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：
输入：n = 2
输出：1

示例 2：
输入：n = 5
输出：5

提示：
0 <= n <= 100
*/

/**
思路：
时间复杂度：和递归树的节点个数成正比。
不使用备忘录，O(2^(n/2)) ~ O(2^n)，两个完全二叉树面积范围之间，大的二叉树的高度是 n，节点个数是 2^n -1；小的二叉树高度是 n/2，节点个数是 2^(n/2) - 1。
使用备忘录，剪枝减低时间复杂度：O(n)，只需要计算左边的边
空间复杂度：和递归树的高度（调用栈深度）成正比，O(n)。
*/
var memFib = [101]int{}

func fib(n int) int {
	if n == 0 {
		return 0
	}
	if n == 1 {
		return 1
	}
	if memFib[n] != 0 {
		return memFib[n]
	}
	memFib[n] = (fib(n-1) + fib(n-2)) % 1000000007
	return memFib[n]
}
