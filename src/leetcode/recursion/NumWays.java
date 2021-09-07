package leetcode.recursion;

/**
 * @author chengzw
 * @description 青蛙跳台阶问题，https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * @since 2021/9/7
 */

/**
 * 思路：最后一次要么要么走 1 步到顶，要么走 2 步到顶
 *      到 n - 2 阶有 f(n-1) 种方法，到 n - 2 阶有 f(n-2) 种方法
 */
public class NumWays {
    //备忘录
    public static int[] mem;

    public int numWays(int n) {
        mem = new int[n + 1];
        return numWays_r(n);
    }

    public static int numWays_r(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (mem[n] != 0) return mem[n];
        mem[n] = (numWays_r(n - 1) + numWays_r(n - 2)) % 1000000007;
        return mem[n];
    }
}
