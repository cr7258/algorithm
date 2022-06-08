package main

/**
 * @description 剑指 Offer 16. 数值的整数次方
 * @author chengzw
 * @since 2022/6/8
 * @link https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */

/**
实现 pow(x,n) ，即计算 x 的 n 次幂函数（即，x^n）。不得使用库函数，同时不需要考虑大数问题。

示例 1：
输入：x = 2.00000, n = 10
输出：1024.00000

示例 2：
输入：x = 2.10000, n = 3
输出：9.26100

示例 3：
输入：x = 2.00000, n = -2
输出：0.25000
解释：2-2 = 1/22 = 1/4 = 0.25
*/

/**
 * 思路：数学公式
 * 当 n 为偶数时， x^n = x^(n/2) * x^(n/2)
 * 当 n 为奇数时， x^n = x^(n/2) * x^(n/2) * x
 *
 * 时间复杂度：O(logn)
 * 空间复杂度：O(logn)
 */
func myPow(x float64, n int) float64 {
	if n >= 0 {
		return rPow(x, n)
	} else {
		return 1 / (rPow(x, -n))
	}
}

func rPow(x float64, n int) float64 {
	if n == 0 {
		return 1
	}

	halfPow := rPow(x, n/2)
	if n%2 == 1 {
		return halfPow * halfPow * x
	} else {
		return halfPow * halfPow
	}
}
