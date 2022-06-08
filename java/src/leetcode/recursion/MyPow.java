package leetcode.recursion;

/**
 * @author chengzw
 * @description 数值的整数次方，https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * @since 2021/9/11
 */

/**
 * 思路：数学公式
 * 当 n 为偶数时， x^n = x^(n/2) * x^(n/2)
 * 当 n 为奇数时， x^n = x^(n/2) * x^(n/2) * x
 *
 * 时间复杂度：O(logn)
 * 空间复杂度：O(logn)
 */
public class MyPow {
    public double myPow(double x, int n) {
        //如果 n 是正数
        if(n >=0) return rPow(x,n);
        //如果 n 是负数，要注意整数越界的问题，整数范围 [-2^31,2^31-1]
        //else return 1 / rPow(x, -1*n)
        //会越界：x=2.00000 n=-2147483648
        // x^-n = 1/x^-n = 1/(x^-(n+1) * x)
        else return 1 / (rPow(x, -1*(n+1)) * x);
    }

    public double rPow(double x,int n){
        if(n == 0) return 1;
        //减少重复计算
        double halfPow = rPow(x,n/2);
        //当 n 为偶数时， x^n = x(n/2) * x(n/2)
        //当 n 为奇数时， x^n = x(n/2) * x(n/2) * x
        if(n % 2 == 1){
            return halfPow * halfPow * x;
        }else{
            return halfPow * halfPow;
        }
    }
}
