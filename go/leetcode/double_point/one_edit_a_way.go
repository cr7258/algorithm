package main

import (
	"math"
)

/**
字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
leetcode: https://leetcode.cn/problems/one-away-lcci/submissions/
思路：
1.两个字符长度不能超过 1
2.按照字符依次往后比较，允许有1次不同（插入或者删除）
3.当发现不同时，后面的字符必须完全相同
*/
func oneEditAway(first string, second string) bool {
	n := len(first)
	m := len(second)

	if math.Abs(float64(n-m)) > 1 {
		return false
	}

	// 两个字符串的指针
	i := 0
	j := 0
	// 当第一次遇到字符不相同时，会跳出循环
	for i < n && j < m && first[i] == second[j] {
		i++
		j++
	}
	// 如果字符串长度相等，继续走
	// 如果两个字符串长度不同，插入或者删除字符，长的字符串的指针往前走一步
	if n == m {
		i++
		j++
	} else if n > m {
		i++
	} else {
		j++
	}

	// 继续循环，之后的每个字符必须相同
	for i < n && j < m {
		if first[i] != second[j] {
			return false
		}
		i++
		j++
	}
	return true
}

func oneEditAway2(first, second string) bool {
	n, m := len(first), len(second)
	if m > n {
		return oneEditAway2(second, first)
	}
	if n-m > 1 {
		return false
	}
	for i, ch := range second {
		if first[i] != byte(ch) {
			if n == m {
				return first[i+1:] == second[i+1:]
			}
			return first[i+1:] == second[i:]
		}
	}
	return true
}

func main() {
	oneEditAway2("happy", "happ")
}
