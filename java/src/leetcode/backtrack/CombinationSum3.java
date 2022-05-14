package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzw
 * @description 组合总和 III
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * @since 2021/10/11
 */

public class CombinationSum3 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1, 0, new ArrayList<>());
        return result;
    }

    //n，k 判断结束条件
    //step 决策阶段
    //sum 当前选的元素的总和，判断结束条件
    //path 路径
    public void backtrack(int k, int n, int step, int sum, List<Integer> path) {

        //结束条件，如果已经选了 k 个数了并且相加和是 n，得到可行解
        //这里不是 step == k，因为 step 决策阶段可能会不选数字
        if (path.size() == k && n == sum) {
            result.add(new ArrayList<>(path));
            return;
        }
        //提前结束
        if (step > 9 || sum > n || path.size() > k) {
            return;
        }

        //情况1：跳过这个数字
        backtrack(k, n, step + 1, sum, path);

        //清空2：把数字添加到结果中
        //step 正好也是 1 ~ 9 中的数字
        path.add(step);
        backtrack(k, n, step + 1, sum + step, path);
        //撤销选择
        path.remove(path.size() - 1);
    }
}
