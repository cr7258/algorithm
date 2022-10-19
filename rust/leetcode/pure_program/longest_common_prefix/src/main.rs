/**
 * @description 14. 最长公共前缀
 * @author chengzw
 * @since 2022/10/19
 * @link https://leetcode.cn/problems/longest-common-prefix/
 */

/**
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。


示例 1：
输入：strs = ["flower","flow","flight"]
输出："fl"

示例 2：
输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
 */

/*
*
思路：
1.纵向扫描时，从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，如果相同则继续对下一列进行比较，
如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀。

时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
空间复杂度：O(1)。使用的额外空间复杂度为常数。
*/
fn main() {
    //let strs = vec![String::from("flower"),String::from("flow"),String::from("flight")];
    let strs = vec![String::from("ab"),String::from("a")];
    let result = longest_common_prefix(strs);
    println!("{}", result)
}



pub fn longest_common_prefix(strs: Vec<String>) -> String {
    let length = strs[0].len(); // 以第一个字符串的长度为基准比较
    let count = strs.len();
    // 遍历字符串的每一个字符
    for i in 0..length {
        // 遍历每个字符串，跳过第一个字符串
        for j in 1..count {
            if i == strs[j].len() || strs[0].chars().nth(i).unwrap() != strs[j].chars().nth(i).unwrap() {
                return strs.get(0).unwrap()[0..i].to_string();
            }
        }
    }
    return strs[0].to_string();
}