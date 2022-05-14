package leetcode.sort;

/**
 * @author chengzw
 * @description 调整数组顺序使奇数位于偶数前面，https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * @since 2021/9/12
 */

/**
 * 思路：两个指针，一个从前往后找偶数，一个从后往前找奇数，进行交换
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int i = 0;
        int n = nums.length;
        int j = n - 1;
        //当前指针遇到后指针，接收
        while (i <= j) {
            //从前往后找偶数
            if (nums[i] % 2 == 1) {
                i++;
                continue;
            }
            //从后往前找奇数
            if (nums[j] % 2 == 0) {
                j--;
                continue;
            }

            //交换
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;
    }
}
