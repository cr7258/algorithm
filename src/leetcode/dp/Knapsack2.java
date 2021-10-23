package leetcode.dp;

/**
 * @author chengzw
 * @description 0-1 背包问题
 * 有 n 个物品，重量分别为 weight[i] (i=0~n-1)，每个物品只有一个，选择其中一些装入背包，在不超过背包总重量的前提下，
 * 能否装满背包？
 * @since 2021/10/23
 */

/**
 * 思路：
 * 和判断背包可装物品的总重量的最大值是多少的题目类型，只是最后判断 d[n-1][w] 这个状态是否可达即可。最后一行，背包重量为 w 这个状态是否可达。
 */
public class Knapsack2 {
    /**
     * @param weight 每个物品的重量
     * @param n      物品数量
     * @param w      背包可承受的最大重量
     * @return
     */
    public boolean knapsack2(int[] weight, int n, int w) {

        //初始化状态，第一行无法通过上一行推导出来
        boolean[][] dp = new boolean[n][w + 1];
        //第一个物品不装到背包
        dp[0][0] = true;
        //第一个物品装到背包
        if (weight[0] <= w) {
            dp[0][weight[0]] = true;
        }
        //动态规划状态转移
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (dp[i - 1][j] == true || (j - weight[i] >= 0 && dp[i - 1][j - weight[i]] == true)) {
                    dp[i][j] = true;
                }
            }
        }

        //判断 d[n-1][w] 这个状态是否可达即可。最后一行，背包重量为 w 这个状态是否可达。
        return dp[n - 1][w];
    }
}
