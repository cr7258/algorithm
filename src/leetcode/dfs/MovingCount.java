package leetcode.dfs;

/**
 * @author chengzw
 * @description 机器人的运动范围，https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * @since 2021/10/17
 */

/**
 * 思路：
 * 1.并不是简单地将格子总数 - 数位和大于 k 的格子，因为有可能不能走的格子会形成道路封锁，后面即使允许走的格子也走不到了
 * 2.对于不能走的格子，把这个格子的边都断开
 * 3.在 S 起点 [0,0] 开始对图进行深度优先遍历或者广度优先遍历
 */
public class MovingCount {

    //记录二维矩阵中的位置是否已经被访问过
    private boolean[][] visited;
    //记录可以走的格子数量
    private int count = 0;

    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        dfs(0, 0, m, n, k);
        return count;
    }

    /**
     * @param i 走到的格子的横坐标
     * @param j 走到的格子的纵坐标
     * @param m
     * @param n
     * @param k
     */
    public void dfs(int i, int j, int m, int n, int k) {
        visited[i][j] = true;
        count ++;
        //格子的上，下，左，右 4 个方位的偏移
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        //深度优先遍历，每个格子的上下左右
        for (int di = 0; di < 4; di++) {
            //0 是 左边的格子，newi 横坐标，newj 纵坐标
            int newi = i + directions[di][0];
            int newj = j + directions[di][1];
            //如果这个格子越界了 || 已经遍历过了 || 数位和大于 k 则跳过这个格子
            if (newi < 0 || newj < 0 || newi >= m || newj >= n
                    || visited[newi][newj] == true
                    || check(newi, newj, k) == false
            ) {
                continue;
            }

            dfs(newi, newj, m, n, k);
        }
    }

    //检查格子坐标数位和是否满足条件
    public boolean check(int i,int j, int k) {
        int sum = 0;
        while (i != 0){
            sum += (i % 10);
            i /=  10;
        }

        while (j != 0){
            sum += (j % 10);
            j /=  10;
        }

        return  sum <= k;
    }
}
