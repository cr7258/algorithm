package dfs

/**
 * @description https://leetcode.cn/problems/flood-fill/
 * @author chengzw
 * @since 2022/6/10
 * @link 733. 图像渲染
 */

/**
编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。需要填充的新颜色为 newColor 。
「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。

示例：
输入：
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
输出：[[2,2,2],[2,2,0],[2,0,1]]

解释:
初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
*/

/**
 * 思路：
 * 1.从指定坐标开始，按照上下左右的顺序探测旁边的方格
 * 2.如果越界 || 已经改过颜色 || 颜色不是初始坐标的颜色 则跳过
 * 3.进行 dfs 深度优先遍历
 */

func floodFill(image [][]int, sr int, sc int, newColor int) [][]int {
	n := len(image)
	m := len(image[0])
	dfs(image, n, m, sr, sc, image[sr][sc], newColor)
	return image
}

//n 横坐标
//m 纵坐标
//sr 坐标移动后的横坐标
//sc 坐标移动后的纵坐标
//color 初始位置的颜色
//newColor 新颜色
func dfs(image [][]int, n int, m int, sr int, sc int, color int, newColor int) {
	image[sr][sc] = newColor
	// 上，下，左，右四个方向
	direction := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	for _, v := range direction {
		newSr := sr + v[0]
		newSc := sc + v[1]

		// 如果越界 || 已经遍历过 || 颜色不同 跳过
		if newSr < 0 || newSc < 0 || newSr >= n || newSc >= m ||
			image[newSr][newSc] == newColor || image[newSr][newSc] != color {
			continue
		}
		dfs(image, n, m, newSr, newSc, color, newColor)
	}
}
