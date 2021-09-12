package leetcode.sort;

import java.util.Arrays;

/**
 * @author chengzw
 * @description 判断能否形成等差数列，https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence/
 * <p>
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 * <p>
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 * <p>
 * 输入：arr = [3,5,1]
 * 输出：true
 * 解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
 * @since 2021/9/12
 */
public class CanMakeArithmeticProgression {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 1) return true;
        //对数组进行排序
        Arrays.sort(arr);
        int n = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != n) return false;
        }
        return true;
    }
}
