package main

/**
 * @description 面试题 08.05. 递归乘法
 * @author chengzw
 * @since 2022/6/10
 * @link https://leetcode.cn/problems/recursive-mulitply-lcci/
 */

/**
递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。

示例1:
输入：A = 1, B = 10
输出：10

示例2:
输入：A = 3, B = 4
输出：12
*/

/**
思路 1：

数学公式 A * B
当 A 为偶数时，(A/2) * B + (A/2) * B
当 A 为奇数时，(A/2) * B + (A/2) * B + B

时间复杂度：O(logn)
空间复杂度：O(logn)
*/
func multiply(A int, B int) int {
	if A == 1 {
		return B
	}
	halfValue := multiply(A/2, B)
	if A%2 == 1 {
		return halfValue + halfValue + B
	} else {
		return halfValue + halfValue
	}
}

/**
思路 2：在思路 1 的基础上，分解小的数
*/
func multiply2(A int, B int) int {
	n := min(A, B)
	k := max(A, B)
	if n == 1 {
		return k
	}
	halfValue := multiply(n/2, k)
	if n%2 == 1 {
		return halfValue + halfValue + k
	} else {
		return halfValue + halfValue
	}
}

func min(x int, y int) int {
	if x < y {
		return x
	}
	return y
}

func max(x int, y int) int {
	if x > y {
		return x
	}
	return y
}
