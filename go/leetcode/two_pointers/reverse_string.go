package main

/**
 * @description 344. 反转字符串
 * @author chengzw
 * @since 2022/6/6
 * @link https://leetcode.cn/problems/reverse-string/
 */

/**
编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

示例 1：
输入：s = ["h","e","l","l","o"]
输出：["o","l","l","e","h"]

示例 2：
输入：s = ["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]
*/

/**
思路：双指针
1.指针 left 从左往右遍历，指针 right 从右往左遍历
2.交换 left 和 right 的元素

时间复杂度：O(n)
空间复杂度：O(1)
*/
func reverseString(s []byte) {
	for left, right := 0, len(s)-1; left < right; left++ {
		// go 语言交换元素很方便
		s[left], s[right] = s[right], s[left]
		right--
	}
}
