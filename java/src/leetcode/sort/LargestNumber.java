package leetcode.sort;

/**
 * @author chengzw
 * @description 179. 最大数
 * @link https://leetcode.cn/problems/largest-number/
 * @since 2022/6/26
 */

/*
给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

示例 1：
输入：nums = [10,2]
输出："210"

示例 2：
输入：nums = [3,30,34,5,9]
输出："9534330"
 */

import java.util.Arrays;


/**
 思路：
 1.定义比较函数，按照位数依次比较，将大的数放在左边
 2.拼接字符串

 时间复杂度：由于是对 String 进行排序，当排序对象不是 Java 中的基本数据类型时，不会使用快排（考虑排序稳定性问题）。
 Arrays.sort() 的底层实现会「元素数量/元素是否大致有序」决定是使用插入排序还是归并排序。这里直接假定使用的是「插入排序」。复杂度为 O(n^2)
 空间复杂度：O(n)
 参考题解：https://leetcode.cn/problems/largest-number/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-vn86e/
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = "" + nums[i];
        // 排序
        Arrays.sort(ss, (a, b) -> {
            String sa = a + b, sb = b + a ;
            return sb.compareTo(sa);
        });
        // 排除 [0,0] 这种情况
        if(ss[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : ss) sb.append(s);
        return sb.toString();
    }
}
