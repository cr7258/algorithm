package leetcode.hashtable;

import java.util.*;

/**
 * @author chengzw
 * @description 只出现一次的数字，https://leetcode-cn.com/problems/single-number/
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 输入: [2,2,1]
 * 输出: 1
 * @since 2021/9/20
 */


public class SingleNumber {
    /**
     * 思路1：
     * 1.使用 hashmap 存储元素和出现的次数
     * 2.返回 hashmap 中 count 为 1 的元素
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (map.containsKey(nums[i])) {
                count += map.get(nums[i]);
            }
            map.put(nums[i], count);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) return nums[i];
        }
        return -1;
    }

    /**
     * 思路2：
     * 1.使用 hashset 存储元素，因为一个元素只出现 1 次 或 2次，当查询的元素在 hashset 中存在时，则移除该元素
     * 2.返回 hashset 中剩余的元素
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        Iterator<Integer> it = set.iterator();
        return it.next();
    }
}
