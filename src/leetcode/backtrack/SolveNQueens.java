package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chengzw
 * @description 八皇后，https://leetcode-cn.com/problems/eight-queens-lcci/
 * <p>
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。
 * 这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 * @since 2021/10/8
 */
public class SolveNQueens {

    //存放结果
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        //构建棋牌
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(0, board, n);
        return result;
    }

    /**
     * @param row   决策阶段
     * @param board 路径
     *              根据 board 可以推算出可选列表
     * @param n     判断结束条件
     */
    public void backtrack(int row, char[][] board, int n) {

        //结束条件
        if (row == n) {
            //将数组转换成 ArrayList，每个 snapshot 是一种摆法
            ArrayList<String> snapshot = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                snapshot.add(new String(board[i]));
            }
            result.add(snapshot);
            return;
        }

        //在一行的格子中做选择
        for (int column = 0; column < n; column++) {
            if (isOk(row, column, board, n)) {
                board[row][column] = 'Q';
                //考察下一行
                backtrack(row + 1, board, n);
                //撤销选择
                board[row][column] = '.';
            }

        }
    }

    public boolean isOk(int row, int column, char[][] board, int n) {

        //判断该行上方是否有 Q
        for (int i = 0; i < row; i++) {
            if (board[i][column] == 'Q') return false;
        }

        //判断该行右上角是否有 Q
        int i = row - 1;
        int j = column + 1;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }

        //判断该行左上角是否有 Q
        i = row - 1;
        j = column - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        return true;
    }
}
