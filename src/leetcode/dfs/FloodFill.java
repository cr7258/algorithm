package leetcode.dfs;

/**
 * @author chengzw
 * @description 颜色填充，https://leetcode-cn.com/problems/color-fill-lcci/
 * <p>
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。需要填充的新颜色为 newColor 。
 * 周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 * <p>
 * 输入：
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出：[[2,2,2],[2,2,0],[2,0,1]]
 * 解释:
 * 初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
 * 初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
 * 注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
 * @since 2021/10/18
 */

/**
 * 思路：
 * 1.从指定坐标开始，按照上下左右的顺序探测旁边的方格
 * 2.如果越界 || 已经改过颜色 || 颜色不是初始坐标的颜色 则跳过
 * 3.进行 dfs 深度优先遍历
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;
        dfs(image, n, m, sr, sc, image[sr][sc], newColor);
        return image;
    }

    //n 横坐标
    //m 纵
    //sr 坐标移动后的横坐标
    //sc 坐标移动后的纵坐标
    //color 初始位置的颜色
    //newColor 新颜色
    public void dfs(int[][] image, int n, int m, int sr, int sc, int color, int newColor) {
        image[sr][sc] = newColor;
        //上下左右的偏移量
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < 4; i++) {
            int newr = sr + direction[i][0];
            int newc = sc + direction[i][1];
            //如果越界 || 已经改过颜色 || 颜色不是初始坐标的颜色 则跳过
            if (newc < 0 || newr < 0 || newr >= n || newc >= m
                    || image[newr][newc] == newColor
                    || image[newr][newc] != color) {
                continue;
            }
            //深度优先遍历
            dfs(image, n, m, newr, newc, color, newColor);
        }
    }
}
