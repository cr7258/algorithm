package leetcode.sort;

/**
 * @author chengzw
 * @description 合并排序的数组，https://leetcode-cn.com/problems/sorted-merge-lcci/
 * <p>
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * @since 2021/9/12
 */

/**
 * 思路：从数组 A 末端往前放元素，谁大放谁
 */
public class MergeArray {
    public void merge(int[] A, int m, int[] B, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        //从末端往前放元素，谁大放谁
        //不用担心覆盖 A 数组原先的元素，因为 A 的末端有足够的缓冲空间容纳 B
        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[k--] = A[i];
                i--;
            } else {
                A[k--] = B[j];
                j--;
            }
        }

        //A 数组和 B 数组剩余的元素拼到数组前面
        while (i >= 0) {
            A[k--] = A[i--];
        }

        while (j >= 0) {
            A[k--] = B[j--];
        }
    }
}
