package leetcode.regular_program;

/**
 * @author chengzw
 * @description 井字游戏，https://leetcode-cn.com/problems/tic-tac-toe-lcci/
 * <p>
 * 输入： board = ["O X"," XO","X O"]
 * 输出： "X"
 * <p>
 * 输入： board = ["OOX","XXO","OXO"]
 * 输出： "Draw"
 * 解释： 没有玩家获胜且不存在空位
 * <p>
 * 输入： board = ["OOX","XXO","OX "]
 * 输出： "Pending"
 * 解释： 没有玩家获胜且仍存在空位
 * <p>
 * 思路：记录可以到达的最远的位置，一旦小于 i，就返回 false。
 * @since 2021/8/21
 */
public class Tictactoe {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static boolean solution1(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reach < i) return false;
            reach = Math.max(i + nums[i], reach);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution1(new int[]{2,3,1,1,4}));
    }
}
