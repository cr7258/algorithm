package leetcode.regular_program;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzw
 * @description 螺旋矩阵，https://leetcode-cn.com/problems/spiral-matrix/
 * <p>
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 思路：左边的数小于右边的数，上面的数小于下面的数
 * @since 2021/8/22
 */
public class SpiralOrder {

    /**
     * 时间复杂度：O(M*N)
     * 空间复杂度：O(1)
     * @param matrix
     * @return
     */
    public static List<Integer> solution1(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;

        while (left <= right && top <= bottom) {

            //往右走
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }

            //往下走
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }

            //往左走
            if (top != bottom) {
                for (int i = right - 1; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
            }


            //往上走，最后这里没有 =，不要重复添加到第一个
            if (left != right) {
                for (int i = bottom - 1; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result1 = solution1(matrix1);
        for (Integer i : result1) {
            System.out.println(i);
        }

        System.out.println("=========================");

        int[][] matrix2 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> result2 = solution1(matrix2);
        for (Integer i : result2) {
            System.out.println(i);
        }

    }
}
