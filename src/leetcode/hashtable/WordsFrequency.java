package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengzw
 * @description 单词频率，https://leetcode-cn.com/problems/words-frequency-lcci/
 * @since 2021/9/20
 */

/**
 * 思路1：使用哈希表存储单词和单词出现的频率
 * 构造哈希表时间复杂度：O(n)
 * 查询时间复杂度：O(1)
 *
 * 思路2：使用排序 + 二分
 * 排序时间复杂度：O(nlogn)
 * 查询时间复杂度：O(logn)
 */
public class WordsFrequency {
    Map<String, Integer> hashMap = new HashMap<>();

    public WordsFrequency(String[] book) {
        for (String word : book) {
            int count = 1;
            if (hashMap.containsKey(word)) {
                count += hashMap.get(word);
            }
            hashMap.put(word, count);
        }

    }
    public int get(String word) {
        if (hashMap.containsKey(word)) {
            return hashMap.get(word);
        }
        return 0;
    }
}
