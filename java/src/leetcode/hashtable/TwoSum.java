package leetcode.hashtable;

/**
 * @author chengzw
 * @description 两数之和，https://leetcode-cn.com/problems/two-sum/
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * @since 2021/9/20
 */

import java.util.HashMap;

/**
 * 思路：使用哈希表存储 {已经遍历到的元素,该元素的下标}，如果哈希表中能找到 target - nums[i]，则返回 [哈希表中元素下标,i]
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]), i};
            else map.put(nums[i], i);
        }
        return null;
    }
}
