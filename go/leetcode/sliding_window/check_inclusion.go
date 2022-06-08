package sliding_window

/**
 * @author chengzw
 * @description 567. 字符串的排列
 * @link https://leetcode.cn/problems/permutation-in-string/
 * @since 2022/6/8
 */

/**
给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
换句话说，s1 的排列之一是 s2 的 子串 。

示例 1：
输入：s1 = "ab" s2 = "eidbaooo"
输出：true
解释：s2 包含 s1 的排列之一 ("ba").

示例 2：
输入：s1= "ab" s2 = "eidboaoo"
输出：false
*/

/**
1.用两个数组分别记录 s1 和 s2 中字符出现的次数
2.s2 的数组往后滑动比较

时间复杂度：O(n)
空间复杂度：O(1)
*/

func checkInclusion(s1 string, s2 string) bool {
	n, m := len(s1), len(s2)
	if m < n {
		return false
	}
	var cnt1, cnt2 [26]int

	// 记录两个字符串中每个字符出现的次数
	for i := 0; i < n; i++ {
		cnt1[s1[i]-'a']++
		cnt2[s2[i]-'a']++
	}
	// 先比较 s2 和 s1 相同长度部分的字符是否相等
	if cnt1 == cnt2 {
		return true
	}
	// 滑动比较，s2 往后移动
	for i := n; i < m; i++ {
		cnt2[s2[i]-'a']++
		cnt2[s2[i-n]-'a']--
		if cnt1 == cnt2 {
			return true
		}
	}
	return false
}
