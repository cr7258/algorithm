package leetcode.dp;

/**
 * @author chengzw
 * @description 0-1 背包问题
 * 有 n 个物品，重量分别为 weight[i] (i=0~n-1)，每个物品只有一个，选择其中一些装入背包，在不超过背包总重量的前提下，
 * 背包可装物品的总重量的最大值是多少？
 * @since 2021/10/23
 */

/**
 * 思路：
 * d[i][w+1] 记录每阶段可达状态
 * d[i][j] = true 表示第 i 个物品决策完以后背包重量为 j 这个状态可达
 * 状态转移方程：d[i][j] = d[i-1][j] || d[i-1][j-weight[i]]
 *                      第 i 个物品不拿   第 i 个物品拿
 */
public class Knapsack1 {
    /**
     * @param weight 每个物品的重量
     * @param n      物品数量
     * @param w      背包可承受的最大重量
     * @return
     */
    public int knapsack1(int[] weight, int n, int w) {

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

        //不超过背包重量的情况下，物品数量的最大值，从后往前扫描
        for (int i = w; i >= 0; i--) {
            if (dp[n - 1][i] == true) return i;
        }

        return 0;
    }

    public static void main(String[] args) {
        Knapsack1 k = new Knapsack1();
        int[] weight = new int[]{2, 3, 4, 6, 2};
        int n = 5;
        int w = 10;
        int result = k.knapsack1(weight, n, w);
        System.out.println(result);
    }
}
