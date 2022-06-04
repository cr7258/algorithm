package binary_tree

/**
 * @author chengzw
 * @description 278. 第一个错误的版本
 * @link https://leetcode.cn/problems/first-bad-version/
 * @since 2022/6/4
 */

/**
你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。

示例 1：
输入：n = 5, bad = 4
输出：4
解释：
调用 isBadVersion(3) -> false
调用 isBadVersion(5) -> true
调用 isBadVersion(4) -> true
所以，4 是第一个错误的版本。

示例 2：
输入：n = 1, bad = 1
输出：1
*/

/**
 * 思路：二分查找
 * 1.如果该版本是错误版本，则第一个错误版本必然位于该版本及该版本的左侧
 * 2.如果该版本是正确版本，那么第一个错误版本必然位于该版本的右侧
 * 3.当 low == high，区间缩为一个点，即为答案
 *
 * 时间复杂度：O(logn)，其中 n 是给定版本的数量。
 * 空间复杂度：O(1)。我们只需要常数的空间保存若干变量。
 */
func firstBadVersion(n int) int {
	low, high := 0, n
	for low < high {
		mid := low + (high-low)/2
		if isBadVersion(mid) {
			high = mid // 如果该版本是错误版本，则第一个错误版本必然位于该版本及该版本的左侧
		} else {
			low = mid + 1 // 如果该版本是正确版本，那么第一个错误版本必然位于该版本的右侧
		}
	}
	// 当 low == high，区间缩为一个点，即为答案
	return low
}

func isBadVersion(version int) bool {
	//TODO
	return true
}
