package pure_program

/**
 * @description 14. 最长公共前缀
 * @author chengzw
 * @since 2022/5/28
 * @link https://leetcode.cn/problems/longest-common-prefix/
 */

/**
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。


示例 1：
输入：strs = ["flower","flow","flight"]
输出："fl"

示例 2：
输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
*/

/**
思路：
1.纵向扫描时，从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，如果相同则继续对下一列进行比较，
如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀。

时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
空间复杂度：O(1)。使用的额外空间复杂度为常数。
*/
func longestCommonPrefix(strs []string) string {
	// 最长公共前缀不会超过最短字段长度
	length := len(strs[0])
	// 数组长度
	count := len(strs)
	for i := 0; i < length; i++ {
		for j := 1; j < count; j++ {
			if i == len(strs[j]) || strs[j][i] != strs[0][i] {
				return strs[0][:i]
			}
		}
	}
	return strs[0]
}
