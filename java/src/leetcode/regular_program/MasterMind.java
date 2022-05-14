package leetcode.regular_program;

/**
 * @author chengzw
 * @description 珠玑妙算，https://leetcode-cn.com/problems/master-mind-lcci/
 * <p>
 * 计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。
 * 某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 * <p>
 * 输入： solution="RGBY",guess="GGRR"
 * 输出： [1,1]
 * 解释： 猜中1次，伪猜中1次。
 * <p>
 * 思路：1.先找出猜出的次数。
 *      2.没猜中的用两个数组分别计算实际和猜测的颜色情况。
 *      int[] 类型 [B,G,R,Y]
 * @since 2021/8/21
 */
public class MasterMind {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param solution
     * @param guess
     * @return
     */
    public static int[] solution1(String solution, String guess) {

        //猜中的次数
        int hit = 0;
        //伪猜中的次数
        int fakeHit = 0;

        //没猜中的用两个数组分别计算实际和猜测的颜色情况。 A ~ Z，26个英文字母，ASCII码
        int[] solutionChar = new int[26];
        int[] guessChar = new int[26];

        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                hit++;
            } else {
                //分别给两个数组对应的颜色 + 1
                solutionChar['Z' - solution.charAt(i)]++;
                guessChar['Z' - guess.charAt(i)]++;
            }
        }

        //统计伪猜中的次数
        for (int k = 0; k < 26; k++) {
            if (solutionChar[k] > guessChar[k]) {
                fakeHit += guessChar[k];
            } else {
                fakeHit += solutionChar[k];
            }
        }

        return new int[]{hit, fakeHit};

    }

    public static void main(String[] args) {
        int[] result = solution1("RGBY", "GGRR");
        for (int i : result) {
            System.out.println(i);
        }
    }
}
