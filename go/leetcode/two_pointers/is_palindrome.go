package main

/**
 * @description 9. 回文数
 * @author chengzw
 * @since 2022/5/27
 * @link https://leetcode.cn/problems/palindrome-number/
 */

/**
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
例如，121 是回文，而 123 不是。

示例 1：
输入：x = 121
输出：true

示例 2：
输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3：
输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。
*/

/**
思路：
1.反转后半部分的数字，然后和前半部分进行比较。
例如，输入 1221，我们可以将数字 “1221” 的后半部分从 “21” 反转为 “12”，并将其与前半部分 “12” 进行比较，因为二者相同，我们得知数字 1221 是回文。
2.负数或者各位数为 0 时，不是回文数。
3.当原始数字小于或等于反转后的数字时，表示已经反转了一半的数字

时间复杂度：O(log n)，对于每次迭代，我们会将输入除以 10，因此时间复杂度为 O(logn)。
空间复杂度：O(1)。我们只需要常数空间存放若干变量。
*/
func isPalindrome(x int) bool {
	// 负数或者各位数为 0 时，不是回文数
	if x < 0 || x != 0 && x%10 == 0 {
		return false
	}

	// 当原始数字小于或等于反转后的数字时，表示已经反转了一半的数字
	reverseNum := 0
	for reverseNum < x {
		reverseNum = reverseNum*10 + x%10
		x /= 10
	}

	// 偶数位数和奇数位数
	return reverseNum == x || reverseNum/10 == x

}
