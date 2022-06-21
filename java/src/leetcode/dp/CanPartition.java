package leetcode.dp;

/**
 * @author chengzw
 * @description 416. 分割等和子集
 * @link https://leetcode.cn/problems/partition-equal-subset-sum/
 * @since 2022/6/21
 */

/**
 给你一个 只包含正整数的非空数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

 示例 1：
 输入：nums = [1,5,11,5]
 输出：true
 解释：数组可以分割成 [1, 5, 5] 和 [11] 。

 示例 2：
 输入：nums = [1,2,3,5]
 输出：false
 解释：数组不能分割成两个元素和相等的子集。
 */

/**
 思路：0-1 背包问题
 1.把问题抽象为在数组中能否找到和为 w 的几个数，使得背包和等于 nums 中所有数和的一半
 2.dp 数组的定义：dp[i][j] = x 表示，对于前 i 个物品，当前背包的容量为 j 时，若 x 为 true，则说明可以恰好将背包装满，若 x 为 false，则说明不能恰好将背包装满。

 时间复杂度：O(n×target)，其中 n 是数组的长度，target 是整个数组的元素和的一半。
 空间复杂度：O(n*target)，其中 target 是整个数组的元素和的一半。
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i < n; i++){
            sum += nums[i];
        }
        // 和的一半是奇数，直接返回 false
        if(sum % 2 == 1) return false;

        // 背包和等于 nums 中所有数和的一半
        sum /= 2;
        // 构建 dp 数组
        boolean[][] dp = new boolean[n][sum+1];
        // 初始化第一行
        dp[0][0] = true;
        if(nums[0] <= sum) {
            dp[0][nums[0]] = true;
        }
        // 状态转移方程
        for(int i=1; i < n;i++){
            for(int j=0; j <= sum; j++){
                // 装入或者不装入背包
                if(j - nums[i] >= 0){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }else{
                    // 背包容量不足，不能装入第 i 个物品
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][sum];
    }
}
