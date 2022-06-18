package main

import "fmt"

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
思路：按照每一个数选与不选画出二叉树

参考题解：
https://leetcode.cn/problems/combinations/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-hui-s-0uql/
https://leetcode.cn/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
*/
var result [][]int

func combine(n int, k int) [][]int {
	result = [][]int{}
	backtrack(n, k, 1, []int{})
	return result
}

func backtrack(n int, k int, step int, path []int) {
	// 找到 k 个数，加到结果数组中
	if len(path) == k {
		// 拷贝一下，防止 path 改变添加到结果数组中的值
		temp := make([]int, k)
		copy(temp, path)
		result = append(result, temp)
		return
	}

	// 递归终止条件
	if step > n {
		return
	}

	// 可选列表，选或者不选，这里就不用 for 循环可选列表了
	// 1.不选
	backtrack(n, k, step+1, path)
	// 2.选
	path = append(path, step)
	//fmt.Println("递归之前: ", path)
	backtrack(n, k, step+1, path)
	path = path[:len(path)-1] // 撤销选择
	//fmt.Println("递归之后: ", path)
}

func main() {
	result := combine(5, 4)
	fmt.Println(result)
}
