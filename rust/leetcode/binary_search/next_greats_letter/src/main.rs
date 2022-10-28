/**
* @description 744. 寻找比目标字母大的最小字母
* @author chengzw
* @since 2022/10/28
* @link https://leetcode.cn/problems/find-smallest-letter-greater-than-target/
*/

/**
思路：二分法，查找第一个大于给定值的值，当 letters[mid] > target 时，判断前一个字母是否小于等于 target
时间复杂度: O(logn)
空间复杂度: O(1)
*/

pub fn next_greatest_letter(letters: Vec<char>, target: char) -> char {
    let mut low = 0;
    let mut high = letters.len() - 1;
    while low <= high {
        let mid = low + (high - low) / 2;
        if letters[mid] > target {
            if mid == 0 || letters[mid - 1] <= target {
                return letters[mid];
            }
            high = mid - 1
        }else {
            low = mid + 1
        }
    }
    return letters[0];
}

fn main() {
    let letters = vec!['c', 'f', 'j'];
    let target = 'c';
    let result = next_greatest_letter(letters, target);
    println!("{:?}", result);
}
