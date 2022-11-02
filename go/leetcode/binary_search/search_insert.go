package main

/**
* @description 35. 搜索插入位置
* @author chengzw
* @since 2022/11/02
* @link https://leetcode.cn/problems/search-insert-position/description/
*/

/**
思路：查找第⼀个⼤于等于给定值的元素
时间复杂度：O(logn)
空间复杂度：O(1)。
*/

func searchInsert(nums []int, target int) int {
    low, high := 0, len(nums) - 1
    for low <= high {
        mid := low + (high - low) / 2
        if nums[mid] == target {
            return mid
        }else if nums[mid] > target {
            high = mid - 1
        }else {
            low = mid + 1
        }
    }
	// 此时 low >= high, 那么插入的位置就是 high 的下一个
    return high + 1
}