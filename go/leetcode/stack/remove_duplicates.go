package stack

/**
 * @description 1047. 删除字符串中的所有相邻重复项
 * @author chengzw
 * @since 2022/6/1
 * @link https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
 */

/**
给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
在 S 上反复执行重复项删除操作，直到无法继续删除。
在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

示例：
输入："abbaca"
输出："ca"

解释：
例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
*/

/**
思路：
1.一旦新来的字符和栈顶的字符一样的话，就弹出栈顶字符，直至扫完整个字符串。栈中剩下的字符串就是最终要输出的结果。

时间复杂度：O(n)
空间复杂度：O(1)
*/
func removeDuplicates(s string) string {
	stack := []rune{}
	for _, c := range s {
		if len(stack) == 0 || stack[len(stack)-1] != c {
			stack = append(stack, c)
		} else {
			stack = stack[:len(stack)-1]
		}
	}
	return string(stack)
}
