package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzw
 * @description 子集，https://leetcode-cn.com/problems/subsets/
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * @since 2021/10/7
 */

public class Subsets {

    //存放结果
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<Integer>());
        return result;
    }

    //回溯
    //nums[k] 代表可选列表
    //k 代表阶段
    //path 代表路径
    public void backtrack(int[] nums, int k, List<Integer> path) {
        //所有决策阶段已经完成
        if (k == nums.length) {
            //要使用新的 ArrayList，否则之后 path 改变原先的 path 也会改变
            result.add(new ArrayList<>(path));
            return;
        }

        //本次决策选空
        backtrack(nums, k + 1, path);

        //本次决策从可选列表中选择一个数
        path.add(nums[k]);
        backtrack(nums, k + 1, path);

        //还原可选列表
        path.remove(path.size() - 1);
    }
}
