package main
/**
* @description 34. 在排序数组中查找元素的第一个和最后一个位置
* @author chengzw
* @since 2022/11/05
* @link https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
*/

/**
思路：
查找第⼀个值等于给定值的元素，查找最后⼀个值等于给定值的元素

时间复杂度：O(logn)
空间复杂度：O(1)。
*/

func searchRange(nums []int, target int) []int {
	low, high := 0, len(nums) - 1
	left := -1
	for low <= high {
		mid := low + (high - low) / 2
		if nums[mid] == target {
			// 查找第一个值等于给定值的元素
			if mid == 0 || nums[mid-1] != target {
				left = mid
				break
			}
			high = mid - 1
		}else if nums[mid] > target{
			high = mid -1
		}else {
			low = mid + 1
		}
	}


	low, high = 0, len(nums) - 1
	right := -1
	for low <= high {
		mid := low + (high - low) / 2
		if nums[mid] == target {
			// 查找最后一个值等于给定值的元素
			if mid == len(nums) - 1 || nums[mid+1] != target {
				right = mid
				break
			}
			low = mid + 1
		}else if nums[mid] > target {
			high = mid - 1
		}else {
			low = mid + 1
		}
	}

	return []int{left, right}
}