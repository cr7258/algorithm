package leetcode.dp;

/**
 * @author chengzw
 * @description 爬楼梯
 * @link https://leetcode.cn/problems/climbing-stairs/
 * @since 2022/5/14
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * <p>
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */
public class ClimbStairs {
    /**
     * 思路：动态规划
     * 1.使用数组 dp 存储每一级台阶的爬法数量，dp[n] = dp[n-1] + dp[n-2]
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    class Solution {
        public int climbStairs(int n) {
            // 使用数组 dp 存储每一级台阶的爬法数量
            // 由于后面初始化 dp[1] 和 dp[2]
            // 为了让当 n = 0 时不越界，保证 dp[1] 和 dp[2] 都有值
            // 所以 dp 的长度为 n + 2
            int[] dp = new int[n + 2];

            // 初始化 dp[1] 和 dp[2]
            // 一级台阶只有一种爬法
            dp[1] = 1;
            // 二级台阶有两种爬法
            dp[2] = 2;

            // 从 3 开始循环至 n，计算 dp[3] 至 dp[n]
            for (int i = 3; i <= n; i++) {
                // 第 i 级台阶的结果 dp[i] 等于第 i-1 和 i-2 的结果之和
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            // 最后返回 n 级台阶的结果
            return dp[n];
        }
    }
}
