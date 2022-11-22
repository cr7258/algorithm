package main

/**
* @description 303. 区域和检索 - 数组不可变
* @author chengzw
* @since 2022/11/22
* @link https://leetcode.cn/problems/range-sum-query-immutable/description/
*/


type NumMatrix struct {
	preSum [][]int
}


func Constructor(matrix [][]int) NumMatrix {
	// 初始化二维数组
	preSum := make([][]int, len(matrix) + 1)
	for i := 0; i < len(preSum); i++ {
		preSum[i] = make([]int, len(matrix[0]) + 1)
	}

	// 构建前缀和数组
	for i := 1; i < len(preSum); i ++ {
		for j := 1; j < len(preSum[0]); j++ {
			preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i - 1][j - 1] - preSum[i-1][j-1];
		}
	}
	return NumMatrix{preSum}
}


func (this *NumMatrix) SumRegion(row1 int, col1 int, row2 int, col2 int) int {
	return this.preSum[row2+1][col2+1] - this.preSum[row1][col2+1] - this.preSum[row2+1][col1] + this.preSum[row1][col1]
}
