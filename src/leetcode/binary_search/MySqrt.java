package leetcode.binary_search;

/**
 * @author chengzw
 * @description x 的平方根，https://leetcode-cn.com/problems/sqrtx/
 * <p>
 * 给你一个非负整数 x ，计算并返回 x 的平方根 。
 * 由于返回类型是整数，结果只保留整数部分 ，小数部分将被舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * @since 2021/9/17
 */

/**
 * 思路：
 * 1.在 0 ~ x/2 + 1 中查询，如果 x 的平方等于 num，直接返回 x
 * 2.如果 x 的平方根小于 num，判断 x + 1 的平方根是否大于 num，如果大于 num，返回 x
 * 3.正常二分逻辑
 */
public class MySqrt {
    public int mySqrt(int x) {
        int low = 0;
        int high = x / 2 + 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //防止溢出
            long midSquare = (long) mid * mid;
            if (midSquare == x) {
                return mid;
                //如果 x 的平方根小于 num，判断 x + 1 的平方根是否大于 num，如果大于 num，返回 x
            } else if (midSquare < x) {
                if ((long) (mid + 1) * (mid + 1) > x) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        //永远不会到这
        return -1;
    }
}
