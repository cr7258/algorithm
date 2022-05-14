package leetcode.binary_search;

/**
 * @author chengzw
 * @description 山脉数组的峰顶索引，https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 * <p>
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * @since 2021/9/15
 */

/**
 * 思路：峰值条件 arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
 */
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int n = arr.length - 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //特殊情况，避免越界
            if (mid == 0) {
                low = mid + 1;
            } else if (mid == n) {
                high = mid - 1;
                //找到峰值
            } else if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
                //上坡
            } else if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
                //下坡
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
