package leetcode.hashtable;

/**
 * @author chengzw
 * @description
 * @since 2022/5/14
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例 1:
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * <p>
 * 示例 2:
 * 输入：s = ""
 * 输出：' '
 * <p>
 * leetcode: https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class FirstUniqChar {
    /**
     * 思路：使用哈希表存储频数
     * 1.对字符串进行两次遍历
     * 2.第一次遍历时，使用哈希表存储字符串中每个字符出现的次数 [a:1, b:2]
     * 3.第二次遍历时，遍历到出现一次的字符就返回该字符
     * <p>
     * 时间复杂度: O(N)
     * 空间复杂度: O(E)，E 是字符集，小于 26
     */
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            // getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (frequency.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    /**
     * 思路：使用哈希表存储索引
     * 1.哈希表中的键表示一个字符，值表示它首次出现的索引，如果是 -1 表示该字符出现了多次
     * 2.当第一次遍历字符串时，如果当前字符不在哈希表中，就将该字符和索引存入哈希表，否则将该字符在哈希表中的映射修改为 -1
     * 3.第二次遍历哈希表中的所有值，找出值不为 -1 的最小值即可
     * <p>
     * 时间复杂度：O(n)，其中 n 是字符串 s 的长度。第一次遍历字符串的时间复杂度为 O(n)，
     * 第二次遍历哈希映射的时间复杂度为 O(∣Σ∣)，由于 s 包含的字符种类数一定小于 s 的长度，因此 O(∣Σ∣) 在渐进意义下小于 O(n)，可以忽略。
     * 空间复杂度：O(∣Σ∣)，其中 Σ 是字符集，在本题中 s 只包含小写字母，因此 ∣Σ∣≤26。我们需要 O(∣Σ∣) 的空间存储哈希映射。
     **/
    public char firstUniqChar2(String s) {
        HashMap<Character, Integer> position = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (position.containsKey(s.charAt(i))) {
                position.put(s.charAt(i), -1);
            } else {
                position.put(s.charAt(i), i);
            }
        }
        int first = n;
        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
            Integer pos = entry.getValue();
            if (pos != -1 && first > pos) {
                first = pos;
            }
        }
        return first == n ? ' ': s.charAt(first);
    }
}

