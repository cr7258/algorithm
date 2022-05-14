package sort;

/**
 * @author chengzw
 * @description 快速排序
 * @since 2021/11/22
 */
public class QuickSort {

    public static void quickSort(int[] nums, int left, int right) {
        // 如果 left 大于等于 right，说明该区间只有 1 个或者没有元素
        if (left >= right) {
            return;
        }

        // 调用函数 partition，将 left 和 right 之间的元素划分为左右两个部分
        int mid = partition(nums, left, right);

        // 划分之后，再对 mid 左侧元素进行快速排序
        quickSort(nums, left, mid - 1);

        // 划分之后，再对 mid 右侧元素进行快速排序
        quickSort(nums, mid + 1, right);
    }

    /**
     * 分区函数
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] nums, int left, int right) {

        // 设置当前区间的第一个元素为基准元素
        int pivot = nums[left];

        // left 向右移动，right 向左移动，直到 left 和 right 指向同一元素位置
        while (left < right) {

            // 只有当小于 pivot 的元素时，right 才停止移动
            while (left < right && nums[right] >= pivot) {
                // right 不断往左边移动
                right--;
            }

            // 将此时的 nums[left] 赋值为 nums[right]
            // 这样比 pivot 小的元素就被移动到了左侧
            // 不用担心 left 的元素被覆盖，因为我们是拿最左边的元素当基准元素，最后当 left 和 right 相遇时会给中间的元素赋值基准元素的值 nums[left] = pivot
            // 等于把基准元素移动到了中间
            nums[left] = nums[right];

            // 只有当大于 pivot 元素时，left 才停止移动
            while (left < right && nums[left] <= pivot) {
                // left 不断往右移动
                left++;
            }

            // 将此时的 nums[right] 赋值为 nums[left]
            // 这样比 pivot 大的元素就被移动到了右侧
            nums[right] = nums[left];
        }

        // 此时 left 和 right 相遇，那么需要将此时的元素设置为 pivot
        // 这个时候，pivot 左侧的元素都小于它，右侧的元素都大于它
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        // 待比较的数组
        int[] nums = new int[]{3, 7, 4, 1, 3, 5, 2, 9, 6, 10};
        quickSort(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
