package leetcode.sort;

import java.util.Arrays;

/**
 * @author chengzw
 * @description 977. 有序数组的平方
 * @link https://leetcode.cn/problems/squares-of-a-sorted-array/
 * @since 2022/6/1
 */

/**
 * 给你一个按非递减顺序排序的整数数组 nums，返回 每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */


public class SortedSquares {
    /**
     * 思路 1：用新数组接收平方后的值，然后进行排序
     * 时间复杂度：O(nlogn)，其中 nn 是数组 nums 的长度。
     * 空间复杂度：O(logn)，除了存储答案的数组以外，我们需要 O(logn) 的栈空间进行排序。
     */
    public int[] sortedSquares(int[] nums) {
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i] * nums[i];
        }
        Arrays.sort(newNums);
        return newNums;
    }

    /**
     * 思路 2：双指针
     * 1.数组原本是有序的, 只是在平方之后就变得无序了, 根本原因就是负数平方之后可能成为最大数了,
     * 那么数组平方的最大值就在数组的两端, 不是最左边就是最右边, 不可能是中间。
     * 2.用双指针指向数组的两端, 必定能找到平方后的最大值, 将其放到新数组末尾, 之后不断向中间移动,
     * 通过比较两个指针平方后的大小, 就能不断地将当前的最大值放入数组的尾部, 直到两个指针相遇为止.
     * <p>
     * 时间复杂度：O(n)，其中 nn 是数组 nums 的长度。
     * 空间复杂度：O(1)。除了存储答案的数组以外，我们只需要维护常量空间。
     */
    public int[] sortedSquares2(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[nums.length];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                newNums[pos] = nums[i] * nums[i];
                i++;
            } else {
                newNums[pos] = nums[j] * nums[j];
                j--;
            }
            pos--;
        }
        return newNums;
    }
}


