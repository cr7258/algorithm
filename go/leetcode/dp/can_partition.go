package main

/**
 * @description
 * @author chengzw
 * @since 2022/6/21
 * @link
 */

func canPartition(nums []int) bool {
	n := len(nums)
	sum := 0
	for i := 0; i < n; i++ {
		sum += nums[i]
	}

	// 如果和的一半是奇数，直接返回 false
	if sum%2 == 1 {
		return false
	}

	sum /= 2
	// dp 数组，dp[i][j] 表示第 i 个物品决策完以后，背包中物品重量是否可以达到为 j
	dp := make([][]bool, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]bool, sum+1)
	}
	// 初始化第一行
	dp[0][0] = true
	if nums[0] <= sum {
		dp[0][nums[0]] = true
	}
	// 状态转移方程
	for i := 1; i < n; i++ {
		for j := 0; j <= sum; j++ {
			if j-nums[i] >= 0 {
				// 装或者不装背包
				dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
			} else {
				// 超过限额，无法装入背包
				dp[i][j] = dp[i-1][j]
			}
		}
	}
	return dp[n-1][sum]
}
