package main

import "fmt"

/**
 * @description 28. 实现 strStr()
 * @author chengzw
 * @since 2022/5/30
 * @link https://leetcode.cn/problems/implement-strstr/
 */

/**
实现 strStr() 函数。
给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。

说明：
当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr()以及 Java 的 indexOf()定义相符。

示例 1：
输入：haystack = "hello", needle = "ll"
输出：2

示例 2：
输入：haystack = "aaaaa", needle = "bba"
输出：-1
*/

func strStr(haystack string, needle string) int {
	// 主串长度
	n := len(haystack)
	// 模式串长度
	m := len(needle)
	// 失效函数
	next := getNexts(needle, m)
	// 模式串下标
	j := 0
	// i 是主串下标，一直前进，不会后退
	for i := 0; i < n; i++ {
		for j > 0 && haystack[i] != needle[j] {
			j = next[j-1] + 1
		}
		if haystack[i] == needle[j] {
			j++
		}
		// 找到匹配模式串了
		if j == m {
			return i - m + 1
		}
	}
	return -1
}

// needle 模式串，m 模式串长度
func getNexts(needle string, m int) []int {
	next := make([]int, m)
	// next[0] 表示好前缀的尾字符下标是 0 的时候，也即好前缀长度为 1 的时候，
	// 好前缀没有前缀子串、后缀子串，所以赋值为 -1，表示这时的好前缀不存在公共子串。
	next[0] = -1
	k := -1
	for i := 1; i < m; i++ {
		// 当模式串的子串长度后移一位，如果之前最长可匹配前缀子串的下标加一对应的字符和最后一位字符不相等，此时最长可匹配前缀子串长度将会减少
		// 判断后移一位之前最长可匹配前缀子串的最长可匹配前缀子串的下标加一是否和最后一位字符相等，直到 k=-1，
		// 如果相等，那么就是下面的逻辑，k+1 就是模式串子串的最长可匹配前缀子串的下标。
		for k != -1 && needle[k+1] != needle[i] {
			k = next[k]
		}
		if needle[k+1] == needle[i] {
			k++
		}
		next[i] = k
	}
	return next
}

func main() {
	//result1 := strStr("hello", "ll")
	//fmt.Println(result1)
	result2 := strStr("ccababacd", "ababacd")
	fmt.Println(result2)
	//result3 := strStr("mississippi", "issip")
	//fmt.Println(result3)
}
