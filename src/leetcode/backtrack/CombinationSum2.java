package leetcode.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chengzw
 * @description  组合总和 II
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 * <p>
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * @since 2021/10/11
 */

/**
 * 思路：决策转变为不重复的数字在这一阶段选几次
 */
public class CombinationSum2 {
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //先分别计算每个不重复的元素出现的次数
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < candidates.length; i++) {
            if (!hm.containsKey(candidates[i])) {
                hm.put(candidates[i], 1);
            } else {
                hm.put(candidates[i], hm.get(candidates[i]) + 1);
            }
        }

        //为了方便计算，使用 uniqueNums 和 count 两个哈希表来存储
        List<Integer> uniqueNums = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            if (hm.containsKey(candidates[i])) {
                uniqueNums.add(candidates[i]);
                counts.add(hm.get(candidates[i]));
                //避免重复计数
                hm.remove(candidates[i]);
            }
        }

        backtrack(uniqueNums, counts, 0, new ArrayList<>(), target);

        return result;
    }

    //uniqueNums 和 count 构成可选列表
    //k 决策阶段
    //path 路径
    //left 和 candidates.length 判断结束条件
    public void backtrack(List<Integer> uniqueNums, List<Integer> counts, int k, List<Integer> path, int left) {

        //结束条件，如果 left 为 0，说明已经从 target 减到 0 了
        if (left == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        //k == uniqueNums,size() 表示已经选完了 candidates 中的数字，因为 k 决策阶段是可能会把一个数字选择多次
        //或者已经超过 target 了，提前结束
        if (left < 0 || k == uniqueNums.size()) {
            return;
        }


        //不重复的数选 1 个，2 个，3 个...，最多选这个数字在 candidates 中出现的次数
        for (int i = 0; i <= counts.get(k); i++) {
            for (int j = 0; j < i; j++) {
                path.add(uniqueNums.get(k));
            }
            //探测下一阶段
            backtrack(uniqueNums, counts, k + 1, path, left - i * uniqueNums.get(k));

            //撤销选择
            for (int j = 0; j < i; j++) {
                path.remove(path.size() - 1);
            }
        }
    }
}
