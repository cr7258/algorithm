package pure_program

import "strings"

/**
 * @description https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/submissions/
 * @author chengzw
 * @since 2022/7/2
 * @link 剑指 Offer 58 - I. 翻转单词顺序
 */

/**
输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

示例 1：
输入: "the sky is blue"
输出: "blue is sky the"

示例 2：
输入: " hello world! "
输出:"world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

示例 3：
输入: "a good  example"
输出:"example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
*/

/**
思路：
1.根据空格拆分单词，放到数组中
2.从后往前的顺序将数组中的元素拼接到字符串中

时间复杂度：O(n)
空间复杂度：O(n)
*/
func reverseWords(s string) string {
	newString := strings.Split(s, " ")
	ans := ""
	for i := len(newString) - 1; i >= 0; i-- {
		if newString[i] != "" {
			ans += newString[i] + " "
		}
	}
	ans = strings.Trim(ans, " ")
	return ans
}
