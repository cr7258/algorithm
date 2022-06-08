package leetcode.math;

/**
 * @description 118. 杨辉三角
 * @author chengzw
 * @link https://leetcode.cn/problems/pascals-triangle/
 * <p>
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * 示例 2:
 * 输入: numRows = 1
 * 输出: [[1]]
 * @since 2022/6/8
 */

/**
 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 在「杨辉三角」中，每个数是它左上方和右上方的数的和。

 示例 1:
 输入: numRows = 5
 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

 示例 2:
 输入: numRows = 1
 输出: [[1]]
 */

import java.util.ArrayList;
import java.util.List;

/**
 思路：第 n 行的第 i 个数等于第 n−1 行的第 i−1 个数和第 i 个数之和

 时间复杂度：O(n^2)
 空间复杂度：O(1)
 */

public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> rowAns = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                // 每行首尾两个数字都是 1
                if (j == 0 || j == i) {
                    rowAns.add(1);
                    // 第 n 行的第 i 个数等于第 n−1 行的第 i−1 个数和第 i 个数之和
                } else {
                    rowAns.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1));
                }
            }
            ans.add(rowAns);
        }
        return ans;
    }
}
