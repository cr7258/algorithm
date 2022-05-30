package main

/**
 * @description
 * @author chengzw
 * @since 2022/5/30
 * @link
 */
func strStr(haystack string, needle string) int {
	if len(needle) > len(haystack) {
		return -1
	}
	// 遍历 haystack 字符串，一直往后走
	i := 0
	// 遍历 needle 字符串，当和 haystack 字符不匹配时，置为 0，重新匹配
	j := 0
	for i < len(haystack)-1 {
		if haystack[i] != needle[j] {
			j = 0
		} else {
			j++
		}
		i++
	}
	if j == 0 {
		return -1
	}
	return i - j
}
