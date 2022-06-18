package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 77. 组合
 * @author chengzw
 * @since 2022/6/16
 * @link https://leetcode.cn/problems/combinations/
 */

/**
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
你可以按 任何顺序 返回答案。

示例 1：
输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

示例 2：
输入：n = 1, k = 1
输出：[[1]]
 */

/**
思路：按照每一个数选与不选画出二叉树

参考题解：
https://leetcode.cn/problems/combinations/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-hui-s-0uql/
https://leetcode.cn/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
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
