package leetcode.recursion;

/**
 * @author chengzw
 * @description 递归乘法，https://leetcode-cn.com/problems/recursive-mulitply-lcci/submissions/
 * <p>
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 * 输入：A = 1, B = 10
 * 输出：10
 * @since 2021/9/11
 */
public class Multiply {

    /**
     * 思路1：数学公式 A * B
     * 当 A 为偶数时，(A/2) * B + (A/2) * B
     * 当 A 为奇数时，(A/2) * B + (A/2) * B + B
     * 时间复杂度：O(logn)
     * 空间复杂度：O(logn)
     * @param A
     * @param B
     * @return
     */
    public static int solution1(int A, int B) {
        if (A == 1) return B;
        int halfValue = solution1(A / 2, B);
        if (A % 2 == 1) {
            return halfValue + halfValue + B;
        } else {
            return halfValue + halfValue;
        }
    }

    /**
     * 思路2：在思路 1 的基础上优化，A 和 B 谁小分解谁
     * @param A
     * @param B
     * @return
     */
    public static int solution2(int A, int B) {
        //小的数作为分解的
        int n = Math.min(A, B);
        int k = Math.max(A, B);
        if (n == 1) return k;
        int halfValue = solution2(n / 2, k);
        if (n % 2 == 1) {
            return halfValue + halfValue + k;
        } else {
            return halfValue + halfValue;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution1(2,10));
        System.out.println(solution2(2,10));
    }
}
