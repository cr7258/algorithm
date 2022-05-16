package main

/**
 * @description 二分查找
 * @author chengzw
 * @since 2022/5/15
 * @link https://leetcode.cn/problems/binary-search/
 */

/**
给定一个 n 个元素有序的（ 升序） 整型数组 nums 和一个目标值 target，
写一个函数搜索 nums 中的 target， 如果目标值存在返回下标， 否则返回 -1。

示例 1:
输入: nums = [-1, 0, 3, 5, 9, 12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4

示例 2:
输入: nums = [-1, 0, 3, 5, 9, 12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 - 1
*/

/**
标准二分查找
时间复杂度：O(logn)，其中 n 是数组的长度。
空间复杂度：O(1)。
*/
func search(nums []int, target int) int {
	low, high := 0, len(nums)-1
	for low <= high {
		// mid := (low + high) / 2 // 存在整型越界问题
		// mid := low + (high-low) /2   // 改进写法
		mid := low + (high-low)>>1 // 牛逼写法
		if nums[mid] == target {
			return mid
		} else if nums[mid] > target {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}
	return -1
}
