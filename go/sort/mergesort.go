package main

import "fmt"

/**
 * @description 归并排序
 * @author chengzw
 * @since 2022/6/27
 */

/**
思路：
1.先把待排序的序列从中间分成前后两部分，然后对前后两部分分别排序，再将排好序的两部分合并在一起。使用的分治思想。
2.result 数组用于临时存放排序的数字

时间复杂度：O(nlogn)
空间复杂度：O(n)
稳定性：是

参考题解：https://www.algomooc.com/1280.html
*/
func mergesort(nums []int, result []int, left int, right int) {
	// 分解到最小的地步了
	if left >= right {
		return
	}

	mid := left + (right-left)/2
	// 分成左右两个区间
	left1 := left
	right1 := mid
	left2 := mid + 1
	right2 := right

	// 将 left1 ~ right1 这一区间的数字排好序，放入 result 中
	mergesort(nums, result, left1, right1)
	// 将 left2 ~ right2 这一区间的数字排好序，放入 result 中
	mergesort(nums, result, left2, right2)

	// 合并
	// 将左右区间中较小的数字存放到 result 中
	k := left
	for left1 <= right1 && left2 <= right2 {
		if nums[left1] < nums[left2] {
			result[k] = nums[left1]
			left1++
			k++
		} else {
			result[k] = nums[left2]
			left2++
			k++
		}
	}
	// 如果左区间中还有元素，那么把它都添加到 result 中
	for left1 <= right1 {
		result[k] = nums[left1]
		left1++
		k++
	}
	// 如果右区间中还有元素，那么把它都添加到 result 中
	for left2 <= right2 {
		result[k] = nums[left2]
		left2++
		k++
	}

	// 最后把 result 中临时存储的结果复制到 nums 数组中
	for i := left; i <= right; i++ {
		nums[i] = result[i]
	}
}

func main() {
	nums := []int{5, 2, 4, 5, 2, 3, 4}
	n := len(nums)
	result := make([]int, n)
	mergesort(nums, result, 0, len(nums)-1)
	fmt.Println(nums)
}
