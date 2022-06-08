package math

/**
 * @description 118. 杨辉三角
 * @author chengzw
 * @since 2022/6/8
 * @link https://leetcode.cn/problems/pascals-triangle/
 */

/**
给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
在「杨辉三角」中，每个数是它左上方和右上方的数的和。

示例 1:
输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

示例 2:
输入: numRows = 1
输出: [[1]]
*/

/**
思路：第 n 行的第 i 个数等于第 n−1 行的第 i−1 个数和第 i 个数之和

时间复杂度：O(n^2)
空间复杂度：O(1)
*/
func generate(numRows int) [][]int {
	ans := make([][]int, numRows)
	for i := range ans {
		// 存放每行结果
		ans[i] = make([]int, i+1)
		// 每行首尾两个数字都是 1
		ans[i][0] = 1
		ans[i][i] = 1
		// 从每行第 2 个数字开始往后遍历
		// 第 n 行的第 i 个数等于第 n−1 行的第 i−1 个数和第 i 个数之和
		for j := 1; j < i; j++ {
			ans[i][j] = ans[i-1][j] + ans[i-1][j-1]
		}
	}
	return ans
}
