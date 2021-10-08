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

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1, new ArrayList<Integer>());
        return result;
    }

    /**
     * @param n    1~n 的数
     * @param k    取 k 个数
     * @param step 决策阶段
     * @param path 路径
     */
    public void backtrack(int n, int k, int step, List<Integer> path) {

        //结束条件，取到 k 个数
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        //结束条件，如果已经超过 1~n 的范围
        if (step == n + 1) {
            return;
        }

        //不选
        backtrack(n, k, step + 1, path);

        //选一个数
        path.add(step);
        //递归
        backtrack(n, k, step + 1, path);

        //撤销选择
        path.remove(path.size() - 1);
    }
}
