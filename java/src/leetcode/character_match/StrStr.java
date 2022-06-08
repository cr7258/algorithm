package leetcode.character_match;

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

/**
 思路：KMP 算法
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();
        int[] next = getNexts(b, m);
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (j > 0 && a[i] != b[j]) { // 一直找到a[i]和b[j]
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                ++j;
            }
            if (j == m) { // 找到匹配模式串的了
                return i - m + 1;
            }
        }
        return -1;
    }


    // b表示模式串，m表示模式串的长度
    private static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; ++i) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }
}

