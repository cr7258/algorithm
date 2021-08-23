package leetcode.regular_program;

/**
 * @author chengzw
 * @description 旋转图像，https://leetcode-cn.com/problems/rotate-image/
 * 题解：https://leetcode-cn.com/problems/rotate-image/solution/xuan-zhuan-tu-xiang-by-leetcode-solution-vu3m/
 * <p>
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * <p>
 * 思路：
 * 方法1.借助辅助数组（题目要求原地，辅助不符合要求）
 * 方法2.用翻转代替旋转，先上下翻转，然后主对角线翻转
 * 方法3.标准旋转，先确定最外层4个点的位置，然后层层推导
 * @since 2021/8/22
 */
public class Rotate {

    /**
     * 借助辅助数组（题目要求原地，辅助不符合要求）
     * 时间复杂度：O(N^2)，其中 N 是 matrix 的边长
     * 空间复杂度：O(N^2)，我们需要使用一个和 matrix 大小相同的辅助数组。
     */
    public static int[][] solution1(int[][] matrix) {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    /**
     * 原地，用翻转代替旋转，先上下翻转，然后主对角线翻转
     * 时间复杂度：O(N^2)，其中 N 是 matrix 的边长。对于每一次翻转操作，我们都需要枚举矩阵中一半的元素。
     * 空间复杂度：O(1)，一个 temp 变量
     *
     * @param matrix
     */
    public static void solution2(int[][] matrix) {

        int temp;
        int n = matrix.length;
        //上下翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }

        //主对角线翻转,j<i
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }
    }

    /**
     * 原地，标准旋转，先确定最外层4个点的位置，从外圈 -> 内圈
     * 时间复杂度：O(N^2)，其中 N 是 matrix 的边长
     * 空间复杂度：O(1)
     *
     * @param matrix
     */
    public static void solution3(int[][] matrix) {

        int n = matrix.length;
        //起始点，最左侧端点
        int s1_i = 0;
        int s1_j = 0;

        //每一圈循环，从外圈开始
        while (n > 1) {
            int s2_i = s1_i;
            int s2_j = s1_j + n - 1;
            int s3_i = s1_i + n - 1;
            int s3_j = s1_j + n - 1;
            int s4_i = s1_i + n - 1;
            int s4_j = s1_j;

            //外圈的偏移
            for (int move = 0; move < n - 1; move++) {
                int p1_i = s1_i;
                int p1_j = s1_j + move;
                int p2_i = s2_i + move;
                int p2_j = s2_j;
                int p3_i = s3_i;
                int p3_j = s3_j - move;
                int p4_i = s4_i - move;
                int p4_j = s4_j;
                swap4(matrix, p1_i, p1_j, p2_i, p2_j, p3_i, p3_j, p4_i, p4_j);
            }

            s1_i++;
            s1_j++;
            //一次交换一边减少2格子
            n -= 2;
        }
    }

    //交换4个方格，顺时针90度
    public static void swap4(int[][] matrix, int p1_i, int p1_j, int p2_i, int p2_j, int p3_i, int p3_j, int p4_i, int p4_j) {
        int temp = matrix[p1_i][p1_j];
        matrix[p1_i][p1_j] = matrix[p4_i][p4_j];
        matrix[p4_i][p4_j] = matrix[p3_i][p3_j];
        matrix[p3_i][p3_j] = matrix[p2_i][p2_j];
        matrix[p2_i][p2_j] = temp;
    }


    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result1 = solution1(matrix1);
        for (int i = 0; i < result1.length; i++) {
            for (int j = 0; j < result1.length; j++) {
                System.out.println(result1[i][j]);
            }
            System.out.println("=========");
        }

        System.out.println("#########################################");
        int[][] matrix2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution2(matrix2);
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                System.out.println(matrix2[i][j]);
            }
            System.out.println("=========");
        }
    }
}
