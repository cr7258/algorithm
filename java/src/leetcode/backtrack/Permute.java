package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzw
 * @description 全排列，https://leetcode-cn.com/problems/permutations/
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以按任意顺序返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * @since 2021/10/7
 */
public class Permute {

    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, 0, new ArrayList<Integer>());
        return result;
    }

    public void backtrack(int[] nums, int k, List<Integer> path) {

        //结束条件
        if (k == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //找原先没有添加到 path 中的数
            if (path.contains(nums[i])) {
                continue;
            }

            //做选择
            path.add(nums[i]);
            //递归
            backtrack(nums, k + 1, path);
            //撤销选择
            path.remove(path.size() - 1);
        }
    }
}
