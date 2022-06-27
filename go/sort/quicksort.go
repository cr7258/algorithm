package main

import "fmt"

/**
 * @description 快速排序
 * @author chengzw
 * @since 2022/6/27
 */

/**
思路：
1.首先设定一个分界值 pivot，通过该分界值将数组分成左右两个部分。
2.将大于或等于分界值的数据集中到数组右边，小于或等于分界值的数据集中到数组的左边。
3.接着，左边和右边的数据可以独立排序；对于左侧的数据，又可以取一个分界值，将该部分数据分成左右两部分，同样在左边放置较小值，右边放置较大值。右边的数据也做类似的处理。
4.重复上述过程。

时间复杂度：O(nlogn)
空间复杂度：O(1)
稳定性：否

参考题解：https://www.algomooc.com/1135.html
*/
func quicksort(nums []int, left int, right int) {
	// 如果 left 大于等于 right，说明该区间只有 1 个或者没有元素
	if left >= right {
		return
	}
	// 调用函数 partition，将 left 和 right 之间的元素划分为左右两部分
	mid := partition(nums, left, right)
	// 划分之后，再对 mid 左侧的元素进行快速排序
	quicksort(nums, left, mid-1)
	// 划分之后，再对 mid 右侧的元素进行快速排序
	quicksort(nums, mid+1, right)
}

func partition(nums []int, left int, right int) int {
	// 设置当前区间的第一个元素为基准元素
	pivot := nums[left]
	// left 向右移动，right 向左移动，直到 left 和 right 指向同一元素为止
	// 移动过程中将小于 pivot 的放在左边，大于 pivot 的放在右边
	for left < right {
		for left < right && nums[right] >= pivot {
			right--
		}
		// 将比 pivot 小的元素移动到左侧
		nums[left] = nums[right]

		for left < right && nums[left] <= pivot {
			left++
		}
		// 将比 pivot 大的元素移动到右侧
		nums[right] = nums[left]
	}
	// 此时，left 和 right 相遇，那么需要将此时的元素设置为 pivot
	// 这个时候，pivot 的左侧元素都小于它，右侧元素都大于它
	nums[left] = pivot
	return left
}

func main() {
	nums := []int{1, 3, 5, 2, 4, 5}
	quicksort(nums, 0, len(nums)-1)
	fmt.Println(nums)
}
