package main

/**
给定一个长度为 n 的整数数组 height。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
返回容器可以储存的最大水量。
说明：你不能倾斜容器。
leetcode: https://leetcode.cn/problems/container-with-most-water

*/

/**
暴力解法：会超时
时间复杂度: O(N^2)
空间复杂度: O(1)
*/
func maxArea1(height []int) int {
	maxarea := 0
	for i := 0; i < len(height); i++ {
		for j := i + 1; j < len(height); j++ {
			maxarea = max(maxarea, min(height[i], height[j])*(j-i))
		}
	}
	return maxarea
}
func min(x, y int) int {
	if x > y {
		return y
	}
	return x
}
func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

/**
思路：
1.相同情况下两边远越越好
2.左右指针分别从两边出发，每次移动较短的指针，判断面积是否增大
*/
func maxArea2(height []int) int {
	maxarea := 0
	i := 0
	j := len(height) - 1
	for i < j {
		maxarea = max(maxarea, min(height[i], height[j])*(j-i))
		if height[i] < height[j] {
			i++
		} else {
			j--
		}
	}
	return maxarea
}
