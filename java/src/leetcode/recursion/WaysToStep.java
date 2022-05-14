package leetcode.recursion;

/**
 * @author chengzw
 * @description 三步问题，https://leetcode-cn.com/problems/three-steps-problem-lcci/
 * <p>
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 * 输入：n = 3
 * 输出：4
 * 说明: 有四种走法
 * @since 2021/9/7
 */
public class WaysToStep {

    private static int[] mem;
    private static int mod = 1000000007;

    /**
     * 思路1：递归方式实现
     * 时间复杂度：
     * 1.递归树总节点的个数，如果不用备忘录，时间复杂度是 3^(n/3) - 1 ~ 3^n - 1；
     * 2.使用备忘录的话，需要计算的节点被剪枝了，时间复杂度是 O(n)，因为只有左边的一排节点需要计算
     * <p>
     * 空间复杂度：O(n)，递归树的高度，最左边一排
     *
     * @param n
     * @return
     */
    public static int solution1(int n) {
        mem = new int[n + 1];
        mod = 1000000007;
        return waysToStep_r(n);

    }

    public static int waysToStep_r(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        if (mem[n] != 0) return mem[n];
        mem[n] = ((waysToStep_r(n - 1) + waysToStep_r(n - 2)) % mod + waysToStep_r(n - 3)) % mod;
        return mem[n];
    }


    /**
     * 思路2：非递归实现，使用一个数组，来盛放每个子问题的值，避免了递归的函数调用
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public static int solution2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % mod + dp[i - 3]) % mod;
        }
        return dp[n];
    }

    /**
     * 思路3：非递归实现+优化，省掉数组，降低空间复杂度
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param n
     * @return
     */
    public static int solution3(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        //a,b,c 是前面子问题的答案，d 是下个问题的答案
        int a = 1;
        int b = 2;
        int c = 4;
        int d = 0;
        for (int i = 4; i <= n; i++) {
            d = ((c + b) % mod + a) % mod;
            //交换元素
            a = b;
            b = c;
            c = d;
        }
        return d;
    }

    public static void main(String[] args) {
        System.out.println(solution1(4));
        System.out.println(solution2(4));
        System.out.println(solution3(4));
    }
}
