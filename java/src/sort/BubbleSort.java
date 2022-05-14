package sort;

/**
 * @author chengzw
 * @description 冒泡排序
 * @since 2021/11/22
 */
public class BubbleSort {

    public static void bubbleSort(int[] a) {
        int n = a.length;
        // 外层循环需要遍历的次数， n 个元素的排序，需要 n - 1 次遍历
        for (int i = 0; i < n - 1; i++) {
            // 内层循环 n - i -1 次，代表第 i 次循环中比较元素的次数
            for (int j = 0; j < n - i - 1; j++) {
                // 如果比较的两个元素 a[j] > a [j+1]，说明较大的元素在较小的元素前面，交换位置
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 待比较的数组
        int[] a = new int[]{3, 7, 4, 1, 3, 5, 2, 9, 6, 10};
        bubbleSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
