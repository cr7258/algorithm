package leetcode.binary_search;

/**
 * @author chengzw
 * @description 寻找旋转排序数组中的最小值，https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * <p>
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * @since 2021/9/15
 */

/**
 * 思路：在循环有序的区间去找最小值
 */
public class FindMin {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //特殊情况
            if (low == high) {
                return nums[mid];
            }
            //先处理命中的情况
            if ((mid != 0 && nums[mid] < nums[mid - 1])  //中间的情况
                    || (mid == 0 && nums[mid] < nums[high])) { //全部有序
                return nums[mid];
            } else if (nums[mid] > nums[high]) { //右循环有序  4 5 1 2 3
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        //永远到不了这
        return -1;
    }
}
