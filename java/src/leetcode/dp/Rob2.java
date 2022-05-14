package leetcode.dp;

/**
 * @author chengzw
 * @description 打家劫舍 II
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * @since 2021/10/25
 */

/**
 * 思路：
 * 1.用一个二维数组 dp[i][j] 表示第 i 个房屋偷或者不偷能偷窃到的最高金额，j 为 0 或者 1，0 表示不偷，1 表示偷
 * 2.如果第 i 个房子偷，那么第 i - 1 个房子就不能偷；如果第 i 个房子不偷，那么第 i - 1 个房子可偷可不偷
 * 3.状态转移方程：
 * dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1])
 * dp[i][1] = dp[i-1][0]
 * 4.由于是一个环形，如果第 0 个不偷窃，判断 1~n-1 之间的房子；如果第 0 个偷窃，判断 2~n-2 之间的房子
 */
public class Rob2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // 由于是一个环形，如果第 0 个不偷窃，判断 1~n-1 之间的房子；如果第 0 个偷窃，判断 2~n-2 之间的房子
        // 不偷第 0 个
        int max1 = rob_dp(1, n - 1, nums);
        // 偷第 0 个
        int max2 = rob_dp(2, n - 2, nums) + nums[0];
        return Math.max(max1, max2);
    }

    // p 起点
    // q 终点
    // 房屋数组
    public int rob_dp(int p, int q, int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        //初始化
        dp[p][0] = 0;
        dp[p][1] = nums[p];
        for (int i = p + 1; i <= q; i++) {
            // 不偷
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            // 偷
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[q][0], dp[q][1]);
    }
}
