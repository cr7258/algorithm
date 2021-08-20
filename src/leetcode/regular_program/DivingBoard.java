package leetcode.regular_program;

/**
 * @author chengzw
 * @description 跳水板，https://leetcode-cn.com/problems/diving-board-lcci/
 * <p>
 * 有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
 * 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： [3,4,5,6]
 * 解释：
 * 可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。
 * <p>
 * shorter = 1
 * longer = 2
 * k = 4
 * 输出： [4,5,6,7,8]
 * <p>
 * 思路：可能的情况总数的等于 k+1
 * 有两种特殊情况： k=0 和 shorter=longer
 * @since 2021/8/20
 */
public class DivingBoard {

    public static int[] solution1(int shorter, int longer, int k) {
        //两种特殊情况
        if (k == 0) return new int[0];
        if (shorter == longer) return new int[]{k * shorter};
        //可能的情况总数
        int num = k + 1;
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = (num - 1 - i) * shorter + i * longer;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = solution1(1, 2, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
