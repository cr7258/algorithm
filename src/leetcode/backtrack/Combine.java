package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzw
 * @description 组合，https://leetcode-cn.com/problems/combinations/
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按任何顺序返回答案。
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * @since 2021/10/7
 */
public class Combine {

    public List<List<Integer>> result = new ArrayList<>();
    int phase = 0;

    public List<List<Integer>> combine(int n, int k) {
        int nums[] = new int[n];
        for (int i = 1; i <= nums.length; i++) {
            nums[i-1] = i;
        }
        phase = k;
        backtrack(nums, 0, new ArrayList<Integer>());
        return result;
    }

    /**
     * @param nums 可选列表
     * @param k    决策阶段
     * @param path 路径
     */
    public void backtrack(int[] nums, int k, List<Integer> path) {

        //结束条件
        if (k == phase) {
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
