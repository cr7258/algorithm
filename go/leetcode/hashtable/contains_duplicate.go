package main

/**
 * @author chengzw
 * @description 217. 存在重复元素
 * @link https://leetcode.cn/problems/contains-duplicate/
 * @since 2022/6/4
 */

/**
给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。

示例 1：
输入：nums = [1,2,3,1]
输出：true

示例 2：
输入：nums = [1,2,3,4]
输出：false

示例 3：
输入：nums = [1,1,1,3,3,4,3,2,4,2]
输出：true
*/

/**
思路：
对于数组中每个元素，我们将它插入到哈希表中。如果插入一个元素时发现该元素已经存在于哈希表中，则说明存在重复的元素。
时间复杂度：O(n)，其中 n 为数组的长度。
空间复杂度：O(n)，其中 n 为数组的长度。
*/
func containsDuplicate(nums []int) bool {
	set := map[int]bool{}
	for _, n := range nums {
		if _, ok := set[n]; ok {
			return true
		}
		set[n] = true
	}
	return false
}
