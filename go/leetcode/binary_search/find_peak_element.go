package main

import "fmt"

/**
* @description 162. 寻找峰值
* @author chengzw
* @since 2022/10/29
* @link https://leetcode.cn/problems/find-peak-element/
*/

/**
思路：
题目描述中出现了 nums[-1] = nums[n] = -∞，这就代表着只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
往递增的方向上，二分查找，一定能找到
时间复杂度: O(logn)
空间复杂度: O(1)
*/

func findPeakElement(nums []int) int {
	// len(nums) - 2 是为了防止 nums[mid + 1] 越界
	low, high := 0, len(nums) - 2
	for low <= high {
		mid := low + (high - low) / 2
		if nums[mid] > nums[mid + 1] {
			high = mid - 1
		}else {
			// 找到递增的最后一个值，+1 就得到峰值
			low = mid + 1
		}
	}
	return low
}

func main()  {
	nums := []int{1,2,10,9,11,2,4}
	result := findPeakElement(nums)
	fmt.Println(result)
}