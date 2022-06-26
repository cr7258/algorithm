package main

/**
 * @description 15. 三数之和
 * @author chengzw
 * @since 2022/5/24
 * @link https://leetcode.cn/problems/3sum/
 */

/**
给你一个包含 n 个整数的数组 nums， 判断 nums 中是否存在三个元素 a， b， c， 使得 a + b + c = 0？ 请你找出所有和为 0 且不重复的三元组。
注意： 答案中不可以包含重复的三元组。

示例 1：
输入： nums = [-1, 0, 1, 2, -1, -4]
输出：[[-1, -1, 2], [-1, 0, 1]]

示例 2：
输入： nums = []
输出：[]

示例 3：
输入： nums = [0]
输出：[]
*/

/**
* 思路：
1.先将 nums 数组从小到大排序
2.双指针，固定 3 个指针中最左（最小）数字的指针 k，双指针 i，j 分设在数组索引两端，通过双指针交替向中间移动，
记录对于每个固定指针 k 的所有满足 nums[k] + nums[i] + nums[j] == 0 的 i,j 组合。
3.注意处理重复结果
参考题解：https://leetcode.cn/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
*/
func threeSum(nums []int) [][]int {
   sort.Ints(nums)
   ans := make([][]int,0)
   n := len(nums)

   for k := 0; k < n; k++ {
       // 当 nums[k] > 0 时直接 break 跳出：因为 nums[j] >= nums[i] >= nums[k] > 0，即 3 个数字都大于 0 ，在此固定指针 k 之后不可能再找到结果了
       if nums[k] > 0 {
           break
       }
       // 跳过重复元素，因为已经将 nums[k - 1] 的所有组合加入到结果中
       if k > 0 && nums[k] == nums[k-1]{
           continue
       }
       i := k+1
       j := n-1

       for i < j {
           sum := nums[k] + nums[i] + nums[j]
           if sum < 0 {
               i++
           }else if sum > 0 {
               j--
           }else {
               ans = append(ans, []int{nums[k], nums[i], nums[j]})
               i++
               j--
               // 跳过重复元素
               for i < j && nums[i] == nums[i-1]{
                   i++
               }
               for i < j && nums[j] == nums[j+1]{
                   j--
               }
           }
       }
   }
   return ans
}