package leetcode.backtrack;

/**
 * @author chengzw
 * @description 解数独，https://leetcode-cn.com/problems/sudoku-solver/
 * <p>
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 * @since 2021/10/9
 */

/**
 * 思路：
 * 1.设置 boolean 类型
 * rows[9][10] 表示这一行中的数字 n 是否已经填了
 * cols[9][10] 表示这列行中的数字 n 是否已经填了
 * blocks[3][3][10] 表示这一个九宫格中的数字 n 是否已经填了
 * 2.扫描棋盘，将 行、列、九宫格 将已经填了数字的格子设置为 true
 * 3.回溯判断
 */
public class SolveSudoku {

    //10 多申请一个空间，索引 0 不设置值，方便后面对应计算
    private boolean[][] rows = new boolean[9][10];
    private boolean[][] cols = new boolean[9][10];
    private boolean[][][] blocks = new boolean[3][3][10];
    //是否得出解
    private boolean solved = false;

    public void solveSudoku(char[][] board) {
        //扫描棋盘，将 行、列、九宫格 将已经填了数字的格子设置为 True
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    //因为前面申请了 10 个空间，num 直接表示行、列、九宫格对应的数字
                    rows[i][num] = true;
                    cols[j][num] = true;
                    blocks[i / 3][j / 3][num] = true;
                }
            }
        }

        backtrack(0, 0, board);
    }

    //row 和 col 共同构成决策阶段
    //可选列表通过推导得出
    //board 是 path，存放结果
    public void backtrack(int row, int col, char[][] board) {

        //结束条件，row 是 0~8，9 已经超出
        if (row == 9) {
            solved = true;
            return;
        }

        //如果已经填过数了，跳过
        if (board[row][col] != '.') {
            int nextRow = row;
            int nextCol = col + 1;
            //换行
            if (col == 8) {
                nextRow = row + 1;
                nextCol = 0;
            }
            //探测下一阶段
            backtrack(nextRow, nextCol, board);
            //提前结束
            if (solved) return;
            //如果没有填过数
        } else {
            for (int num = 1; num <= 9; num++) {
                //如果满足行，列，九宫格都没出现过的条件，就填上数
                if (!rows[row][num] && !cols[col][num] && !blocks[row / 3][col / 3][num]) {
                    //数字转化成 char
                    board[row][col] = String.valueOf(num).charAt(0);
                    rows[row][num] = true;
                    cols[col][num] = true;
                    blocks[row / 3][col / 3][num] = true;

                    int nextRow = row;
                    int nextCol = col + 1;
                    //换行
                    if (col == 8) {
                        nextRow = row + 1;
                        nextCol = 0;
                    }
                    //探测下一阶段
                    backtrack(nextRow, nextCol, board);
                    //提前结束
                    if (solved) return;
                    //撤销选择
                    board[row][col] = '.';
                    rows[row][num] = false;
                    cols[col][num] = false;
                    blocks[row / 3][col / 3][num] = false;
                }
            }
        }
    }
}
