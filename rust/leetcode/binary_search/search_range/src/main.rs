/**
* @description 34. 在排序数组中查找元素的第一个和最后一个位置
* @author chengzw
* @since 2022/11/05
* @link https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
*/

/**
思路：
查找第⼀个值等于给定值的元素，查找最后⼀个值等于给定值的元素

时间复杂度：O(logn)
空间复杂度：O(1)。
*/

pub fn search_range(nums: Vec<i32>, target: i32) -> Vec<i32> {

    if nums.len() == 0 {
        return vec![-1, -1];
    }

    let mut low = 0;
    let mut high = nums.len() -1;
    let mut left = -1;

    if target < nums[low] || target > nums[high] {
        return vec![-1, -1];
    }

    while low <= high{
        let mid = low + (high - low) / 2;
        if nums[mid] == target {
            if mid == 0 || nums[mid-1] != target {
                left = mid as i32;
                break;
            }
            high = mid - 1; // 默认为 usize (无符号), 需要注意 high 小于 0 的情况。
        }else if nums[mid] > target {
            high = mid - 1;
        }else {
            low = mid + 1;
        }
    }

    let mut low = 0;
    let mut high = nums.len() - 1;
    let mut right = -1;
    while low <= high{
        let mid = low + (high - low) / 2;
        if nums[mid] == target {
            if mid == nums.len() - 1 || nums[mid+1] != target {
                right = mid as i32;
                break;
            }
            low = mid + 1;
        }else if nums[mid] > target {
            high = mid - 1;
        }else {
            low = mid + 1;
        }
    }
    return vec![left as i32, right as i32];
}

fn main() {
//    let nums = vec![5,7,7,8,8,10];
    let nums = vec![2];
    let target = 0;
    let result = search_range(nums, target);
    println!("{:?}", result);
}