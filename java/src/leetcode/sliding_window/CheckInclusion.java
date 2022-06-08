package leetcode.sliding_window;

/**
 * @author chengzw
 * @description 567. 字符串的排列
 * @link https://leetcode.cn/problems/permutation-in-string/
 * @since 2022/6/8
*/

/**
 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 换句话说，s1 的排列之一是 s2 的 子串 。

 示例 1：
 输入：s1 = "ab" s2 = "eidbaooo"
 输出：true
 解释：s2 包含 s1 的排列之一 ("ba").

 示例 2：
 输入：s1= "ab" s2 = "eidboaoo"
 输出：false
 */

import java.util.Arrays;

/**
 1.用两个数组分别记录 s1 和 s2 中字符出现的次数
 2.s2 的数组往后滑动比较

 时间复杂度：O(n)
 空间复杂度：O(1)
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        // 记录两个字符串中每个字符出现的次数
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (int i = 0; i < n; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt1[s2.charAt(i) - 'a']++;
        }

        // 先比较 s2 和 s1 相同长度部分的字符是否相等
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }

        // 滑动比较，s2 往后移动
        for (int i = n; i < m; i++) {
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - n) - 'a']--;
            if(Arrays.equals(cnt1, cnt2)){
                return true;
            }
        }
        return false;
    }
}
