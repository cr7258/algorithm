package leetcode.sliding_window;

/**
 * @author chengzw
 * @description 3. 无重复字符的最长子串
 * @link https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * @since 2022/5/26
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

/**
 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

 示例1:
 输入: s = "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

 示例 2:
 输入: s = "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

 示例 3:
 输入: s = "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

import java.util.HashSet;

/**
 思路：滑动窗口
 1.使用哈希表记录字符是否在子串中出现过
 2.两个指针，左指针向右移动，说明有元素重复，删除哈希表中该元素
 3.右指针向右移动，子串扩展，哈希表添加元素
 4.变量 ans 记录子串的最大长度

 时间复杂度：O(n)，其中 n 是字符串的长度。左指针和右指针分别会遍历整个字符串一次。
 空间复杂度：O(∣Σ∣)，其中 Σ 表示字符集（即字符串中可以出现的字符）。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        // 哈希表记录字符是否在子串中出现过
        HashSet<Character> hashSet = new HashSet<>();
        // 右指针，初始值为 -1，相当于在字符串的左边界的左侧，还没有开始移动
        int r = -1, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                // 左指针向右移动，说明有元素重复，删除哈希表中该元素
                hashSet.remove(s.charAt(i - 1));
            }
            while (r + 1 < s.length() && !hashSet.contains(s.charAt(r + 1))) {
                // 移动右指针，子串扩展，哈希表添加元素
                hashSet.add(s.charAt(r + 1));
                r++;
                // 获取当前子串的最大长度
                ans = Math.max(ans, r - i + 1);
            }
        }
        return ans;
    }
}
