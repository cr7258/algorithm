package leetcode.math;

/**
 * @description 7. 整数反转
 * @author chengzw
 * @link https://leetcode.cn/problems/reverse-integer/
 * @since 2022/6/5
 */

/**
 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。
 假设环境不允许存储 64 位整数（有符号或无符号）。

 示例 1：
 输入：x = 123
 输出：321

 示例 2：
 输入：x = -123
 输出：-321

 示例 3：
 输入：x = 120
 输出：21

 示例 4：
 输入：x = 0
 输出：0

 提示：
 -231 <= x <= 231 - 1
 */

/**
 思路：ans * 10 + 取模拿到末尾数字
 参考资料：https://leetcode.cn/problems/reverse-integer/solution/tu-jie-7-zheng-shu-fan-zhuan-by-wang_ni_ma/
 时间复杂度：O(log∣x∣)。翻转的次数即 x 十进制的位数。
 空间复杂度：O(1)。
 */
public class Reverse {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) {
                return 0;
            }
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return ans;
    }
}
