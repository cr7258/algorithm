package main

import "fmt"

/**
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例 1:
输入：s = "abaccdeff"
输出：'b'

示例 2:
输入：s = ""
输出：' '

leetcode: https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/

思路：使用哈希表存储频数
1.对字符串进行两次遍历
2.第一次遍历时，使用哈希表存储字符串中每个字符出现的次数 [a:1, b:2]
3.第二次遍历时，遍历到出现一次的字符就返回该字符

时间复杂度: O(N)
空间复杂度: O(E)，E 是字符集，小于 26
*/
func firstUniqChar(s string) byte {
	frequency := [26]int{}
	for _, ch := range s {
		frequency[ch-'a']++
	}
	for i, ch := range s {
		if frequency[ch-'a'] == 1 {
			return s[i]
		}
	}
	return ' '
}

func firstUniqChar2(s string) byte {
	frequency := make(map[byte]int)
	for _, ch := range s {
		frequency[byte(ch-'a')]++
	}
	for i, ch := range s {
		if frequency[byte(ch-'a')] == 1 {
			return s[i]
		}
	}
	return ' '
}

/**
思路：使用哈希表存储索引
1.哈希表中的键表示一个字符，值表示它首次出现的索引，如果是 -1 表示该字符出现了多次
2.当第一次遍历字符串时，如果当前字符不在哈希表中，就将该字符和索引存入哈希表，否则将该字符在哈希表中的映射修改为 -1
3.第二次遍历哈希表中的所有值，找出值不为 -1 的最小值即可

时间复杂度：O(n)，其中 n 是字符串 s 的长度。第一次遍历字符串的时间复杂度为 O(n)，
第二次遍历哈希映射的时间复杂度为 O(∣Σ∣)，由于 s 包含的字符种类数一定小于 s 的长度，因此 O(∣Σ∣) 在渐进意义下小于 O(n)，可以忽略。
空间复杂度：O(∣Σ∣)，其中 Σ 是字符集，在本题中 s 只包含小写字母，因此 ∣Σ∣≤26。我们需要 O(∣Σ∣) 的空间存储哈希映射。

*/
func firstUniqChar3(s string) byte {
	position := make(map[byte]int)
	for i, ch := range s {
		// 判断 position 中是否含有字符
		if _, ok := position[byte(ch-'a')]; ok {
			position[byte(ch-'a')] = -1
		} else {
			position[byte(ch-'a')] = i
		}
	}
	first := len(s)
	for _, pos := range position {
		if pos != -1 && first > pos {
			first = pos
		}
	}
	if first == len(s) {
		return ' '
	} else {
		return s[first]
	}
}

func main() {
	fmt.Println(firstUniqChar3("loveleetcode"))
}
