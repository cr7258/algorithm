package leetcode.dp;

/**
 * @author chengzw
 * @description 0-1 背包问题
 * 有 n 个物品，重量分别为 weight[i] (i=0~n-1)，每个物品只有一个，选择其中一些装入背包，在不超过背包总重量的前提下，
 * 装满背包有多少种装法？
 * @since 2021/10/23
 */


/**
 * 思路：
 * dp[i][j] 记录每阶段可达重量对应的装法个数。
 * dp[i][j] 表示第 i 个物品决策完之后，背包重量为 j，对应有几种装法。
 * 状态转移方程：dp[i][j] = dp[i-1][j] + dp[i-1][j-weight[i]]
 * 第 i 个物品不拿   第 i 个物品拿
 */
public class Knapsack4 {
    /**
     * @param weight 每个物品的重量
     * @param n      物品数量
     * @param w      背包可承受的最大重量
     * @return
     */
    public int knapsack4(int[] weight, int n, int w) {
        int[][] dp = new int[n][w + 1];
        //初始化第一行
        dp[0][0] = 0;
        if (weight[0] <= w) {
            dp[0][weight[0]] = 1;
        }

        //动态规划状态转移
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (j - weight[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - weight[i]];
                }
            }
        }

        return dp[n - 1][w];
    }

    public static void main(String[] args) {
        Knapsack3 k = new Knapsack3();
        int[] weight = new int[]{2, 3, 4, 6, 2};
        int n = 5;
        int w = 10;
        int result = k.knapsack3(weight, n, w);
        System.out.println(result);
    }
}
