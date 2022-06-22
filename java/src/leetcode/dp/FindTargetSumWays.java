package leetcode.dp;

/**
 * @description 494. 目标和
 * @author chengzw
 * @since 2022/6/22
 * @link https://leetcode.cn/problems/target-sum/
 */

/**
 给你一个整数数组 nums 和一个整数 target 。
 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。


 示例 1：
 输入：nums = [1,1,1,1,1], target = 3
 输出：5
 解释：一共有 5 种方法让最终目标和为 3 。
 -1 + 1 + 1 + 1 + 1 = 3
 +1 - 1 + 1 + 1 + 1 = 3
 +1 + 1 - 1 + 1 + 1 = 3
 +1 + 1 + 1 - 1 + 1 = 3
 +1 + 1 + 1 + 1 - 1 = 3

 示例 2：
 输入：nums = [1], target = 1
 输出：1
 */

/**
 思路：
 1.dp[i][j] 表示第 i 个物品决策完以后，到达背包中物品重量为 j 这种状态有多少种方法
 2.状态转移方程：dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]
 */
public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        // 偏移量，数组索引要大于 0
        int offset = 1000;
        int w = 2000;

        // dp[i][j] 表示第 i 个物品决策完后，背包重量到达 j 有几种方法
        int[][] dp = new int[n][w+1];
        // 初始化第一行
        dp[0][offset+nums[0]] += 1;  // 有可能第一个值是 0
        dp[0][offset-nums[0]] += 1;

        // 状态转移方程
        for(int i=1; i < n; i++){
            for(int j=0; j <= w; j++){
                if(j-nums[i] >=0 && j-nums[i] <= w){
                    // 第 i 个物品加
                    dp[i][j] = dp[i-1][j-nums[i]];
                }
                if(j+nums[i] >=0 && j+nums[i] <= w){
                    // 第 i 个物品减
                    dp[i][j] += dp[i-1][j+nums[i]];
                }
            }
        }
        return dp[n-1][target+offset];
    }
}
