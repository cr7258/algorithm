package leetcode.backtrack;

/**
 * @author chengzw
 * @description 组合总和，https://leetcode-cn.com/problems/combination-sum/
 * <p>
 * 给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。
 * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 * 对于给定的输入，保证和为target 的唯一组合数少于 150 个。
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 * @since 2021/10/11
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 1.left 记录 target 扣的剩余的值，当 left 等于 0 时，将 path 添加到 result 中
 * 2.先在前面的数字中按 1、2、3 的数量选，进行多阶段决策，最多选的数量是 left/这个数字
 */
public class CombinationSum {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target, new ArrayList<>());
        return result;

    }

    //candidates 可选列表
    //k 决策阶段
    //left 剩下的值，当等于 0 时，说明已经从 target 减到 0 了
    //path 路径
    public void backtrack(int[] candidates, int k, int left, List<Integer> path) {

        //结束条件，left 等于 0 时，已经从 target 减到 0 了
        if (left == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        //如果 candidates 数组中的数字都用完了，或者已经超过 target 了，提前结束
        if(left < 0 || k == candidates.length){
            return;
        }

        //先在前面的数字中按 1、2、3 的数量选，进行多阶段决策，最多选的数量是 left/这个数字
        //同一个数字选 1 个，2 个，3 个的时候
        for (int i = 0; i <= left / candidates[k]; i++) {
            for (int j = 0; j < i; j++) {
                path.add(candidates[k]);
            }
            //探测下一阶段
            backtrack(candidates, k + 1, left - i * candidates[k], path);

            //撤销选择
            for (int j = 0; j < i; j++) {
                path.remove(path.size() - 1);
            }
        }
    }
}
