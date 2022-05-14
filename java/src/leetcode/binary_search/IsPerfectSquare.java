package leetcode.binary_search;

/**
 * @author chengzw
 * @description 有效的完全平方数，https://leetcode-cn.com/problems/valid-perfect-square/
 * <p>
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 * <p>
 * 输入：num = 16
 * 输出：true
 * <p>
 * 输入：num = 14
 * 输出：false
 * @since 2021/9/17
 */

/**
 * 思路：二分查找，从 0 ~ x/2 + 1，当 x 的平方等于 num 时，返回 x
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int low = 0;
        int high = num / 2 + 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //防止溢出
            long midSquare = (long) mid * mid;
            if (midSquare == num) {
                return true;
            } else if (midSquare < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
