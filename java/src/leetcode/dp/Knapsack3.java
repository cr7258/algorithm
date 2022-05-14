package leetcode.dp;

/**
 * @author chengzw
 * @description 0-1 背包问题
 * 有 n 个物品，重量分别为 weight[i] (i=0~n-1)，每个物品只有一个，选择其中一些装入背包，在不超过背包总重量的前提下，
 * 正好装满背包最少需要多少物品？
 * @since 2021/10/23
 */


/**
 * 思路：
 * dp[n][w+1] 记录每阶段可达重量对应的最少物品个数。
 * dp[i][j] 表示第 i 个物品决策完之后，背包重量为 j，对应的最少物品个数。
 * 状态转移方程：dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-weight[i]] + 1) 每阶段只需要保留到达相同重量时，最少的物品个数
 * 第 i 个物品不拿   第 i 个物品拿（拿了个数要加1）
 */
public class Knapsack3 {
    /**
     * @param weight 每个物品的重量
     * @param n      物品数量
     * @param w      背包可承受的最大重量
     * @return
     */
    public int knapsack3(int[] weight, int n, int w) {

        //记录到达某个状态时物品的最少重量
        Integer[][] dp = new Integer[n][w + 1];

        //最少物品个数先初始化为最大整数值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        //初始化第一行
        dp[0][0] = 0;
        if (weight[0] <= w) {
            dp[0][weight[0]] = 1;
        }

        //动态规划状态转移
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (dp[i - 1][j] != Integer.MAX_VALUE) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (j - weight[i] >= 0 && dp[i - 1][j - weight[i]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - weight[i]] + 1);
                }
            }
        }

        //正好装满背包最少需要多少物品
        if (dp[n - 1][w] == Integer.MAX_VALUE) return -1;
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
