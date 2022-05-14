package leetcode.hashtable;

/**
 * @author chengzw
 * @description 判定是否互为字符重排，https://leetcode-cn.com/problems/check-permutation-lcci/
 * <p>
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * @since 2021/9/20
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 对 s1 构建哈希表，存储单词和元素出现的次数
 * s2 中拿元素，匹配一次就在哈希表中 -1，当 s2 中的某个单词个数不匹配时，返回 false
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        //如果两个字符串长度不相等
        int n = s1.length();
        int n2 = s2.length();
        if (n != n2) return false;

        //将 s1 的元素添加到哈希表中
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s1.charAt(i);
            int count = 1;
            //如果元素在哈希表中存在，count++
            if (map.containsKey(c)) {
                count += map.get(c);
            }
            map.put(c, count);
        }

        //遍历 s2，判断 s2 中的元素个数和哈希表中的是否匹配
        for (int j = 0; j < n; j++) {
            char c2 = s2.charAt(j);
            //如果在哈希表中没找 s2 中的元素，直接返回 false
            if (!map.containsKey(c2)) return false;
            else {
                int count = map.get(c2) - 1;
                //如果 count < 0，直接返回 false
                if (count < 0) return false;
                map.put(c2, count);
            }
        }
        return true;
    }
}
