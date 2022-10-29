/**
* @description 162. 寻找峰值
* @author chengzw
* @since 2022/10/29
* @link https://leetcode.cn/problems/find-peak-element/
*/

/**
思路：
题目描述中出现了 nums[-1] = nums[n] = -∞，这就代表着只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
往递增的方向上，二分查找，一定能找到
时间复杂度: O(logn)
空间复杂度: O(1)
*/

pub fn find_peak_element(nums: Vec<i32>) -> i32 {
    let mut low = 0;
    let mut high = nums.len() - 1;
    while low < high {
        let mid = low + (high - low) / 2;
        if nums[mid] > nums[mid + 1]{
            high = mid;
        }else {
            low = mid + 1
        }
    }
    return low as i32;
}

fn main() {
    let nums = vec![1,2,1,3,5,6,4];
    let result = find_peak_element(nums);
    println!("{:?}", result);
}