package sort;

/**
 * @author chengzw
 * @description 归并排序
 * @since 2021/11/30
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int result[], int start, int end) {
        // 1、分解到最小需要解决的地步，无法再分解了
        if (start >= end) {
            // 需要开始解决问题
            return;
        }

        // 2、解决

        // 计算数组 arr 的中间位置
        int mid = (start + end) / 2;

        // start1 为左区间的开始位置
        int start1 = start;

        // end1 为左区间的结束位置
        int end1 = mid;

        // start2 为右区间的开始位置
        int start2 = mid + 1;

        // end2 为右区间的结束位置
        int end2 = end;

        // 调用 mergeSort 函数，将 arr 数组中的 start1 到 end1 这一区间的数字排序后，并存放到 result 中
        mergeSort(arr, result, start1, end1);

        // 调用 mergeSort 函数，将 arr 数组中的 start2 到 end2 这一区间的数字排序后，并存放到 result 中
        mergeSort(arr, result, start2, end2);

        // 3、合并

        // 将左右区间中较小的数字存放到 result 中，从 k 开始
        int k = start;

        while (start1 <= end1 && start2 <= end2) {
            // 如果 arr[start1] < arr[start2])
            if (arr[start1] < arr[start2]) {
                // result[k] 存放的是 arr[start1]
                result[k] = arr[start1];
                start1++;
                k++;
            } else {
                // 否则，result[k] 存放的是 arr[start2]
                result[k] = arr[start2];
                start2++;
                k++;
            }

        }

        // 如果左区间中还有元素，那么把它都添加到 result 中
        while (start1 <= end1) {
            result[k] = arr[start1];
            k++;
            start1++;
        }

        // 如果右区间中还有元素，那么把它都添加到 result 中
        while (start2 <= end2) {
            result[k] = arr[start2];
            k++;
            start2++;
        }

        // 最后，把结果赋值到 arr 中
        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }

    public static void main(String[] args) {
        // 待比较的数组
        int[] arr = new int[]{3, 7, 4, 1, 3, 5, 2, 9, 6, 10};
        int[] result = new int[arr.length];
        mergeSort(arr, result, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
