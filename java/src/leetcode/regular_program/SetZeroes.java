package leetcode.regular_program;

/**
 * @author chengzw
 * @description 零矩阵，https://leetcode-cn.com/problems/zero-matrix-lcci/
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 * 输入：
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出：
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 *
 * 思路：第一次循环标记出要清空的行和列。
 *      第二次循环判断元素的所在的行或者列是否被标记为清空，如果被标记则置为0。
 * @since 2021/8/20
 */
public class SetZeroes {

    /**
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m+n)
     * @param matrix
     */
    public static void solution1(int[][] matrix) {
        //行数
        int n = matrix.length;
        if (n == 0) return;
        //列数
        int m = matrix[0].length;
        //要清空的行
        boolean[] rowClean = new boolean[n];
        //要清空的列
        boolean[] columnClean = new boolean[m];

        //标记要清空的行和列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rowClean[i] = true;
                    columnClean[j] = true;
                }
            }
        }

        //清空
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rowClean[i] || columnClean[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution1(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j]);
            }
            System.out.println("==============");
        }
    }
}
