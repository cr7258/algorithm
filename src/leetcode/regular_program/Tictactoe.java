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
 * 思路：依次判断行，列，左对角线，右对角线
 * @since 2021/8/21
 */
public class Tictactoe {

    public static String solution1(String[] board) {
        int n = board.length;

        char[][] newBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            newBoard[i] = board[i].toCharArray();
        }

        //是否分出胜负
        boolean determined = false;

        //判断行
        for (int i = 0; i < n; i++) {
            if (newBoard[i][0] == ' ') continue;
            determined = true;
            for (int j = 0; j < n; j++) {
                if (newBoard[i][0] != newBoard[i][j]) {
                    determined = false;
                    break;
                }
            }
            if (determined) return "" + newBoard[i][0];
        }
        //判断列
        for (int j = 0; j < n; j++) {
            if (newBoard[0][j] == ' ') continue;
            determined = true;
            for (int i = 0; i < n; i++) {
                if (newBoard[0][j] != newBoard[i][j]) {
                    determined = false;
                    break;
                }
            }
            if (determined) return "" + newBoard[0][j];
        }
        //判断左对角线
        if (newBoard[0][0] != ' ') {
            int i = 1;
            int j = 1;
            determined = true;
            while (i < n && j < n) {
                if (newBoard[i][j] != newBoard[0][0]) {
                    determined = false;
                    break;
                }
                i++;
                j++;
            }
            if (determined) return "" + newBoard[0][0];
        }

        //判断右对角线
        if (newBoard[n - 1][0] != ' ') {
            int i = n - 2;
            int j = 1;
            determined = true;
            while (i >= 0 && j < n) {
                if (newBoard[i][j] != newBoard[n - 1][0]) {
                    determined = false;
                    break;
                }
                i--;
                j++;
            }
            if (determined) return "" + newBoard[n - 1][0];
        }

        //判断是否还有空格
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (newBoard[i][j] == ' ') return "Pending";
            }
        }

        //平局
        return "Draw";
    }

    public static void main(String[] args) {
        System.out.println(solution1(new String[]{"O X", " XO", "X O"}));
        System.out.println(solution1(new String[]{"OOX", "XXO", "OXO"}));
        System.out.println(solution1(new String[]{"OOX", "XXO", "OX "}));
    }
}
