package leetcode.dfs;

/**
 * @author chengzw
 * @description
 * @link
 * @since 2022/6/10
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        boolean[][] visited = new boolean[h][w];
        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int[] count = new int[]{0};
                    dfs(grid, visited, i, j, h, w, count);
                    ans = Math.max(ans, count[0]);
                }
            }
        }
        return ans;
    }

    //dfs 遍历陆地旁边的 4 个格子
    public void dfs(int[][] grid, boolean[][] visited, int i, int j, int h, int w, int[] count) {
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        visited[i][j] = true;
        for (int di = 0; di < 4; di++) {
            int newi = i + direction[di][0];
            int newj = j + direction[di][0];
            // 如果越界 || 已经遍历过 || 不是 1，则跳过
            if (newi < 0 || newj < 0 || newi >= h || newj >= w ||
                    grid[newi][newj] != 1 || !visited[newi][newj]) {
                continue;
            }
            count[0]++;
            dfs(grid, visited, newi, newj, h, w, count);
        }
    }
}
