package leetcode.hashtable;

/**
 * @author chengzw
 * @description 数组中重复的数字，https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * <p>
 * 找出数组中任意一个重复的数字。
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * @since 2021/9/20
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 使用哈希表存储数字，当查询的数字在哈希表中存在时，说明重复
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return nums[i];
            set.add(nums[i]);
        }
        return -1;
    }
}
