package leetcode.sort;

/**
 * @author chengzw
 * @description 有效的字母异位词，https://leetcode-cn.com/problems/valid-anagram/
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * @since 2021/9/12
 */

import java.util.Arrays;

/**
 * 思路：将字符串转为字符数组，先排序，然后元素比较，遇到不同就直接返回 false
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        //排序
        Arrays.sort(charS);
        Arrays.sort(charT);
        for (int i = 0; i < charS.length; i++) {
            if (charS[i] != charT[i]) return false;
        }
        return true;
    }
}
