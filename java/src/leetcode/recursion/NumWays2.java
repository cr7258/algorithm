package leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 剑指 Offer 10- II. 青蛙跳台阶问题
 * @author chengzw
 * @since 2022/6/5
 * @link https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */

/**
 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

 示例 1：
 输入：n = 2
 输出：2

 示例 2：
 输入：n = 7
 输出：21

 示例 3：
 输入：n = 0
 输出：1

 提示：
 0 <= n <= 100
 */

/**
 思路：设跳上 n 级台阶有 f(n) 种跳法。在所有跳法中，青蛙的最后一步只有两种情况： 跳上 1 级或 2 级台阶。
 当为 1 级台阶： 剩 n−1 个台阶，此情况共有 f(n−1) 种跳法；
 当为 2 级台阶： 剩 n−2 个台阶，此情况共有 f(n−2) 种跳法。
 f(n) 为以上两种情况之和，即 f(n)=f(n-1)+f(n-2)

 时间复杂度：O(n)
 空间复杂度：O(n)
 */

public class NumWays2 {
    //备忘录
    private Map<Integer, Integer> map = new HashMap<>();
    public int numWays(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.containsKey(n)) return map.get(n);
        int result = (numWays(n - 1) + numWays(n - 2)) % 1000000007;
        map.put(n, result);
        return result;
    }
}
