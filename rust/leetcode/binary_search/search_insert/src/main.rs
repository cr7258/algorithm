/**
* @description 35. 搜索插入位置
* @author chengzw
* @since 2022/11/02
* @link https://leetcode.cn/problems/search-insert-position/description/
*/

/**
思路：查找第⼀个⼤于等于给定值的元素
时间复杂度：O(logn)
空间复杂度：O(1)。
*/

pub fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
    let mut low = 0;
    let mut high = nums.len() - 1;
    while low <= high {
        let mid = low + (high - low) / 2;
        if nums[mid] == target {
            return mid as i32;
        }else if nums[mid] > target {
            // rust 需要额外处理，当 mid - 1 值是负数时会溢出
            if mid == 0 {
                return mid as i32;
            }
            high = mid - 1;
        }else {
            low = mid + 1;
        }
    }
    // 此时 low >= high, 那么插入的位置就是 high 的下一个
    return (high + 1) as i32;
}

fn main() {
    let nums = vec![1,3,5,6];
    let target = 5;
    let result = search_insert(nums, target);
    println!("{}", result);
}
