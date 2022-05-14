package leetcode.regular_program;

/**
 * @author chengzw
 * @description 搜索二维矩阵，https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * <p>
 * 编写一个高效的算法来搜索 M * N 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * 思路：
 * 从右上角开始搜索，如果 target 小于 i,j 所在的值，往左扫描。
 * 如果 target 大于 i,j 所在的值，往下扫描。
 * @since 2021/8/23
 */
public class SearchMatrix {

    /**
     * 时间复杂度：O(M*N)
     * 空间复杂度：O(1)
     * @param matrix
     * @param target
     * @return
     */
    public static boolean solution1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        //从右上角开始找
        int i = 0;
        int j = n - 1;

        //扫描到左下角为止
        while (i <= m - 1 && j >= 0) {
            if (matrix[i][j] == target) return true;

            //如果 target 小于 i,j 所在的值，往左扫描。
            if (matrix[i][j] > target) {
                j--;
                continue;
            }

            //如果 target 大于 i,j 所在的值，往下扫描。
            if (matrix[i][j] < target) {
                i++;
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution1(new int[][]{{1,4,7},{2,5,8},{3,6,9}},5));
    }
}
