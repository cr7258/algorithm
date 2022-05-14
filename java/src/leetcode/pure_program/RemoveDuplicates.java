package leetcode.pure_program;

/**
 * @author chengzw
 * @description 删除有序数组中的重复项，https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 原地删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * @since 2021/8/18
 */
public class RemoveDuplicates {
    public static int solution1(int[] nums) {
        int n = nums.length;
        //k表示下一个没有重复的数字要放的位置，注意是有序数组
        int k = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] != nums[k]) {
                k++;
                nums[k] = nums[i];
            }
        }
        return k + 1;
    }

    public static void main(String[] args) {
        System.out.println(solution1(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
