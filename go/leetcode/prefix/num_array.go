package main

/**
 * @description 304. 二维区域和检索 - 矩阵不可变
 * @author chengzw
 * @since 2022/11/22
 * @link https://leetcode.cn/problems/range-sum-query-2d-immutable/description/
 */

/**
思路：
空间换时间
维护一个二维 preSum 数组，专门记录以原点为顶点的矩阵的元素之和，就可以用几次加减运算算出任何一个子矩阵的元素和
https://labuladong.github.io/algo/2/20/24/

时间复杂度：O(1)
空间复杂度：O(n)
*/

type NumArray struct {
	preSum []int
}

func Constructor(nums []int) NumArray {
	preSum := make([]int, len(nums)+1)
	for i := 1; i < len(preSum); i++ {
		preSum[i] = preSum[i-1] + nums[i-1]
	}
	return NumArray{preSum}
}

func (this *NumArray) SumRange(left int, right int) int {
	return this.preSum[right+1] - this.preSum[left]
}

/**
* Your NumArray object will be instantiated and called as such:
* obj := Constructor(nums);
* param_1 := obj.SumRange(left,right);
 */
