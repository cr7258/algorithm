# 算法练习
## 哈希表
|题目|解法|难度|时间复杂度|空间复杂度|
|---|---|---|---|---|
|[剑指 Offer 50. 第一个只出现一次的字符](https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/) | [Go](go/leetcode/hashtable/first_uniq_char.go)<br> [Java](java/src/leetcode/hashtable/FirstUniqChar.java)  | 简单| O(n)  | O(1)   | 
|[146. LRU 缓存](https://leetcode.cn/problems/lru-cache/) | [Go](go/leetcode/hashtable/lru_cache.go)<br> [Java](java/src/leetcode/hashtable/LRUCache.java)  | 中等| O(1)  | O(1)   | 
|[13. 罗马数字转整数](https://leetcode.cn/problems/roman-to-integer/) | [Go](go/leetcode/hashtable/roman_to_Int.go)<br> [Java](java/src/leetcode/hashtable/RomanToInt.java)  | 中等| O(n)  | O(1)   | 
|[1. 两数之和](https://leetcode.cn/problems/two-sum/) | [Go](go/leetcode/hashtable/two_sum.go)<br> [Java](java/src/leetcode/hashtable/TwoSum.java)  | 中等| O(n)  | O(n)   |
|[15. 三数之和](https://leetcode.cn/problems/3sum/) | [Go](go/leetcode/hashtable/three_num.go)<br> [Java](java/src/leetcode/hashtable/ThreeSum.java)  | 中等| O(n^2)  | O(n)   |
|[217. 存在重复元素](https://leetcode.cn/problems/contains-duplicate/) | [Go](go/leetcode/hashtable/contains_duplicate.go)<br> [Java](java/src/leetcode/hashtable/ContainsDuplicate.java)  | 简单| O(n)  | O(n)   |

## 双指针
题目|解法|难度|时间复杂度|空间复杂度|
|---|---|---|---|---|
|[盛最多水的容器](https://leetcode.cn/problems/container-with-most-water) | [Go](go/leetcode/two_pointers/max_area.go) | 中等| O(n)  | O(1)   | 
|[面试题 01.05. 一次编辑](https://leetcode.cn/problems/one-away-lcci/submissions/) | [Go](go/leetcode/two_pointers/one_edit_a_way.go) | 简单| O(m+n)  | O(1)   | 
|[9. 回文数](https://leetcode.cn/problems/palindrome-number/) | [Go](go/leetcode/two_pointers/is_palindrome.go)<br> [Java](java/src/leetcode/two_pointers/IsPalindromeNum.java) | 简单| O(logn)  | O(1)   | 
|[27. 移除元素](https://leetcode.cn/problems/remove-element/) | [Go](go/leetcode/two_pointers/remove_element.go)<br> [Java](java/src/leetcode/two_pointers/RemoveElement.java) | 简单| O(n)  | O(1)   |
|[344. 反转字符串](https://leetcode.cn/problems/reverse-string/) | [Go](go/leetcode/two_pointers/reverse_string.go)<br> [Java](java/src/leetcode/two_pointers/ReverseString.java) | 简单| O(n)  | O(1)   |
|[557. 反转字符串中的单词 III](https://leetcode.cn/problems/reverse-words-in-a-string-iii/) | [Go](go/leetcode/two_pointers/reverse_word.go)<br> [Java](java/src/leetcode/two_pointers/ReverseWords.java) | 简单| O(n)  | O(n)   |

## 链表
|题目|解法|难度|时间复杂度|空间复杂度|
|---|---|---|---|---|
|[203. 移除链表元素](https://leetcode.cn/problems/remove-linked-list-elements/) | [Go](go/leetcode/linkedlist/remove_elements.go)<br> [Java](java/src/leetcode/linkedlist/RemoveElements.java)  | 简单| O(n)  | O(1)   | 
|[876. 链表的中间结点](https://leetcode.cn/problems/middle-of-the-linked-list/) | [Go](go/leetcode/linkedlist/middle_node.go)<br> [Java](java/src/leetcode/linkedlist/MiddleNode.java)  | 简单| O(n)  | O(1)   |
|[83. 删除排序链表中的重复元素](https://leetcode.cn/problems/remove-duplicates-from-sorted-list/) | [Go](go/leetcode/linkedlist/delete_duplicates.go)<br> [Java](java/src/leetcode/linkedlist/DeleteDuplicates.java)  | 简单| O(n)  | O(1)   |
|[剑指 Offer 25. 合并两个排序的链表](https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/) | [Go](go/leetcode/linkedlist/merge_two_lists.go)<br> [Java](java/src/leetcode/linkedlist/MergeTwoLists.java)  | 简单| O(n+m)  | O(1)   |
|[2. 两数相加](https://leetcode.cn/problems/add-two-numbers/) | [Go](go/leetcode/linkedlist/add_two_numbers.go)<br> [Java](java/src/leetcode/linkedlist/AddTwoNumbers.java)  | 中等| O(n+m)  | O(1)   |
|[206. 反转链表](https://leetcode.cn/problems/reverse-linked-list/) | [Go](go/leetcode/linkedlist/reverse_list.go)<br> [Java](java/src/leetcode/linkedlist/ReverseList.java)  | 中等| O(n)  | O(1)   |
|[328. 奇偶链表](https://leetcode.cn/problems/odd-even-linked-list/) | [Go](go/leetcode/linkedlist/odd_even_list.go)<br> [Java](java/src/leetcode/linkedlist/OddEvenList.java)  | 中等| O(n)  | O(1)   |
|[19. 删除链表的倒数第 N 个结点](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/) | [Go](go/leetcode/linkedlist/remove_nth_from_end.go)<br> [Java](java/src/leetcode/linkedlist/RemoveNthFromEnd.java)  | 中等| O(n)  | O(1)   |
|[25. K 个一组翻转链表](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/) | [Go](go/leetcode/linkedlist/reverse_k_group.go)<br> [Java](java/src/leetcode/linkedlist/ReverseKGroup.java)  | 困难| O(n)  | O(1)   |
|[160. 相交链表](https://leetcode.cn/problems/intersection-of-two-linked-lists/) | [Go](go/leetcode/linkedlist/get_intersection_node.go)<br> [Java](java/src/leetcode/linkedlist/GetIntersectionNode.java)  | 简单| O(m+n)  | O(1)   |
|[141. 环形链表](https://leetcode.cn/problems/linked-list-cycle/) | [Go](go/leetcode/linkedlist/has_cycle.go)<br> [Java](java/src/leetcode/linkedlist/HasCycle.java)  | 简单| O(n)  | O(1)   |

## 栈
|题目|解法|难度|时间复杂度|空间复杂度|
|---|---|---|---|---|
|[剑指 Offer 09. 用两个栈实现队列](https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/) | [Go](go/leetcode/stack/c_queue.go)<br> [Java](java/src/leetcode/stack/CQueue.java)  | 简单|  O(1) | O(n)   |
|[面试题 03.05. 栈排序](https://leetcode.cn/problems/sort-of-stacks-lcci/) | [Go](go/leetcode/stack/sorted_stack.go)<br> [Java](java/src/leetcode/stack/SortedStack.java)  | 中等 |  O(1) | O(n)   |
|[155. 最小栈](https://leetcode.cn/problems/min-stack/) | [Go](go/leetcode/stack/min_stack.go)<br> [Java](java/src/leetcode/stack/MinStack.java)  | 简单|  O(1) | O(n)   |
|[20. 有效的括号](https://leetcode.cn/problems/valid-parentheses/) | [Go](go/leetcode/stack/is_valid.go)<br> [Java](java/src/leetcode/stack/IsValid.java)  | 简单|  O(n) | O(1)   |
|[面试题 16.26. 计算器](https://leetcode.cn/problems/calculator-lcci/) | [Go](go/leetcode/stack/calculate.go)<br> [Java](java/src/leetcode/stack/Calculate.java)  | 中等|  O(n) | O(n)   |
|[1047. 删除字符串中的所有相邻重复项](https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/) | [Go](go/leetcode/stack/remove_duplicates.go)<br> [Java](java/src/leetcode/stack/RemoveDuplicates.java)  | 简单|  O(n) | O(1)   |
|[739. 每日温度](https://leetcode.cn/problems/daily-temperatures/) | [Go](go/leetcode/stack/daily_temperatures.go)<br> [Java](java/src/leetcode/stack/DailyTemperatures.java)  | 中等|  O(n) | O(n)   |

## 队列
|题目|解法|难度|时间复杂度|空间复杂度|
|---|---|---|---|---|
|[225. 用队列实现栈](https://leetcode.cn/problems/implement-stack-using-queues/) | [Go](go/leetcode/queue/my_stack.go)<br> [Java](java/src/leetcode/queue/MyStack2.java)  | 简单|  O(1) | O(n)   |


## 排序
|题目|解法|难度|时间复杂度|空间复杂度|
|---|---|---|---|---|
|[56. 合并区间](https://leetcode.cn/problems/merge-intervals/) | [Go](go/leetcode/sort/merge.go)<br> [Java](java/src/leetcode/sort/Merge.java)  | 简单| O(nlogn)  |O(logn)   |
|[977. 有序数组的平方](https://leetcode.cn/problems/squares-of-a-sorted-array/) | [Go](go/leetcode/sort/sorted_squares.go)<br> [Java](java/src/leetcode/sort/SortedSquares.java)  | 简单| O(n)  |O(1)   |

## 递归
|题目|解法|难度|时间复杂度|空间复杂度|
|---|---|---|---|---|
|[70. 爬楼梯](https://leetcode.cn/problems/climbing-stairs/) | [Go](go/leetcode/recursion/climb_stairs.go)<br> [Java](java/src/leetcode/recursion/ClimbStairs.java)  | 简单| O(n)  | O(n)   | 
|[剑指 Offer 10- II. 青蛙跳台阶问题](https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/) | [Go](go/leetcode/recursion/num_ways.go)<br> [Java](java/src/leetcode/recursion/NumWays.java)  | 简单| O(n)  | O(n)   |
|[剑指 Offer 10- I. 斐波那契数列](https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/) | [Go](go/leetcode/recursion/fib.go)<br> [Java](java/src/leetcode/recursion/Fib.java)  | 简单| O(n)  | O(n)   |
|[剑指 Offer 06. 从尾到头打印链表](https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/) | [Go](go/leetcode/recursion/reverse_print.go)<br> [Java](java/src/leetcode/recursion/ReversePrint.java)  | 简单| O(n)  | O(n)   |
|[面试题 08.01. 三步问题](https://leetcode.cn/problems/three-steps-problem-lcci/) | [Go](go/leetcode/recursion/ways_to_step.go)<br> [Java](java/src/leetcode/recursion/WaysToStep.java)  | 简单| O(n)  | O(n)   |
|[剑指 Offer 24. 反转链表](https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/) | [Go](go/leetcode/recursion/reverse_list.go)<br> [Java](java/src/leetcode/recursion/ReverseList.java)  | 简单| O(n)  | O(n)   |

## 二分查找
|题目|解法|难度|时间复杂度|空间复杂度|
|---|---|---|---|---|
|[704. 二分查找](https://leetcode.cn/problems/binary-search/) | [Go](go/leetcode/binary_search/search.go)<br> [Java](java/src/leetcode/binary_search/Search.java)  | 简单| O(logn)  | O(1)   | 
|[374. 猜数字大小](https://leetcode.cn/problems/guess-number-higher-or-lower/) | [Go](go/leetcode/binary_search/guess_number.go)<br> [Java](java/src/leetcode/binary_search/GuessNumber.java)  | 简单| O(logn)  | O(1)   |
|[278. 第一个错误的版本](https://leetcode.cn/problems/first-bad-version/) | [Go](go/leetcode/binary_tree/first_bad_version.go)<br> [Java](java/src/leetcode/binary_tree/FirstBadVersion.java)  | 简单| O(logn)  | O(1)   |

## 二叉树
题目|解法|难度|时间复杂度|空间复杂度|
|---|---|---|---|---|
|[108. 将有序数组转换为二叉搜索树](https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/) | [Go](go/leetcode/binary_tree/sorted_array_to_bst.go)<br> [Java](java/src/leetcode/binary_tree/sortedArrayToBST.java)  | 简单| O(n)  | O(logn)   | 

## 滑动窗口
|题目|解法|难度|时间复杂度|空间复杂度|
|---|---|---|---|---|
|[3. 无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/) | [Go](go/leetcode/sliding_window/length_of_longest_substring.go)<br> [Java](java/src/leetcode/sliding_window/LengthOfLongestSubstring.java)  | 简单| O(n)  |O(∣Σ∣)，其中 Σ 表示字符集   |
|[209. 长度最小的子数组](https://leetcode.cn/problems/minimum-size-subarray-sum/) | [Go](go/leetcode/sliding_window/min_sub_array_len.go)<br> [Java](java/src/leetcode/sliding_window/MinSubArrayLen.java)  | 中等| O(n)  |O(1)|


## 动态规划
|题目|解法|难度|时间复杂度|空间复杂度|
|---|---|---|---|---|
|[70. 爬楼梯](https://leetcode.cn/problems/climbing-stairs/) | [Go](go/leetcode/dp/climb_stairs.go)<br> [Java](java/src/leetcode/dp/ClimbStairs.java)  | 简单| O(n)  | O(n)   | 

## 贪心
题目|解法|难度|时间复杂度|空间复杂度|
|---|---|---|---|---|
|[45. 跳跃游戏 II](https://leetcode.cn/problems/jump-game-ii/) | [Go](go/leetcode/greedy/jump.go)<br> [Java](java/src/leetcode/greedy/Jump.java)  | 简单| O(n)  | O(1)   | 
|[121. 买卖股票的最佳时机](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/) | [Go](go/leetcode/greedy/max_profit.go)<br> [Java](java/src/leetcode/greedy/MaxProfit.java)  | 简单| O(n)  | O(1)   |
|[53. 最大子数组和](https://leetcode.cn/problems/maximum-subarray/) | [Go](go/leetcode/greedy/max_sub_array.go)<br> [Java](java/src/leetcode/greedy/MaxSubArray.java)  | 简单| O(n)  | O(1)   |

## 纯编程题
题目|解法|难度|时间复杂度|空间复杂度|
|---|---|---|---|---|
|[14. 最长公共前缀](https://leetcode.cn/problems/longest-common-prefix/) | [Go](go/leetcode/pure_program/longest_common_prefix.go)<br> [Java](java/src/leetcode/pure_program/LongestCommonPrefix.java)  | 简单| O(mn)  | O(1)   |

## 数学
题目|解法|难度|时间复杂度|空间复杂度|
|---|---|---|---|---|
|[7. 整数反转](https://leetcode.cn/problems/reverse-integer/) | [Go](go/leetcode/math/reverse.go)<br> [Java](java/src/leetcode/math/Reverse.java)  | 简单| O(log∣x∣)，翻转的次数即 x 十进制的位数| O(1)   |


