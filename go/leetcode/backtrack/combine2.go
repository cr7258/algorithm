package main

/**
 * @description 77. 组合
 * @author chengzw
 * @since 2022/6/16
 * @link https://leetcode.cn/problems/combinations/
 */

/**
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
你可以按 任何顺序 返回答案。

示例 1：
输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

示例 2：
输入：n = 1, k = 1
输出：[[1]]
*/

/**
思路：
1.如果组合里有 1 ，那么需要在 [2, 3, 4] 里再找 1 个数；
2.如果组合里有 2 ，那么需要在 [3, 4] 里再找 1 数。注意：这里不能再考虑 1，因为包含 1 的组合，在第 1 种情况中已经包含。
3.依次类推（后面部分省略）。
*/
var result [][]int

func combine(n int, k int) [][]int {
	result = [][]int{}
	var path []int
	backtrack(n, k, 1, path)
	return result
}

func backtrack(n int, k int, step int, path []int) {
	// 如果找到 k 个数的组合
	if len(path) == k {
		temp := make([]int, k)
		copy(temp, path)
		result = append(result, temp)
		return
	}

	// 遍历可能的搜索起点
	//普通写法：for i := step, i <= n; i++
	//剪枝: 搜索起点的上界 + 接下来要选择的元素个数 - 1 = n -> 搜索起点的上界 = n - (k - path.size()) + 1
	for i := step; i <= n-(k-len(path))+1; i++ {
		// 向路径中添加一个数
		path = append(path, i)
		// 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
		backtrack(n, k, i+1, path)
		// 撤销选择
		path = path[:len(path)-1]
	}
}
