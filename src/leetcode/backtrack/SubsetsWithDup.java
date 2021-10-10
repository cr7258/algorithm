package leetcode.backtrack;

/**
 * @author chengzw
 * @description 子集有重复元素，https://leetcode-cn.com/problems/subsets-ii/
 * <p>
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * @since 2021/10/10
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 思路：
 * 1.因为结果不能包含重复的子集，决策从放和不放转换成放几个
 * 2.先计算出每个数字分别有几个，使用哈希表来存储每个不重复的数字和对应出现的次数
 * 3.因为哈希表不支持顺序遍历，因此根据哈希表构建两个数组，uniqueNums 表示每个不重复的数字，counts 表示数字出现的次数
 * 3.然后进行多阶段决策，决策放几个
 */
public class SubsetsWithDup {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        //使用哈希表计算每个不重复的数字出现的次数
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (hm.containsKey(nums[i])) {
                count += hm.get(nums[i]);
            }
            hm.put(nums[i], count);
        }

        //由于哈希表不支持顺序遍历，为了方便计算，将哈希表转换成两个数组
        int n = hm.size();
        int[] uniqueNums = new int[n];
        int[] counts = new int[n];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                uniqueNums[k] = nums[i];
                counts[k] = hm.get(nums[i]);
                k++;
                //哈希表中移除该数字，避免 count 重复计算
                hm.remove(nums[i]);
            }
        }

        backtrack(uniqueNums, counts, 0, new ArrayList<Integer>());
        return result;
    }

    //uniqueNums 和 counts 共同组成可选列表
    //k 决策阶段
    //path 路径
    public void backtrack(int[] uniqueNums, int[] counts, int k, List<Integer> path) {

        //结束条件，k 不是等于 nums.length，因为在决策的时候是决策选一个不重复的数字选几个
        if (k == uniqueNums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int count = 0; count <= counts[k]; count++) {
            //决策一个不重复的数字选几个
            for (int i = 0; i < count; i++) {
                path.add(uniqueNums[k]);
            }
            //探测下一阶段
            backtrack(uniqueNums, counts, k + 1, path);
            //撤销选择
            for (int j = 0; j < count; j++) {
                path.remove(path.size() - 1);
            }
        }
    }
}
