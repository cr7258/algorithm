package leetcode.two_pointers;

/**
 * @author chengzw
 * @description 557. 反转字符串中的单词 III
 * @link https://leetcode.cn/problems/reverse-words-in-a-string-iii/
 * @since 2022/6/7
 */

/**
 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

 示例 1：
 输入：s = "Let's take LeetCode contest"
 输出："s'teL ekat edoCteeL tsetnoc"

 示例 2:
 输入： s = "God Ding"
 输出："doG gniD"
 */

/**
 思路：
 1.开辟一个新字符串。
 2.从头到尾遍历原字符串，直到找到空格为止，此时找到了一个单词，并能得到单词的起止位置。随后，根据单词的起止位置，可以将该单词逆序放到新字符串当中。
 3.如此循环多次，直到遍历完原字符串，就能得到翻转后的结果。

 时间复杂度：O(n)，其中 n 为字符串的长度。原字符串中的每个字符都会在 O(1) 的时间内放入新字符串中。
 空间复杂度：O(n)。我们开辟了与原字符串等大的空间。
 */
public class ReverseWords {
    public String reverseWords(String s) {
        int start = 0;
        int end = 0;
        StringBuilder sb = new StringBuilder();
        while (start < s.length()) {
            // 走到空格为止
            while (end < s.length() && s.charAt(end) != ' ') {
                end++;
            }

            // 添加反转的字符
            int p = start; // 占据之前字符的位数
            while (start < end) {
                sb.append(s.charAt(end + p - start - 1));
                start++;
            }

            // 添加连续的空格
            while (end < s.length() && s.charAt(end) == ' '){
                sb.append(' ');
                end++;
            }
            start = end;
        }
        return sb.toString();
    }
}
