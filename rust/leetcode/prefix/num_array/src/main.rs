/**
* @description 303. 区域和检索 - 数组不可变
* @author chengzw
* @since 2022/11/22
* @link https://leetcode.cn/problems/range-sum-query-immutable/description/
*/

/**
思路：
用一个新的数组 preSum ，preSum[i] 记录 nums[0..i-1] 的累加和。
如果我想求索引区间 [1, 4] 内的所有元素之和，就可以通过 preSum[5] - preSum[1] 得出。
https://labuladong.github.io/algo/2/20/24/
时间复杂度：O(1)
空间复杂度：O(n)
*/

struct NumArray {
    pre_sum: Vec<i32>
}

impl NumArray {

    fn new(nums: Vec<i32>) -> Self {
        // vec![v;n] 创建并初始化 vec，共 n 个元素，每个元素都初始化为 v
        let mut pre_sum = vec![0; nums.len() + 1];
        for i in 1..pre_sum.len() {
            pre_sum[i] = pre_sum[i-1] + nums[i-1];
        }
        Self { pre_sum: pre_sum }
    }

    fn sum_range(&self, left: i32, right: i32) -> i32 {
        return self.pre_sum[(right + 1) as usize] - self.pre_sum[left as usize];
    }
}

fn main() {
    let nums = vec![-2, 0, 3, -5, 2, -1];
    let obj = NumArray::new(nums);
    let result = obj.sum_range(0, 5);
    println!("{}", result);
}

