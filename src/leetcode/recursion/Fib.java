package leetcode.recursion;

/**
 * @author chengzw
 * @description 斐波那契数列，https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * <p>
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 输入：n = 5
 * 输出：5
 * 解释：0 + 1 + 1 + 2 + 3 + 5，第 5 项是 5，5 = 2 + 3
 *
 * @since 2021/9/7
 */

/**
 * 斐波那契公式：F(N) = F(N - 1) + F(N - 2)
 */
public class Fib {

    //给递归套一层非递归的壳，用于接题目的参数
    public static int solution1(int n) {
        mem = new int[n + 1];
        return fib_r(n);
    }

    //备忘录，解决重复计算的问题
    private static int[] mem;

    public static int fib_r(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (mem[n] != 0) return mem[n];
        //题目说了要去模，防止大小溢出
        mem[n] = (fib_r(n - 1) + fib_r(n - 2)) % 1000000007;
        return mem[n];
    }

    public static void main(String[] args) {
        System.out.println(solution1(5));
    }
}
