package leetcode.binary_search;

/**
 * @author chengzw
 * @description 在排序数组中查找元素的第一个和最后一个位置，https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * @since 2021/9/14
 */

/**
 * 思路：1.找第一个元素时，如果 nums[mid] == target，向前探测
 *      2.找最后一个元素时，如果 nums[mid] == target，向后探测
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        //获取第一个位置
        int low = 0;
        int n = nums.length - 1;
        int high = n;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] != target){
                    first = mid;
                    break;
                }else{
                    //往前找
                    high = mid - 1;
                }
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        low = 0;
        high = n;
        //获取最后一个位置
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == n || nums[mid+1] != target){
                    last = mid;
                    break;
                }else{
                    //往后找
                    low = mid + 1;
                }
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return new int[]{first,last};
    }
}
