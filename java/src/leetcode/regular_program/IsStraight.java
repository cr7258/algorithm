package leetcode.regular_program;

/**
 * @author chengzw
 * @description 扑克牌中的顺子，https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * <p>
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 思路：最大的牌减去最小的牌差小于4，并且没有重复的牌，0跳过。
 * @since 2021/8/20
 */
public class IsStraight {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static boolean solution1(int[] nums) {
        if (nums.length != 5) return false;
        //牌最大14
        boolean[] dup = new boolean[14];
        int min = 100;
        int max = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                //如果有重复值，就不是顺子
                if (dup[nums[i]]) return false;
                else dup[nums[i]] = true;
                if (nums[i] < min) min = nums[i];
                if (nums[i] > max) max = nums[i];
            }
        }
        return max - min < 5;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3, 4, 5};
        int[] num2 = new int[]{0, 0, 1, 2, 5};
        int[] num3 = new int[]{0, 0, 0, 0, 5};
        System.out.println(solution1(num1));
        System.out.println(solution1(num2));
        System.out.println(solution1(num3));
    }
}
