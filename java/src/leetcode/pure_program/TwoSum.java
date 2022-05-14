package leetcode.pure_program;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengzw
 * @description 两数之和，https://leetcode-cn.com/problems/two-sum/
 * 题解：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * @since 2021/8/1
 */
public class TwoSum {
    //方法一，简单粗暴
    public static int[] solution1(int[] nums, int target) {
        //先确定 A
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {  //再确定 B
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //方法二
    public static int[] solution2(int[] nums, int target) {
        //创建一个哈希表，对于每一个 x，首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中
        //如果下次查询查到 target - x，则去哈希表找到 target - x 这个值的下标，和 i 一起返回
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            //第一轮 4,0 添加到 map
            //第三轮 9-5=4，找到，返回 4 的下标和 i 的下标
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] result1 = solution1(new int[]{4, 1, 5, 3}, 9);
        System.out.println(result1[0] + " " + result1[1]);

        int[] result2 = solution2(new int[]{4, 1, 5, 3}, 9);
        System.out.println(result2[0] + " " + result2[1]);
    }
}
