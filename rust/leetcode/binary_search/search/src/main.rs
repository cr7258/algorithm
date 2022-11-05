pub fn search(nums: Vec<i32>, target: i32) -> i32 {
    let mut low = 0;
    let mut high = nums.len() - 1;

    if target < nums[low] || target > nums[high] {
        return -1;
    }

    while low <= high {
        let mid = low + (high - low) / 2; // usize
        if nums[mid] == target {
            return mid as i32;
        }else if nums[mid] > target {
            high = mid - 1; // 默认为 usize (无符号), 需要注意 high 小于 0 的情况。
        }else {
            low = mid + 1;
        }
    }
    return -1;
}

fn main() {
//    let nums = vec![2,3,4,6,7,8];
//    let target = 6;
    let nums = vec![5];
    let target = -5;
    let result = search(nums, target);
    println!("{:?}", result);
}
