package sort

import "sort"

/**
 * @author chengzw
 * @description 56. 合并区间
 * @link https://leetcode.cn/problems/merge-intervals/solution/he-bing-qu-jian-by-leetcode-solution/
 * @since 2022/5/20
 */

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */

/**
思路：
1.我们将列表中的区间按照左端点升序排序。然后我们将第一个区间加入 merged 数组中，并按顺序依次考虑之后的每个区间。
2.如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾。
3.否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。

时间复杂度：O(nlogn)，其中 n 为区间的数量。除去排序的开销，我们只需要一次线性扫描，所以主要的时间开销是排序的 O(nlogn)。
空间复杂度：O(logn)，其中 n 为区间的数量。这里计算的是存储答案之外，使用的额外空间。O(logn) 即为排序所需要的空间复杂度。

*/
func merge(intervals [][]int) [][]int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	var result [][]int
	result = append(result, intervals[0])
	for i := 1; i < len(intervals); i++ {
		L := intervals[i][0]
		R := intervals[i][1]
		if result[len(result)-1][1] < L {
			result = append(result, intervals[i])
		} else {
			result[len(result)-1][1] = max(result[len(result)-1][1], R)
		}
	}
	return result
}

func max(i, j int) int {
	if i > j {
		return i
	}
	return j
}
