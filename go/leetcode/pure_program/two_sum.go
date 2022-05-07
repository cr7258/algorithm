package main

import "fmt"

/**
给定一个整数数组 nums 和一个整数目标值 target，在该数组中找出 和为目标值 target  的 两个 整数，并返回它们的数组下标。
假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。可以按任意顺序返回答案。

例如：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]

输入：nums = [3,3], target = 6
输出：[0,1]
*/

func twoSum(nums []int, target int) []int {
	//创建一个 map，对于每一个 num，首先查询 map 中是否存在 target-num
	//如果不存在，将 num 插入到 map 中
	//如果存在，将 num 的下标 i 和 target-num 的下标一起返回
	resultMap := make(map[int]int)
	for i, v := range nums {
		if resultMap[target-v] != 0 {
			return []int{i, resultMap[target-v]}
		}
		if j, isPresent := resultMap[target-v]; isPresent {
			return []int{j, i}
		}
		resultMap[v] = i
	}
	return nil
}

func main() {
	nums := []int{2, 7, 11, 15}
	target := 9
	fmt.Println(twoSum(nums, target))
}
