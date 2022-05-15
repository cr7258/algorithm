package greedy

/**
 * @description 45. 跳跃游戏 II
 * @author chengzw
 * @since 2022/5/15
 * @Link https://leetcode.cn/problems/jump-game-ii/
 */

/**
给你一个非负整数数组 nums， 你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
你的目标是使用最少的跳跃次数到达数组的最后一个位置。
假设你总是可以到达数组的最后一个位置。

示例 1:
输入: nums = [2, 3, 1, 1, 4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
从下标为 0 跳到下标为 1 的位置， 跳 1 步， 然后跳 3 步到达数组的最后一个位置。

示例 2:
输入: nums = [2, 3, 0, 1, 4]
输出: 2
*/

/**
思路：贪心算法，反向查找出发位置
1.选择距离最后一个位置最远的那个位置，也就是对应下标最小的那个位置。从左到右遍历数组，选择第一个满足要求的位置。
2.依次类推，指到找到数组的开始位置。

时间复杂度：O(n^2)， 其中 n 是数组长度。有两层嵌套循环，在最坏的情况下，例如数组中的所有元素都是 1， position 需要遍历数组中的每个位置， 对于 position 的每个值都有一次循环。
空间复杂度：O(1)。
*/
func jump(nums []int) int {
	position := len(nums) - 1
	step := 0
	for position > 0 {
		// 从左到右遍历数组，选择第一个满足要求的位置
		for i := 0; i < position; i++ {
			if i+nums[i] >= position {
				position = i
				step++
				break
			}
		}
	}
	return step
}

/**
思路：贪心算法，正向查找可到达的最大位置
1.正向查找，每次找到可到达的最远位置，就可以在线性时间内得到最少的跳跃次数。
2.例如，对于数组 [2,3,1,2,4,2,3]，初始位置是下标 0，从下标 0 出发，最远可到达下标 2。
下标 0 可到达的位置中，下标 1 的值是 3，从下标 1 出发可以达到更远的位置，因此第一步到达下标 1。
3.maxPosition 维护当前能够达到的最大下标位置，记为边界。从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1。
4.不用访问最后一个元素，因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置

时间复杂度：O(n)，其中 n 是数组长度。
空间复杂度：O(1)。
*/
func jump2(nums []int) int {
	maxPosition := 0 // 边界
	step := 0
	end := 0 // 上一个边界
	for i := 0; i < len(nums)-1; i++ {
		maxPosition = max(maxPosition, i+nums[i])
		if i == end {
			end = maxPosition
			step++
		}
	}
	return step
}

func max(x int, y int) int {
	if x >= y {
		return x
	} else {
		return y
	}
}
