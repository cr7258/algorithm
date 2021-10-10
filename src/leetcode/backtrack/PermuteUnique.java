package leetcode.backtrack;

/**
 * @author chengzw
 * @description 全排列包含重复数字，https://leetcode-cn.com/problems/permutations-ii/
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * @since 2021/10/10
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 思路：
 * 1.先统计每个不重复的数字分别有几个，用两个数组存放 uniqueNums counts。
 * 2.在决策的时候如果使用该数字就 count --，当 count 为 0 时，就不能使用该数字了。
 */
public class PermuteUnique {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        //使用哈希表计算每个不重复的数字出现的次数
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (hm.containsKey(nums[i])) {
                count += hm.get(nums[i]);
            }
            hm.put(nums[i], count);
        }

        //由于哈希表不支持顺序遍历，为了方便计算，将哈希表转换成两个数组
        int n = hm.size();
        int[] uniqueNums = new int[n];
        int[] counts = new int[n];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                uniqueNums[k] = nums[i];
                counts[k] = hm.get(nums[i]);
                k++;
                //哈希表中移除该数字，避免 count 重复计算
                hm.remove(nums[i]);
            }
        }

        backtrack(uniqueNums, counts, 0, new ArrayList<Integer>(), nums.length);
        return result;
    }

    //uniqueNums 和 counts 共同组成可选列表
    //k 决策阶段
    //path 路径
    //n 是结束条件，表示总共 3 个元素
    public void backtrack(int[] uniqueNums, int[] counts, int k, List<Integer> path, int n) {
        if (k == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        //第 k 个有多少种选择
        for (int i = 0; i < uniqueNums.length; i++) {
            //如果 count 为 0，说明选不了了
            if (counts[i] == 0) {
                continue;
            }

            //添加元素，count --
            counts[i]--;
            path.add(uniqueNums[i]);

            //探测下一阶段
            backtrack(uniqueNums, counts, k + 1, path, n);

            //撤销选择
            path.remove(path.size() - 1);
            counts[i]++;
        }
    }
}
