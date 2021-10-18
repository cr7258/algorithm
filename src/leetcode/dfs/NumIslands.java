package leetcode.dfs;

/**
 * @author chengzw
 * @description 岛屿数量，https://leetcode-cn.com/problems/number-of-islands/
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * @since 2021/10/17
 */
public class NumIslands {
    //记录岛屿数
    private int count = 0;
    //记录格子是否被遍历过
    private boolean[][] visited;
    //格子的高和宽
    private int h;
    private int w;

    public int numIslands(char[][] grid) {
        //高
        h = grid.length;
        //长
        w = grid[0].length;
        visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                //如果这个格子没有越界没有被遍历过，并且是陆地，count ++
                if (visited[i][j] != true && grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    //dfs 遍历陆地旁边的 4 个格子
    public void dfs(char[][] grid, int i, int j) {
        //格子上下左右方位的偏移量
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //设置已经遍历过
        visited[i][j] = true;

        for (int di = 0; di < 4; di++) {
            int newi = i + directions[di][0];
            int newj = j + directions[di][1];
            //如果格子没有越界 || 是陆地 || 没有被遍历过，则进行 dfs 遍历
            if (newi >= 0 && newj >= 0 && newi < h && newj < w
                    && visited[newi][newj] == false
                    && grid[newi][newj] == '1') {
                dfs(grid, newi, newj);
            }
        }
    }
}
