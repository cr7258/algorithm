package leetcode.binary_search;

/**
 * @author chengzw
 * @description 搜索插入位置，https://leetcode-cn.com/problems/search-insert-position/
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * @since 2021/9/14
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        //目标值不存在于数组中，找地方插入
        //因为循环终止条件是 low > high，此时 high 是小的值
        return high + 1;
    }
}
