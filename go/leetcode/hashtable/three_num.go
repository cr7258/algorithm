package main

import "sort"

/**
 * @description 15. 三数之和
 * @author chengzw
 * @since 2022/5/24
 * @link https://leetcode.cn/problems/3sum/
 */

/**
给你一个包含 n 个整数的数组 nums， 判断 nums 中是否存在三个元素 a， b， c， 使得 a + b + c = 0？ 请你找出所有和为 0 且不重复的三元组。
注意： 答案中不可以包含重复的三元组。

示例 1：
输入： nums = [-1, 0, 1, 2, -1, -4]
输出：[[-1, -1, 2], [-1, 0, 1]]

示例 2：
输入： nums = []
输出：[]

示例 3：
输入： nums = [0]
输出：[]
*/

/**
 * 思路：
 * 1.先对数组进行排序
 * 2.将数组的元素添加到哈希表中
 * 3.两个循环，第一个循环 i，第二个循环 j
 * 4.如果在哈希表存在元素等于 0-(i+j)，则添加 i,j,k
 *
 * 时间复杂度: O(n^2)
 * 时间复杂度: O(n)
 */
func threeSum(nums []int) [][]int {
	// 对数组进行排序
	sort.Ints(nums)
	// 存放结果
	var result [][]int
	// 将元素添加到哈希表中
	table := make(map[int]int)
	for i, num := range nums {
		table[num] = i
	}

	for i := 0; i < len(nums); i++ {
		//避免 i 重复，如果元素连续则跳过，避免重复添加
		if i != 0 && nums[i] == nums[i-1] {
			continue
		}
		//避免 j 重复，但是 j != i + 1 确保不能跳过第二个 -1，例如 [-1,-1,2]，
		for j := i + 1; j < len(nums); j++ {
			if j != i+1 && nums[j] == nums[j-1] {
				continue
			}
			k := -(nums[j] + nums[i])
			if index, ok := table[k]; ok {
				// 避免 [-4,2] 2 被重复使用
				if index > j {
					result = append(result, []int{nums[i], nums[j], k})
				}
			}
		}
	}
	return result
}
