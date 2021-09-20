package leetcode.hashtable;

/**
 * @author chengzw
 * @description 三数之和，https://leetcode-cn.com/problems/3sum/
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * @since 2021/9/20
 */

import java.util.*;

/**
 * 思路：
 * 1.先对数组排序
 * 2.将数组的元素添加到哈希表中
 * 3.两个循环，第一个循环 a，第二个循环 b
 * 4.如果在哈希表存在元素等于 0-(a+b)，则添加 a,b,c
 *
 * 时间复杂度: O(n^2)
 * 时间复杂度: O(n)
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //排序数组
        Arrays.sort(nums);
        //结果列表
        List<List<Integer>> result = new ArrayList<>();
        //将数组中的元素添加到哈希表中
        Map<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;  //避免 a 重复，如果元素连续则跳过，避免重复添加
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue; //避免 b 重复，[-1,-1,2]，j != i + 1 不能跳过第二个 -1
                //如果在哈希表中找到元素等于 0-(a+b)，则将 a,b,c 添加到结果列表中
                int c = -(nums[i] + nums[j]);
                if (!hashMap.containsKey(c)) continue;

                int k = hashMap.get(c);
                if (k > j) { //[-1,0,1,2,-1,-4]，避免 [-4,2,2] 2 被重复使用 2 次的情况
                    List<Integer> resultItem = new ArrayList<>();
                    resultItem.add(nums[i]);
                    resultItem.add(nums[j]);
                    resultItem.add(nums[k]);
                    result.add(resultItem);
                }

            }
        }
        return result;
    }
}
