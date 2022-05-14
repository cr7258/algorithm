package leetcode.binary_search;

/**
 * @author chengzw
 * @description 寻找峰值，https://leetcode-cn.com/problems/find-peak-element/
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 * @since 2021/9/17
 */

/**
 * 思路：
 * 1.只需要找到一个峰值即可，峰值条件 nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]
 * 2.当遇到上坡，往右找，low = mid + 1;
 * 3.当遇到下坡，往左找，high = mid - 1;
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        //[1]
        if (low == high) {
            return low;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //[2,1]
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
                //[1,2]
            } else if (mid == n - 1) {
                if (nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
